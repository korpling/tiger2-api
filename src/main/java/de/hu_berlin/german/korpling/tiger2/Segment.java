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
package de.hu_berlin.german.korpling.tiger2;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Segment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.Segment#getGraphs <em>Graphs</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.Segment#getCorpus <em>Corpus</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.Segment#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getSegment()
 * @model
 * @generated
 */
public interface Segment extends EObject {
	/**
	 * Returns the value of the '<em><b>Graphs</b></em>' containment reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.tiger2.Graph}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.tiger2.Graph#getSegment <em>Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graphs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graphs</em>' containment reference list.
	 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getSegment_Graphs()
	 * @see de.hu_berlin.german.korpling.tiger2.Graph#getSegment
	 * @model opposite="segment" containment="true"
	 * @generated
	 */
	EList<Graph> getGraphs();

	/**
	 * Returns the value of the '<em><b>Corpus</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.tiger2.Corpus#getSegments <em>Segments</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Corpus</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Corpus</em>' container reference.
	 * @see #setCorpus(Corpus)
	 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getSegment_Corpus()
	 * @see de.hu_berlin.german.korpling.tiger2.Corpus#getSegments
	 * @model opposite="segments" transient="false"
	 * @generated
	 */
	Corpus getCorpus();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.tiger2.Segment#getCorpus <em>Corpus</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Corpus</em>' container reference.
	 * @see #getCorpus()
	 * @generated
	 */
	void setCorpus(Corpus value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getSegment_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.tiger2.Segment#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

} // Segment
