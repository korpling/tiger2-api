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

import de.hu_berlin.german.korpling.tiger2.Corpus;
import de.hu_berlin.german.korpling.tiger2.DOMAIN;
import de.hu_berlin.german.korpling.tiger2.Feature;
import de.hu_berlin.german.korpling.tiger2.FeatureValue;
import de.hu_berlin.german.korpling.tiger2.Tiger2Package;
import de.hu_berlin.german.korpling.tiger2.exceptions.TigerInternalException;
import de.hu_berlin.german.korpling.tiger2.exceptions.TigerInvalidModelException;

import java.lang.annotation.Inherited;
import java.net.URI;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.impl.FeatureImpl#getFeatureValues <em>Feature Values</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.impl.FeatureImpl#getCorpus <em>Corpus</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.impl.FeatureImpl#getId <em>Id</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.impl.FeatureImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.impl.FeatureImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.impl.FeatureImpl#getDcrReference <em>Dcr Reference</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.impl.FeatureImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureImpl extends EObjectImpl implements Feature {
	/**
	 * The cached value of the '{@link #getFeatureValues() <em>Feature Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureValues()
	 * @generated
	 * @ordered
	 */
	protected EList<FeatureValue> featureValues;

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
	 * The default value of the '{@link #getDomain() <em>Domain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomain()
	 * @generated
	 * @ordered
	 */
	protected static final DOMAIN DOMAIN_EDEFAULT = DOMAIN.T;

	/**
	 * The cached value of the '{@link #getDomain() <em>Domain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomain()
	 * @generated
	 * @ordered
	 */
	protected DOMAIN domain = DOMAIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDcrReference() <em>Dcr Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDcrReference()
	 * @generated
	 * @ordered
	 */
	protected static final URI DCR_REFERENCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDcrReference() <em>Dcr Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDcrReference()
	 * @generated
	 * @ordered
	 */
	protected URI dcrReference = DCR_REFERENCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * Creates an object of type {@link FeatureValue} and initializes all internal fields.
	 */
	protected FeatureImpl() {
		super();
		init();
	}
	
	/**
	 * Initializes all internal fields:
	 * <ul>
	 * 	<li>{@link #featureValueValue2FeatureValue}</li>
	 * </ul>
	 */
	protected void init()
	{
		this.featureValueValue2FeatureValue= new ConcurrentHashMap<String, FeatureValue>();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Tiger2Package.Literals.FEATURE;
	}

	/**
	 * Stores a map containing the value of a {@link FeatureValue} and the corresponding {@link FeatureValue} object. 
	 */
	private ConcurrentHashMap<String, FeatureValue> featureValueValue2FeatureValue= null;
	
	/**
	 * This method is invoked by the EMF framework, when something has changed in a list being contained by
	 * this object.
	 */
	@Override
	public void eNotify(Notification notification) 
	{
		super.eNotify(notification);		
		
		if (notification.getFeature() instanceof EReference) {
			EReference ref = (EReference) notification.getFeature();
			if(ref.equals(Tiger2Package.Literals.FEATURE__FEATURE_VALUES)) {
				FeatureValue featureValue= null;
				switch (notification.getEventType()) {
				case Notification.ADD:
				{
					featureValue= (FeatureValue) notification.getNewValue();
					if (featureValue== null)
						throw new TigerInvalidModelException("Cannot add the given featureValue to map, because it is null.");
					if (featureValue.getValue()== null)
						throw new TigerInvalidModelException("Cannot add the given featureValue to map, because its value is null.");
					if (featureValueValue2FeatureValue== null)
						throw new TigerInternalException("Cannot add featureValue to map, because the map has not been initialized.");
					this.featureValueValue2FeatureValue.put(featureValue.getValue(), featureValue);
					break;
				}
				case Notification.ADD_MANY:
					throw new UnsupportedOperationException("Adding more than one Feature object is not supported yet.");
//					break;
				case Notification.REMOVE:
				{
					featureValue= (FeatureValue) notification.getOldValue();
					this.featureValueValue2FeatureValue.remove(featureValue);
					break;	
				}
				
				case Notification.REMOVE_MANY:
					throw new UnsupportedOperationException("Removing more than one Feature object is not supported yet.");	
//					break;
				default:
					break;
				}
			}
		}		
	}
	
	/**
	 * This method must be implemented and return true, if this object shall be notified, when adding objects into contained
	 * lists (Containment relation).
	 * @return returns always <code>true</code>
	 */
	@Override
	public boolean eNotificationRequired() {
		return true;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FeatureValue> getFeatureValues() {
		if (featureValues == null) {
			featureValues = new EObjectContainmentWithInverseEList<FeatureValue>(FeatureValue.class, this, Tiger2Package.FEATURE__FEATURE_VALUES, Tiger2Package.FEATURE_VALUE__FEATURE);
		}
		return featureValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Corpus getCorpus() {
		if (eContainerFeatureID() != Tiger2Package.FEATURE__CORPUS) return null;
		return (Corpus)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCorpus(Corpus newCorpus, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCorpus, Tiger2Package.FEATURE__CORPUS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCorpus(Corpus newCorpus) {
		if (newCorpus != eInternalContainer() || (eContainerFeatureID() != Tiger2Package.FEATURE__CORPUS && newCorpus != null)) {
			if (EcoreUtil.isAncestor(this, newCorpus))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCorpus != null)
				msgs = ((InternalEObject)newCorpus).eInverseAdd(this, Tiger2Package.CORPUS__FEATURES, Corpus.class, msgs);
			msgs = basicSetCorpus(newCorpus, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Tiger2Package.FEATURE__CORPUS, newCorpus, newCorpus));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Tiger2Package.FEATURE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DOMAIN getDomain() {
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomain(DOMAIN newDomain) {
		DOMAIN oldDomain = domain;
		domain = newDomain == null ? DOMAIN_EDEFAULT : newDomain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Tiger2Package.FEATURE__DOMAIN, oldDomain, domain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Tiger2Package.FEATURE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URI getDcrReference() {
		return dcrReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDcrReference(URI newDcrReference) {
		URI oldDcrReference = dcrReference;
		dcrReference = newDcrReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Tiger2Package.FEATURE__DCR_REFERENCE, oldDcrReference, dcrReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Tiger2Package.FEATURE__TYPE, oldType, type));
	}
	
	/**
	 * {@link Inherited Feature#findFeatureValue(String)}
	 */
	public FeatureValue findFeatureValue(String featureValueValue) 
	{
		return(this.featureValueValue2FeatureValue.get(featureValueValue));
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
			case Tiger2Package.FEATURE__FEATURE_VALUES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFeatureValues()).basicAdd(otherEnd, msgs);
			case Tiger2Package.FEATURE__CORPUS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetCorpus((Corpus)otherEnd, msgs);
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
			case Tiger2Package.FEATURE__FEATURE_VALUES:
				return ((InternalEList<?>)getFeatureValues()).basicRemove(otherEnd, msgs);
			case Tiger2Package.FEATURE__CORPUS:
				return basicSetCorpus(null, msgs);
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
			case Tiger2Package.FEATURE__CORPUS:
				return eInternalContainer().eInverseRemove(this, Tiger2Package.CORPUS__FEATURES, Corpus.class, msgs);
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
			case Tiger2Package.FEATURE__FEATURE_VALUES:
				return getFeatureValues();
			case Tiger2Package.FEATURE__CORPUS:
				return getCorpus();
			case Tiger2Package.FEATURE__ID:
				return getId();
			case Tiger2Package.FEATURE__DOMAIN:
				return getDomain();
			case Tiger2Package.FEATURE__NAME:
				return getName();
			case Tiger2Package.FEATURE__DCR_REFERENCE:
				return getDcrReference();
			case Tiger2Package.FEATURE__TYPE:
				return getType();
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
			case Tiger2Package.FEATURE__FEATURE_VALUES:
				getFeatureValues().clear();
				getFeatureValues().addAll((Collection<? extends FeatureValue>)newValue);
				return;
			case Tiger2Package.FEATURE__CORPUS:
				setCorpus((Corpus)newValue);
				return;
			case Tiger2Package.FEATURE__ID:
				setId((String)newValue);
				return;
			case Tiger2Package.FEATURE__DOMAIN:
				setDomain((DOMAIN)newValue);
				return;
			case Tiger2Package.FEATURE__NAME:
				setName((String)newValue);
				return;
			case Tiger2Package.FEATURE__DCR_REFERENCE:
				setDcrReference((URI)newValue);
				return;
			case Tiger2Package.FEATURE__TYPE:
				setType((String)newValue);
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
			case Tiger2Package.FEATURE__FEATURE_VALUES:
				getFeatureValues().clear();
				return;
			case Tiger2Package.FEATURE__CORPUS:
				setCorpus((Corpus)null);
				return;
			case Tiger2Package.FEATURE__ID:
				setId(ID_EDEFAULT);
				return;
			case Tiger2Package.FEATURE__DOMAIN:
				setDomain(DOMAIN_EDEFAULT);
				return;
			case Tiger2Package.FEATURE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case Tiger2Package.FEATURE__DCR_REFERENCE:
				setDcrReference(DCR_REFERENCE_EDEFAULT);
				return;
			case Tiger2Package.FEATURE__TYPE:
				setType(TYPE_EDEFAULT);
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
			case Tiger2Package.FEATURE__FEATURE_VALUES:
				return featureValues != null && !featureValues.isEmpty();
			case Tiger2Package.FEATURE__CORPUS:
				return getCorpus() != null;
			case Tiger2Package.FEATURE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case Tiger2Package.FEATURE__DOMAIN:
				return domain != DOMAIN_EDEFAULT;
			case Tiger2Package.FEATURE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case Tiger2Package.FEATURE__DCR_REFERENCE:
				return DCR_REFERENCE_EDEFAULT == null ? dcrReference != null : !DCR_REFERENCE_EDEFAULT.equals(dcrReference);
			case Tiger2Package.FEATURE__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
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
		result.append(", domain: ");
		result.append(domain);
		result.append(", name: ");
		result.append(name);
		result.append(", dcrReference: ");
		result.append(dcrReference);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //FeatureImpl
