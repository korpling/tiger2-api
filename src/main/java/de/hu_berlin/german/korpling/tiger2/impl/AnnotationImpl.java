/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hu_berlin.german.korpling.tiger2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.hu_berlin.german.korpling.tiger2.AnnotatableElement;
import de.hu_berlin.german.korpling.tiger2.Annotation;
import de.hu_berlin.german.korpling.tiger2.Feature;
import de.hu_berlin.german.korpling.tiger2.FeatureValue;
import de.hu_berlin.german.korpling.tiger2.Tiger2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.impl.AnnotationImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.impl.AnnotationImpl#getValue <em>Value</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.impl.AnnotationImpl#getFeatureRef <em>Feature Ref</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.impl.AnnotationImpl#getFeatureValueRef <em>Feature Value Ref</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.impl.AnnotationImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AnnotationImpl extends EObjectImpl implements Annotation {
	/**
	 * The cached value of the '{@link #getOwner() <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwner()
	 * @generated
	 * @ordered
	 */
	protected AnnotatableElement owner;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFeatureRef() <em>Feature Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureRef()
	 * @generated
	 * @ordered
	 */
	protected Feature featureRef;

	/**
	 * The cached value of the '{@link #getFeatureValueRef() <em>Feature Value Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureValueRef()
	 * @generated
	 * @ordered
	 */
	protected FeatureValue featureValueRef;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnnotationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Tiger2Package.Literals.ANNOTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotatableElement getOwner() {
		if (owner != null && owner.eIsProxy()) {
			InternalEObject oldOwner = (InternalEObject)owner;
			owner = (AnnotatableElement)eResolveProxy(oldOwner);
			if (owner != oldOwner) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Tiger2Package.ANNOTATION__OWNER, oldOwner, owner));
			}
		}
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotatableElement basicGetOwner() {
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(AnnotatableElement newOwner, NotificationChain msgs) {
		AnnotatableElement oldOwner = owner;
		owner = newOwner;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Tiger2Package.ANNOTATION__OWNER, oldOwner, newOwner);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(AnnotatableElement newOwner) {
		if (newOwner != owner) {
			NotificationChain msgs = null;
			if (owner != null)
				msgs = ((InternalEObject)owner).eInverseRemove(this, Tiger2Package.ANNOTATABLE_ELEMENT__ANNOTATIONS, AnnotatableElement.class, msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, Tiger2Package.ANNOTATABLE_ELEMENT__ANNOTATIONS, AnnotatableElement.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Tiger2Package.ANNOTATION__OWNER, newOwner, newOwner));
	}

	/**
	 * {@inheritDoc Annotation#getValue()}
	 */
	public String getValue() {
		if (this.getFeatureValueRef()!= null)
			return(this.getFeatureValueRef().getValue());
		else return(this.value);
	}

	/**
	 * {@inheritDoc Annotation#getValue()}
	 */
	public void setValue(String newValue) {
		if (this.getFeatureValueRef()== null)
		{
			String oldValue = value;
			value = newValue;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, Tiger2Package.ANNOTATION__VALUE, oldValue, value));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature getFeatureRef() {
		if (featureRef != null && featureRef.eIsProxy()) {
			InternalEObject oldFeatureRef = (InternalEObject)featureRef;
			featureRef = (Feature)eResolveProxy(oldFeatureRef);
			if (featureRef != oldFeatureRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Tiger2Package.ANNOTATION__FEATURE_REF, oldFeatureRef, featureRef));
			}
		}
		return featureRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature basicGetFeatureRef() {
		return featureRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureRef(Feature newFeatureRef) {
		Feature oldFeatureRef = featureRef;
		featureRef = newFeatureRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Tiger2Package.ANNOTATION__FEATURE_REF, oldFeatureRef, featureRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureValue getFeatureValueRef() {
		if (featureValueRef != null && featureValueRef.eIsProxy()) {
			InternalEObject oldFeatureValueRef = (InternalEObject)featureValueRef;
			featureValueRef = (FeatureValue)eResolveProxy(oldFeatureValueRef);
			if (featureValueRef != oldFeatureValueRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Tiger2Package.ANNOTATION__FEATURE_VALUE_REF, oldFeatureValueRef, featureValueRef));
			}
		}
		return featureValueRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureValue basicGetFeatureValueRef() {
		return featureValueRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureValueRef(FeatureValue newFeatureValueRef) {
		FeatureValue oldFeatureValueRef = featureValueRef;
		featureValueRef = newFeatureValueRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Tiger2Package.ANNOTATION__FEATURE_VALUE_REF, oldFeatureValueRef, featureValueRef));
	}

	/**
	 * {@inheritDoc Annotation#getName()}
	 */
	public String getName() 
	{
		if (this.getFeatureRef()!= null)
			return(this.getFeatureRef().getName());
		else return(null);
	}

	/**
	 * {@inheritDoc Annotation#setName(String)}
	 */
	public void setName(String newName) {
		// TODO: implement this method to set the 'Name' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Tiger2Package.ANNOTATION__OWNER:
				if (owner != null)
					msgs = ((InternalEObject)owner).eInverseRemove(this, Tiger2Package.ANNOTATABLE_ELEMENT__ANNOTATIONS, AnnotatableElement.class, msgs);
				return basicSetOwner((AnnotatableElement)otherEnd, msgs);
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
			case Tiger2Package.ANNOTATION__OWNER:
				return basicSetOwner(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Tiger2Package.ANNOTATION__OWNER:
				if (resolve) return getOwner();
				return basicGetOwner();
			case Tiger2Package.ANNOTATION__VALUE:
				return getValue();
			case Tiger2Package.ANNOTATION__FEATURE_REF:
				if (resolve) return getFeatureRef();
				return basicGetFeatureRef();
			case Tiger2Package.ANNOTATION__FEATURE_VALUE_REF:
				if (resolve) return getFeatureValueRef();
				return basicGetFeatureValueRef();
			case Tiger2Package.ANNOTATION__NAME:
				return getName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Tiger2Package.ANNOTATION__OWNER:
				setOwner((AnnotatableElement)newValue);
				return;
			case Tiger2Package.ANNOTATION__VALUE:
				setValue((String)newValue);
				return;
			case Tiger2Package.ANNOTATION__FEATURE_REF:
				setFeatureRef((Feature)newValue);
				return;
			case Tiger2Package.ANNOTATION__FEATURE_VALUE_REF:
				setFeatureValueRef((FeatureValue)newValue);
				return;
			case Tiger2Package.ANNOTATION__NAME:
				setName((String)newValue);
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
			case Tiger2Package.ANNOTATION__OWNER:
				setOwner((AnnotatableElement)null);
				return;
			case Tiger2Package.ANNOTATION__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case Tiger2Package.ANNOTATION__FEATURE_REF:
				setFeatureRef((Feature)null);
				return;
			case Tiger2Package.ANNOTATION__FEATURE_VALUE_REF:
				setFeatureValueRef((FeatureValue)null);
				return;
			case Tiger2Package.ANNOTATION__NAME:
				setName(NAME_EDEFAULT);
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
			case Tiger2Package.ANNOTATION__OWNER:
				return owner != null;
			case Tiger2Package.ANNOTATION__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case Tiger2Package.ANNOTATION__FEATURE_REF:
				return featureRef != null;
			case Tiger2Package.ANNOTATION__FEATURE_VALUE_REF:
				return featureValueRef != null;
			case Tiger2Package.ANNOTATION__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
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
		result.append(" (value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //AnnotationImpl
