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
package de.hu_berlin.german.korpling.tiger2.tests;

import org.junit.Test;

import de.hu_berlin.german.korpling.tiger2.Annotation;
import de.hu_berlin.german.korpling.tiger2.Edge;
import de.hu_berlin.german.korpling.tiger2.Feature;
import de.hu_berlin.german.korpling.tiger2.Tiger2Factory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object
 * '<em><b>Edge</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 * <li>{@link de.hu_berlin.german.korpling.tiger2.AnnotatableElement#findAnnotation(java.lang.String)
 * <em>Find Annotation</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class EdgeTest extends TestCase {

	/**
	 * The fixture for this Edge test case. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected Edge fixture = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(EdgeTest.class);
	}

	/**
	 * Constructs a new Edge test case with the given name. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EdgeTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Edge test case. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected void setFixture(Edge fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Edge test case. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected Edge getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(Tiger2Factory.eINSTANCE.createEdge());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the
	 * '{@link de.hu_berlin.german.korpling.tiger2.AnnotatableElement#findAnnotation(java.lang.String)
	 * <em>Find Annotation</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see de.hu_berlin.german.korpling.tiger2.AnnotatableElement#findAnnotation(java.lang.String)
	 * @generated
	 */
	/**
	 * Tests the
	 * '{@link de.hu_berlin.german.korpling.tiger2.AnnotatableElement#findAnnotation(java.lang.String)
	 * <em>Find Annotation</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see de.hu_berlin.german.korpling.tiger2.AnnotatableElement#findAnnotation(java.lang.String)
	 */
	@Test
	public void testFindAnnotation__String() {
		Feature feat1 = Tiger2Factory.eINSTANCE.createFeature();
		feat1.setName("feat1");
		Feature feat2 = Tiger2Factory.eINSTANCE.createFeature();
		feat2.setName("feat2");
		Feature feat3 = Tiger2Factory.eINSTANCE.createFeature();
		feat3.setName("feat3");

		Annotation anno1 = Tiger2Factory.eINSTANCE.createAnnotation();
		anno1.setFeatureRef(feat1);
		anno1.setValue("value1");
		this.getFixture().getAnnotations().add(anno1);
		assertEquals(anno1, this.getFixture().findAnnotation(feat1.getName()));

		Annotation anno2 = Tiger2Factory.eINSTANCE.createAnnotation();
		anno2.setFeatureRef(feat2);
		anno2.setValue("value2");
		this.getFixture().getAnnotations().add(anno2);
		assertEquals(anno2, this.getFixture().findAnnotation(feat2.getName()));

		Annotation anno3 = Tiger2Factory.eINSTANCE.createAnnotation();
		anno3.setFeatureRef(feat3);
		anno3.setValue("value1");
		this.getFixture().getAnnotations().add(anno3);
		assertEquals(anno3, this.getFixture().findAnnotation(feat3.getName()));

		// try
		// {
		// Annotation anno4= Tiger2Factory.eINSTANCE.createAnnotation();
		// anno4.setFeatureRef(feat1);
		// anno4.setValue("value1");
		// this.getFixture().getAnnotations().add(anno4);
		// fail("shall not the same annotation twice.");
		// }
		// catch (Exception e) {
		// }
	}
} // EdgeTest
