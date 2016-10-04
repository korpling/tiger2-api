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
 * An exception class for all errors in &lt;tiger2/&gt; files.
 * 
 * @author Florian Zipser
 *
 */
public class TigerImplausibleContentException extends TigerException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 688067841778247348L;

	public TigerImplausibleContentException() {
		super();
	}

	public TigerImplausibleContentException(String s) {
		super(s);
	}

	public TigerImplausibleContentException(String s, Throwable ex) {
		super(s, ex);
	}
}
