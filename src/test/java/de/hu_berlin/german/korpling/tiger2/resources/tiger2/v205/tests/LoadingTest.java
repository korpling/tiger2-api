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
/**
 * 
 */
package de.hu_berlin.german.korpling.tiger2.resources.tiger2.v205.tests;


import java.io.File;
import java.io.IOException;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.german.korpling.tiger2.Corpus;
import de.hu_berlin.german.korpling.tiger2.DOMAIN;
import de.hu_berlin.german.korpling.tiger2.Edge;
import de.hu_berlin.german.korpling.tiger2.Feature;
import de.hu_berlin.german.korpling.tiger2.FeatureValue;
import de.hu_berlin.german.korpling.tiger2.Graph;
import de.hu_berlin.german.korpling.tiger2.Segment;
import de.hu_berlin.german.korpling.tiger2.SyntacticNode;
import de.hu_berlin.german.korpling.tiger2.Terminal;
import de.hu_berlin.german.korpling.tiger2.resources.TigerResourceFactory;

/**
 * @author Florian Zipser
 *
 */
public class LoadingTest extends TestCase{

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(LoadingTest.class);
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		resourceSet= new ResourceSetImpl();
		// Register XML resource factory
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("tiger2",new TigerResourceFactory());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	public ResourceSet resourceSet = null;
	
	public static final String TEST_FOLDER="./src/test/resources/tiger2/";
	
	@Test
	public void testReadHeader_intern() throws IOException
	{
		File inputFile= new File(TEST_FOLDER+ "internMeta/header.tiger2");
		
		//load resource 
		Resource resource = resourceSet.createResource(URI.createFileURI(inputFile.getAbsolutePath()));
		
		if (resource== null)
			throw new NullPointerException("The resource is null.");
		resource.load(null);
		
		Corpus corpus= (Corpus) resource.getContents().get(0);
		assertNotNull(corpus);
		assertNotNull(corpus.getMeta());
		assertEquals("example.inline.tiger2", corpus.getMeta().getName());
		assertEquals("Amir Zeldes", corpus.getMeta().getAuthor());
		assertEquals("24 June 2010", corpus.getMeta().getDate());
		assertEquals("tiger2 XML with inline terminals", corpus.getMeta().getDescription());
		assertEquals("Modified PTB tagset", corpus.getMeta().getFormat());
		assertEquals("First version", corpus.getMeta().getHistory());
	}
	
	@Test
	public void testReadHeader_extern() throws IOException
	{
		File inputFile= new File(TEST_FOLDER+ "externMeta/header.tiger2");
		
		//load resource 
		Resource resource = resourceSet.createResource(URI.createFileURI(inputFile.getAbsolutePath()));
		
		if (resource== null)
			throw new NullPointerException("The resource is null.");
		resource.load(null);
		
		Corpus corpus= (Corpus) resource.getContents().get(0);
		assertNotNull(corpus);
		assertNotNull(corpus.getMeta());
		assertEquals("My Corpus", corpus.getMeta().getName());
		assertEquals("author", corpus.getMeta().getAuthor());
		assertEquals("date", corpus.getMeta().getDate());
		assertEquals("description of the corpus", corpus.getMeta().getDescription());
		assertEquals("original format, if the corpus was not born as tiger-2-corpus", corpus.getMeta().getFormat());
		assertEquals("version of the corpus", corpus.getMeta().getHistory());
	}
	
