package de.hu_berlin.german.korpling.tiger2.exceptions;

/**
 * An exception class for the ;&lttiger2/&gt; model. All expected exception produced by the ;&lttiger2/&gt; are derived from this class.  
 * @author Florian Zipser
 *
 */
public class TigerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4908992517732737905L;

	public TigerException()
	{ super(); }
	
    public TigerException(String s)
    { super(s); }
    
	public TigerException(String s, Throwable ex)
	{super(s, ex); }
}
