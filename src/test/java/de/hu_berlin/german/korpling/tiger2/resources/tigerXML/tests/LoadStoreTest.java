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
package de.hu_berlin.german.korpling.tiger2.resources.tigerXML.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

import org.custommonkey.xmlunit.DetailedDiff;
import org.custommonkey.xmlunit.Difference;
import org.custommonkey.xmlunit.DifferenceConstants;
import org.custommonkey.xmlunit.DifferenceListener;
import org.custommonkey.xmlunit.ElementNameAndAttributeQualifier;
import org.custommonkey.xmlunit.ElementQualifier;
import org.custommonkey.xmlunit.XMLTestCase;
import org.custommonkey.xmlunit.XMLUnit;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import de.hu_berlin.german.korpling.tiger2.Corpus;
import de.hu_berlin.german.korpling.tiger2.resources.TigerResourceFactory;


public class LoadStoreTest extends XMLTestCase{

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		resourceSet= new ResourceSetImpl();
		// Register XML resource factory
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(TigerResourceFactory.FILE_ENDING_TIGERXML, new TigerResourceFactory());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	public ResourceSet resourceSet = null;
	
	public static final String TEST_FOLDER="./src/test/resources/tigerXML/";
	
	@Test
	public void testLoadStore_1() throws IOException, SAXException
	{
		File inputFile= new File(TEST_FOLDER+ "loadStore/sampleCorpus1.xml");
		File outputFile= new File(System.getProperty("java.io.tmpdir")+"/sampleCorpus1.xml");
		
		//load resource 
		Resource resourceLoad = resourceSet.createResource(URI.createFileURI(inputFile.getAbsolutePath()));
		
		if (resourceLoad== null)
			throw new NullPointerException("The resource is null.");
		resourceLoad.load(null);
		
		Corpus corpus= (Corpus) resourceLoad.getContents().get(0);
		
		//save resource 
		Resource resourceSave = resourceSet.createResource(URI.createFileURI(outputFile.getAbsolutePath()));
		if (resourceSave== null)
			throw new NullPointerException("The resource is null.");
		resourceSave.getContents().add(corpus);
		resourceSave.save(null);
		
		InputStream inputStream= new FileInputStream(inputFile);
		Reader inputReader = new InputStreamReader(inputStream, "UTF-8");
		InputSource inputSource = new InputSource(inputReader);
		
		InputStream outputStream= new FileInputStream(outputFile);
		Reader outputReader = new InputStreamReader(outputStream, "UTF-8");
		InputSource outputSource = new InputSource(outputReader);
		
//		System.out.println("num of segments: "+ corpus.getSegments().size());
//		System.out.println("num of graphs: "+ corpus.getSegments().get(0).getGraphs().size());
//		System.out.println("num of syn nodes: "+ corpus.getSegments().get(0).getGraphs().get(0).getSyntacticNodes().size());
//		System.out.println("num of non-terminals: "+ corpus.getSegments().get(0).getGraphs().get(0).getNonTerminals().size());
//		System.out.println("num of terminals: "+ corpus.getSegments().get(0).getGraphs().get(0).getTerminals().size());
//		System.out.println("num of edges: "+ corpus.getSegments().get(0).getGraphs().get(0).getEdges().size());
//		System.out.println("inputFile: "+ inputFile.getAbsolutePath());
//		System.out.println("outputFile: "+ outputFile.getAbsolutePath());
		
		XMLUnit.setIgnoreWhitespace(true);
		XMLUnit.getIgnoreAttributeOrder();
		DetailedDiff differ = new DetailedDiff(compareXML(outputSource, inputSource));
		ElementQualifier elementQualifier= new ElementNameAndAttributeQualifier("xml:id");
		differ.overrideElementQualifier(elementQualifier);
		differ.overrideDifferenceListener(new XMLElementOrderIgnoreListener());
		assertTrue("test XML matches control skeleton XML " + differ, differ.similar());
		assertEquals("test XML matches control skeleton XML " + differ, 0, differ.getAllDifferences().size());
	}
	
	
	/**
	 * A listener class, ignoring the order of xml elements.
	 * @author Florian Zipser
	 *
	 */
	class XMLElementOrderIgnoreListener implements DifferenceListener 
	{
		private final int[] IGNORE = new int[] {
		DifferenceConstants.CHILD_NODELIST_SEQUENCE_ID
		};
		{
			Arrays.sort(IGNORE);
		}
		public int differenceFound(Difference difference) {
			
			return Arrays.binarySearch(IGNORE, difference.getId()) >= 0
			? RETURN_IGNORE_DIFFERENCE_NODES_IDENTICAL
			: RETURN_ACCEPT_DIFFERENCE;
		}
		public void skippedComparison(Node control, Node test) {
		}
	}
}
