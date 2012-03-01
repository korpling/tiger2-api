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
package de.hu_berlin.german.korpling.tiger2.persisting.tests;

import java.io.IOException;

import org.custommonkey.xmlunit.XMLTestCase;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import de.hu_berlin.german.korpling.tiger2.resources.TigerResourceFactory;


public class LoadStoreTest extends XMLTestCase{

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		resourceSet= new ResourceSetImpl();
		// Register XML resource factory
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(TigerResourceFactory.FILE_ENDING_TIGER2,new TigerResourceFactory());
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
	public void testLoadStore_1() throws IOException, SAXException
	{
//		File inputFile= new File(TEST_FOLDER+ "loadStore/corpus.tiger2");
//		File outputFile= new File(System.getProperty("java.io.tmpdir")+"/corpus.tiger2");
//		
//		//load resource 
//		Resource resourceLoad = resourceSet.createResource(URI.createFileURI(inputFile.getAbsolutePath()));
//		
//		if (resourceLoad== null)
//			throw new NullPointerException("The resource is null.");
//		resourceLoad.load(null);
//		
//		Corpus corpus= (Corpus) resourceLoad.getContents().get(0);
//		
//		//load resource 
//		Resource resourceSave = resourceSet.createResource(URI.createFileURI(outputFile.getAbsolutePath()));
//		if (resourceSave== null)
//			throw new NullPointerException("The resource is null.");
//		resourceSave.getContents().add(corpus);
//		resourceSave.save(null);
//		
//		InputStream inputStream= new FileInputStream(inputFile);
//		Reader inputReader = new InputStreamReader(inputStream, "UTF-8");
//		InputSource inputSource = new InputSource(inputReader);
//		
//		InputStream outputStream= new FileInputStream(outputFile);
//		Reader outputReader = new InputStreamReader(outputStream, "UTF-8");
//		InputSource outputSource = new InputSource(outputReader);
//		
//		XMLUnit.setIgnoreWhitespace(true);
////		XMLUnit.setCompareUnmatched(true);
//		System.out.println(outputFile.getAbsolutePath());
//		DetailedDiff myDiff = new DetailedDiff(compareXML(inputSource, outputSource));
//		myDiff.overrideElementQualifier(new ElementNameAndAttributeQualifier("xml:id"));
//	    List allDifferences = myDiff.getAllDifferences();
//	    for (Object obj: allDifferences)
//	    {
//	    	System.out.println(obj);
//	    }
//		
//		Diff myDiff2 = new Diff(inputSource, outputSource);
//        assertTrue("test XML matches control skeleton XML " + myDiff2, myDiff2.similar());
	}
}
