/**
 * Copyright 2009 Humboldt-Universität zu Berlin, INRIA.
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
package de.hu_berlin.german.korpling.tiger2.resources.tigerXML;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.apache.commons.lang.StringEscapeUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import de.hu_berlin.german.korpling.tiger2.Annotation;
import de.hu_berlin.german.korpling.tiger2.Corpus;
import de.hu_berlin.german.korpling.tiger2.DEFAULT_TYPE;
import de.hu_berlin.german.korpling.tiger2.DOMAIN;
import de.hu_berlin.german.korpling.tiger2.Edge;
import de.hu_berlin.german.korpling.tiger2.Feature;
import de.hu_berlin.german.korpling.tiger2.FeatureValue;
import de.hu_berlin.german.korpling.tiger2.Graph;
import de.hu_berlin.german.korpling.tiger2.Meta;
import de.hu_berlin.german.korpling.tiger2.NonTerminal;
import de.hu_berlin.german.korpling.tiger2.Segment;
import de.hu_berlin.german.korpling.tiger2.SyntacticNode;
import de.hu_berlin.german.korpling.tiger2.Terminal;
import de.hu_berlin.german.korpling.tiger2.exceptions.TigerException;
import de.hu_berlin.german.korpling.tiger2.exceptions.TigerInternalException;
import de.hu_berlin.german.korpling.tiger2.exceptions.TigerInvalidModelException;
import de.hu_berlin.german.korpling.tiger2.exceptions.TigerResourceException;

/**
 * This class stores a given  {@link Corpus} object to a given {@link URI} object. For using an object of this class, please call the methods 
 * in the given order.
 * <ol>
 * 	<li>{@link #setCorpus(Corpus)}</li>
 * 	<li>{@link #setOutputURI(URI)}</li>
 * 	<li>{@link #save()}</li>
 * </ol>
 * @author Florian Zipser
 *
 */
public class TigerXMLWriter 
{
	/**
	 * The {@link Corpus} object, which shall be filled.
	 */
	private Corpus corpus= null;

	/**
	 * Sets the {@link Corpus} object, which shall be filled.
	 */
	public void setCorpus(Corpus corpus) {
		this.corpus = corpus;
	}

	/**
	 * Returns the {@link Corpus} object, which shall be filled.
	 */
	public Corpus getCorpus() {
		return corpus;
	}
	
	/**
	 * The uri, of the file which is currently read.
	 */
	private URI outputURI= null;
	
	/**
	 * Sets the uri, of the file which is currently read.
	 */ 
	public void setOutputURI(URI inputURI) {
		this.outputURI = inputURI;
	}

	/**
	 * Returns the uri, of the file which is currently read.
	 */ 
	public URI getOutputURI() {
		return outputURI;
	}
	
	/**
	 * Writer for storing the &lt;tiger2/&gt; file.
	 */
	protected PrintWriter output = null;
	
	/**
	 * Stores the set {@link Corpus} object to the set {@link URI} in &lt;tiger2/&gt; syntax.
	 */
	public void save()
	{
		if (this.getOutputURI()== null)
			throw new TigerInternalException("Cannot save the 'Corpus' object, because no output uri was given.");
		
		
			
		try
		{
			//start: open stream for writing
				File tiger2out= new File(this.getOutputURI().toFileString());
				tiger2out.getParentFile().mkdirs();
				
				try {
					output= new PrintWriter( 
							new BufferedWriter(
								new OutputStreamWriter(
									new FileOutputStream(
											tiger2out)
									,"UTF8")),false);
				} catch (UnsupportedEncodingException e) 
				{
					throw new TigerResourceException("Cannot open stream for writing 'Corpus' object to uri '"+this.getOutputURI()+"'.", e);
				} catch (FileNotFoundException e) {
					throw new TigerResourceException("Cannot open stream for writing 'Corpus' object to uri '"+this.getOutputURI()+"'.", e);
				}
			//end: open stream for writing
		
			this.saveSuperCorpus(this.getCorpus());
			
		}catch (Exception e) {
			if (e instanceof TigerException)
				throw (TigerException) e;
			else 
				throw new TigerException("An unknown exception occurs while saving 'Corpus' object to uri '"+this.getOutputURI()+"'.", e);
		}
		finally
		{
			if (output!= null)
				output.close();
		}
	}
	
