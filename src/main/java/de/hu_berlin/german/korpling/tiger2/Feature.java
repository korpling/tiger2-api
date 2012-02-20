/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hu_berlin.german.korpling.tiger2;

import java.net.URI;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.Feature#getFeatureValues <em>Feature Values</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.Feature#getCorpus <em>Corpus</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.Feature#getId <em>Id</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.Feature#getDomain <em>Domain</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.Feature#getName <em>Name</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.Feature#getDcrReference <em>Dcr Reference</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.Feature#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getFeature()
 * @model
 * @generated
 */
public interface Feature extends EObject {
	/**
	 * Returns the value of the '<em><b>Feature Values</b></em>' containment reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.tiger2.FeatureValue}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.tiger2.FeatureValue#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Values</em>' containment reference list.
	 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getFeature_FeatureValues()
	 * @see de.hu_berlin.german.korpling.tiger2.FeatureValue#getFeature
	 * @model opposite="feature" containment="true"
	 * @generated
	 */
	EList<FeatureValue> getFeatureValues();

	/**
	 * Returns the value of the '<em><b>Corpus</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.tiger2.Corpus#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Corpus</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Corpus</em>' container reference.
	 * @see #setCorpus(Corpus)
	 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getFeature_Corpus()
	 * @see de.hu_berlin.german.korpling.tiger2.Corpus#getFeatures
	 * @model opposite="features" transient="false"
	 * @generated
	 */
	Corpus getCorpus();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.tiger2.Feature#getCorpus <em>Corpus</em>}' container reference.
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
	 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getFeature_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.tiger2.Feature#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Domain</b></em>' attribute.
	 * The literals are from the enumeration {@link de.hu_berlin.german.korpling.tiger2.DOMAIN}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain</em>' attribute.
	 * @see de.hu_berlin.german.korpling.tiger2.DOMAIN
	 * @see #setDomain(DOMAIN)
	 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getFeature_Domain()
	 * @model
	 * @generated
	 */
	DOMAIN getDomain();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.tiger2.Feature#getDomain <em>Domain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain</em>' attribute.
	 * @see de.hu_berlin.german.korpling.tiger2.DOMAIN
	 * @see #getDomain()
	 * @generated
	 */
	void setDomain(DOMAIN value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getFeature_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.tiger2.Feature#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Dcr Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dcr Reference</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dcr Reference</em>' attribute.
	 * @see #setDcrReference(URI)
	 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getFeature_DcrReference()
	 * @model dataType="de.hu_berlin.german.korpling.tiger2.URI"
	 * @generated
	 */
	URI getDcrReference();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.tiger2.Feature#getDcrReference <em>Dcr Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dcr Reference</em>' attribute.
	 * @see #getDcrReference()
	 * @generated
	 */
	void setDcrReference(URI value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getFeature_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.tiger2.Feature#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	FeatureValue findFeatureValue(String featureValueValue);

} // Feature
