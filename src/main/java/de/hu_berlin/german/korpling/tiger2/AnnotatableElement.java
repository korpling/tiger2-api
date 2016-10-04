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
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Annotatable Element</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.hu_berlin.german.korpling.tiger2.AnnotatableElement#getAnnotations
 * <em>Annotations</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getAnnotatableElement()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface AnnotatableElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Annotations</b></em>' reference list.
	 * The list contents are of type
	 * {@link de.hu_berlin.german.korpling.tiger2.Annotation}. It is
	 * bidirectional and its opposite is
	 * '{@link de.hu_berlin.german.korpling.tiger2.Annotation#getOwner
	 * <em>Owner</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Annotations</em>' reference list.
	 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#getAnnotatableElement_Annotations()
	 * @see de.hu_berlin.german.korpling.tiger2.Annotation#getOwner
	 * @model opposite="owner"
	 * @generated
	 */
	EList<Annotation> getAnnotations();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model
	 * @generated
	 */
	Annotation findAnnotation(String annotationName);

} // AnnotatableElement
