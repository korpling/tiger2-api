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
package de.hu_berlin.german.korpling.tiger2.resources;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;

import de.hu_berlin.german.korpling.tiger2.exceptions.TigerResourceException;
import de.hu_berlin.german.korpling.tiger2.resources.tiger2.v205.Tiger2Resource;
import de.hu_berlin.german.korpling.tiger2.resources.tigerXML.TigerXMLResource;
import de.hu_berlin.german.korpling.tiger2.resources.util.Tiger2ContentChecker;
import de.hu_berlin.german.korpling.tiger2.resources.util.XMLHelper;

public class TigerResourceFactory extends ResourceFactoryImpl {
	/**
	 * Possible types of a <tiger2/> conform file. Such a file can be:
	 * <ul>
	 * <li>{@link TIGER2_FILE_TYPES#TIGER2} - containing an entire
	 * corpus-structure</li>
	 * <li>{@link TIGER2_FILE_TYPES#TIGER2_SUBCORPUS} - containing a
	 * sub-corpus</li>
	 * <li>{@link TIGER2_FILE_TYPES#TIGER2_ANNOTATION} - containing only
	 * annotation definitions</li>
	 * <li>{@link TIGER2_FILE_TYPES#TIGER2_METADATA} - containing only
	 * meta-data</li>
	 * </ul>
	 * 
	 * @author Florian Zipser
	 *
	 */
	public enum TIGER2_FILE_TYPES {
		TIGER2, TIGER2_SUBCORPUS, TIGER2_ANNOTATION, TIGER2_METADATA
	};

	public static final String FILE_ENDING_TIGER2 = "tiger2";
	public static final String FILE_ENDING_TIGER2_2 = "tig2";
	public static final String FILE_ENDING_TIGERXML = "xml";
	public static final String FILE_ENDING_TIGERXML_2 = "tiger";

	public Resource createResource(URI uri) {
		Resource resource = null;
		if (FILE_ENDING_TIGER2.equalsIgnoreCase(uri.fileExtension())) {
			resource = new Tiger2Resource();
			resource.setURI(uri);
		} else if (FILE_ENDING_TIGERXML.equalsIgnoreCase(uri.fileExtension())) {
			resource = new TigerXMLResource();
			resource.setURI(uri);
		}

		return (resource);
	}

	/**
	 * Checks the type of the <tiger2/> file, by reading its content. A
	 * <tiger2/> file can be separated into files containing an entire
	 * corpus-structure, containing a sub-corpus, containing only annotation
	 * definitions or containing only meta-data.
	 * 
	 * @param uri
	 *            file to be checked
	 * @return type of content
	 */
	public static TIGER2_FILE_TYPES checkFileType(URI uri) {
		if (uri == null)
			throw new TigerResourceException(
					"Cannot check type of file located via given uri, because the given uri is null.");

		Tiger2ContentChecker reader = new Tiger2ContentChecker();
		if (uri.toFileString() == null)
			throw new TigerResourceException("Cannot check type of file located via given uri, because the given uri '"
					+ uri + "' is convertable to a file.");
		File xmlFile = new File(uri.toFileString());

		if (!xmlFile.exists())
			throw new TigerResourceException("Cannot check type of file located via given uri, because the given uri '"
					+ uri + "' points to a non existing file '" + xmlFile.getAbsolutePath() + "'.");
		XMLHelper.readXml(xmlFile, reader);

		return (reader.getTiger2Type());
	}
}
