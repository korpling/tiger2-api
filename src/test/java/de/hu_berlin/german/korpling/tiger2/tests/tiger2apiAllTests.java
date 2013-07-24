/**
 */
package de.hu_berlin.german.korpling.tiger2.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>tiger2-api</b></em>' model.
 * <!-- end-user-doc -->
 * @generated
 */
public class tiger2apiAllTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new tiger2apiAllTests("tiger2-api Tests");
		suite.addTest(Tiger2Tests.suite());
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public tiger2apiAllTests(String name) {
		super(name);
	}

} //tiger2apiAllTests