	/**
	 * The alias used for namespace {@link TigerXMLDictionary#NAMESPACE_TIGER2}
	 */
	public static final String NS_ALIAS_TIGER2="tiger2";
	
	/**
	 * Stores the given {@link Corpus} object as super corpus (see {@link TigerXMLDictionary#ELEMENT_CORPUS}).
	 * @param corpus corpus to store as super corpus 
	 */
	protected void saveSuperCorpus(Corpus corpus)
	{
		this.output.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
		this.output.print("<"+TigerXMLDictionary.ELEMENT_CORPUS+" ");
		String idVal= null;
		if (	(corpus.getId()!= null)&&
				(!corpus.getId().isEmpty()))
			idVal= corpus.getId();
		else
			idVal="NOT_SET";
		this.output.print(TigerXMLDictionary.ATTRIBUTE_ID+"=\""+idVal+"\"");
		this.output.println(">");
		//start: print head
			this.output.println("<"+TigerXMLDictionary.ELEMENT_HEAD+">");
			if (corpus.getMeta()!= null)
				this.saveMeta(corpus.getMeta());
			if (corpus.getFeatures()!= null)
			{
				this.output.println("<"+TigerXMLDictionary.ELEMENT_ANNOTATION+">");
				this.saveFeatures(corpus.getFeatures());
				this.output.println("</"+TigerXMLDictionary.ELEMENT_ANNOTATION+">");
			}
			this.output.println("</"+TigerXMLDictionary.ELEMENT_HEAD+">");
		//end: print head
		if (	(corpus.getSubCorpora()!= null)&&
				(corpus.getSubCorpora().size()> 0))
		{//corpus contains subcorpora
			for (Corpus subCorpus: corpus.getSubCorpora())
			{
				this.saveSubCorpus(subCorpus);
			}
		}//corpus contains subcorpora
		//start: print body
			this.saveBody(corpus.getSegments());
		//end: print body
		this.output.println("</"+TigerXMLDictionary.ELEMENT_CORPUS+">");
	}
	
	/**
	 * Stores the given {@link Corpus} object as sub corpus (see {@link TigerXMLDictionary#ELEMENT_SUB_CORPUS}).
	 * @param corpus corpus to store as sub corpus
	 */
	protected void saveSubCorpus(Corpus corpus)
	{
		this.output.println("<"+TigerXMLDictionary.ELEMENT_SUB_CORPUS+" "+TigerXMLDictionary.ATTRIBUTE_ID+"=\""+corpus.getId()+"\">");
		if (corpus.getMeta()!= null)
			this.saveMeta(corpus.getMeta());
		if (	(corpus.getSubCorpora()!= null)&&
				(corpus.getSubCorpora().size()> 0))
		{//corpus contains subcorpora
			for (Corpus subCorpus: corpus.getSubCorpora())
			{
				this.saveSubCorpus(subCorpus);
			}
		}//corpus contains subcorpora
		//start: print body
			this.saveBody(corpus.getSegments());
		//end: print body
		this.output.println("</"+TigerXMLDictionary.ELEMENT_SUB_CORPUS+">");
	}
	