	@Test
	public void testReadAnnotation_intern() throws IOException
	{
		File inputFile= new File(TEST_FOLDER+ "annotationIntern/annotation.tiger2");
		
		//load resource 
		Resource resource = resourceSet.createResource(URI.createFileURI(inputFile.getAbsolutePath()));
		
		if (resource== null)
			throw new NullPointerException("The resource is null.");
		resource.load(null);
		
		Corpus corpus= (Corpus) resource.getContents().get(0);
		assertNotNull(corpus);
		assertNotNull(corpus.getFeatures());
		assertEquals(6, corpus.getFeatures().size());
		assertNotNull(corpus.findFeature("word", DOMAIN.T));
		assertNotNull(corpus.findFeature("lemma", DOMAIN.T));
		
		Feature feature= null;
		FeatureValue featureValue= null;
		
		feature= corpus.findFeature("pos", DOMAIN.T);
		assertNotNull(feature);
		assertEquals(java.net.URI.create("http://www.isocat.org/datcat/DC-396"), feature.getDcrReference());
		
		featureValue= corpus.findFeatureValue("pos", DOMAIN.T, "JJ"); 
		assertNotNull(featureValue);
		assertEquals("Adjective", featureValue.getDescription());
		assertEquals(java.net.URI.create("http://www.isocat.org/datcat/DC-1230"), featureValue.getDcrReference());
		
		featureValue= corpus.findFeatureValue("pos", DOMAIN.T, "NN"); 
		assertNotNull(featureValue);
		assertEquals("Noun, singular or mass", featureValue.getDescription());
		
		feature= corpus.findFeature("cat", DOMAIN.NT);
		assertNotNull(feature);
		
		featureValue= corpus.findFeatureValue("cat", DOMAIN.NT, "NP"); 
		assertNotNull(featureValue);
		assertEquals("Nominal Phrase", featureValue.getDescription());
		
		featureValue= corpus.findFeatureValue("cat", DOMAIN.NT, "S"); 
		assertNotNull(featureValue);
		assertEquals("Sentence or Clause", featureValue.getDescription());
		
		featureValue= corpus.findFeatureValue("cat", DOMAIN.NT, "VP"); 
		assertNotNull(featureValue);
		assertEquals("Verbal Phrase", featureValue.getDescription());
		
		featureValue= corpus.findFeatureValue("cat", DOMAIN.NT, "ROOT"); 
		assertNotNull(featureValue);
		assertEquals("Graph Root", featureValue.getDescription());
	}
	
	@Test
	public void testReadAnnotation_extern() throws IOException
	{
		File inputFile= new File(TEST_FOLDER+ "annotationExtern/corpus.tiger2");
		
		//load resource 
		Resource resource = resourceSet.createResource(URI.createFileURI(inputFile.getAbsolutePath()));
		
		if (resource== null)
			throw new NullPointerException("The resource is null.");
		resource.load(null);
		
		Corpus corpus= (Corpus) resource.getContents().get(0);
		assertNotNull(corpus);
		assertNotNull(corpus.getFeatures());
		assertEquals(6, corpus.getFeatures().size());
		assertNotNull(corpus.findFeature("word", DOMAIN.T));
		assertNotNull(corpus.findFeature("lemma", DOMAIN.T));
		
		Feature feature= null;
		FeatureValue featureValue= null;
		
		feature= corpus.findFeature("pos", DOMAIN.T);
		assertNotNull(feature);
		assertEquals(java.net.URI.create("http://www.isocat.org/datcat/DC-396"), feature.getDcrReference());
		
		featureValue= corpus.findFeatureValue("pos", DOMAIN.T, "JJ"); 
		assertNotNull(featureValue);
		assertEquals("Adjective", featureValue.getDescription());
		assertEquals(java.net.URI.create("http://www.isocat.org/datcat/DC-1230"), featureValue.getDcrReference());
		
		featureValue= corpus.findFeatureValue("pos", DOMAIN.T, "NN"); 
		assertNotNull(featureValue);
		assertEquals("Noun, singular or mass", featureValue.getDescription());
		
		feature= corpus.findFeature("cat", DOMAIN.NT);
		assertNotNull(feature);
		
		featureValue= corpus.findFeatureValue("cat", DOMAIN.NT, "NP"); 
		assertNotNull(featureValue);
		assertEquals("Nominal Phrase", featureValue.getDescription());
		
		featureValue= corpus.findFeatureValue("cat", DOMAIN.NT, "S"); 
		assertNotNull(featureValue);
		assertEquals("Sentence or Clause", featureValue.getDescription());
		
		featureValue= corpus.findFeatureValue("cat", DOMAIN.NT, "VP"); 
		assertNotNull(featureValue);
		assertEquals("Verbal Phrase", featureValue.getDescription());
		
		featureValue= corpus.findFeatureValue("cat", DOMAIN.NT, "ROOT"); 
		assertNotNull(featureValue);
		assertEquals("Graph Root", featureValue.getDescription());
	}
	
