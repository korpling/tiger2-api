/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hu_berlin.german.korpling.tiger2;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.Graph#getEdges <em>Edges</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.Graph#getSyntacticNodes <em>Syntactic Nodes</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.Graph#getNonTerminals <em>Non Terminals</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.Graph#getTerminals <em>Terminals</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.Graph#getId <em>Id</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.Graph#getSegment <em>Segment</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getGraph()
 * @model
 * @generated
 */
public interface Graph extends EObject {
	/**
	 * Returns the value of the '<em><b>Edges</b></em>' containment reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.tiger2.Edge}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.tiger2.Edge#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edges</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edges</em>' containment reference list.
	 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getGraph_Edges()
	 * @see de.hu_berlin.german.korpling.tiger2.Edge#getGraph
	 * @model opposite="graph" containment="true"
	 * @generated
	 */
	EList<Edge> getEdges();

	/**
	 * Returns the value of the '<em><b>Syntactic Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.tiger2.SyntacticNode}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.tiger2.SyntacticNode#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Syntactic Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Syntactic Nodes</em>' containment reference list.
	 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getGraph_SyntacticNodes()
	 * @see de.hu_berlin.german.korpling.tiger2.SyntacticNode#getGraph
	 * @model opposite="graph" containment="true"
	 * @generated
	 */
	EList<SyntacticNode> getSyntacticNodes();

	/**
	 * Returns the value of the '<em><b>Non Terminals</b></em>' reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.tiger2.NonTerminal}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Non Terminals</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Non Terminals</em>' reference list.
	 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getGraph_NonTerminals()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<NonTerminal> getNonTerminals();

	/**
	 * Returns the value of the '<em><b>Terminals</b></em>' reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.tiger2.Terminal}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Terminals</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Terminals</em>' reference list.
	 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getGraph_Terminals()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Terminal> getTerminals();

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
	 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getGraph_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.tiger2.Graph#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Segment</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.tiger2.Segment#getGraphs <em>Graphs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Segment</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Segment</em>' container reference.
	 * @see #setSegment(Segment)
	 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getGraph_Segment()
	 * @see de.hu_berlin.german.korpling.tiger2.Segment#getGraphs
	 * @model opposite="graphs" transient="false"
	 * @generated
	 */
	Segment getSegment();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.tiger2.Graph#getSegment <em>Segment</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Segment</em>' container reference.
	 * @see #getSegment()
	 * @generated
	 */
	void setSegment(Segment value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Edge> getIncomingEdges(String nodeId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Edge> getOutgoingEdges(String nodeId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	SyntacticNode findNode(String nodeId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Edge findEdge(String edgeId);

} // Graph