	/**
	 * Stores the given {@link Meta} object as {@link TigerXMLDictionary#ELEMENT_META}.
	 * @param meta meta data object to store
	 */
	protected void saveMeta(Meta meta)
	{
		this.output.println("<"+TigerXMLDictionary.ELEMENT_META+">");
		if (	(meta.getName()!= null)&&
				(!meta.getName().isEmpty()))
			this.output.println("<"+TigerXMLDictionary.ELEMENT_NAME+">"+meta.getName()+"</"+TigerXMLDictionary.ELEMENT_NAME+">");
		if (	(meta.getAuthor()!= null)&&
				(!meta.getAuthor().isEmpty()))
			this.output.println("<"+TigerXMLDictionary.ELEMENT_AUTHOR+">"+meta.getAuthor()+"</"+TigerXMLDictionary.ELEMENT_AUTHOR+">");
		if (	(meta.getDate()!= null)&&
				(!meta.getDate().isEmpty()))
			this.output.println("<"+TigerXMLDictionary.ELEMENT_DATE+">"+meta.getDate()+"</"+TigerXMLDictionary.ELEMENT_DATE+">");
		if (	(meta.getDescription()!= null)&&
				(!meta.getDescription().isEmpty()))
			this.output.println("<"+TigerXMLDictionary.ELEMENT_DESCRIPTION+">"+meta.getDescription()+"</"+TigerXMLDictionary.ELEMENT_DESCRIPTION+">");
		if (	(meta.getFormat()!= null)&&
				(!meta.getFormat().isEmpty()))
			this.output.println("<"+TigerXMLDictionary.ELEMENT_FORMAT+">"+meta.getFormat()+"</"+TigerXMLDictionary.ELEMENT_FORMAT+">");
		if (	(meta.getHistory()!= null)&&
				(!meta.getHistory().isEmpty()))
			this.output.println("<"+TigerXMLDictionary.ELEMENT_HISTORY+">"+meta.getHistory()+"</"+TigerXMLDictionary.ELEMENT_HISTORY+">");
		this.output.println("</"+TigerXMLDictionary.ELEMENT_META+">");
	}
	
	/**
	 * Stores the given list of {@link Feature} objects as (see {@link TigerXMLDictionary#ELEMENT_FEATURE}) elements.
	 * @param corpus corpus to store as sub corpus
	 */
	protected void saveFeatures(EList<Feature> features)
	{
		if (features!= null)
		{
			StringBuffer edgeLabel= null;
			StringBuffer secedgeLabel= null;
			for (Feature feature: features)
			{
				if (DOMAIN.EDGE.equals(feature.getDomain()))
				{//compute String for xml element, feature in case of t or nt, edgelabel or secedgelabel in case of edge
					String featureXMLElement= TigerXMLDictionary.ELEMENT_FEATURE.toString();
					StringBuffer currentBuffer= null;
					if (	(DEFAULT_TYPE.EDGE.getLiteral().equals(feature.getType()))||
							(DEFAULT_TYPE.PRIM.getLiteral().equals(feature.getType())))
					{
						edgeLabel= new StringBuffer();
						featureXMLElement= TigerXMLDictionary.ELEMENT_EDGELABEL.toString();
						currentBuffer= edgeLabel;
					}
					else if (DEFAULT_TYPE.SECEDGE.getLiteral().equals(feature.getType()))
					{
						secedgeLabel= new StringBuffer();
						currentBuffer= secedgeLabel;
						featureXMLElement= TigerXMLDictionary.ELEMENT_SECEDGELABEL.toString();
					}
					else 
					{
						secedgeLabel= new StringBuffer();
						currentBuffer= secedgeLabel;
						featureXMLElement= TigerXMLDictionary.ELEMENT_SECEDGELABEL.toString();
					}
					if (	(feature.getFeatureValues()!= null)||
							(feature.getFeatureValues().size()>0))
					{	
						currentBuffer.append("<"+featureXMLElement.toString());
						currentBuffer.append(">");
						currentBuffer.append("\n");
						this.saveFeaturesValues(currentBuffer, feature.getFeatureValues());
						currentBuffer.append("</"+featureXMLElement+">");
					}
					else this.output.println(">");
				}//compute String for xml element, feature in case of t or nt, edgelabel or secedgelabel in case of edge
				else
				{//print normal feature element
					this.output.print("<"+TigerXMLDictionary.ELEMENT_FEATURE.toString());
					if (feature.getId()!= null)
						this.output.print(" "+ TigerXMLDictionary.ATTRIBUTE_ID+"=\""+feature.getId()+"\"");
					if (feature.getName()!= null)
						this.output.print(" "+ TigerXMLDictionary.ATTRIBUTE_NAME+"=\""+feature.getName()+"\"");
					if (feature.getDomain()!= null)
						this.output.print(" "+ TigerXMLDictionary.ATTRIBUTE_DOMAIN+"=\""+feature.getDomain().getName()+"\"");
					
					if (	(feature.getFeatureValues()!= null)||
							(feature.getFeatureValues().size()>0))
					{	
						this.output.println(">");
						this.saveFeaturesValues(feature.getFeatureValues());
						this.output.println("</"+TigerXMLDictionary.ELEMENT_FEATURE.toString()+">");
					}
					else this.output.println(">");
				}//print normal feature element
			}
			if (edgeLabel!= null)
				this.output.println(edgeLabel.toString());
			if (secedgeLabel!= null)
				this.output.println(secedgeLabel.toString());
		}
	}
	
