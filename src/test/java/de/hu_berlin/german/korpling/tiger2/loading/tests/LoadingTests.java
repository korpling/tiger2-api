/**
 * 
 */
package de.hu_berlin.german.korpling.tiger2.loading.tests;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;

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
public class LoadingTests {

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
		
		//end: check edges
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
}