	@Test
	public void testReadTerminals() throws IOException
	{
		File inputFile= new File(TEST_FOLDER+ "terminals/terminals.tiger2");
		
		//load resource 
		Resource resource = resourceSet.createResource(URI.createFileURI(inputFile.getAbsolutePath()));
		
		if (resource== null)
			throw new NullPointerException("The resource is null.");
		resource.load(null);
		
		Corpus corpus= (Corpus) resource.getContents().get(0);
		assertNotNull(corpus);
		assertEquals(1, corpus.getSegments().size());
		Segment segment= corpus.getSegments().get(0);
		assertNotNull(segment);
		assertEquals(1, segment.getGraphs().size());
		Graph graph= segment.getGraphs().get(0);
		assertNotNull(graph);
		assertEquals(7,graph.getTerminals().size());

		SyntacticNode synNode= null;
		//start: check terminals
			synNode= graph.findNode("s1_t1");
			assertNotNull(synNode);
			assertEquals("I", ((Terminal)synNode).getWord());
			assertNotNull(synNode.findAnnotation("lemma"));
			assertEquals("I", synNode.findAnnotation("lemma").getValue());
			assertNotNull(synNode.findAnnotation("pos"));
			assertEquals("PP", synNode.findAnnotation("pos").getValue());
			
			synNode= graph.findNode("s1_t2");
			assertNotNull(synNode);
			assertEquals("wanna", ((Terminal)synNode).getWord());
			assertNotNull(synNode.findAnnotation("lemma"));
			assertEquals("wanna", synNode.findAnnotation("lemma").getValue());
			assertNotNull(synNode.findAnnotation("pos"));
			assertEquals("VBP", synNode.findAnnotation("pos").getValue());
	
			synNode= graph.findNode("s1_t3");
			assertNotNull(synNode);
			assertEquals("put", ((Terminal)synNode).getWord());
			assertNotNull(synNode.findAnnotation("lemma"));
			assertEquals("put", synNode.findAnnotation("lemma").getValue());
			assertNotNull(synNode.findAnnotation("pos"));
			assertEquals("VB", synNode.findAnnotation("pos").getValue());
			
			synNode= graph.findNode("s1_t4");
			assertNotNull(synNode);
			assertEquals("up", ((Terminal)synNode).getWord());
			assertNotNull(synNode.findAnnotation("lemma"));
			assertEquals("up", synNode.findAnnotation("lemma").getValue());
			assertNotNull(synNode.findAnnotation("pos"));
			assertEquals("RP", synNode.findAnnotation("pos").getValue());
			
			synNode= graph.findNode("s1_t5");
			assertNotNull(synNode);
			assertEquals("new", ((Terminal)synNode).getWord());
			assertNotNull(synNode.findAnnotation("lemma"));
			assertEquals("new", synNode.findAnnotation("lemma").getValue());
			assertNotNull(synNode.findAnnotation("pos"));
			assertEquals("JJ", synNode.findAnnotation("pos").getValue());
			
			synNode= graph.findNode("s1_t6");
			assertNotNull(synNode);
			assertEquals("wallpaper", ((Terminal)synNode).getWord());
			assertNotNull(synNode.findAnnotation("lemma"));
			assertEquals("wallpaper", synNode.findAnnotation("lemma").getValue());
			assertNotNull(synNode.findAnnotation("pos"));
			assertEquals("NN", synNode.findAnnotation("pos").getValue());
			
			synNode= graph.findNode("s1_t7");
			assertNotNull(synNode);
			assertEquals(".", ((Terminal)synNode).getWord());
			assertNotNull(synNode.findAnnotation("lemma"));
			assertEquals(".", synNode.findAnnotation("lemma").getValue());
			assertNotNull(synNode.findAnnotation("pos"));
			assertEquals(".", synNode.findAnnotation("pos").getValue());
		//end: check terminals
	}
	
