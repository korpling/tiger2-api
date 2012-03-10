package de.hu_berlin.german.korpling.tiger2.resources.util;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DefaultHandler2;

import de.hu_berlin.german.korpling.tiger2.resources.TigerResourceFactory.TIGER2_FILE_TYPES;
import de.hu_berlin.german.korpling.tiger2.resources.tiger2.Tiger2Dictionary;

/**
 * Reads a <tiger2/> conform file and checks its type by reading its content.
 * @author Florian Zipser
 *
 */
public class Tiger2ContentChecker extends DefaultHandler2{

	/**
	 * Computed type of the processed file.
	 */
	private TIGER2_FILE_TYPES tiger2Type= null;
	/**
	 * Returns the computed type of the processed file.
	 * @return
	 */
	public TIGER2_FILE_TYPES getTiger2Type() {
		return tiger2Type;
	}
	
	/**
	 * Just reads the root element to check the type of the given file.
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(	String uri,
            					String localName,
            					String qName,
            					Attributes attributes) throws SAXException
    {
		if (Tiger2Dictionary.ELEMENT_CORPUS.equals(qName))
			this.tiger2Type= TIGER2_FILE_TYPES.TIGER2;
		else if (Tiger2Dictionary.ELEMENT_ANNOTATION.equals(qName))
			this.tiger2Type= TIGER2_FILE_TYPES.TIGER2_ANNOTATION;
		else if (Tiger2Dictionary.ELEMENT_META.equals(qName))
			this.tiger2Type= TIGER2_FILE_TYPES.TIGER2_METADATA;
		throw new EndOfProcessingException();
    }
}
