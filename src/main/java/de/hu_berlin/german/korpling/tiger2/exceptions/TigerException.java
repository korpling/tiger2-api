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
 * An exception class for the ;&lttiger2/&gt; model. All expected exception
 * produced by the ;&lttiger2/&gt; are derived from this class.
 * 
 * @author Florian Zipser
 *
 */
public class TigerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4908992517732737905L;

	public TigerException() {
		super();
	}

	public TigerException(String s) {
		super(s);
	}

	public TigerException(String s, Throwable ex) {
		super(s, ex);
	}
}
