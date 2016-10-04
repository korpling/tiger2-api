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

import de.hu_berlin.german.korpling.tiger2.Corpus;
import de.hu_berlin.german.korpling.tiger2.DOMAIN;
import de.hu_berlin.german.korpling.tiger2.Feature;
import de.hu_berlin.german.korpling.tiger2.FeatureValue;
import de.hu_berlin.german.korpling.tiger2.Tiger2Factory;
import de.hu_berlin.german.korpling.tiger2.exceptions.TigerImplausibleContentException;
import de.hu_berlin.german.korpling.tiger2.exceptions.TigerInternalException;
import de.hu_berlin.german.korpling.tiger2.resources.util.XMLHelper;

/**
 * Reads data from an xml file which is conform to
 * http://korpling.german.hu-berlin.de/tiger2/V2.0.5/Annotation.xsd and imports
 * the contained information into the given {@link Annotation} object.
 * 
 * @author Florian Zipser
 *
 */
public class AnnotationReader extends DefaultHandler2 {
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
	 * {@link Corpus} object to fill with imported data.
	 */
	private Corpus corpus = null;

	/**
	 * Sets the {@link Corpus} object to fill with imported data.
	 * 
	 * @param corpus
	 */
	public void setCorpus(Corpus corpus) {
		this.corpus = corpus;
	}

	/**
	 * Returns the {@link Corpus} object to fill with imported data.
	 * 
	 * @return filed {@link Corpus} object
	 */
	public Corpus getCorpus() {
		return corpus;
	}

	public AnnotationReader() {
		this.elementStack = new Stack<String>();
	}

	/**
	 * Stores the current {@link Tiger2Dictionary#ELEMENT_FEATURE} object
	 */
	private Feature currentFeature = null;
	/**
	 * Stores the current {@link Tiger2Dictionary#ELEMENT_VALUE} object
	 */
	private FeatureValue currentFeatureValue = null;

	/**
	 * Stack, storing the path of read xml elements, starting from root to
	 * current element.
	 */
	private Stack<String> elementStack = null;

	/**
	 * Reads the sub-elements of {@link Tiger2Dictionary#ELEMENT_ANNOTATION}
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
			if (Tiger2Dictionary.ELEMENT_VALUE.equals(this.elementStack.peek())) {
				this.currentFeatureValue.setDescription(text.toString());
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
		if (Tiger2Dictionary.ELEMENT_FEATURE.equals(qName)) {
			if (Tiger2Dictionary.ELEMENT_ANNOTATION.toString().equals(elementStack.peek())) {
				this.currentFeature = Tiger2Factory.eINSTANCE.createFeature();
				for (int i = 0; i < attributes.getLength(); i++) {
					String attName = attributes.getLocalName(i);
					String attValue = attributes.getValue(i);
					if (Tiger2Dictionary.ATTRIBUTE_ID.equals(attName)) {
						this.currentFeature.setId(attValue);
					} else if (Tiger2Dictionary.ATTRIBUTE_TYPE.equals(attName)) {
						this.currentFeature.setType(attValue);
					} else if (Tiger2Dictionary.ATTRIBUTE_NAME.equals(attName)) {
						this.currentFeature.setName(attValue);
					} else if (Tiger2Dictionary.ATTRIBUTE_DOMAIN.equals(attName)) {
						DOMAIN domain = DOMAIN.get(attValue);
						if (domain == null)
							throw new TigerImplausibleContentException(
									"The domain value for a Feature can only be one of the following: '"
											+ DOMAIN.T.toString() + "', '" + DOMAIN.NT.toString() + "' or '"
											+ DOMAIN.EDGE.toString() + "'.");
						this.currentFeature.setDomain(domain);
					} else if (Tiger2Dictionary.ATTRIBUTE_DAT_CAT.equals(attName)) {
						if ((attValue != null) && (!attValue.isEmpty())) {
							java.net.URI datCatUri = java.net.URI.create(attValue);
							this.currentFeature.setDcrReference(datCatUri);
						}
					}
				}
				this.getCorpus().getFeatures().add(currentFeature);
			} else
				throw new TigerImplausibleContentException("An element of type '" + Tiger2Dictionary.ELEMENT_FEATURE
						+ "' was found, which is not nedted in a '" + Tiger2Dictionary.ELEMENT_ANNOTATION
						+ "' element");
		} else if (Tiger2Dictionary.ELEMENT_VALUE.equals(qName)) {
			if (Tiger2Dictionary.ELEMENT_FEATURE.toString().equals(this.elementStack.peek())) {
				this.currentFeatureValue = Tiger2Factory.eINSTANCE.createFeatureValue();
				for (int i = 0; i < attributes.getLength(); i++) {
					String attName = attributes.getLocalName(i);
					String attValue = attributes.getValue(i);
					if (Tiger2Dictionary.ATTRIBUTE_ID.equals(attName))
						this.currentFeatureValue.setId(attValue);
					else if (Tiger2Dictionary.ATTRIBUTE_NAME.equals(attName))
						this.currentFeatureValue.setValue(attValue);
					else if (Tiger2Dictionary.ATTRIBUTE_DAT_CAT.equals(attName)) {
						if ((attValue != null) && (!attValue.isEmpty())) {
							java.net.URI datCatUri = java.net.URI.create(attValue);
							this.currentFeatureValue.setDcrReference(datCatUri);
						}
					}
				}
				this.currentFeature.getFeatureValues().add(this.currentFeatureValue);
			} else
				throw new TigerImplausibleContentException("An element of type '" + Tiger2Dictionary.ELEMENT_VALUE
						+ "' was found, which is not nedted in a '" + Tiger2Dictionary.ELEMENT_FEATURE + "' element");
		} else if (Tiger2Dictionary.ELEMENT_EXTERNAL.equals(qName)) {// annotation-data
																		// are
																		// stored
																		// in an
																		// external
																		// file
			String correspFileName = null;
			correspFileName = attributes.getValue(Tiger2Dictionary.ATTRIBUTE_CORRESP);
			if (correspFileName == null)
				throw new TigerImplausibleContentException(
						"Cannot read annotation-data, because of the element '" + Tiger2Dictionary.ELEMENT_EXTERNAL
								+ "' is used, but its value '" + Tiger2Dictionary.ATTRIBUTE_CORRESP + "' isn't set.");
			if (this.getInputURI() == null)
				throw new TigerInternalException(
						"Cannot read external annotation-data file, because the input uir was not set.");
			File correspFile = new File(
					new File(this.getInputURI().toFileString()).getParent() + "/" + correspFileName);
			if (!correspFile.exists())
				throw new TigerImplausibleContentException("Cannot read annotation-data, because the specified file '"
						+ correspFile.getAbsolutePath() + "' does not exist.");
			// start: create new annotation-reader to parse external file
			AnnotationReader externalAnnotationReader = new AnnotationReader();
			externalAnnotationReader.setInputURI(URI.createFileURI(correspFile.getAbsolutePath()));
			externalAnnotationReader.setCorpus(this.getCorpus());

			XMLHelper.readXml(correspFile, externalAnnotationReader);
			// end: create new annotation-reader to parse external file
		} // annotation-data are stored in an external file
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
