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
