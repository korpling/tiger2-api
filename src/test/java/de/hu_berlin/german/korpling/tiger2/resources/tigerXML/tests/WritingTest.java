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
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import junit.textui.TestRunner;

import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLTestCase;
import org.custommonkey.xmlunit.XMLUnit;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import de.hu_berlin.german.korpling.tiger2.Corpus;
import de.hu_berlin.german.korpling.tiger2.resources.TigerResourceFactory;
import de.hu_berlin.german.korpling.tiger2.samples.Tiger2Sample;

/**
 * @author Florian Zipser
 *
 */
public class WritingTest extends XMLTestCase{

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(WritingTest.class);
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
	public static final String TMP_FOLDER= System.getProperty("java.io.tmpdir")+ "tigerXML/writer/";
	
	/**
	 * Writes the sample comming from {@link Tiger2Sample#createSample1()} to xml file and compares it to a
	 * correct one.
	 * 
	 * @throws IOException
	 * @throws SAXException 
	 */
	@Test
	public void testWriteSample1() throws IOException, SAXException
	{
		File tmpFile= new File(TMP_FOLDER+ "sampleCorpus1.xml");
		File expectedFile= new File(TEST_FOLDER+ "sampleCorpus/sampleCorpus1.xml");
		
		Corpus sampleCorpus= Tiger2Sample.createSampleCorpus1();
		
		//load resource 
		Resource resource = resourceSet.createResource(URI.createFileURI(tmpFile.getAbsolutePath()));
		
		if (resource== null)
			throw new NullPointerException("The resource is null.");
		resource.getContents().add(sampleCorpus);
		resource.save(null);
		
		InputStream expectedStream= new FileInputStream(expectedFile);
		Reader expectedReader = new InputStreamReader(expectedStream, "UTF-8");
		InputSource expectedSource = new InputSource(expectedReader);
		
		InputStream tmpStream= new FileInputStream(tmpFile);
		Reader tmpReader = new InputStreamReader(tmpStream, "UTF-8");
		InputSource tmpSource = new InputSource(tmpReader);
		
		XMLUnit.setIgnoreWhitespace(true);
		Diff myDiff = new Diff(expectedSource, tmpSource);
	    assertTrue("test XML matches control skeleton XML " + myDiff, myDiff.similar());
	}
}