	/**
	 * Stores the given list of {@link FeatureValue} objects as (see {@link TigerXMLDictionary#ELEMENT_VALUE}) elements.
	 * @param corpus corpus to store as sub corpus
	 * @param output Stream to write the data to
	 */
	protected void saveFeaturesValues(EList<FeatureValue> featureValues)
	{
		StringBuffer buf= new StringBuffer();
		this.saveFeaturesValues(buf, featureValues);
		this.output.append(buf.toString());
	}
	
	/**
	 * Stores the given list of {@link FeatureValue} objects as (see {@link TigerXMLDictionary#ELEMENT_VALUE}) elements.
	 * @param corpus corpus to store as sub corpus
	 * @param output Stream to write the data to
	 */
	protected void saveFeaturesValues(StringBuffer output, EList<FeatureValue> featureValues)
	{
		if (featureValues!= null)
		{
			for (FeatureValue featureValue: featureValues)
			{
				output.append("<"+TigerXMLDictionary.ELEMENT_VALUE);
				if (featureValue.getId()!= null)
					output.append(" "+ TigerXMLDictionary.ATTRIBUTE_ID+"=\""+featureValue.getId()+"\"");
				if (featureValue.getValue()!= null)
					output.append(" "+ TigerXMLDictionary.ATTRIBUTE_NAME+"=\""+featureValue.getValue()+"\"");
				
				if (featureValue.getDescription()!= null)
				{
					output.append(">");
					output.append(featureValue.getDescription());
					output.append("</"+TigerXMLDictionary.ELEMENT_VALUE+">");
					output.append("\n");
				}
				else 
				{
					output.append("/>");
					output.append("\n");
				}
			}
		}
	}
	
