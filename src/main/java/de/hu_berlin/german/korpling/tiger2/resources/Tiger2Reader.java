/**
 * Copyright 2009 Humboldt University of Berlin, INRIA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */
package de.hu_berlin.german.korpling.tiger2.resources;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.common.util.URI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DefaultHandler2;

import de.hu_berlin.german.korpling.tiger2.Annotation;
import de.hu_berlin.german.korpling.tiger2.Corpus;
import de.hu_berlin.german.korpling.tiger2.DOMAIN;
import de.hu_berlin.german.korpling.tiger2.Edge;
import de.hu_berlin.german.korpling.tiger2.Graph;
import de.hu_berlin.german.korpling.tiger2.Meta;
import de.hu_berlin.german.korpling.tiger2.NonTerminal;
import de.hu_berlin.german.korpling.tiger2.Segment;
import de.hu_berlin.german.korpling.tiger2.SyntacticNode;
import de.hu_berlin.german.korpling.tiger2.Terminal;
import de.hu_berlin.german.korpling.tiger2.Tiger2Factory;
import de.hu_berlin.german.korpling.tiger2.exceptions.TigerImplausibleContentException;
import de.hu_berlin.german.korpling.tiger2.exceptions.TigerInternalException;
import de.hu_berlin.german.korpling.tiger2.exceptions.TigerInvalidModelException;

/**
 * A SAX parser for reading a <tiger2/> xml file and mapping its content to the <tiger2/> model.
 * @author Florian Zipser
 *
 */
public class Tiger2Reader extends DefaultHandler2
{
	private static final Logger LOGGER= LoggerFactory.getLogger(Tiger2Reader.class); 
//	private static final Log LOGGER = LogFactory.getLog(Tiger2Reader.class);
	/**
	 * The {@link Corpus} object, which shall be filled.
	 */
	private Corpus rootCorpus= null;

	/**
	 * Sets the {@link Corpus} object, which shall be filled.
	 */
	public void setRootCorpus(Corpus corpus) {
		this.rootCorpus = corpus;
		this.currentCorpus= corpus;
	}

	/**
	 * Returns the {@link Corpus} object, which shall be filled.
	 */
	public Corpus getRootCorpus() {
		return rootCorpus;
	}
	
	/**
	 * The uri, of the file which is currently read.
	 */
	private URI inputURI= null;
	
	/**
	 * Sets the uri, of the file which is currently read.
	 */ 
	public void setInputURI(URI inputURI) {
		this.inputURI = inputURI;
	}

	/**
	 * Returns the uri, of the file which is currently read.
	 */ 
	public URI getInputURI() {
		return inputURI;
	}
	
	public  Tiger2Reader()
	{
		this.init();
	}
	
	/**
	 * Initializes this object. Initializing is used when a {@link Tiger2Reader} object is created or in case such an object shall be reset
	 * for starting a new parsing.
	 * All internal sets, lists, variables and so on will be set to their initial value. 
	 */
	public void init()
	{
		this.elementStack= new Stack<String>();
		this.id2synNode= Collections.synchronizedMap(new HashMap<String, SyntacticNode>());
		this.notTargetedEdges= Collections.synchronizedMap(new HashMap<Edge, String>());
		
		currentSegment= null;
		currentGraph= null;
		currentSyntacticNode= null;
	}
	
	/**
	 * Stack, storing the path of read xml elements, starting from root to current element.
	 */
	private Stack<String> elementStack= null;
	
	/**
	 * Stores the current {@link Tiger2XML#ELEMENT_SEGMENT} object
	 */
	private Segment currentSegment= null;
	
	/**
	 * Stores the current {@link Tiger2XML#ELEMENT_GRAPH} object
	 */
	private Graph currentGraph= null;
	
	/**
	 * A SAX reader to import meta-data
	 */
	private MetaReader metaReader= null;
	/**
	 * A SAX reader to import annotation-data
	 */
	private AnnotationReader annotationReader= null;
	
	/**
	 * Stores the current {@link Tiger2XML#ELEMENT_TERMINAL} or {@link Tiger2XML#ELEMENT_NONTERMINAL} object
	 */	
	private SyntacticNode currentSyntacticNode= null;
	