	@Test
	public void testReadOneCorpus() throws IOException
	{
		File inputFile= new File(TEST_FOLDER+ "oneCorpus/corpus.tiger2");
		
		//load resource 
		Resource resource = resourceSet.createResource(URI.createFileURI(inputFile.getAbsolutePath()));
		
		if (resource== null)
			throw new NullPointerException("The resource is null.");
		resource.load(null);
		
		Corpus corpus= (Corpus) resource.getContents().get(0);
		assertNotNull(corpus);
		assertEquals(1, corpus.getSegments().size());
		Segment segment= corpus.getSegments().get(0);
		assertNotNull(segment);
		assertEquals(1, segment.getGraphs().size());
		Graph graph= segment.getGraphs().get(0);
		assertNotNull(graph);
		assertEquals(7,graph.getTerminals().size());

		SyntacticNode synNode= null;
		//start: check terminals
			synNode= graph.findNode("s1_t1");
			assertNotNull(synNode);
			assertEquals("I", ((Terminal)synNode).getWord());
			assertNotNull(synNode.findAnnotation("lemma"));
			assertEquals("I", synNode.findAnnotation("lemma").getValue());
			assertNotNull(synNode.findAnnotation("pos"));
			assertEquals("PP", synNode.findAnnotation("pos").getValue());
			
			synNode= graph.findNode("s1_t2");
			assertNotNull(synNode);
			assertEquals("wanna", ((Terminal)synNode).getWord());
			assertNotNull(synNode.findAnnotation("lemma"));
			assertEquals("wanna", synNode.findAnnotation("lemma").getValue());
			assertNotNull(synNode.findAnnotation("pos"));
			assertEquals("VBP", synNode.findAnnotation("pos").getValue());
	
			synNode= graph.findNode("s1_t3");
			assertNotNull(synNode);
			assertEquals("put", ((Terminal)synNode).getWord());
			assertNotNull(synNode.findAnnotation("lemma"));
			assertEquals("put", synNode.findAnnotation("lemma").getValue());
			assertNotNull(synNode.findAnnotation("pos"));
			assertEquals("VB", synNode.findAnnotation("pos").getValue());
			
			synNode= graph.findNode("s1_t4");
			assertNotNull(synNode);
			assertEquals("up", ((Terminal)synNode).getWord());
			assertNotNull(synNode.findAnnotation("lemma"));
			assertEquals("up", synNode.findAnnotation("lemma").getValue());
			assertNotNull(synNode.findAnnotation("pos"));
			assertEquals("RP", synNode.findAnnotation("pos").getValue());
			
			synNode= graph.findNode("s1_t5");
			assertNotNull(synNode);
			assertEquals("new", ((Terminal)synNode).getWord());
			assertNotNull(synNode.findAnnotation("lemma"));
			assertEquals("new", synNode.findAnnotation("lemma").getValue());
			assertNotNull(synNode.findAnnotation("pos"));
			assertEquals("JJ", synNode.findAnnotation("pos").getValue());
			
			synNode= graph.findNode("s1_t6");
			assertNotNull(synNode);
			assertEquals("wallpaper", ((Terminal)synNode).getWord());
			assertNotNull(synNode.findAnnotation("lemma"));
			assertEquals("wallpaper", synNode.findAnnotation("lemma").getValue());
			assertNotNull(synNode.findAnnotation("pos"));
			assertEquals("NN", synNode.findAnnotation("pos").getValue());
			
			synNode= graph.findNode("s1_t7");
			assertNotNull(synNode);
			assertEquals(".", ((Terminal)synNode).getWord());
			assertNotNull(synNode.findAnnotation("lemma"));
			assertEquals(".", synNode.findAnnotation("lemma").getValue());
			assertNotNull(synNode.findAnnotation("pos"));
			assertEquals(".", synNode.findAnnotation("pos").getValue());
		//end: check terminals
		
		//start: check nonterminals
			synNode= graph.findNode("s1_nt1");
			assertNotNull(synNode);
			assertNotNull(synNode.findAnnotation("cat"));
			assertEquals("NP", synNode.findAnnotation("cat").getValue());
			
			synNode= graph.findNode("s1_nt2");
			assertNotNull(synNode);
			assertNotNull(synNode.findAnnotation("cat"));
			assertEquals("VP", synNode.findAnnotation("cat").getValue());
			
			synNode= graph.findNode("s1_nt3");
			assertNotNull(synNode);
			assertNotNull(synNode.findAnnotation("cat"));
			assertEquals("VP", synNode.findAnnotation("cat").getValue());
			
			synNode= graph.findNode("s1_nt4");
			assertNotNull(synNode);
			assertNotNull(synNode.findAnnotation("cat"));
			assertEquals("NP", synNode.findAnnotation("cat").getValue());
			
			synNode= graph.findNode("s1_nt5");
			assertNotNull(synNode);
			assertNotNull(synNode.findAnnotation("cat"));
			assertEquals("S", synNode.findAnnotation("cat").getValue());

			synNode= graph.findNode("s1_nt6");
			assertNotNull(synNode);
			assertNotNull(synNode.findAnnotation("cat"));
			assertEquals("S", synNode.findAnnotation("cat").getValue());
			
			synNode= graph.findNode("s1_ROOT");
			assertNotNull(synNode);
			assertNotNull(synNode.findAnnotation("cat"));
			assertEquals("ROOT", synNode.findAnnotation("cat").getValue());
		//end: check nonterminals
		
		//start: check edges
			Edge edge= null;
			edge= graph.findEdge("s1_e1");
			assertNotNull(edge);
			assertEquals("prim", edge.getType());
			assertNotNull(edge.getSource());
			assertNotNull(edge.getTarget());
			assertEquals(graph.findNode("s1_nt1"), edge.getSource());
			assertEquals(graph.findNode("s1_t1"), edge.getTarget());
			
			edge= graph.findEdge("s1_e2");
			assertNotNull(edge);
			assertEquals("prim", edge.getType());
			assertNotNull(edge.getSource());
			assertNotNull(edge.getTarget());
			assertEquals(graph.findNode("s1_nt2"), edge.getSource());
			assertEquals(graph.findNode("s1_t2"), edge.getTarget());
			
			edge= graph.findEdge("s1_e3");
			assertNotNull(edge);
			assertEquals("prim", edge.getType());
			assertNotNull(edge.getSource());
			assertNotNull(edge.getTarget());
			assertEquals(graph.findNode("s1_nt3"), edge.getSource());
			assertEquals(graph.findNode("s1_t3"), edge.getTarget());
			
			edge= graph.findEdge("s1_e4");
			assertNotNull(edge);
			assertEquals("prim", edge.getType());
			assertNotNull(edge.getSource());
			assertNotNull(edge.getTarget());
			assertEquals(graph.findNode("s1_nt3"), edge.getSource());
			assertEquals(graph.findNode("s1_t4"), edge.getTarget());
			
			edge= graph.findEdge("s1_e5");
			assertNotNull(edge);
			assertEquals("prim", edge.getType());
			assertNotNull(edge.getSource());
			assertNotNull(edge.getTarget());
			assertEquals(graph.findNode("s1_nt3"), edge.getSource());
			assertEquals(graph.findNode("s1_nt4"), edge.getTarget());
		//end: check edges
	}
	
