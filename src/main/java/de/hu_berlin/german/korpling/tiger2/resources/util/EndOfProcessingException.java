package de.hu_berlin.german.korpling.tiger2.resources.util;

import org.xml.sax.SAXException;

public class EndOfProcessingException extends SAXException 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4139123009243672951L;

	public EndOfProcessingException() {
		super();
	}
	
	public EndOfProcessingException(String msg) {
		super(msg);
	}
}
