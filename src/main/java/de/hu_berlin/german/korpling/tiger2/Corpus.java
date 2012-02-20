/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hu_berlin.german.korpling.tiger2;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import de.hu_berlin.german.korpling.tiger2.exceptions.TigerInvalidModelException;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Corpus</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.Corpus#getSegments <em>Segments</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.Corpus#getId <em>Id</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.Corpus#getSubCorpora <em>Sub Corpora</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.Corpus#getSuperCorpus <em>Super Corpus</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.Corpus#getMeta <em>Meta</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.Corpus#getFeatures <em>Features</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getCorpus()
 * @model
 * @generated
 */
public interface Corpus extends EObject {
	/**
	 * Returns the value of the '<em><b>Segments</b></em>' containment reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.tiger2.Segment}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.tiger2.Segment#getCorpus <em>Corpus</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Segments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Segments</em>' containment reference list.
	 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getCorpus_Segments()
	 * @see de.hu_berlin.german.korpling.tiger2.Segment#getCorpus
	 * @model opposite="corpus" containment="true"
	 * @generated
	 */
	EList<Segment> getSegments();

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
	 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getCorpus_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.tiger2.Corpus#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Sub Corpora</b></em>' containment reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.tiger2.Corpus}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.tiger2.Corpus#getSuperCorpus <em>Super Corpus</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Corpora</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Corpora</em>' containment reference list.
	 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getCorpus_SubCorpora()
	 * @see de.hu_berlin.german.korpling.tiger2.Corpus#getSuperCorpus
	 * @model opposite="superCorpus" containment="true"
	 * @generated
	 */
	EList<Corpus> getSubCorpora();

	/**
	 * Returns the value of the '<em><b>Super Corpus</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.tiger2.Corpus#getSubCorpora <em>Sub Corpora</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Corpus</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Corpus</em>' container reference.
	 * @see #setSuperCorpus(Corpus)
	 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getCorpus_SuperCorpus()
	 * @see de.hu_berlin.german.korpling.tiger2.Corpus#getSubCorpora
	 * @model opposite="subCorpora" transient="false"
	 * @generated
	 */
	Corpus getSuperCorpus();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.tiger2.Corpus#getSuperCorpus <em>Super Corpus</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Corpus</em>' container reference.
	 * @see #getSuperCorpus()
	 * @generated
	 */
	void setSuperCorpus(Corpus value);

	/**
	 * Returns the value of the '<em><b>Meta</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.tiger2.Meta#getCorpus <em>Corpus</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta</em>' containment reference.
	 * @see #setMeta(Meta)
	 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getCorpus_Meta()
	 * @see de.hu_berlin.german.korpling.tiger2.Meta#getCorpus
	 * @model opposite="corpus" containment="true"
	 * @generated
	 */
	Meta getMeta();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.tiger2.Corpus#getMeta <em>Meta</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta</em>' containment reference.
	 * @see #getMeta()
	 * @generated
	 */
	void setMeta(Meta value);

	/**
	 * Returns the value of the '<em><b>Features</b></em>' containment reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.tiger2.Feature}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.tiger2.Feature#getCorpus <em>Corpus</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' containment reference list.
	 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getCorpus_Features()
	 * @see de.hu_berlin.german.korpling.tiger2.Feature#getCorpus
	 * @model opposite="corpus" containment="true"
	 * @generated
	 */
	EList<Feature> getFeatures();

	/**
	 * Creates and returns a new {@link Annotation} object and refers it to the corresponding {@link Feature} and {@link FeatureValue} object
	 * matching the parameters <code>name</code> and <code>domain</code> or <code>value</code>. 
	 * If the parameters <code>name</code> and <code>domain</code> are null will be returned.
	 * @param name name to identify the {@link Feature} object
	 * @param domain domain to identify the {@link Feature} object
	 * @param value value to identify the {@link FeatureValue} object
	 * @return the created {@link Annotation} object
	 * @exception throws an {@link TigerInvalidModelException}, if no {@link Feature} object matching the parameters was found,
	 * @model
	 * @generated
	 */
	Annotation createAnnotation(String name, DOMAIN domain, String value);

	/**
	 * Creates and returns a new {@link Annotation} object and refers it to the corresponding {@link Feature} and {@link FeatureValue} object
	 * matching the parameters <code>name</code> and <code>domain</code> or <code>value</code>. 
	 * If the parameters <code>name</code> and <code>domain</code> are empty, null will be returned.
	 * If no {@link Feature} or {@link FeatureValue} having the given coordinates was found, the search will be done again without
	 * the <code>type</code>.  
	 * @param featureName name to identify the {@link Feature} object
	 * @param domain domain to identify the {@link Feature} object
	 * @param type type of the annotation corresponding to a {@link Feature}
	 * @param featureValue value to identify the {@link FeatureValue} object
	 * @return the created {@link Annotation} object
	 * @exception throws an {@link TigerInvalidModelException}, if no {@link Feature} object matching the parameters was found,
	 * @model
	 * @generated
	 */
	Annotation createAnnotation(String featureName, DOMAIN domain, String type, String featureValue);
	
	/**
	 * Searches a {@link Feature} object matching to the given <em>featureName</em> and <em>featureDomain</em>.
	 * @param featureName
	 * @param domain
	 * @return {@link Feature} object if a matching one was found
	 * @model
	 * @generated
	 */
	Feature findFeature(String featureName, DOMAIN domain);

	/**
	 * Searches a {@link FeatureValue} object matching to the given <em>featureValueValue</em> which is contained in a 
	 * {@link Feature} object matching to the given <em>featureName</em> and <em>featureDomain</em>.
	 * @param featureName
	 * @param featureDomain
	 * @param featureValueValue 
	 * @return {@link FeatureValue} object if a matching one was found
	 * @model
	 * @generated
	 */
	FeatureValue findFeatureValue(String featureName, DOMAIN featureDomain, String featureValueValue);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Feature findFeature(String featureName, DOMAIN domain, String type);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	FeatureValue findFeatureValue(String featureName, DOMAIN domain, String type, String featureValueValue);

} // Corpus
