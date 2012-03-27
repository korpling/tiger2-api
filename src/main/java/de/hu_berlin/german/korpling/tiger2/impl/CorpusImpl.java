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

import java.lang.annotation.Inherited;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import de.hu_berlin.german.korpling.tiger2.Annotation;
import de.hu_berlin.german.korpling.tiger2.Corpus;
import de.hu_berlin.german.korpling.tiger2.DOMAIN;
import de.hu_berlin.german.korpling.tiger2.Feature;
import de.hu_berlin.german.korpling.tiger2.FeatureValue;
import de.hu_berlin.german.korpling.tiger2.Meta;
import de.hu_berlin.german.korpling.tiger2.Segment;
import de.hu_berlin.german.korpling.tiger2.Tiger2Factory;
import de.hu_berlin.german.korpling.tiger2.Tiger2Package;
import de.hu_berlin.german.korpling.tiger2.exceptions.TigerInvalidModelException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Corpus</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.impl.CorpusImpl#getSegments <em>Segments</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.impl.CorpusImpl#getId <em>Id</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.impl.CorpusImpl#getSubCorpora <em>Sub Corpora</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.impl.CorpusImpl#getSuperCorpus <em>Super Corpus</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.impl.CorpusImpl#getMeta <em>Meta</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.impl.CorpusImpl#getFeatures <em>Features</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CorpusImpl extends EObjectImpl implements Corpus {
	/**
	 * The cached value of the '{@link #getSegments() <em>Segments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSegments()
	 * @generated
	 * @ordered
	 */
	protected EList<Segment> segments;

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
	 * The cached value of the '{@link #getSubCorpora() <em>Sub Corpora</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubCorpora()
	 * @generated
	 * @ordered
	 */
	protected EList<Corpus> subCorpora;
	/**
	 * The cached value of the '{@link #getMeta() <em>Meta</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeta()
	 * @generated
	 * @ordered
	 */
	protected Meta meta;
	/**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<Feature> features;

	/**
	 * Creates a new object of type {@link CorpusImpl} and initializes all internal fields.
	 */
	protected CorpusImpl() {
		super();
		init();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Tiger2Package.Literals.CORPUS;
	}

	/**
	 * Initializes this object, a list of actions is given here:
	 * <ul>
	 * 	<li>creating object {@link #featureNameDomain2FeatureMap}</li>
	 * </ul>
	 */
	protected void init()
	{
		this.featureNameDomain2FeatureMap= new ConcurrentHashMap<String, Feature>();
	}
	
	
	/**
	 * This {@link HashMap} stores a pair of the value {@link Feature#getName()} and {@link Feature#getDomain()} and the corresponding {@link Feature} object for
	 * having a fast access. The key is created by concatenating {@link Feature#getName()} and {@link Feature#getDomain()}.
	 */
	private ConcurrentHashMap<String, Feature> featureNameDomain2FeatureMap= null;
	
	/**
	 * Specifies the separator to be used to separate the single items of a key of the internal hash table for finding
	 * {@link Feature} objects.
	 * Generates an identifier for {@link Segment} objects if they do not already have one.
	 */
	protected static final String FEATURE_SEPARATOR= "#";
	
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
	 * This method is invoked by the EMF framework, when something has changed in a list being contained by
	 * this object.
	 */
	@Override
	public void eNotify(Notification notification) 
	{
		super.eNotify(notification);		
		
		if (notification.getFeature() instanceof EReference) {
			EReference ref = (EReference) notification.getFeature();
			if(ref.equals(Tiger2Package.Literals.CORPUS__FEATURES)) 
			{
				Object newValue= notification.getNewValue();
				switch (notification.getEventType()) {
				case Notification.ADD:
				{
					if (newValue instanceof Feature)
					{
						Feature newFeature= (Feature) newValue;
						String key= newFeature.getName()+FEATURE_SEPARATOR+newFeature.getDomain();
						if (newFeature.getType()!= null)
							key= key+FEATURE_SEPARATOR+newFeature.getType();
						this.featureNameDomain2FeatureMap.put(key, newFeature);
					}
					break;
				}
				case Notification.ADD_MANY:
					throw new UnsupportedOperationException("Adding more than one Feature object is not supported yet.");
//					break;
				case Notification.REMOVE:
					if (notification.getOldValue() instanceof Feature)
					{
						if (newValue instanceof Feature)
						{
							Feature newFeature= (Feature) newValue;
							this.featureNameDomain2FeatureMap.remove(newFeature);
						}
					}
					break;
				case Notification.REMOVE_MANY:
					throw new UnsupportedOperationException("Removing more than one Feature object is not supported yet.");	
//					break;
				default:
					break;
				}
			}
			else if(ref.equals(Tiger2Package.Literals.CORPUS__SEGMENTS)) {
				Object newValue= notification.getNewValue();
				switch (notification.getEventType()) 
				{
					case Notification.ADD:
					{
						if (newValue instanceof Segment)
						{
							Segment segment= (Segment) newValue;
							if (segment.getId()== null)
								segment.setId("seg_"+ (this.getSegments().size()+ 1));
						}
					}
				}
			}
		}		
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Segment> getSegments() {
		if (segments == null) {
			segments = new EObjectContainmentWithInverseEList<Segment>(Segment.class, this, Tiger2Package.CORPUS__SEGMENTS, Tiger2Package.SEGMENT__CORPUS);
		}
		return segments;
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
			eNotify(new ENotificationImpl(this, Notification.SET, Tiger2Package.CORPUS__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Corpus> getSubCorpora() {
		if (subCorpora == null) {
			subCorpora = new EObjectContainmentWithInverseEList<Corpus>(Corpus.class, this, Tiger2Package.CORPUS__SUB_CORPORA, Tiger2Package.CORPUS__SUPER_CORPUS);
		}
		return subCorpora;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Corpus getSuperCorpus() {
		if (eContainerFeatureID() != Tiger2Package.CORPUS__SUPER_CORPUS) return null;
		return (Corpus)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSuperCorpus(Corpus newSuperCorpus, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSuperCorpus, Tiger2Package.CORPUS__SUPER_CORPUS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperCorpus(Corpus newSuperCorpus) {
		if (newSuperCorpus != eInternalContainer() || (eContainerFeatureID() != Tiger2Package.CORPUS__SUPER_CORPUS && newSuperCorpus != null)) {
			if (EcoreUtil.isAncestor(this, newSuperCorpus))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSuperCorpus != null)
				msgs = ((InternalEObject)newSuperCorpus).eInverseAdd(this, Tiger2Package.CORPUS__SUB_CORPORA, Corpus.class, msgs);
			msgs = basicSetSuperCorpus(newSuperCorpus, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Tiger2Package.CORPUS__SUPER_CORPUS, newSuperCorpus, newSuperCorpus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Meta getMeta() {
		return meta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMeta(Meta newMeta, NotificationChain msgs) {
		Meta oldMeta = meta;
		meta = newMeta;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Tiger2Package.CORPUS__META, oldMeta, newMeta);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeta(Meta newMeta) {
		if (newMeta != meta) {
			NotificationChain msgs = null;
			if (meta != null)
				msgs = ((InternalEObject)meta).eInverseRemove(this, Tiger2Package.META__CORPUS, Meta.class, msgs);
			if (newMeta != null)
				msgs = ((InternalEObject)newMeta).eInverseAdd(this, Tiger2Package.META__CORPUS, Meta.class, msgs);
			msgs = basicSetMeta(newMeta, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Tiger2Package.CORPUS__META, newMeta, newMeta));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Feature> getFeatures() {
		if (features == null) {
			features = new EObjectContainmentWithInverseEList<Feature>(Feature.class, this, Tiger2Package.CORPUS__FEATURES, Tiger2Package.FEATURE__CORPUS);
		}
		return features;
	}

	/**
	 * {@link Inherited Corpus#createAnnotation(String, String, String)}
	 */
	public Annotation createAnnotation(String name, DOMAIN domain, String value) 
	{
		return(this.createAnnotation(name, domain, null, value));
	}
	
	/**
	 * {@inheritDoc Corpus#createAnnotation(String, DOMAIN, String, String)}
	 */
	public Annotation createAnnotation(String featureName, DOMAIN domain, String type, String featureValue) {
		Annotation retVal= null;
		if (	(featureName!= null)&&
				(!featureName.isEmpty())&&
				(domain!= null))
		{
			Feature feature= this.findFeature(featureName, domain, type);
			if (feature== null)
			{//generalized search 
				feature= this.findFeature(featureName, domain);
			}//generalized search
			if (feature!= null)
			{
				retVal= Tiger2Factory.eINSTANCE.createAnnotation();
				retVal.setFeatureRef(feature);
				
				FeatureValue featureValue1= this.findFeatureValue(featureName, domain, type, featureValue);
				if (featureValue1== null)
				{//generalized search 
					featureValue1= this.findFeatureValue(featureName, domain, featureValue);
				}//generalized search
				if (featureValue1!= null)
				{
					retVal.setFeatureValueRef(featureValue1);
				}
				else if (	(featureValue1== null)&&
							(feature.getFeatureValues().size()==0))
				{
					retVal.setValue(featureValue);
				}
				else 
				{
					EList<String> features= new BasicEList<String>();
					Feature feature2= this.findFeature(featureName, domain);
					if (	(feature2 != null)&&
							(feature2.getFeatureValues()!= null)&&
							(feature2.getFeatureValues().size()> 0))
					{
						for (FeatureValue featureValue2: feature2.getFeatureValues())
							features.add(featureValue2.getValue());
					}
					throw new TigerInvalidModelException("Cannot create an annotation for feature '"+featureName+"' in domain '"+domain+"' and type '"+type+"' with value '"+featureValue+"', because there is no featureValue defined for such an annotation value. Known values are: "+ features);
				}
			}
			else throw new TigerInvalidModelException("Cannot create an annotation for feature '"+featureName+"' in domain '"+domain+"' with value '"+featureValue+"', because there is no matching feature defined. Supported features are: "+ this.featureNameDomain2FeatureMap);
		}
		return(retVal);
	}

	/**
	 * {@inheritDoc Corpus#findFeatureValue(String, String, String)}
	 */
	public FeatureValue findFeatureValue(String featureName, DOMAIN featureDomain, String featureValueValue) 
	{
		return(findFeatureValue(featureName, featureDomain, null, featureValueValue));
	}
	
	/**
	 * {@inheritDoc Corpus#findFeature(String, DOMAIN, String)}
	 */
	public FeatureValue findFeatureValue(	String featureName, 
											DOMAIN featureDomain, 
											String type, 
											String featureValueValue) 
	{
		Feature feature= this.findFeature(featureName, featureDomain, type);
		if (feature!= null)
		{
			return(feature.findFeatureValue(featureValueValue));
		}
		return(null);
//		else
//			throw new TigerInvalidModelException("Cannot find a feature-value object for featureName='"+featureName+"', featureDomain='"+featureDomain+"' and type='"+type+"', because no feature having these coordinates exist.");
		
	}

	/**
	 * {@inheritDoc Corpus#findFeature(String, String)}
	 */
	public Feature findFeature(String featureName, DOMAIN domain) 
	{
		return(this.findFeature(featureName, domain, null));
	}

	/**
	 * {@inheritDoc Corpus#findFeature(String, DOMAIN, String)}
	 */
	public Feature findFeature(String featureName, DOMAIN domain, String type) {
		String key= featureName+FEATURE_SEPARATOR+domain;
		if (type!= null)
			key= key + FEATURE_SEPARATOR+ type;
		return(this.featureNameDomain2FeatureMap.get(key));
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
			case Tiger2Package.CORPUS__SEGMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSegments()).basicAdd(otherEnd, msgs);
			case Tiger2Package.CORPUS__SUB_CORPORA:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubCorpora()).basicAdd(otherEnd, msgs);
			case Tiger2Package.CORPUS__SUPER_CORPUS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSuperCorpus((Corpus)otherEnd, msgs);
			case Tiger2Package.CORPUS__META:
				if (meta != null)
					msgs = ((InternalEObject)meta).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Tiger2Package.CORPUS__META, null, msgs);
				return basicSetMeta((Meta)otherEnd, msgs);
			case Tiger2Package.CORPUS__FEATURES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFeatures()).basicAdd(otherEnd, msgs);
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
			case Tiger2Package.CORPUS__SEGMENTS:
				return ((InternalEList<?>)getSegments()).basicRemove(otherEnd, msgs);
			case Tiger2Package.CORPUS__SUB_CORPORA:
				return ((InternalEList<?>)getSubCorpora()).basicRemove(otherEnd, msgs);
			case Tiger2Package.CORPUS__SUPER_CORPUS:
				return basicSetSuperCorpus(null, msgs);
			case Tiger2Package.CORPUS__META:
				return basicSetMeta(null, msgs);
			case Tiger2Package.CORPUS__FEATURES:
				return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
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
			case Tiger2Package.CORPUS__SUPER_CORPUS:
				return eInternalContainer().eInverseRemove(this, Tiger2Package.CORPUS__SUB_CORPORA, Corpus.class, msgs);
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
			case Tiger2Package.CORPUS__SEGMENTS:
				return getSegments();
			case Tiger2Package.CORPUS__ID:
				return getId();
			case Tiger2Package.CORPUS__SUB_CORPORA:
				return getSubCorpora();
			case Tiger2Package.CORPUS__SUPER_CORPUS:
				return getSuperCorpus();
			case Tiger2Package.CORPUS__META:
				return getMeta();
			case Tiger2Package.CORPUS__FEATURES:
				return getFeatures();
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
			case Tiger2Package.CORPUS__SEGMENTS:
				getSegments().clear();
				getSegments().addAll((Collection<? extends Segment>)newValue);
				return;
			case Tiger2Package.CORPUS__ID:
				setId((String)newValue);
				return;
			case Tiger2Package.CORPUS__SUB_CORPORA:
				getSubCorpora().clear();
				getSubCorpora().addAll((Collection<? extends Corpus>)newValue);
				return;
			case Tiger2Package.CORPUS__SUPER_CORPUS:
				setSuperCorpus((Corpus)newValue);
				return;
			case Tiger2Package.CORPUS__META:
				setMeta((Meta)newValue);
				return;
			case Tiger2Package.CORPUS__FEATURES:
				getFeatures().clear();
				getFeatures().addAll((Collection<? extends Feature>)newValue);
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
			case Tiger2Package.CORPUS__SEGMENTS:
				getSegments().clear();
				return;
			case Tiger2Package.CORPUS__ID:
				setId(ID_EDEFAULT);
				return;
			case Tiger2Package.CORPUS__SUB_CORPORA:
				getSubCorpora().clear();
				return;
			case Tiger2Package.CORPUS__SUPER_CORPUS:
				setSuperCorpus((Corpus)null);
				return;
			case Tiger2Package.CORPUS__META:
				setMeta((Meta)null);
				return;
			case Tiger2Package.CORPUS__FEATURES:
				getFeatures().clear();
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
			case Tiger2Package.CORPUS__SEGMENTS:
				return segments != null && !segments.isEmpty();
			case Tiger2Package.CORPUS__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case Tiger2Package.CORPUS__SUB_CORPORA:
				return subCorpora != null && !subCorpora.isEmpty();
			case Tiger2Package.CORPUS__SUPER_CORPUS:
				return getSuperCorpus() != null;
			case Tiger2Package.CORPUS__META:
				return meta != null;
			case Tiger2Package.CORPUS__FEATURES:
				return features != null && !features.isEmpty();
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

} //CorpusImpl
