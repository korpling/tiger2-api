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

import de.hu_berlin.german.korpling.tiger2.Feature;
import de.hu_berlin.german.korpling.tiger2.FeatureValue;
import de.hu_berlin.german.korpling.tiger2.Tiger2Factory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object
 * '<em><b>Feature</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 * <li>{@link de.hu_berlin.german.korpling.tiger2.Feature#findFeatureValue(java.lang.String)
 * <em>Find Feature Value</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class FeatureTest extends TestCase {

	/**
	 * The fixture for this Feature test case. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected Feature fixture = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(FeatureTest.class);
	}

	/**
	 * Constructs a new Feature test case with the given name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FeatureTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Feature test case. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected void setFixture(Feature fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Feature test case. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected Feature getFixture() {
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
		setFixture(Tiger2Factory.eINSTANCE.createFeature());
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
	 * '{@link de.hu_berlin.german.korpling.tiger2.Feature#findFeatureValue(java.lang.String)
	 * <em>Find Feature Value</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see de.hu_berlin.german.korpling.tiger2.Feature#findFeatureValue(java.lang.String)
	 */
	public void testFindFeatureValue__String() {
		String value1 = "N";

		FeatureValue featureValue1 = Tiger2Factory.eINSTANCE.createFeatureValue();
		featureValue1.setValue(value1);

		this.getFixture().getFeatureValues().add(featureValue1);
		assertEquals(featureValue1, this.getFixture().findFeatureValue(value1));

		String value2 = "VVFIN";

		FeatureValue featureValue2 = Tiger2Factory.eINSTANCE.createFeatureValue();
		featureValue2.setValue(value2);

		this.getFixture().getFeatureValues().add(featureValue2);
		assertEquals(featureValue2, this.getFixture().findFeatureValue(value2));
	}

} // FeatureTest