	/**
	 * Stores the given list of {@link Segment} objects as {@link TigerXMLDictionary#ELEMENT_SEGMENT} elements inside a
	 * {@link TigerXMLDictionary#ELEMENT_BODY} element. 
	 * @param segments
	 */
	protected void saveBody(EList<Segment> segments)
	{
		this.output.println("<"+TigerXMLDictionary.ELEMENT_BODY+">");
		if (	(segments!= null)&&
				(segments.size()> 0))
		{
			for (Segment segment: segments)
			{
				this.output.println("<"+TigerXMLDictionary.ELEMENT_SEGMENT+" "+TigerXMLDictionary.ATTRIBUTE_ID+"=\""+segment.getId()+"\">");
				if (	(segment.getGraphs()!= null)&&
						(segment.getGraphs().size()> 0))
				{
					for (Graph graph: segment.getGraphs())
					{
						if (graph!= null)
							this.saveGraph(graph);
					}
				}
				this.output.println("</"+TigerXMLDictionary.ELEMENT_SEGMENT+">");
			}
		}
		this.output.println("</"+TigerXMLDictionary.ELEMENT_BODY+">");
	}
	/**
	 * Stores the given list of {@link Graph} objects as {@link TigerXMLDictionary#ELEMENT_GRAPH} elements inside a
	 * {@link TigerXMLDictionary#ELEMENT_GRAPH} element. 
	 * @param graph
	 */
	protected void saveGraph(Graph graph)
	{
		this.output.print("<"+TigerXMLDictionary.ELEMENT_GRAPH);
		SyntacticNode synNode= graph.findRoot();
		if (synNode!= null)
			this.output.print(" "+ TigerXMLDictionary.ATTRIBUTE_ROOT+"=\""+synNode.getId()+"\"");
		this.output.println(">");
		//start: store terminal nodes
			if (	(graph.getTerminals()!= null)&&
					(graph.getTerminals().size()> 0))
			{
				this.output.println("<"+TigerXMLDictionary.ELEMENT_TERMINALS+">");
				for (Terminal terminal: graph.getTerminals())
				{
					this.saveTerminal(terminal);
				}
				this.output.println("</"+TigerXMLDictionary.ELEMENT_TERMINALS+">");
			}
		//end: store terminal nodes
			
		//start: store non-terminal nodes
			if (	(graph.getNonTerminals()!= null)&&
					(graph.getNonTerminals().size()> 0))
			{
				this.output.println("<"+TigerXMLDictionary.ELEMENT_NONTERMINALS+">");
				for (NonTerminal nonTerminal: graph.getNonTerminals())
				{
					this.saveNonTerminal(nonTerminal);
				}
				this.output.println("</"+TigerXMLDictionary.ELEMENT_NONTERMINALS+">");
			}
		//end: store non-terminal nodes
		this.output.println("</"+TigerXMLDictionary.ELEMENT_GRAPH+">");
	}
	
	/**
	 * Stores the given list of {@link Terminal} objects as {@link TigerXMLDictionary#ELEMENT_TERMINAL} elements inside a
	 * {@link TigerXMLDictionary#ELEMENT_TERMINAL} element. 
	 * @param terminal
	 */
	protected void saveTerminal(Terminal terminal)
	{
		if (terminal!= null)
		{
			this.output.print("<"+TigerXMLDictionary.ELEMENT_TERMINAL+" "+TigerXMLDictionary.ATTRIBUTE_ID+"=\""+terminal.getId()+"\"");
			if (terminal.getWord()!= null)
			{
				String word= "";
				if (!terminal.getWord().isEmpty())
					word= StringEscapeUtils.escapeXml(terminal.getWord());
				this.output.print(" "+TigerXMLDictionary.ATTRIBUTE_WORD+"=\""+word+"\"");
			}
			this.saveAnnotations(terminal.getAnnotations());
			if (terminal.getGraph().getOutgoingEdges(terminal.getId())!= null)
			{
				this.output.println(">");
				for (Edge edge: terminal.getGraph().getOutgoingEdges(terminal.getId()))
				{
					this.saveEdge(edge);
				}
				this.output.println("</"+TigerXMLDictionary.ELEMENT_TERMINAL+">");
			}
			else this.output.println("/>");
		}
	}
	
	/**
	 * Stores the given list of {@link NonTerminal} objects as {@link TigerXMLDictionary#ELEMENT_NONTERMINAL} elements inside a
	 * {@link TigerXMLDictionary#ELEMENT_NONTERMINALS} element. 
	 * @param nonTerminal
	 */
	protected void saveNonTerminal(NonTerminal nonTerminal)
	{
		if (nonTerminal!= null)
		{
			this.output.print("<"+TigerXMLDictionary.ELEMENT_NONTERMINAL+" "+TigerXMLDictionary.ATTRIBUTE_ID+"=\""+nonTerminal.getId()+"\"");
			this.saveAnnotations(nonTerminal.getAnnotations());
			if (nonTerminal.getGraph().getOutgoingEdges(nonTerminal.getId())!= null)
			{
				this.output.println(">");
				for (Edge edge: nonTerminal.getGraph().getOutgoingEdges(nonTerminal.getId()))
				{
					this.saveEdge(edge);
				}
				this.output.println("</"+TigerXMLDictionary.ELEMENT_NONTERMINAL+">");
			}
			else this.output.println("/>");
		}
	}
	
