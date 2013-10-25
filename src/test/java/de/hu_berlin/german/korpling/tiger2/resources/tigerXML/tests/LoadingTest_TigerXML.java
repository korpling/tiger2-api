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
package de.hu_berlin.german.korpling.tiger2.resources.tigerXML.tests;


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
import de.hu_berlin.german.korpling.tiger2.DEFAULT_TYPE;
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
public class LoadingTest_TigerXML extends TestCase{

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(LoadingTest_TigerXML.class);
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		resourceSet= new ResourceSetImpl();
		// Register XML resource factory
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xml",new TigerResourceFactory());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	public ResourceSet resourceSet = null;
	
	public static final String TEST_FOLDER="./src/test/resources/tigerXML/";
	
	/**
	 * Tests a small sample corpus, having some meta annotations, annotation definitions and one segments including
	 * one graph. 
	 * @throws IOException
	 */
	@Test
	public void testReadEntireCorpus1() throws IOException
	{
		File inputFile= new File(TEST_FOLDER+ "corpus1/corpus1.xml");
		
		//load resource 
		Resource resource = resourceSet.createResource(URI.createFileURI(inputFile.getAbsolutePath()));
		
		if (resource== null)
			throw new NullPointerException("The resource is null.");
		resource.load(null);
		
		SyntacticNode synNode= null;
		
		assertNotNull(resource.getContents());
		assertEquals(1, resource.getContents().size());
		
		Corpus corpus= (Corpus) resource.getContents().get(0);
		assertNotNull(corpus);
		assertNotNull(corpus.getMeta());
		assertEquals("KidKo", corpus.getId());
		assertEquals("Sample fuer IDS Korpustechnologie-Messe", corpus.getMeta().getName());
		assertEquals("Negra Format, Version 4", corpus.getMeta().getFormat());
		assertEquals("SFB 632 B6", corpus.getMeta().getAuthor());
		
		assertNotNull(corpus.getSegments());
		assertEquals(1, corpus.getSegments().size());
		assertNotNull(corpus.getSegments().get(0).getGraphs());
		assertEquals(1, corpus.getSegments().get(0).getGraphs().size());
		
		Graph graph= corpus.getSegments().get(0).getGraphs().get(0);
		assertEquals(3, graph.getTerminals().size());
		assertEquals(2, graph.getNonTerminals().size());
		assertEquals(4, graph.getEdges().size());
		
		//terminals
			synNode= graph.findNode("s4_1");
			assertNotNull(synNode);
			assertEquals("Hier", ((Terminal)synNode).getWord());
			assertNotNull(synNode.findAnnotation("lemma"));
			assertEquals("hier", synNode.findAnnotation("lemma").getValue());
			assertNotNull(synNode.findAnnotation("pos"));
			assertEquals("ADV", synNode.findAnnotation("pos").getValue());
			
			synNode= graph.findNode("s4_2");
			assertNotNull(synNode);
			assertEquals("Johnny", ((Terminal)synNode).getWord());
			assertNotNull(synNode.findAnnotation("lemma"));
			assertEquals("JOHNny", synNode.findAnnotation("lemma").getValue());
			assertNotNull(synNode.findAnnotation("pos"));
			assertEquals("NE", synNode.findAnnotation("pos").getValue());
			
			synNode= graph.findNode("s4_3");
			assertNotNull(synNode);
			assertEquals(".", ((Terminal)synNode).getWord());
			assertNotNull(synNode.findAnnotation("lemma"));
			assertEquals("--", synNode.findAnnotation("lemma").getValue());
			assertNotNull(synNode.findAnnotation("pos"));
			assertEquals("$.", synNode.findAnnotation("pos").getValue());
		//terminals
		
		//nonterminals
			synNode= graph.findNode("s4_501");
			assertNotNull(synNode);
			assertNotNull(synNode.findAnnotation("cat"));
			assertEquals("NSU", synNode.findAnnotation("cat").getValue());
			
			synNode= graph.findNode("s4_500");
			assertNotNull(synNode);
			assertNotNull(synNode.findAnnotation("cat"));
			assertEquals("VROOT", synNode.findAnnotation("cat").getValue());
		//nonterminals
			
		//start: check edges
			assertEquals(4, graph.getEdges().size());
			
			Edge edge= null;
			
			edge= graph.findEdge("e1");
			assertNotNull(edge);
			assertEquals(DEFAULT_TYPE.PRIM.toString(), edge.getType());
			assertNotNull(edge.getSource());
			assertNotNull(edge.getTarget());
			assertEquals(graph.findNode("s4_501"), edge.getSource());
			assertEquals(graph.findNode("s4_1"), edge.getTarget());
			assertNotNull(edge.findAnnotation(DEFAULT_TYPE.LABEL.toString()));
			assertEquals("MO", edge.findAnnotation(DEFAULT_TYPE.LABEL.toString()).getValue());
			
			edge= graph.findEdge("e2");
			assertNotNull(edge);
			assertEquals(DEFAULT_TYPE.PRIM.toString(), edge.getType());
			assertNotNull(edge.getSource());
			assertNotNull(edge.getTarget());
			assertEquals(graph.findNode("s4_501"), edge.getSource());
			assertEquals(graph.findNode("s4_2"), edge.getTarget());
			assertNotNull(edge.findAnnotation(DEFAULT_TYPE.LABEL.toString()));
			assertEquals("SB", edge.findAnnotation(DEFAULT_TYPE.LABEL.toString()).getValue());
			
			edge= graph.findEdge("e3");
			assertNotNull(edge);
			assertEquals(DEFAULT_TYPE.PRIM.toString(), edge.getType());
			assertNotNull(edge.getSource());
			assertNotNull(edge.getTarget());
			assertEquals(graph.findNode("s4_500"), edge.getSource());
			assertEquals(graph.findNode("s4_501"), edge.getTarget());
			assertNotNull(edge.findAnnotation(DEFAULT_TYPE.LABEL.toString()));
			assertEquals("--", edge.findAnnotation(DEFAULT_TYPE.LABEL.toString()).getValue());
			
			edge= graph.findEdge("e4");
			assertNotNull(edge);
			assertEquals(DEFAULT_TYPE.PRIM.toString(), edge.getType());
			assertNotNull(edge.getSource());
			assertNotNull(edge.getTarget());
			assertEquals(graph.findNode("s4_500"), edge.getSource());
			assertEquals(graph.findNode("s4_3"), edge.getTarget());
			assertNotNull(edge.findAnnotation(DEFAULT_TYPE.LABEL.toString()));
			assertEquals("--", edge.findAnnotation(DEFAULT_TYPE.LABEL.toString()).getValue());
		//end: check edges
	}
	
