package de.hu_berlin.german.korpling.tiger2.exceptions;

/**
 * An exception class for all exceptions concerning wrong uris and wrong pathes to &lt;tiger2/&gt; files.   
 * @author Florian Zipser
 *
 */
public class TigerResourceException extends TigerException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3691102631246688942L;

	public TigerResourceException()
	{ super(); }
	
    public TigerResourceException(String s)
    { super(s); }
    
	public TigerResourceException(String s, Throwable ex)
	{super(s, ex); }
}