	/**
	 * Stores the given list of {@link Annotation} objects as attribute value pairs separated by <em>=</em>. If
	 * given list of annotations is empty or null, no annotation will be written.
	 * @param annotations a list of {@link Annotation} objects to be written to stream
	 */
	protected void saveAnnotations(EList<Annotation> annotations)
	{
		if (	(annotations!= null)&&
				(annotations.size()> 0))
		{
			for (Annotation annotation: annotations)
			{
				this.output.print(" "+annotation.getName()+"=\""+StringEscapeUtils.escapeXml(annotation.getValue())+"\"");
			}
		}
	}
	
	/**
	 * Stores the given list of {@link Edge} objects as {@link TigerXMLDictionary#ELEMENT_EDGE}. 
	 * @param edge
	 */
	protected void saveEdge(Edge edge)
	{
		if (edge== null)
			throw new TigerInvalidModelException("Cannot save edge, because it is empty.");
		if (edge.getSource()== null)
			throw new TigerInvalidModelException("Cannot save edge '"+edge+"', because its source is empty.");
		if (edge.getTarget()== null)
			throw new TigerInvalidModelException("Cannot save edge '"+edge+"', because its target is empty.");
		String xmlElement= null;
		//start: compute xml element name: secedge or edge
			if (edge.getType()!= null)
			{
				if (	(DEFAULT_TYPE.PRIM.toString().equalsIgnoreCase(edge.getType())) ||
						((DEFAULT_TYPE.EDGE.toString().equalsIgnoreCase(edge.getType()))))
				{
					xmlElement= TigerXMLDictionary.ELEMENT_EDGE;
				}
				else xmlElement= TigerXMLDictionary.ELEMENT_SECEDGE;
			}
			else
			{	
				String featType= null;
				for (Annotation annotation: edge.getAnnotations())
				{
					if (	(annotation.getFeatureRef().getType()!= null)&&
							(!annotation.getFeatureRef().getType().isEmpty()))
					{
						if (featType== null)
							annotation.getFeatureRef().getType();
						else if (featType.equals(annotation.getFeatureRef().getType()))
							throw new TigerInvalidModelException("Cannot export <tiger2/> model to TigerXML, because the type of Annotation of the given edge '"+edge.getId()+"' is not the same for all annotations.");
					}
				}
				if (	(DEFAULT_TYPE.PRIM.toString().equalsIgnoreCase(featType))||
						(DEFAULT_TYPE.EDGE.toString().equalsIgnoreCase(featType)))
						xmlElement= TigerXMLDictionary.ELEMENT_EDGE;
				else xmlElement= TigerXMLDictionary.ELEMENT_SECEDGE;
			}
		//end: compute xml element name: secedge or edge
		this.output.print("<"+xmlElement);
		this.output.print(" "+TigerXMLDictionary.ATTRIBUTE_IDREF+"=\""+edge.getTarget().getId()+"\"");
		
		//start: print only 'label'-annotation, in case of no label annotation exists, print first annotation
			Annotation labelAnno= null;
			if (	(edge.getAnnotations()!= null)&&
					(edge.getAnnotations().size()>0))
			{
				for (Annotation anno: edge.getAnnotations())
				{
					if (DEFAULT_TYPE.LABEL.toString().equals(anno.getValue()))
					{
						labelAnno= anno;
						break;
					}
				}
				if (labelAnno== null)
					labelAnno= edge.getAnnotations().get(0);
			}
			
			if (labelAnno!= null)
				this.output.print(" "+DEFAULT_TYPE.LABEL.toString()+"=\""+StringEscapeUtils.escapeXml(labelAnno.getValue())+"\"");
		//end: print only 'label'-annotation, in case of no label annotation exists, print first annotation
		
		this.output.println("/>");
	}
}