	/**
	 * Tests a small sample corpus, having some meta annotations, annotation definitions and one segments including
	 * one graph. Checks only the correct number of nodes and edges.
	 * @throws IOException
	 */
	@Test
	public void testReadSecEdges() throws IOException
	{
		File inputFile= new File(TEST_FOLDER+ "withSecEdges/sampleCorpus1.xml");
		
		//load resource 
		Resource resource = resourceSet.createResource(URI.createFileURI(inputFile.getAbsolutePath()));
		
		if (resource== null)
			throw new NullPointerException("The resource is null.");
		resource.load(null);
		
		assertNotNull(resource.getContents());
		assertEquals(1, resource.getContents().size());
		
		Corpus corpus= (Corpus) resource.getContents().get(0);
		
		assertNotNull(corpus.getFeatures());
		
		System.out.println("features: "+corpus.getFeatures());
		assertEquals(6, corpus.getFeatures().size());
		
		assertNotNull(corpus.findFeature("lemma", DOMAIN.T).getFeatureValues());
		assertEquals(0, corpus.findFeature("lemma", DOMAIN.T).getFeatureValues().size());
		
		assertNotNull(corpus.findFeature("pos", DOMAIN.T).getFeatureValues());
		assertEquals(7, corpus.findFeature("pos", DOMAIN.T).getFeatureValues().size());
		
		assertNotNull(corpus.findFeature("function", DOMAIN.T).getFeatureValues());
		assertEquals(1, corpus.findFeature("function", DOMAIN.T).getFeatureValues().size());
		
		assertNotNull(corpus.findFeature("cat", DOMAIN.NT).getFeatureValues());
		assertEquals(4, corpus.findFeature("cat", DOMAIN.NT).getFeatureValues().size());
		
		assertNotNull(corpus.findFeature(DEFAULT_TYPE.LABEL.toString(), DOMAIN.EDGE, DEFAULT_TYPE.PRIM.toString()).getFeatureValues());
		assertEquals(5, corpus.findFeature(DEFAULT_TYPE.LABEL.toString(), DOMAIN.EDGE, DEFAULT_TYPE.PRIM.toString()).getFeatureValues().size());
		
		assertNotNull(corpus.findFeature(DEFAULT_TYPE.LABEL.toString(), DOMAIN.EDGE, DEFAULT_TYPE.SEC.toString()).getFeatureValues());
		assertEquals(1, corpus.findFeature(DEFAULT_TYPE.LABEL.toString(), DOMAIN.EDGE, DEFAULT_TYPE.SEC.toString()).getFeatureValues().size());
		
		assertNotNull(corpus.getSegments());
		assertEquals(1, corpus.getSegments().size());
		assertNotNull(corpus.getSegments().get(0).getGraphs());
		assertEquals(1, corpus.getSegments().get(0).getGraphs().size());
		
		Graph graph= corpus.getSegments().get(0).getGraphs().get(0);
		assertEquals(8, graph.getTerminals().size());
		assertEquals(7, graph.getNonTerminals().size());
		assertEquals(15, graph.getEdges().size());
	}
}