	/**
	 * Checks if all edges are read correctly in sense of relating a source and a target node.
	 * @throws IOException
	 */
	@Test
	public void testCorrectNumberOfEdges() throws IOException
	{
		File inputFile= new File(TEST_FOLDER+ "edges/corpus.tiger2");
		
		//load resource 
		Resource resource = resourceSet.createResource(URI.createFileURI(inputFile.getAbsolutePath()));
		
		if (resource== null)
			throw new NullPointerException("The resource is null.");
		resource.load(null);
		
		Corpus corpus= (Corpus) resource.getContents().get(0);
		assertNotNull(corpus);
		assertEquals(1, corpus.getSegments().size());
		Segment segment= corpus.getSegments().get(0);
		assertNotNull(segment);
		assertEquals(1, segment.getGraphs().size());
		Graph graph= segment.getGraphs().get(0);
		assertNotNull(graph);
		
		assertEquals(41, graph.getEdges().size());
		//start: check edges for terminals
			assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s1_t2").size());
			assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s1_t10").size());
			assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s1_t12").size());
			assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s1_t14").size());
			assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s1_t16").size());
			assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s1_t18").size());
			assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s1_t22").size());
			assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s1_t24").size());
		//end: check edges for terminals
			
		//start: check edges for non-terminals (outgoing edges)
			assertEquals(2, graph.getOutgoingEdges("WPD.AAA.00001_s1_nt28").size());
			assertEquals(8, graph.getOutgoingEdges("WPD.AAA.00001_s1_nt43").size());
			assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s1_nt41").size());
			assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s1_nt33").size());
			assertEquals(2, graph.getOutgoingEdges("WPD.AAA.00001_s1_nt29").size());
			assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s1_nt42").size());
			assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s1_nt34").size());
			assertEquals(3, graph.getOutgoingEdges("WPD.AAA.00001_s1_nt30").size());
			assertEquals(2, graph.getOutgoingEdges("WPD.AAA.00001_s1_nt38").size());
			assertEquals(2, graph.getOutgoingEdges("WPD.AAA.00001_s1_nt35").size());
			assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s1_nt31").size());
			assertEquals(2, graph.getOutgoingEdges("WPD.AAA.00001_s1_nt39").size());
			assertEquals(2, graph.getOutgoingEdges("WPD.AAA.00001_s1_nt36").size());
			assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s1_nt32").size());
			assertEquals(2, graph.getOutgoingEdges("WPD.AAA.00001_s1_nt40").size());
			assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s1_nt37").size());
		//end: check edges non-for terminals (outgoing edges)
	}
	
