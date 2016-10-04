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
package de.hu_berlin.german.korpling.tiger2.resources.tiger2.v205;

import java.io.File;
import java.util.Stack;

import org.eclipse.emf.common.util.URI;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DefaultHandler2;

import de.hu_berlin.german.korpling.tiger2.Meta;
import de.hu_berlin.german.korpling.tiger2.exceptions.TigerImplausibleContentException;
import de.hu_berlin.german.korpling.tiger2.exceptions.TigerInternalException;
import de.hu_berlin.german.korpling.tiger2.resources.util.XMLHelper;

/**
 * Reads data from an xml file which is conform to
 * http://korpling.german.hu-berlin.de/tiger2/V2.0.5/Meta.xsd and imports the
 * contained information into the given {@link Meta} object.
 * 
 * @author Florian Zipser
 *
 */
public class MetaReader extends DefaultHandler2 {
	/**
	 * The uri, of the file which is currently read.
	 */
	private URI inputURI = null;

	/**
	 * Sets the uri, of the file which is currently read.
	 */
	public void setInputURI(URI inputURI) {
		this.inputURI = inputURI;
	}

	/**
	 * Returns the uri, of the file which is currently read.
	 */
	public URI getInputURI() {
		return inputURI;
	}

	/**
	 * {@link Meta} object to fill with imported data.
	 */
	private Meta meta = null;

	/**
	 * Sets the {@link Meta} object to fill with imported data.
	 * 
	 * @param meta
	 */
	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	/**
	 * Returns the {@link Meta} object to fill with imported data.
	 * 
	 * @return filed {@link Meta} object
	 */
	public Meta getMeta() {
		return meta;
	}

	public MetaReader() {
		this.elementStack = new Stack<String>();
	}

	/**
	 * Stack, storing the path of read xml elements, starting from root to
	 * current element.
	 */
	private Stack<String> elementStack = null;

	/**
	 * Reads the sub-elements of {@link Tiger2Dictionary#ELEMENT_META}
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// start: extracting the textual content of an element
		StringBuffer text = new StringBuffer();
		for (int i = start; i < start + length; i++)
			text.append(ch[i]);
		// end: extracting the textual content of an element
		if (this.elementStack.size() > 0) {// only if this reader has seen an
											// opening element
			if (Tiger2Dictionary.ELEMENT_NAME.equals(this.elementStack.peek())) {
				this.getMeta().setName(text.toString());
			} else if (Tiger2Dictionary.ELEMENT_AUTHOR.equals(this.elementStack.peek())) {
				this.getMeta().setAuthor(text.toString());
			} else if (Tiger2Dictionary.ELEMENT_DATE.equals(this.elementStack.peek())) {
				this.getMeta().setDate(text.toString());
			} else if (Tiger2Dictionary.ELEMENT_DESCRIPTION.equals(this.elementStack.peek())) {
				this.getMeta().setDescription(text.toString());
			} else if (Tiger2Dictionary.ELEMENT_FORMAT.equals(this.elementStack.peek())) {
				this.getMeta().setFormat(text.toString());
			} else if (Tiger2Dictionary.ELEMENT_HISTORY.equals(this.elementStack.peek())) {
				this.getMeta().setHistory(text.toString());
			}
		} // only if this reader has seen an opening element
	}

	/**
	 * Pushes current on {@link #elementStack}.
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String,
	 *      java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (Tiger2Dictionary.ELEMENT_EXTERNAL.equals(qName)) {// meta-data are
																// stored in an
																// external file
			String correspFileName = null;
			correspFileName = attributes.getValue(Tiger2Dictionary.ATTRIBUTE_CORRESP);
			if (correspFileName == null)
				throw new TigerImplausibleContentException(
						"Cannot read meta-data, because of the element '" + Tiger2Dictionary.ELEMENT_EXTERNAL
								+ "' is used, but its value '" + Tiger2Dictionary.ATTRIBUTE_CORRESP + "' isn't set.");
			if (this.getInputURI() == null)
				throw new TigerInternalException(
						"Cannot read external meta-data file, because the input uir was not set.");
			File correspFile = new File(
					new File(this.getInputURI().toFileString()).getParent() + "/" + correspFileName);
			if (!correspFile.exists())
				throw new TigerImplausibleContentException("Cannot read meta-data, because the specified file '"
						+ correspFile.getAbsolutePath() + "' does not exist.");
			// start: create new meta-reader to parse external file
			MetaReader externalMetaReader = new MetaReader();
			externalMetaReader.setInputURI(URI.createFileURI(correspFile.getAbsolutePath()));
			externalMetaReader.setMeta(this.getMeta());

			XMLHelper.readXml(correspFile, externalMetaReader);
			// end: create new meta-reader to parse external file
		} // meta-data are stored in an external file
		elementStack.push(qName);
	}

	/**
	 * Removes current element from {@link #elementStack}.
	 */
	@Override
	public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
		if (this.elementStack.size() > 0) {// only if this reader has seen an
											// opening element
			elementStack.pop();
		} // only if this reader has seen an opening element
	}
}
