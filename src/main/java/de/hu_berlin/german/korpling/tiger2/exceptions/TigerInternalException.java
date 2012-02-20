package de.hu_berlin.german.korpling.tiger2.exceptions;

/**
 * This exception class is used for exceptions, that seemed to be caused by a bug in the &lt;tiger2/&gt; api.  
 * @author Florian Zipser
 *
 */
public class TigerInternalException extends TigerException {
	public static final String GENERAL_MSG="We are sorry for that exception. It seems that this was caused by an internal problem of the <tiger2/> api. Please report that containing the entire exception message to the <tiger2/> team. Exception: ";

	/**
	 * 
	 */
	private static final long serialVersionUID = -7081993411092905756L;

	public TigerInternalException()
	{ super(); }
	
    public TigerInternalException(String s)
    { super(GENERAL_MSG+ s); }
    
	public TigerInternalException(String s, Throwable ex)
	{super(GENERAL_MSG+ s, ex); }
}
