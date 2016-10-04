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
package de.hu_berlin.german.korpling.tiger2.resources.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DefaultHandler2;

import de.hu_berlin.german.korpling.tiger2.exceptions.TigerInternalException;
import de.hu_berlin.german.korpling.tiger2.exceptions.TigerResourceException;

public abstract class XMLHelper {
	/**
	 * Reads an xml file.
	 */
	public static void readXml(File xmlFile, DefaultHandler2 myReader) {
		SAXParser parser;
		XMLReader xmlReader;

		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setNamespaceAware(true);
		try {
			factory.setFeature("http://xml.org/sax/features/namespace-prefixes", true);
		} catch (SAXNotRecognizedException e2) {
			throw new TigerInternalException(
					"Cannot set namespace feature to SAXParserFactory, because of nested exception. ", e2);
		} catch (SAXNotSupportedException e2) {
			throw new TigerInternalException(
					"Cannot set namespace feature to SAXParserFactory, because of nested exception. ", e2);
		} catch (ParserConfigurationException e2) {
			throw new TigerInternalException(
					"Cannot set namespace feature to SAXParserFactory, because of nested exception. ", e2);
		}

		try {
			parser = factory.newSAXParser();
			xmlReader = parser.getXMLReader();
			xmlReader.setContentHandler(myReader);
		} catch (ParserConfigurationException e) {
			throw new TigerResourceException(
					"Cannot load <tiger2/> files from resource '" + xmlFile.getAbsolutePath() + "'.", e);
		} catch (Exception e) {
			throw new TigerResourceException(
					"Cannot load <tiger2/> files from resource '" + xmlFile.getAbsolutePath() + "'.", e);
		}
		try {
			InputStream inputStream = new FileInputStream(xmlFile);
			Reader reader = new InputStreamReader(inputStream, "UTF-8");

			InputSource is = new InputSource(reader);
			is.setEncoding("UTF-8");
			try {
				xmlReader.parse(is);
			} catch (EndOfProcessingException e) {
			}
		} catch (IOException e) {
			throw new TigerResourceException(
					"Cannot load <tiger2/> files from resource '" + xmlFile.getAbsolutePath() + "'.", e);
		} catch (SAXException e) {
			try {
				parser = factory.newSAXParser();
				xmlReader = parser.getXMLReader();
				xmlReader.setContentHandler(myReader);
				try {
					xmlReader.parse(xmlFile.getAbsolutePath());
				} catch (EndOfProcessingException e2) {
				}
			} catch (Exception e1) {
				throw new TigerResourceException(
						"Cannot load <tiger2/> files from resource '" + xmlFile.getAbsolutePath() + "'.", e1);
			}
		}
	}
}
