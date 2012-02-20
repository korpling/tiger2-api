/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hu_berlin.german.korpling.tiger2.tests;

import de.hu_berlin.german.korpling.tiger2.Annotation;
import de.hu_berlin.german.korpling.tiger2.Feature;
import de.hu_berlin.german.korpling.tiger2.FeatureValue;
import de.hu_berlin.german.korpling.tiger2.Tiger2Factory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.Annotation#getValue() <em>Value</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.Annotation#getName() <em>Name</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class AnnotationTest extends TestCase {

	/**
	 * The fixture for this Annotation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Annotation fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AnnotationTest.class);
	}

	/**
	 * Constructs a new Annotation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotationTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Annotation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Annotation fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Annotation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Annotation getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(Tiger2Factory.eINSTANCE.createAnnotation());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.tiger2.Annotation#getValue() <em>Value</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.tiger2.Annotation#getValue()
	 */
	public void testGetValue() 
	{
		String value= "annoVal";
		FeatureValue featureValue= Tiger2Factory.eINSTANCE.createFeatureValue();
		featureValue.setValue(value);
		
		this.getFixture().setFeatureValueRef(featureValue);
		assertEquals(value, this.getFixture().getValue());
		
		value= "annoVal2";
		this.getFixture().setValue(value);
		assertEquals(featureValue.getValue(), this.getFixture().getValue());
		
		this.getFixture().setFeatureValueRef(null);
		this.getFixture().setValue(value);
		assertEquals(value, this.getFixture().getValue());
		
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.tiger2.Annotation#setValue(java.lang.String) <em>Value</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.tiger2.Annotation#setValue(java.lang.String)
	 */
	public void testSetValue() {
		this.testGetValue();
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.tiger2.Annotation#getName() <em>Name</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.tiger2.Annotation#getName()
	 */
	public void testGetName() 
	{
		String name= "annoName";
		Feature feature= Tiger2Factory.eINSTANCE.createFeature();
		feature.setName(name);
		
		this.getFixture().setFeatureRef(feature);
		assertEquals(name, this.getFixture().getName());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.tiger2.Annotation#setName(java.lang.String) <em>Name</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.tiger2.Annotation#setName(java.lang.String)
	 */
	public void testSetName() {
		this.testGetName();	}

} //AnnotationTest