	/**
	 * Checks interferences between two graphs contained in one file.
	 * @throws IOException
	 */
	@Test
	public void testInterferences() throws IOException
	{
		File inputFile= new File(TEST_FOLDER+ "moreGraphs/twoGraphs.tiger2");
		
		//load resource 
		Resource resource = resourceSet.createResource(URI.createFileURI(inputFile.getAbsolutePath()));
		
		if (resource== null)
			throw new NullPointerException("The resource is null.");
		resource.load(null);
		
		Corpus corpus= (Corpus) resource.getContents().get(0);
		assertNotNull(corpus);
		assertEquals(2, corpus.getSegments().size());
		
		//start: check segment 1
			Segment segment= corpus.getSegments().get(0);
			assertEquals("WPD.AAA.00001_s1", segment.getId());
			assertNotNull(segment);
			assertEquals(1, segment.getGraphs().size());
			Graph graph= segment.getGraphs().get(0);
			assertNotNull(graph);
			
			assertEquals(41, graph.getEdges().size());
			//start: check edges for terminals
				assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s1_t2").size());
				assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s1_t10").size());
				assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s1_t12").size());
				assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s1_t14").size());
				assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s1_t16").size());
				assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s1_t18").size());
				assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s1_t22").size());
				assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s1_t24").size());
			//end: check edges for terminals
				
			//start: check edges for non-terminals (outgoing edges)
				assertEquals(2, graph.getOutgoingEdges("WPD.AAA.00001_s1_nt28").size());
				assertEquals(8, graph.getOutgoingEdges("WPD.AAA.00001_s1_nt43").size());
				assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s1_nt41").size());
				assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s1_nt33").size());
				assertEquals(2, graph.getOutgoingEdges("WPD.AAA.00001_s1_nt29").size());
				assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s1_nt42").size());
				assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s1_nt34").size());
				assertEquals(3, graph.getOutgoingEdges("WPD.AAA.00001_s1_nt30").size());
				assertEquals(2, graph.getOutgoingEdges("WPD.AAA.00001_s1_nt38").size());
				assertEquals(2, graph.getOutgoingEdges("WPD.AAA.00001_s1_nt35").size());
				assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s1_nt31").size());
				assertEquals(2, graph.getOutgoingEdges("WPD.AAA.00001_s1_nt39").size());
				assertEquals(2, graph.getOutgoingEdges("WPD.AAA.00001_s1_nt36").size());
				assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s1_nt32").size());
				assertEquals(2, graph.getOutgoingEdges("WPD.AAA.00001_s1_nt40").size());
				assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s1_nt37").size());
			//end: check edges non-for terminals (outgoing edges)
		//end: check segment 1
				
		//start: check segment 2
			segment= corpus.getSegments().get(1);
			assertEquals("WPD.AAA.00001_s2", segment.getId());
			assertNotNull(segment);
			assertEquals(1, segment.getGraphs().size());
			graph= segment.getGraphs().get(0);
			assertNotNull(graph);
			
			assertEquals(42, graph.getEdges().size());
			//start: check edges for terminals
				assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s2_t0").size());
				assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s2_t2").size());
				assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s2_t10").size());
				assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s2_t14").size());
				assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s2_t16").size());
				assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s2_t18").size());
				assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s2_t22").size());
			//end: check edges for terminals
				
			//start: check edges for non-terminals (outgoing edges)
				assertEquals(2, graph.getOutgoingEdges("WPD.AAA.00001_s2_nt28").size());
				assertEquals(6, graph.getOutgoingEdges("WPD.AAA.00001_s2_nt46").size());
				assertEquals(2, graph.getOutgoingEdges("WPD.AAA.00001_s2_nt39").size());
				assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s2_nt34").size());
				assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s2_nt41").size());
				assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s2_nt35").size());
				assertEquals(2, graph.getOutgoingEdges("WPD.AAA.00001_s2_nt29").size());
				assertEquals(3, graph.getOutgoingEdges("WPD.AAA.00001_s2_nt44").size());
				assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s2_nt42").size());
				assertEquals(2, graph.getOutgoingEdges("WPD.AAA.00001_s2_nt36").size());
				assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s2_nt31").size());
				assertEquals(2, graph.getOutgoingEdges("WPD.AAA.00001_s2_nt40").size());
				assertEquals(2, graph.getOutgoingEdges("WPD.AAA.00001_s2_nt37").size());
				assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s2_nt32").size());
				assertEquals(3, graph.getOutgoingEdges("WPD.AAA.00001_s2_nt45").size());
				assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s2_nt43").size());
				assertEquals(2, graph.getOutgoingEdges("WPD.AAA.00001_s2_nt38").size());
				assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s2_nt33").size());
				assertEquals(1, graph.getOutgoingEdges("WPD.AAA.00001_s2_nt30").size());
			//end: check edges non-for terminals (outgoing edges)
		//end: check segment 2
	}
}
