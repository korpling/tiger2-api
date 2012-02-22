/**
 * Copyright 2009 Humboldt University of Berlin, INRIA.
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