	/**
	 * Stores the current {@link Tiger2XML#ELEMENT_CORPUS} or {@link Tiger2XML#ELEMENT_SUB_CORPUS} object
	 */
	private Corpus currentCorpus= null;
	/**
	 * A map storing tiger-ids and the created corresponding {@link SyntacticNode} object
	 */
	private Map<String, SyntacticNode> id2synNode= null;
	
	/**
	 * A map storing the edges, which do not have a target yet. When an edge was read, it is possible, that its target node haven't 
	 * been read yet. In such cases all the edges have to processed at the end see {@link #endDocument()}
	 */
	private Map<Edge, String> notTargetedEdges= null;
	
	/**
	 * Reads the sub-elements of {@link Tiger2XML#ELEMENT_META}
	 * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
	 */
	public void characters(	char[] ch,
            				int start,
            				int length) throws SAXException
    {
		if (	(this.elementStack!= null)&&
				(Tiger2XML.ELEMENT_META.equals(this.elementStack.peek())))
		{//corpus/meta/*
			if (this.metaReader== null)
				throw new TigerInternalException("No reader for meta-data is set.");
			this.metaReader.characters(ch, start, length);
		}//corpus/meta/*
		else if (	(this.elementStack!= null)&&
				(Tiger2XML.ELEMENT_ANNOTATION.equals(this.elementStack.peek())))
		{//corpus/annotation/* delegating content to annotation-reader
			if (this.annotationReader== null)
				throw new TigerInternalException("No reader for annotation-data is set.");
			this.annotationReader.characters(ch, start, length);
		}//corpus/annotation/* delegating content to annotation-reader
    }
	
	/**
	 * determines if an element shall be pushed onto the stack. this shall not happen, when delegating content
	 * to another reader.
	 */
	private boolean pushElement= true;
	
	/**
	 * This counter is only necessary to count the current number of {@link Edge} objects, to give them an artificial id. 
	 * This is necessary, because of edges are sometimes added to the graph first, when all nodes are read.
	 */
	private int edgeCounter= 0;
	
