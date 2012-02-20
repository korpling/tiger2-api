package de.hu_berlin.german.korpling.tiger2.resources;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import de.hu_berlin.german.korpling.tiger2.Annotation;
import de.hu_berlin.german.korpling.tiger2.Corpus;
import de.hu_berlin.german.korpling.tiger2.Edge;
import de.hu_berlin.german.korpling.tiger2.Feature;
import de.hu_berlin.german.korpling.tiger2.FeatureValue;
import de.hu_berlin.german.korpling.tiger2.Graph;
import de.hu_berlin.german.korpling.tiger2.Meta;
import de.hu_berlin.german.korpling.tiger2.NonTerminal;
import de.hu_berlin.german.korpling.tiger2.Segment;
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
public class Tiger2Writer 
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
	 * Stores the given {@link Corpus} object as super corpus (see {@link Tiger2XML#ELEMENT_CORPUS}).
	 * @param corpus corpus to store as super corpus 
	 */
	protected void saveSuperCorpus(Corpus corpus)
	{
		this.output.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
		this.output.println("<"+Tiger2XML.ELEMENT_CORPUS+" "+Tiger2XML.ATTRIBUTE_ID+"=\""+corpus.getId()+"\""+
							" xmlns=\"http://korpling.german.hu-berlin.de/tiger2/V2.0.4/\""+
							" xmlns:tiger2=\"http://korpling.german.hu-berlin.de/tiger2/V2.0.4/\""+
							" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\""+
							" xsi:schemaLocation=\"http://korpling.german.hu-berlin.de/tiger2/V2.0.4/ http://korpling.german.hu-berlin.de/tiger2/V2.0.4/Tiger2.xsd\">");
		//start: print head
			this.output.println("<"+Tiger2XML.ELEMENT_HEAD+">");
			if (corpus.getMeta()!= null)
				this.saveMeta(corpus.getMeta());
			if (corpus.getFeatures()!= null)
			{
				this.output.println("<"+Tiger2XML.ELEMENT_ANNOTATION+">");
				this.saveFeatures(corpus.getFeatures());
				this.output.println("</"+Tiger2XML.ELEMENT_ANNOTATION+">");
			}
			this.output.println("</"+Tiger2XML.ELEMENT_HEAD+">");
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
		this.output.println("</"+Tiger2XML.ELEMENT_CORPUS+">");
	}
	
	/**
	 * Stores the given {@link Corpus} object as sub corpus (see {@link Tiger2XML#ELEMENT_SUB_CORPUS}).
	 * @param corpus corpus to store as sub corpus
	 */
	protected void saveSubCorpus(Corpus corpus)
	{
		this.output.println("<"+Tiger2XML.ELEMENT_SUB_CORPUS+" "+Tiger2XML.ATTRIBUTE_ID+"=\""+corpus.getId()+"\">");
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
		this.output.println("</"+Tiger2XML.ELEMENT_SUB_CORPUS+">");
	}
	
	/**
	 * Stores the given {@link Meta} object as {@link Tiger2XML#ELEMENT_META}.
	 * @param meta meta data object to store
	 */
	protected void saveMeta(Meta meta)
	{
		this.output.println("<"+Tiger2XML.ELEMENT_META+">");
		if (	(meta.getName()!= null)&&
				(!meta.getName().equals("")))
			this.output.println("<"+Tiger2XML.ELEMENT_NAME+">"+meta.getName()+"</"+Tiger2XML.ELEMENT_NAME+">");
		if (	(meta.getAuthor()!= null)&&
				(!meta.getAuthor().equals("")))
			this.output.println("<"+Tiger2XML.ELEMENT_AUTHOR+">"+meta.getName()+"</"+Tiger2XML.ELEMENT_AUTHOR+">");
		if (	(meta.getDate()!= null)&&
				(!meta.getDate().equals("")))
			this.output.println("<"+Tiger2XML.ELEMENT_DATE+">"+meta.getName()+"</"+Tiger2XML.ELEMENT_DATE+">");
		if (	(meta.getDescription()!= null)&&
				(!meta.getDescription().equals("")))
			this.output.println("<"+Tiger2XML.ELEMENT_DESCRIPTION+">"+meta.getName()+"</"+Tiger2XML.ELEMENT_DESCRIPTION+">");
		if (	(meta.getFormat()!= null)&&
				(!meta.getFormat().equals("")))
			this.output.println("<"+Tiger2XML.ELEMENT_FORMAT+">"+meta.getName()+"</"+Tiger2XML.ELEMENT_FORMAT+">");
		if (	(meta.getHistory()!= null)&&
				(!meta.getHistory().equals("")))
			this.output.println("<"+Tiger2XML.ELEMENT_HISTORY+">"+meta.getName()+"</"+Tiger2XML.ELEMENT_HISTORY+">");
		this.output.println("</"+Tiger2XML.ELEMENT_META+">");
	}
	
	/**
	 * Stores the given list of {@link Feature} objects as (see {@link Tiger2XML#ELEMENT_FEATURE}) elements.
	 * @param corpus corpus to store as sub corpus
	 */
	protected void saveFeatures(EList<Feature> features)
	{
		if (features!= null)
		{
			for (Feature feature: features)
			{
				this.output.print("<"+Tiger2XML.ELEMENT_FEATURE);
				if (feature.getId()!= null)
					this.output.print(" "+ Tiger2XML.ATTRIBUTE_ID+"=\""+feature.getId()+"\"");
				if (feature.getName()!= null)
					this.output.print(" "+ Tiger2XML.ATTRIBUTE_NAME+"=\""+feature.getName()+"\"");
				if (feature.getDomain()!= null)
					this.output.print(" "+ Tiger2XML.ATTRIBUTE_DOMAIN+"=\""+feature.getDomain()+"\"");
				if (feature.getDcrReference()!= null)
					this.output.print(" "+ Tiger2XML.ATTRIBUTE_DAT_CAT+"=\""+feature.getDcrReference()+"\"");
				
				if (	(feature.getFeatureValues()!= null)||
						(feature.getFeatureValues().size()>0))
				{	
					this.output.println(">");
					this.saveFeaturesValues(feature.getFeatureValues());
					this.output.println("</"+Tiger2XML.ELEMENT_FEATURE+">");
				}
				else this.output.println(">");
			}
		}
	}
	
	/**
	 * Stores the given list of {@link FeatureValue} objects as (see {@link Tiger2XML#ELEMENT_VALUE}) elements.
	 * @param corpus corpus to store as sub corpus
	 */
	protected void saveFeaturesValues(EList<FeatureValue> featureValues)
	{
		if (featureValues!= null)
		{
			for (FeatureValue featureValue: featureValues)
			{
				this.output.print("<"+Tiger2XML.ELEMENT_VALUE);
				if (featureValue.getId()!= null)
					this.output.print(" "+ Tiger2XML.ATTRIBUTE_ID+"=\""+featureValue.getId()+"\"");
				if (featureValue.getValue()!= null)
					this.output.print(" "+ Tiger2XML.ATTRIBUTE_NAME+"=\""+featureValue.getValue()+"\"");
				if (featureValue.getDcrReference()!= null)
					this.output.print(" "+ Tiger2XML.ATTRIBUTE_DAT_CAT+"=\""+featureValue.getDcrReference()+"\"");
				
				if (featureValue.getDescription()!= null)
				{
					this.output.print(">");
					this.output.print(featureValue.getDescription());
					this.output.println("</"+Tiger2XML.ELEMENT_VALUE+">");
				}
				else this.output.println("/>"); 
			}
		}
	}
	
	/**
	 * Stores the given list of {@link Segment} objects as {@link Tiger2XML#ELEMENT_SEGMENT} elements inside a
	 * {@link Tiger2XML#ELEMENT_BODY} element. 
	 * @param segments
	 */
	protected void saveBody(EList<Segment> segments)
	{
		this.output.println("<"+Tiger2XML.ELEMENT_BODY+">");
		if (	(segments!= null)&&
				(segments.size()> 0))
		{
			for (Segment segment: segments)
			{
				this.output.println("<"+Tiger2XML.ELEMENT_SEGMENT+" "+Tiger2XML.ATTRIBUTE_ID+"=\""+segment.getId()+"\">");
				if (	(segment.getGraphs()!= null)&&
						(segment.getGraphs().size()> 0))
				{
					for (Graph graph: segment.getGraphs())
					{
						if (graph!= null)
							this.saveGraph(graph);
					}
				}
				this.output.println("</"+Tiger2XML.ELEMENT_SEGMENT+">");
			}
		}
		this.output.println("</"+Tiger2XML.ELEMENT_BODY+">");
	}
	/**
	 * Stores the given list of {@link Graph} objects as {@link Tiger2XML#ELEMENT_GRAPH} elements inside a
	 * {@link Tiger2XML#ELEMENT_GRAPH} element. 
	 * @param graph
	 */
	protected void saveGraph(Graph graph)
	{
		this.output.println("<"+Tiger2XML.ELEMENT_GRAPH+" "+Tiger2XML.ATTRIBUTE_ID+"=\""+graph.getId()+"\">");
		//start: store terminal nodes
			if (	(graph.getTerminals()!= null)&&
					(graph.getTerminals().size()> 0))
			{
				this.output.println("<"+Tiger2XML.ELEMENT_TERMINALS+">");
				for (Terminal terminal: graph.getTerminals())
				{
					this.saveTerminal(terminal);
				}
				this.output.println("</"+Tiger2XML.ELEMENT_TERMINALS+">");
			}
		//end: store terminal nodes
			
		//start: store non-terminal nodes
			if (	(graph.getNonTerminals()!= null)&&
					(graph.getNonTerminals().size()> 0))
			{
				this.output.println("<"+Tiger2XML.ELEMENT_NONTERMINALS+">");
				for (NonTerminal nonTerminal: graph.getNonTerminals())
				{
					this.saveNonTerminal(nonTerminal);
				}
				this.output.println("</"+Tiger2XML.ELEMENT_NONTERMINALS+">");
			}
		//end: store non-terminal nodes
		this.output.println("</"+Tiger2XML.ELEMENT_GRAPH+">");
	}
	
	/**
	 * Stores the given list of {@link Terminal} objects as {@link Tiger2XML#ELEMENT_TERMINAL} elements inside a
	 * {@link Tiger2XML#ELEMENT_TERMINAL} element. 
	 * @param terminal
	 */
	protected void saveTerminal(Terminal terminal)
	{
		this.output.print("<"+Tiger2XML.ELEMENT_TERMINAL+" "+Tiger2XML.ATTRIBUTE_ID+"=\""+terminal.getId());
		this.output.print(" "+Tiger2XML.ATTRIBUTE_WORD+"=\""+terminal.getWord()+"\"");
		this.output.print(" "+Tiger2XML.ATTRIBUTE_TYPE+"=\""+terminal.getType()+"\"");
		this.saveAnnotations(terminal.getAnnotations());
		this.output.println("/>");
	}
	
	/**
	 * Stores the given list of {@link NonTerminal} objects as {@link Tiger2XML#ELEMENT_NONTERMINAL} elements inside a
	 * {@link Tiger2XML#ELEMENT_NONTERMINALS} element. 
	 * @param nonTerminal
	 */
	protected void saveNonTerminal(NonTerminal nonTerminal)
	{
		if (nonTerminal!= null)
		{
			this.output.print("<"+Tiger2XML.ELEMENT_NONTERMINAL+" "+Tiger2XML.ATTRIBUTE_ID+"=\""+nonTerminal.getId());
			this.output.print(" "+Tiger2XML.ATTRIBUTE_TYPE+"=\""+nonTerminal.getType()+"\"");
			
			this.saveAnnotations(nonTerminal.getAnnotations());
			if (nonTerminal.getGraph().getOutgoingEdges(nonTerminal.getId())!= null)
			{
				this.output.println("\">");
				for (Edge edge: nonTerminal.getGraph().getOutgoingEdges(nonTerminal.getId()))
				{
					this.saveEdge(edge);
				}
				this.output.println("</"+Tiger2XML.ELEMENT_NONTERMINAL+">");
			}
			else this.output.println("\">");
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
				this.output.print(" "+annotation.getName()+"=\""+annotation.getValue()+"\"");
			}
		}
	}
	
	/**
	 * Stores the given list of {@link Edge} objects as {@link Tiger2XML#ELEMENT_EDGE}. 
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
		this.output.print("<"+Tiger2XML.ELEMENT_EDGE+" "+Tiger2XML.ATTRIBUTE_ID+"\""+edge.getId());
		this.output.print(" "+Tiger2XML.ATTRIBUTE_TYPE+"=\""+edge.getType()+"\"");
		this.output.print(" "+Tiger2XML.ATTRIBUTE_TARGET+"=\""+edge.getTarget().getId()+"\"");
		
		this.saveAnnotations(edge.getAnnotations());
		this.output.println("\">");
	}
}