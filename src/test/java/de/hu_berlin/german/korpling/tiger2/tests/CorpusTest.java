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

import de.hu_berlin.german.korpling.tiger2.Annotation;
import de.hu_berlin.german.korpling.tiger2.Corpus;
import de.hu_berlin.german.korpling.tiger2.DOMAIN;
import de.hu_berlin.german.korpling.tiger2.Feature;
import de.hu_berlin.german.korpling.tiger2.FeatureValue;
import de.hu_berlin.german.korpling.tiger2.Tiger2Factory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object
 * '<em><b>Corpus</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 * <li>{@link de.hu_berlin.german.korpling.tiger2.Corpus#createAnnotation(java.lang.String, de.hu_berlin.german.korpling.tiger2.DOMAIN, java.lang.String)
 * <em>Create Annotation</em>}</li>
 * <li>{@link de.hu_berlin.german.korpling.tiger2.Corpus#findFeature(java.lang.String, de.hu_berlin.german.korpling.tiger2.DOMAIN)
 * <em>Find Feature</em>}</li>
 * <li>{@link de.hu_berlin.german.korpling.tiger2.Corpus#findFeatureValue(java.lang.String, de.hu_berlin.german.korpling.tiger2.DOMAIN, java.lang.String)
 * <em>Find Feature Value</em>}</li>
 * <li>{@link de.hu_berlin.german.korpling.tiger2.Corpus#findFeature(java.lang.String, de.hu_berlin.german.korpling.tiger2.DOMAIN, java.lang.String)
 * <em>Find Feature</em>}</li>
 * <li>{@link de.hu_berlin.german.korpling.tiger2.Corpus#createAnnotation(java.lang.String, de.hu_berlin.german.korpling.tiger2.DOMAIN, java.lang.String, java.lang.String)
 * <em>Create Annotation</em>}</li>
 * <li>{@link de.hu_berlin.german.korpling.tiger2.Corpus#findFeatureValue(java.lang.String, de.hu_berlin.german.korpling.tiger2.DOMAIN, java.lang.String, java.lang.String)
 * <em>Find Feature Value</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class CorpusTest extends TestCase {

	/**
	 * The fixture for this Corpus test case. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected Corpus fixture = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(CorpusTest.class);
	}

	/**
	 * Constructs a new Corpus test case with the given name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CorpusTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Corpus test case. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected void setFixture(Corpus fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Corpus test case. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected Corpus getFixture() {
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
		setFixture(Tiger2Factory.eINSTANCE.createCorpus());
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
	 * '{@link de.hu_berlin.german.korpling.tiger2.Corpus#createAnnotation(java.lang.String, de.hu_berlin.german.korpling.tiger2.DOMAIN, java.lang.String)
	 * <em>Create Annotation</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see de.hu_berlin.german.korpling.tiger2.Corpus#createAnnotation(java.lang.String,
	 *      de.hu_berlin.german.korpling.tiger2.DOMAIN, java.lang.String)
	 */
	public void testCreateAnnotation__String_DOMAIN_String() {
		String name = "POS";
		DOMAIN domain = DOMAIN.T;
		String value = "N";
		try {
			this.getFixture().createAnnotation(name, domain, value);
			fail("shall not create an annotation, to not existing Feature objects.");
		} catch (Exception e) {
		}

		Feature feature1 = Tiger2Factory.eINSTANCE.createFeature();
		feature1.setName(name);
		feature1.setDomain(domain);
		FeatureValue featureValue1 = Tiger2Factory.eINSTANCE.createFeatureValue();
		featureValue1.setValue(value);
		feature1.getFeatureValues().add(featureValue1);
		this.getFixture().getFeatures().add(feature1);

		Annotation annotation = this.getFixture().createAnnotation(name, domain, value);
		assertNotNull(annotation);
		assertEquals(name, annotation.getName());
		assertEquals(value, annotation.getValue());

		Feature expectedFeature = null;
		FeatureValue expectedFeatureValue = null;

		for (Feature feature : this.getFixture().getFeatures()) {
			if ((name.equals(feature.getName())) || (domain.equals(feature.getDomain()))) {
				expectedFeature = feature;
				for (FeatureValue featureValue : feature.getFeatureValues()) {
					if (value.equals(featureValue.getValue())) {
						expectedFeatureValue = featureValue;
						break;
					}
				}
				break;
			}
		}
		assertNotNull(expectedFeature);
		assertEquals(name, expectedFeature.getName());
		assertEquals(domain, expectedFeature.getDomain());

		assertNotNull(expectedFeatureValue);
		assertEquals(value, expectedFeatureValue.getValue());
	}

	/**
	 * Tests the
	 * '{@link de.hu_berlin.german.korpling.tiger2.Corpus#createAnnotation(java.lang.String, de.hu_berlin.german.korpling.tiger2.DOMAIN, java.lang.String)
	 * <em>Create Annotation</em>}' operation. Creates an annotation while no
	 * {@link FeatureValue} objects are defined for the used {@link Feature}
	 * object.
	 * 
	 * @see de.hu_berlin.german.korpling.tiger2.Corpus#createAnnotation(java.lang.String,
	 *      de.hu_berlin.german.korpling.tiger2.DOMAIN, java.lang.String)
	 */
	public void testCreateAnnotation__String_DOMAIN_String2() {
		String name = "POS";
		DOMAIN domain = DOMAIN.T;
		String value = "N";
		try {
			this.getFixture().createAnnotation(name, domain, value);
			fail("shall not create an annotation, to not existing Feature objects.");
		} catch (Exception e) {
		}

		Feature feature1 = Tiger2Factory.eINSTANCE.createFeature();
		feature1.setName(name);
		feature1.setDomain(domain);
		FeatureValue featureValue1 = Tiger2Factory.eINSTANCE.createFeatureValue();
		featureValue1.setValue(value);
		feature1.getFeatureValues().add(featureValue1);
		this.getFixture().getFeatures().add(feature1);

		value = "V";
		try {
			Annotation annotation = this.getFixture().createAnnotation(name, domain, value);
			fail("Such an annotation shall not be created while, no featureValue mathcing to that value is defined.");
		} catch (Exception e) {
		}
	}

	/**
	 * Tests the
	 * '{@link de.hu_berlin.german.korpling.tiger2.Corpus#createAnnotation(java.lang.String, de.hu_berlin.german.korpling.tiger2.DOMAIN, java.lang.String)
	 * <em>Create Annotation</em>}' operation. Creates an annotation although
	 * {@link FeatureValue} objects are defined for the used {@link Feature}
	 * object, but no mathing one.
	 * 
	 * @see de.hu_berlin.german.korpling.tiger2.Corpus#createAnnotation(java.lang.String,
	 *      de.hu_berlin.german.korpling.tiger2.DOMAIN, java.lang.String)
	 */
	public void testCreateAnnotation__String_DOMAIN_String3() {
		String name = "POS";
		DOMAIN domain = DOMAIN.T;
		String value = "N";
		try {
			this.getFixture().createAnnotation(name, domain, value);
			fail("shall not create an annotation, to not existing Feature objects.");
		} catch (Exception e) {
		}

		Feature feature1 = Tiger2Factory.eINSTANCE.createFeature();
		feature1.setName(name);
		feature1.setDomain(domain);
		this.getFixture().getFeatures().add(feature1);

		Annotation annotation = this.getFixture().createAnnotation(name, domain, value);
		assertNotNull(annotation);
		assertEquals(name, annotation.getName());
		assertEquals(value, value);
	}

	/**
	 * Tests the
	 * '{@link de.hu_berlin.german.korpling.tiger2.Corpus#findFeature(java.lang.String, java.lang.String)
	 * <em>Find Feature</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see de.hu_berlin.german.korpling.tiger2.Corpus#findFeature(java.lang.String,
	 *      java.lang.String)
	 */
	public void testFindFeature__String_DOMAIN() {
		String name = "POS";
		DOMAIN domain = DOMAIN.T;

		Feature feature = Tiger2Factory.eINSTANCE.createFeature();
		feature.setName(name);
		feature.setDomain(domain);
		this.getFixture().getFeatures().add(feature);

		assertEquals(feature, this.getFixture().findFeature(name, domain));

		String name2 = "POS";
		DOMAIN domain2 = DOMAIN.NT;

		Feature feature2 = Tiger2Factory.eINSTANCE.createFeature();
		feature2.setName(name2);
		feature2.setDomain(domain2);
		this.getFixture().getFeatures().add(feature2);

		assertEquals(feature, this.getFixture().findFeature(name, domain));
		assertEquals(feature2, this.getFixture().findFeature(name2, domain2));
	}

	/**
	 * Tests the
	 * '{@link de.hu_berlin.german.korpling.tiger2.Corpus#findFeatureValue(java.lang.String, java.lang.String, java.lang.String)
	 * <em>Find Feature Value</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see de.hu_berlin.german.korpling.tiger2.Corpus#findFeatureValue(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	public void testFindFeatureValue__String_DOMAIN_String() {
		String name = "POS";
		DOMAIN domain = DOMAIN.T;

		Feature feature = Tiger2Factory.eINSTANCE.createFeature();
		feature.setName(name);
		feature.setDomain(domain);
		this.getFixture().getFeatures().add(feature);

		FeatureValue featVal1 = Tiger2Factory.eINSTANCE.createFeatureValue();
		featVal1.setValue("N");
		feature.getFeatureValues().add(featVal1);

		FeatureValue featVal2 = Tiger2Factory.eINSTANCE.createFeatureValue();
		featVal2.setValue("V");
		feature.getFeatureValues().add(featVal2);

		assertEquals(featVal1,
				this.getFixture().findFeatureValue(feature.getName(), feature.getDomain(), featVal1.getValue()));
		assertEquals(featVal2,
				this.getFixture().findFeatureValue(feature.getName(), feature.getDomain(), featVal2.getValue()));
	}

	/**
	 * Tests the
	 * '{@link de.hu_berlin.german.korpling.tiger2.Corpus#findFeature(java.lang.String, de.hu_berlin.german.korpling.tiger2.DOMAIN, java.lang.String)
	 * <em>Find Feature</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see de.hu_berlin.german.korpling.tiger2.Corpus#findFeature(java.lang.String,
	 *      de.hu_berlin.german.korpling.tiger2.DOMAIN, java.lang.String)
	 */
	public void testFindFeature__String_DOMAIN_String() {
		Feature feat1 = Tiger2Factory.eINSTANCE.createFeature();
		feat1.setName("feat1");
		feat1.setDomain(DOMAIN.T);
		feat1.setType("type1");
		this.getFixture().getFeatures().add(feat1);

		assertEquals(feat1, this.getFixture().findFeature(feat1.getName(), feat1.getDomain(), feat1.getType()));

		Feature feat2 = Tiger2Factory.eINSTANCE.createFeature();
		feat2.setName("feat2");
		feat2.setDomain(DOMAIN.NT);
		feat2.setType("type1");
		this.getFixture().getFeatures().add(feat2);

		assertEquals(feat1, this.getFixture().findFeature(feat1.getName(), feat1.getDomain(), feat1.getType()));
		assertEquals(feat2, this.getFixture().findFeature(feat2.getName(), feat2.getDomain(), feat2.getType()));
	}

	/**
	 * Tests the
	 * '{@link de.hu_berlin.german.korpling.tiger2.Corpus#createAnnotation(java.lang.String, de.hu_berlin.german.korpling.tiger2.DOMAIN, java.lang.String, java.lang.String)
	 * <em>Create Annotation</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see de.hu_berlin.german.korpling.tiger2.Corpus#createAnnotation(java.lang.String,
	 *      de.hu_berlin.german.korpling.tiger2.DOMAIN, java.lang.String,
	 *      java.lang.String)
	 */
	public void testCreateAnnotation__String_DOMAIN_String_String() {
		Feature feat1 = Tiger2Factory.eINSTANCE.createFeature();
		feat1.setName("feat1");
		feat1.setDomain(DOMAIN.T);
		feat1.setType("type1");
		this.getFixture().getFeatures().add(feat1);

		FeatureValue featVal1 = Tiger2Factory.eINSTANCE.createFeatureValue();
		featVal1.setValue("value1");
		feat1.getFeatureValues().add(featVal1);

		FeatureValue featVal2 = Tiger2Factory.eINSTANCE.createFeatureValue();
		featVal2.setValue("value2");
		feat1.getFeatureValues().add(featVal2);

		Annotation anno1 = this.getFixture().createAnnotation(feat1.getName(), feat1.getDomain(), feat1.getType(),
				featVal1.getValue());
		assertEquals(feat1.getName(), anno1.getName());
		assertEquals(feat1, anno1.getFeatureRef());
		assertEquals(featVal1.getValue(), anno1.getValue());
		assertEquals(featVal1, anno1.getFeatureValueRef());

		Annotation anno2 = this.getFixture().createAnnotation(feat1.getName(), feat1.getDomain(), feat1.getType(),
				featVal2.getValue());
		assertEquals(feat1.getName(), anno2.getName());
		assertEquals(feat1, anno2.getFeatureRef());
		assertEquals(featVal2.getValue(), anno2.getValue());
		assertEquals(featVal2, anno2.getFeatureValueRef());
	}

	/**
	 * Tests the
	 * '{@link de.hu_berlin.german.korpling.tiger2.Corpus#findFeatureValue(java.lang.String, de.hu_berlin.german.korpling.tiger2.DOMAIN, java.lang.String, java.lang.String)
	 * <em>Find Feature Value</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see de.hu_berlin.german.korpling.tiger2.Corpus#findFeatureValue(java.lang.String,
	 *      de.hu_berlin.german.korpling.tiger2.DOMAIN, java.lang.String,
	 *      java.lang.String)
	 */
	public void testFindFeatureValue__String_DOMAIN_String_String() {
		Feature feat1 = Tiger2Factory.eINSTANCE.createFeature();
		feat1.setName("feat1");
		feat1.setDomain(DOMAIN.T);
		feat1.setType("type1");
		this.getFixture().getFeatures().add(feat1);

		FeatureValue featVal1 = Tiger2Factory.eINSTANCE.createFeatureValue();
		featVal1.setValue("value1");
		feat1.getFeatureValues().add(featVal1);

		assertEquals(featVal1, this.getFixture().findFeatureValue(feat1.getName(), feat1.getDomain(), feat1.getType(),
				featVal1.getValue()));

		FeatureValue featVal2 = Tiger2Factory.eINSTANCE.createFeatureValue();
		featVal2.setValue("value2");
		feat1.getFeatureValues().add(featVal2);

		assertEquals(featVal1, this.getFixture().findFeatureValue(feat1.getName(), feat1.getDomain(), feat1.getType(),
				featVal1.getValue()));
		assertEquals(featVal2, this.getFixture().findFeatureValue(feat1.getName(), feat1.getDomain(), feat1.getType(),
				featVal2.getValue()));
	}

} // CorpusTest
