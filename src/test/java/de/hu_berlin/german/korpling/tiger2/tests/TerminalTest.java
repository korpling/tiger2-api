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

import de.hu_berlin.german.korpling.tiger2.Terminal;
import de.hu_berlin.german.korpling.tiger2.Tiger2Factory;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object
 * '<em><b>Terminal</b></em>'. <!-- end-user-doc -->
 * 
 * @generated
 */
public class TerminalTest extends SyntacticNodeTest {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(TerminalTest.class);
	}

	/**
	 * Constructs a new Terminal test case with the given name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TerminalTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Terminal test case. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected Terminal getFixture() {
		return (Terminal) fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(Tiger2Factory.eINSTANCE.createTerminal());
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
	 * This test is just an alibi, until some tests were added.
	 */
	public void testAlibi() {
	}

} // TerminalTest
