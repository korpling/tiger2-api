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
package de.hu_berlin.german.korpling.tiger2;

import java.net.URI;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Terminal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.Terminal#getSource <em>Source</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.Terminal#getWord <em>Word</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getTerminal()
 * @model
 * @generated
 */
public interface Terminal extends SyntacticNode {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' attribute.
	 * @see #setSource(URI)
	 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getTerminal_Source()
	 * @model dataType="de.hu_berlin.german.korpling.tiger2.URI"
	 * @generated
	 */
	URI getSource();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.tiger2.Terminal#getSource <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' attribute.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(URI value);

	/**
	 * Returns the value of the '<em><b>Word</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Word</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Word</em>' attribute.
	 * @see #setWord(String)
	 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getTerminal_Word()
	 * @model
	 * @generated
	 */
	String getWord();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.tiger2.Terminal#getWord <em>Word</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Word</em>' attribute.
	 * @see #getWord()
	 * @generated
	 */
	void setWord(String value);

} // Terminal
