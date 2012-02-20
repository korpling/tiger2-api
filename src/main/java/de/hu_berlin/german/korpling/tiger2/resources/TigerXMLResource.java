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

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

import de.hu_berlin.german.korpling.tiger2.Corpus;
import de.hu_berlin.german.korpling.tiger2.exceptions.TigerResourceException;


public class TigerXMLResource extends ResourceImpl
{	
	/**
	 * Stores a TigerXML model into the given file.
	 */
	public void save(java.util.Map<?,?> options) throws java.io.IOException
	{
	}
	
	
	/**
	 * Loads a resource into treetagger-model from tab-seperated file.
	 */
	public void load(java.util.Map<?,?> options) throws IOException
	{
		if (this.getURI()== null)
			throw new TigerResourceException("Cannot load any resource, because no uri is given.");
		
		File exmaraldaFile= new File(this.getURI().toFileString());
		if (!exmaraldaFile.exists()) 
			throw new TigerResourceException("Cannot load resource, because the file does not exists: " + exmaraldaFile);
		
		if (!exmaraldaFile.canRead())
			throw new TigerResourceException("Cannot load resource, because the file can not be read: " + exmaraldaFile);
//		BasicTranscription basicTranscription= null;
//		{//create everything a valid exmaralda needs
//			basicTranscription= ExmaraldaBasicFactory.eINSTANCE.createBasicTranscription();
//			this.getContents().add(basicTranscription);
//		}
//		
//		SAXParser parser;
//        XMLReader xmlReader;
//        EXBReader exbReader= new EXBReader();
//        exbReader.setExmaraldaFile(exmaraldaFile);
//        exbReader.setBasicTranscription(basicTranscription);
//        
//        SAXParserFactory factory= SAXParserFactory.newInstance();
//        
//        try
//        {
//			parser= factory.newSAXParser();
//	        xmlReader= parser.getXMLReader();
//	        xmlReader.setContentHandler(exbReader);
//        } catch (ParserConfigurationException e) {
//        	throw new ExmaraldaException("Cannot load exmaralda from resource '"+exmaraldaFile.getAbsolutePath()+"'.", e);
//        }catch (Exception e) {
//	    	throw new ExmaraldaException("Cannot load exmaralda from resource '"+exmaraldaFile.getAbsolutePath()+"'.", e);
//		}
//        try {
//	        InputStream inputStream= new FileInputStream(exmaraldaFile);
//			Reader reader = new InputStreamReader(inputStream, "UTF-8");
//			 
//			InputSource is = new InputSource(reader);
//			is.setEncoding("UTF-8");
//			 
//			xmlReader.parse(is);
//			
//	    
//        } catch (SAXException e) 
//        {
//        	
//            try
//            {
//				parser= factory.newSAXParser();
//		        xmlReader= parser.getXMLReader();
//		        xmlReader.setContentHandler(exbReader);
//				xmlReader.parse(exmaraldaFile.getAbsolutePath());
//            }catch (Exception e1) {
//            	throw new ExmaraldaException("Cannot load exmaralda from resource '"+exmaraldaFile.getAbsolutePath()+"'.", e1);
//			}
//		}
	}
}
