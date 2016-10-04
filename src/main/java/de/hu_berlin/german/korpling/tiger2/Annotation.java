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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Annotation</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.hu_berlin.german.korpling.tiger2.Annotation#getOwner
 * <em>Owner</em>}</li>
 * <li>{@link de.hu_berlin.german.korpling.tiger2.Annotation#getValue
 * <em>Value</em>}</li>
 * <li>{@link de.hu_berlin.german.korpling.tiger2.Annotation#getFeatureRef
 * <em>Feature Ref</em>}</li>
 * <li>{@link de.hu_berlin.german.korpling.tiger2.Annotation#getFeatureValueRef
 * <em>Feature Value Ref</em>}</li>
 * <li>{@link de.hu_berlin.german.korpling.tiger2.Annotation#getName
 * <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getAnnotation()
 * @model
 * @generated
 */
public interface Annotation extends EObject {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' reference. It is
	 * bidirectional and its opposite is
	 * '{@link de.hu_berlin.german.korpling.tiger2.AnnotatableElement#getAnnotations
	 * <em>Annotations</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Owner</em>' reference.
	 * @see #setOwner(AnnotatableElement)
	 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getAnnotation_Owner()
	 * @see de.hu_berlin.german.korpling.tiger2.AnnotatableElement#getAnnotations
	 * @model opposite="annotations"
	 * @generated
	 */
	AnnotatableElement getOwner();

	/**
	 * Sets the value of the
	 * '{@link de.hu_berlin.german.korpling.tiger2.Annotation#getOwner
	 * <em>Owner</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Owner</em>' reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(AnnotatableElement value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute. This value is
	 * a derived value and calls {@link FeatureValue#getValue()} if this
	 * reference is set, otherwise the internal value is returned if set.
	 * 
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getAnnotation_Value()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the
	 * '{@link de.hu_berlin.german.korpling.tiger2.Annotation#getValue
	 * <em>Value</em>}' attribute. A value can only be set, if this object has
	 * no reference to a {@link FeatureValue} object via
	 * {@link #getFeatureRef()}. If it has one, this method has no effect.
	 * 
	 * @param value
	 *            the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Feature Ref</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Ref</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Feature Ref</em>' reference.
	 * @see #setFeatureRef(Feature)
	 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getAnnotation_FeatureRef()
	 * @model required="true"
	 * @generated
	 */
	Feature getFeatureRef();

	/**
	 * Sets the value of the
	 * '{@link de.hu_berlin.german.korpling.tiger2.Annotation#getFeatureRef
	 * <em>Feature Ref</em>}' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Feature Ref</em>' reference.
	 * @see #getFeatureRef()
	 * @generated
	 */
	void setFeatureRef(Feature value);

	/**
	 * Returns the value of the '<em><b>Feature Value Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Value Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Feature Value Ref</em>' reference.
	 * @see #setFeatureValueRef(FeatureValue)
	 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getAnnotation_FeatureValueRef()
	 * @model
	 * @generated
	 */
	FeatureValue getFeatureValueRef();

	/**
	 * Sets the value of the
	 * '{@link de.hu_berlin.german.korpling.tiger2.Annotation#getFeatureValueRef
	 * <em>Feature Value Ref</em>}' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Feature Value Ref</em>' reference.
	 * @see #getFeatureValueRef()
	 * @generated
	 */
	void setFeatureValueRef(FeatureValue value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. This value is
	 * a derived value and calls {@link Feature#getName()}
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getAnnotation_Name()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	String getName();

} // Annotation