	/**
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(	String uri,
            					String localName,
            					String qName,
            					Attributes attributes) throws SAXException
    {
		
		if (elementStack.size()>0)
		
		if (Tiger2XML.ELEMENT_CORPUS.equals(qName))
		{
		}
		else if (Tiger2XML.ELEMENT_SUB_CORPUS.equals(qName))
		{
			Corpus subCorpus= Tiger2Factory.eINSTANCE.createCorpus();
			this.currentCorpus.getSubCorpora().add(subCorpus);
			this.currentCorpus= subCorpus;
		}
		else if (Tiger2XML.ELEMENT_META.equals(qName))
		{//corpus/meta
			Meta meta= Tiger2Factory.eINSTANCE.createMeta();
			this.metaReader= new MetaReader();
			this.metaReader.setInputURI(this.getInputURI());
			this.metaReader.setMeta(meta);
			this.currentCorpus.setMeta(meta);
			elementStack.push(qName);
			pushElement= false;
		}//corpus/meta
		else if (	(this.elementStack!= null)&&
					(Tiger2XML.ELEMENT_META.equals(this.elementStack.peek())))
		{//corpus/meta/* delegating content to meta-reader
			if (this.metaReader== null)
				throw new TigerInternalException("No reader for meta-data is set.");
			this.metaReader.startElement(uri, localName, qName, attributes);
		}//corpus/meta/* delegating content to meta-reader
		else if (Tiger2XML.ELEMENT_ANNOTATION.equals(qName))
		{//corpus/annotation
			this.annotationReader= new AnnotationReader();
			this.annotationReader.setInputURI(this.getInputURI());
			this.annotationReader.setCorpus(this.currentCorpus);
			this.annotationReader.startElement(uri, localName, qName, attributes);
			elementStack.push(qName);
			pushElement= false;
		}//corpus/annotation
		else if (	(this.elementStack!= null)&&
					(Tiger2XML.ELEMENT_ANNOTATION.equals(this.elementStack.peek())))
		{//corpus/annotation/* delegating content to annotation-reader
			if (this.annotationReader== null)
				throw new TigerInternalException("No reader for meta-data is set.");
			this.annotationReader.startElement(uri, localName, qName, attributes);
		}//corpus/annotation/* delegating content to annotation-reader
		else if (Tiger2XML.ELEMENT_SEGMENT.equals(qName))
		{
			Segment segment= Tiger2Factory.eINSTANCE.createSegment();
			this.currentSegment= segment;
			//start: @xml:id
				String id= attributes.getValue(Tiger2XML.ATTRIBUTE_ID);
				if (id!= null)
					segment.setId(id);
			//end: @xml:id
			this.currentCorpus.getSegments().add(segment);
		}
		else if (Tiger2XML.ELEMENT_GRAPH.equals(qName))
		{
			Graph graph= Tiger2Factory.eINSTANCE.createGraph();
			this.currentGraph= graph;
			//start: @xml:id
				String id= attributes.getValue(Tiger2XML.ATTRIBUTE_ID);
				if (id!= null)
					graph.setId(id);
			//end: @xml:id
			if (this.currentSegment== null)
				throw new TigerInternalException("The variable 'currentSegment' of Tiger2Reader was empty when reding a graph element.");
			this.currentSegment.getGraphs().add(graph);
		}
		else if (Tiger2XML.ELEMENT_TERMINAL.equals(qName))
		{
			Terminal terminal= Tiger2Factory.eINSTANCE.createTerminal();
			
			//start: @xml:id
				String id= attributes.getValue(Tiger2XML.ATTRIBUTE_ID);
				if (id== null)
				{
					this.LOGGER.warn("One syntactic node (terminal) element has no id.");
					id= "synNode_"+ this.currentGraph.getSyntacticNodes().size()+1;
				}
				else
				{
					if (this.currentGraph.findNode(id)!= null)
						id= id+"_"+ this.currentGraph.getSyntacticNodes().size()+1;
				}
				terminal.setId(id);
				this.id2synNode.put(id, terminal);
			//end: @xml:id
			
			String type= attributes.getValue(Tiger2XML.ATTRIBUTE_TYPE);
			if (type!= null)
				terminal.setType(type);
			for (int i= 0; i< attributes.getLength(); i++)
			{
				String attName= attributes.getLocalName(i);
				String attValue= attributes.getValue(i);
				
				if (Tiger2XML.ATTRIBUTE_ID.equals(attributes.getQName(i)))
					;
				else if (	(Tiger2XML.ATTRIBUTE_WORD.equals(attName))||
							(	(Tiger2XML.ATTRIBUTE_WORD.equals(attName))&&
								(attributes.getURI(i).equals(Tiger2XML.NAMESPACE_TIGER2))))
				{
					terminal.setWord(attValue);
				}
				else if (	(Tiger2XML.ATTRIBUTE_CORRESP.equals(attName))&&
							(attributes.getURI(i).equals(Tiger2XML.NAMESPACE_TIGER2)))
				{// start: //t/@corresp
					;//TODO implement that
				}// end: //t/@corresp
				else if (	(Tiger2XML.ATTRIBUTE_TYPE.equals(attName))&&
							(attributes.getURI(i).equals(Tiger2XML.NAMESPACE_TIGER2)))
					;//ignore it
				else
				{
					Annotation annotation= this.currentCorpus.createAnnotation(attName, DOMAIN.T, attValue);
					if (annotation!= null)
						terminal.getAnnotations().add(annotation);
				}
			}
			this.currentGraph.getSyntacticNodes().add(terminal);
			this.currentSyntacticNode= terminal;
		}
		else if (Tiger2XML.ELEMENT_NONTERMINAL.equals(qName))
		{
			NonTerminal nonTerminal= Tiger2Factory.eINSTANCE.createNonTerminal();
			
			//start: @xml:id
				String id= attributes.getValue(Tiger2XML.ATTRIBUTE_ID);
				if (id== null)
				{
					this.LOGGER.warn("One syntactic node element (non-terminal) has no id.");
					id= "synNode_"+ this.currentGraph.getSyntacticNodes().size()+1;
				}
				else
				{
					if (this.currentGraph.findNode(id)!= null)
						id= id+"_"+ this.currentGraph.getSyntacticNodes().size()+1;
				}
				nonTerminal.setId(id);
				this.id2synNode.put(id, nonTerminal);
			//end: @xml:id
			
			String type= attributes.getValue(Tiger2XML.ATTRIBUTE_TYPE);
			if (type!= null)
				nonTerminal.setType(type);
			for (int i= 0; i< attributes.getLength(); i++)
			{
				String attName= attributes.getLocalName(i);
				String attValue= attributes.getValue(i);
				if (Tiger2XML.ATTRIBUTE_ID.equals(attributes.getQName(i)))
					;//ignore it
				else if (	(Tiger2XML.ATTRIBUTE_TYPE.equals(attName))&&
							(attributes.getURI(i).equals(Tiger2XML.NAMESPACE_TIGER2)))
					;//ignore it
				else
				{
					Annotation annotation= this.currentCorpus.createAnnotation(attName, DOMAIN.NT, type, attValue);
					if (annotation!= null)
						nonTerminal.getAnnotations().add(annotation);
				}
			}
			this.currentGraph.getSyntacticNodes().add(nonTerminal);
			this.currentSyntacticNode= nonTerminal;
		}
		else if (Tiger2XML.ELEMENT_EDGE.equals(qName))
		{//ELEMENT_EDGE
			Edge edge= Tiger2Factory.eINSTANCE.createEdge();
			//start: @xml:id
				String id= attributes.getValue(Tiger2XML.ATTRIBUTE_ID);
				if (id== null)
				{
					this.LOGGER.warn("One '"+Tiger2XML.ELEMENT_EDGE+"' element has no id.");
					id= "edge_"+ edgeCounter;
					this.edgeCounter++;
				}
				else
				{
					if (this.currentGraph.findEdge(id)!= null)
					{	
						id= id+"_"+ edgeCounter;
						this.edgeCounter++;
					}
				}
				edge.setId(id);
			//end: @xml:id
				
			//start: @type
				String type= attributes.getValue(Tiger2XML.NAMESPACE_TIGER2, Tiger2XML.ATTRIBUTE_TYPE);
				if (type== null)
					type= attributes.getValue(Tiger2XML.ATTRIBUTE_TYPE);
				if (type != null)
					edge.setType(type);
			//end: @type
				
			for (int i= 0; i< attributes.getLength(); i++)
			{
				String attName= attributes.getLocalName(i);
				String attValue= attributes.getValue(i);
				
				if (Tiger2XML.ATTRIBUTE_ID.equals(attributes.getQName(i)))
				{
					;//ignore that
					
				}
				else if (	(Tiger2XML.ATTRIBUTE_TARGET.equals(attName))&&
							(attributes.getURI(i).equals(Tiger2XML.NAMESPACE_TIGER2)))
				{
					if (	(attName== null)||
							(attName.isEmpty()))
						throw new TigerImplausibleContentException("An edge was found with an empty '"+Tiger2XML.ATTRIBUTE_TARGET+"' value.");
					if (attValue.startsWith("#"))
						attValue= attValue.replace("#", "");
					SyntacticNode synNode= id2synNode.get(attValue);
					if (synNode!= null)
					{
						edge.setTarget(synNode);
						currentGraph.getEdges().add(edge);
					}
					else
						this.notTargetedEdges.put(edge, attValue);
				}
				else if (Tiger2XML.ATTRIBUTE_TYPE.equals(attName))
					;//ignore it
				else
				{
					Annotation annotation= null;
					try{
						annotation= this.currentCorpus.createAnnotation(attName, DOMAIN.EDGE, type, attValue);
					}catch (TigerInvalidModelException e) {
						throw new TigerImplausibleContentException("An exception occurs in edge '"+edge.getId()+"' ", e);
					}
					if (annotation!= null)
						edge.getAnnotations().add(annotation);
				}
			}
//			if (!(this.currentSyntacticNode instanceof NonTerminal))
//				throw new TigerImplausibleContentException("An edge was found, which is not a child element of an <nt> element.");
			edge.setSource(this.currentSyntacticNode);
		}//ELEMENT_EDGE
		if (pushElement)
		{
			elementStack.push(qName);
		}
    }
	
//	/**
//	 * Creates and returns a {@link Annotation} object, refering the {@link Feature} object matching to <em>annoName</em> 
//	 * and <em>annoDomain<em> and refering the {@link FeatureValue} object matching to <em>annoValue</em>. Returns null,
//	 * if  <em>annoName</em> and <em>annoDomain<em> is null.
//	 * @param annoName 
//	 * @param domain
//	 * @param annoValue value to identify a {@link FeatureValue} object, if parameter is not null
//	 * @return {@link Annotation} object refering a corresponding {@link Feature} and {@link FeatureValue} object
//	 */
//	protected Annotation createAnnotation(String annoName, DOMAIN domain, String annoValue)
//	{
//		if (	(annoName!= null)&&
//				(!annoName.isEmpty())&&
//				(domain!= null))
//		{
//			Annotation annotation= Tiger2Factory.eINSTANCE.createAnnotation();
//			Feature feature= this.currentCorpus.findFeature(annoName, domain);
//			if (feature== null)
//				throw new TigerImplausibleContentException("Cannot find a feature corresponding to the annotation in element having the featureName '"+annoName+"' and the domain '"+domain+"'.");
//			annotation.setFeatureRef(feature);
//			FeatureValue featureValue= feature.findFeatureValue(annoValue);
//			annotation.setFeatureValueRef(featureValue);
//			return(annotation);
//		}
//		else return(null);
//	}
	
