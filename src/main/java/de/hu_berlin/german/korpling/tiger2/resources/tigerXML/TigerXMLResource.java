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

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

import de.hu_berlin.german.korpling.tiger2.Corpus;
import de.hu_berlin.german.korpling.tiger2.Tiger2Factory;
import de.hu_berlin.german.korpling.tiger2.exceptions.TigerResourceException;
import de.hu_berlin.german.korpling.tiger2.resources.util.XMLHelper;


public class TigerXMLResource extends ResourceImpl
{	
	/**
	 * Stores a TigerXML model into the given file.
	 */
	public void save(java.util.Map<?,?> options) throws java.io.IOException
	{
		TigerXMLWriter writer= new TigerXMLWriter();
		writer.setOutputURI(this.getURI());
		writer.setCorpus((Corpus)this.getContents().get(0));
		writer.save();
	}
	
	
	/**
	 * Loads a resource into treetagger-model from tab-seperated file.
	 */
	public void load(java.util.Map<?,?> options) throws IOException
	{
		if (this.getURI()== null)
			throw new TigerResourceException("Cannot load any resource, because no uri is given.");
		
		File tigerFile= new File(this.getURI().toFileString());
		if (!tigerFile.exists()) 
			throw new TigerResourceException("Cannot load resource, because the file does not exists: " + tigerFile);
		
		if (!tigerFile.canRead())
			throw new TigerResourceException("Cannot load resource, because the file can not be read: " + tigerFile);
		
		Corpus corpus= null;
		corpus= Tiger2Factory.eINSTANCE.createCorpus();
		this.getContents().add(corpus);
		
        TigerXMLReader tigerXMLReader= new TigerXMLReader();
        tigerXMLReader.setRootCorpus(corpus);
        tigerXMLReader.setInputURI(URI.createFileURI(tigerFile.getAbsolutePath()));
        XMLHelper.readXml(tigerFile, tigerXMLReader);
	}
}
