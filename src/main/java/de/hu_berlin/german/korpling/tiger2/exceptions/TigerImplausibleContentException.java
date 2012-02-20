package de.hu_berlin.german.korpling.tiger2.exceptions;

/**
 * An exception class for all errors in &lt;tiger2/&gt; files.  
 * @author Florian Zipser
 *
 */
public class TigerImplausibleContentException extends TigerException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 688067841778247348L;

	public TigerImplausibleContentException()
	{ super(); }
	
    public TigerImplausibleContentException(String s)
    { super(s); }
    
	public TigerImplausibleContentException(String s, Throwable ex)
	{super(s, ex); }
}
