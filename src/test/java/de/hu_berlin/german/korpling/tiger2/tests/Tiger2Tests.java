/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hu_berlin.german.korpling.tiger2.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>tiger2</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class Tiger2Tests extends TestSuite {

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
		TestSuite suite = new Tiger2Tests("tiger2 Tests");
		suite.addTestSuite(GraphTest.class);
		suite.addTestSuite(NonTerminalTest.class);
		suite.addTestSuite(TerminalTest.class);
		suite.addTestSuite(EdgeTest.class);
		suite.addTestSuite(CorpusTest.class);
		suite.addTestSuite(AnnotationTest.class);
		suite.addTestSuite(FeatureTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tiger2Tests(String name) {
		super(name);
	}

} //Tiger2Tests