	/**
	 * If the element {@link Tiger2XML#ELEMENT_CORPUS} or {@link Tiger2XML#ELEMENT_CORPUS} ends, all not yet targeted edges will be targeted and
	 * stored in the graph by calling {@link #processNotTargetedEdges()}.
	 */
	@Override
	public void endElement(String namespaceURI, String localName, String qName) throws SAXException
	{
		//determines if an xml element is to pop from stack
		boolean popElement= true;
		if (Tiger2XML.ELEMENT_GRAPH.equals(qName))
		{
			this.processNotTargetedEdges();
			this.currentGraph= null;
		}
		else if (	(this.elementStack!= null)&&
					(Tiger2XML.ELEMENT_META.equals(this.elementStack.peek()))) 
		{//corpus/meta/* delegating content to meta-reader
			if (Tiger2XML.ELEMENT_META.equals(qName))
			{//</meta>
				pushElement= true;
			}//</meta>
			else
			{
				if (this.metaReader== null)
					throw new TigerInternalException("No reader for meta-data is set.");
				popElement= false;
			}
			this.metaReader.endElement(namespaceURI, localName, qName);
		}//corpus/meta/* delegating content to meta-reader
		else if (	(this.elementStack!= null)&&
				(Tiger2XML.ELEMENT_ANNOTATION.equals(this.elementStack.peek())))
		{//corpus/annotation/* delegating content to annotation-reader
			if (Tiger2XML.ELEMENT_ANNOTATION.equals(qName))
			{//</meta>
				pushElement= true;
			}//</meta>
			else
			{
				if (this.annotationReader== null)
					throw new TigerInternalException("No reader for annotation-data is set.");
				popElement= false;
			}
			this.annotationReader.endElement(namespaceURI, localName, qName);
		}//corpus/annotation/* delegating content to annotation-reader
		
		if (popElement)
		{
			elementStack.pop();
		}
	}
	
	/**
	 * Setting the target of all not targeted edges (see {@link #notTargetedEdges}) and adds them to the current graph 
	 * (see {@link Tiger2Reader#currentGraph}).
	 */
	private void processNotTargetedEdges()
	{
		if (	(notTargetedEdges!= null) &&
				(notTargetedEdges.size()>0))
		{
			Set<Edge> edges= this.notTargetedEdges.keySet();
			for (Edge edge: edges)
			{
				String targetId= notTargetedEdges.get(edge);
				if (targetId== null)
					throw new TigerInternalException("An edge was found in 'NotTargetedEdges', that has no corresponding target node id.");
				SyntacticNode target= this.id2synNode.get(targetId);
				if (target== null)
					throw new TigerImplausibleContentException("The referred target of an edge ( id of target is '"+targetId+"') in the document '"+this.getInputURI()+"' cannot be found. The reason might be, that the node is not contained in document.");
				edge.setTarget(target);
				this.currentGraph.getEdges().add(edge);
			}
			notTargetedEdges= Collections.synchronizedMap(new HashMap<Edge, String>());
		}
	}
}
