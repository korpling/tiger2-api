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

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Syntactic Node</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.hu_berlin.german.korpling.tiger2.SyntacticNode#getGraph
 * <em>Graph</em>}</li>
 * <li>{@link de.hu_berlin.german.korpling.tiger2.SyntacticNode#getId
 * <em>Id</em>}</li>
 * <li>{@link de.hu_berlin.german.korpling.tiger2.SyntacticNode#getType
 * <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getSyntacticNode()
 * @model abstract="true"
 * @generated
 */
public interface SyntacticNode extends AnnotatableElement {
	/**
	 * Returns the value of the '<em><b>Graph</b></em>' container reference. It
	 * is bidirectional and its opposite is
	 * '{@link de.hu_berlin.german.korpling.tiger2.Graph#getSyntacticNodes
	 * <em>Syntactic Nodes</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Graph</em>' container reference.
	 * @see #setGraph(Graph)
	 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getSyntacticNode_Graph()
	 * @see de.hu_berlin.german.korpling.tiger2.Graph#getSyntacticNodes
	 * @model opposite="syntacticNodes" transient="false"
	 * @generated
	 */
	Graph getGraph();

	/**
	 * Sets the value of the
	 * '{@link de.hu_berlin.german.korpling.tiger2.SyntacticNode#getGraph
	 * <em>Graph</em>}' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Graph</em>' container reference.
	 * @see #getGraph()
	 * @generated
	 */
	void setGraph(Graph value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getSyntacticNode_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the
	 * '{@link de.hu_berlin.german.korpling.tiger2.SyntacticNode#getId
	 * <em>Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getSyntacticNode_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the
	 * '{@link de.hu_berlin.german.korpling.tiger2.SyntacticNode#getType
	 * <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

} // SyntacticNode
