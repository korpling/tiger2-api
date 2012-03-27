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
package de.hu_berlin.german.korpling.tiger2.impl;

import de.hu_berlin.german.korpling.tiger2.Edge;
import de.hu_berlin.german.korpling.tiger2.Graph;
import de.hu_berlin.german.korpling.tiger2.NonTerminal;
import de.hu_berlin.german.korpling.tiger2.Segment;
import de.hu_berlin.german.korpling.tiger2.SyntacticNode;
import de.hu_berlin.german.korpling.tiger2.Terminal;
import de.hu_berlin.german.korpling.tiger2.Tiger2Package;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.impl.GraphImpl#getEdges <em>Edges</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.impl.GraphImpl#getSyntacticNodes <em>Syntactic Nodes</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.impl.GraphImpl#getNonTerminals <em>Non Terminals</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.impl.GraphImpl#getTerminals <em>Terminals</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.impl.GraphImpl#getId <em>Id</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.impl.GraphImpl#getSegment <em>Segment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GraphImpl extends EObjectImpl implements Graph {
	/**
	 * The cached value of the '{@link #getEdges() <em>Edges</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<Edge> edges;

	/**
	 * The cached value of the '{@link #getSyntacticNodes() <em>Syntactic Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSyntacticNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<SyntacticNode> syntacticNodes;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Tiger2Package.Literals.GRAPH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Edge> getEdges() {
		if (edges == null) {
			edges = new EObjectContainmentWithInverseEList<Edge>(Edge.class, this, Tiger2Package.GRAPH__EDGES, Tiger2Package.EDGE__GRAPH);
		}
		return edges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SyntacticNode> getSyntacticNodes() {
		if (syntacticNodes == null) {
			syntacticNodes = new EObjectContainmentWithInverseEList<SyntacticNode>(SyntacticNode.class, this, Tiger2Package.GRAPH__SYNTACTIC_NODES, Tiger2Package.SYNTACTIC_NODE__GRAPH);
		}
		return syntacticNodes;
	}

	/**
	 * {@inheritDoc Graph#getNonTerminals()}
	 */
	//TODO replace, when using SGraph 
	public EList<NonTerminal> getNonTerminals() {
		EList<NonTerminal> retVal= new BasicEList<NonTerminal>();
		for (SyntacticNode synNode: this.getSyntacticNodes())
		{
			if (synNode instanceof NonTerminal)
				retVal.add((NonTerminal) synNode);
		}
		return(retVal);
	}

	/**
	 * {@inheritDoc Graph#getTerminals()}
	 */
	//TODO replace, when using SGraph 
	public EList<Terminal> getTerminals() 
	{
		EList<Terminal> retVal= new BasicEList<Terminal>();
		for (SyntacticNode synNode: this.getSyntacticNodes())
		{
			if (synNode instanceof Terminal)
				retVal.add((Terminal) synNode);
		}
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Tiger2Package.GRAPH__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Segment getSegment() {
		if (eContainerFeatureID() != Tiger2Package.GRAPH__SEGMENT) return null;
		return (Segment)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSegment(Segment newSegment, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSegment, Tiger2Package.GRAPH__SEGMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSegment(Segment newSegment) {
		if (newSegment != eInternalContainer() || (eContainerFeatureID() != Tiger2Package.GRAPH__SEGMENT && newSegment != null)) {
			if (EcoreUtil.isAncestor(this, newSegment))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSegment != null)
				msgs = ((InternalEObject)newSegment).eInverseAdd(this, Tiger2Package.SEGMENT__GRAPHS, Segment.class, msgs);
			msgs = basicSetSegment(newSegment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Tiger2Package.GRAPH__SEGMENT, newSegment, newSegment));
	}

	/**
	 * {@inheritDoc Graph#getIncomingEdges(String)}
	 */
	public EList<Edge> getIncomingEdges(String nodeId) {
		EList<Edge> retVal= new BasicEList<Edge>();
		for (Edge edge: this.getEdges())
		{
			if (edge.getTarget().getId().equals(nodeId))
				retVal.add(edge);
		}
		if (retVal.size()== 0)
			return(null);
		return(retVal);
	}

	/**
	 *{@inheritDoc Graph#getOutgoingEdges(String)}
	 */
	public EList<Edge> getOutgoingEdges(String nodeId) 
	{
		EList<Edge> retVal= new BasicEList<Edge>();
		for (Edge edge: this.getEdges())
		{
			if (edge.getSource().getId().equals(nodeId))
				retVal.add(edge);
		}
		if (retVal.size()== 0)
			return(null);
		return(retVal);
	}

	/**
	 * {@inheritDoc Graph#findNode(String)}
	 */
	//TODO replace, when using SGraph 
	public SyntacticNode findNode(String nodeId) 
	{
		SyntacticNode retVal= null;
		if (	(nodeId!= null)&&
				(!nodeId.isEmpty()))
		{
			for(SyntacticNode synNode: this.getSyntacticNodes())
			{
				if (nodeId.equals(synNode.getId()))
				{
					retVal= synNode;
					break;
				}
			}
		}
		return(retVal);
	}

	/**
	 * {@inheritDoc Graph#findEdge(String)}
	 */
	public Edge findEdge(String edgeId) {
		Edge retVal= null;
		if (	(edgeId!= null)&&
				(!edgeId.isEmpty()))
		{
			for(Edge edge: this.getEdges())
			{
				if (edgeId.equals(edge.getId()))
				{
					retVal= edge;
					break;
				}
			}
		}
		return(retVal);
	}

	/**
	 * {@inheritDoc Graph#findRoots()}
	 */
	public EList<SyntacticNode> findRoots() 
	{
		EList<SyntacticNode> retVal= null;
		HashSet<String> nonRoots= new HashSet<String>();
		for (Edge edge: this.getEdges())
		{
			nonRoots.add(edge.getSource().getId());
		}
		for (SyntacticNode synNode: this.getSyntacticNodes())
		{
			if (!nonRoots.contains(synNode.getId()))
			{
				if (retVal== null)
					retVal= new BasicEList<SyntacticNode>();
				retVal.add(synNode);
			}
		}
		return(retVal);
	}

	/**
	 * {@inheritDoc Graph#findRoot()}
	 */
	public SyntacticNode findRoot() {
		SyntacticNode retVal= null;
		EList<SyntacticNode> roots= this.findRoots();
		if (	(roots!= null)&&
				(roots.size()> 0))
			retVal= roots.get(0);
		return(retVal);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Tiger2Package.GRAPH__EDGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEdges()).basicAdd(otherEnd, msgs);
			case Tiger2Package.GRAPH__SYNTACTIC_NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSyntacticNodes()).basicAdd(otherEnd, msgs);
			case Tiger2Package.GRAPH__SEGMENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSegment((Segment)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Tiger2Package.GRAPH__EDGES:
				return ((InternalEList<?>)getEdges()).basicRemove(otherEnd, msgs);
			case Tiger2Package.GRAPH__SYNTACTIC_NODES:
				return ((InternalEList<?>)getSyntacticNodes()).basicRemove(otherEnd, msgs);
			case Tiger2Package.GRAPH__SEGMENT:
				return basicSetSegment(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case Tiger2Package.GRAPH__SEGMENT:
				return eInternalContainer().eInverseRemove(this, Tiger2Package.SEGMENT__GRAPHS, Segment.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Tiger2Package.GRAPH__EDGES:
				return getEdges();
			case Tiger2Package.GRAPH__SYNTACTIC_NODES:
				return getSyntacticNodes();
			case Tiger2Package.GRAPH__NON_TERMINALS:
				return getNonTerminals();
			case Tiger2Package.GRAPH__TERMINALS:
				return getTerminals();
			case Tiger2Package.GRAPH__ID:
				return getId();
			case Tiger2Package.GRAPH__SEGMENT:
				return getSegment();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Tiger2Package.GRAPH__EDGES:
				getEdges().clear();
				getEdges().addAll((Collection<? extends Edge>)newValue);
				return;
			case Tiger2Package.GRAPH__SYNTACTIC_NODES:
				getSyntacticNodes().clear();
				getSyntacticNodes().addAll((Collection<? extends SyntacticNode>)newValue);
				return;
			case Tiger2Package.GRAPH__ID:
				setId((String)newValue);
				return;
			case Tiger2Package.GRAPH__SEGMENT:
				setSegment((Segment)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case Tiger2Package.GRAPH__EDGES:
				getEdges().clear();
				return;
			case Tiger2Package.GRAPH__SYNTACTIC_NODES:
				getSyntacticNodes().clear();
				return;
			case Tiger2Package.GRAPH__ID:
				setId(ID_EDEFAULT);
				return;
			case Tiger2Package.GRAPH__SEGMENT:
				setSegment((Segment)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Tiger2Package.GRAPH__EDGES:
				return edges != null && !edges.isEmpty();
			case Tiger2Package.GRAPH__SYNTACTIC_NODES:
				return syntacticNodes != null && !syntacticNodes.isEmpty();
			case Tiger2Package.GRAPH__NON_TERMINALS:
				return !getNonTerminals().isEmpty();
			case Tiger2Package.GRAPH__TERMINALS:
				return !getTerminals().isEmpty();
			case Tiger2Package.GRAPH__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case Tiger2Package.GRAPH__SEGMENT:
				return getSegment() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //GraphImpl
