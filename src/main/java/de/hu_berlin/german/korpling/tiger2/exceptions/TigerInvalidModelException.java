package de.hu_berlin.german.korpling.tiger2.exceptions;

/**
 * This exception class is used for exceptions, that occurs, when dealing with the &lt;tiger2/&gt; model and
 * and one or more objects are not valid.  
 * @author Florian Zipser
 *
 */
public class TigerInvalidModelException extends TigerException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 6769495248730951008L;

	public TigerInvalidModelException()
	{ super(); }
	
    public TigerInvalidModelException(String s)
    { super(s); }
    
	public TigerInvalidModelException(String s, Throwable ex)
	{super(s, ex); }
}
