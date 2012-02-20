/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hu_berlin.german.korpling.tiger2.tests;

import de.hu_berlin.german.korpling.tiger2.Edge;
import de.hu_berlin.german.korpling.tiger2.Graph;
import de.hu_berlin.german.korpling.tiger2.NonTerminal;
import de.hu_berlin.german.korpling.tiger2.Terminal;
import de.hu_berlin.german.korpling.tiger2.Tiger2Factory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.Graph#getNonTerminals() <em>Non Terminals</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.Graph#getTerminals() <em>Terminals</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.Graph#getIncomingEdges(java.lang.String) <em>Get Incoming Edges</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.Graph#getOutgoingEdges(java.lang.String) <em>Get Outgoing Edges</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.Graph#findNode(java.lang.String) <em>Find Node</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.tiger2.Graph#findEdge(java.lang.String) <em>Find Edge</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class GraphTest extends TestCase {

	/**
	 * The fixture for this Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Graph fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(GraphTest.class);
	}

	/**
	 * Constructs a new Graph test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Graph fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Graph getFixture() {
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
		setFixture(Tiger2Factory.eINSTANCE.createGraph());
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
	 * Tests the '{@link de.hu_berlin.german.korpling.tiger2.Graph#getNonTerminals() <em>Non Terminals</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.tiger2.Graph#getNonTerminals()
	 */
	public void testGetNonTerminals() 
	{
		NonTerminal nt1= Tiger2Factory.eINSTANCE.createNonTerminal();
		this.getFixture().getSyntacticNodes().add(nt1);
		assertNotNull(this.getFixture().getNonTerminals());
		assertEquals(1, this.getFixture().getNonTerminals().size());
		assertTrue(this.getFixture().getNonTerminals().contains(nt1));
		
		NonTerminal nt2= Tiger2Factory.eINSTANCE.createNonTerminal();
		this.getFixture().getSyntacticNodes().add(nt2);
		
		assertNotNull(this.getFixture().getNonTerminals());
		assertEquals(2, this.getFixture().getNonTerminals().size());
		assertTrue(this.getFixture().getNonTerminals().contains(nt1));
		assertTrue(this.getFixture().getNonTerminals().contains(nt2));
		
		NonTerminal nt3= Tiger2Factory.eINSTANCE.createNonTerminal();
		this.getFixture().getSyntacticNodes().add(nt3);
		
		assertNotNull(this.getFixture().getNonTerminals());
		assertEquals(3, this.getFixture().getNonTerminals().size());
		assertTrue(this.getFixture().getNonTerminals().contains(nt1));
		assertTrue(this.getFixture().getNonTerminals().contains(nt2));
		assertTrue(this.getFixture().getNonTerminals().contains(nt3));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.tiger2.Graph#getTerminals() <em>Terminals</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.tiger2.Graph#getTerminals()
	 */
	public void testGetTerminals() 
	{
		Terminal t1= Tiger2Factory.eINSTANCE.createTerminal();
		this.getFixture().getSyntacticNodes().add(t1);
		assertNotNull(this.getFixture().getTerminals());
		assertEquals(1, this.getFixture().getTerminals().size());
		assertTrue(this.getFixture().getTerminals().contains(t1));
		
		Terminal t2= Tiger2Factory.eINSTANCE.createTerminal();
		this.getFixture().getSyntacticNodes().add(t2);
		
		assertNotNull(this.getFixture().getTerminals());
		assertEquals(2, this.getFixture().getTerminals().size());
		assertTrue(this.getFixture().getTerminals().contains(t1));
		assertTrue(this.getFixture().getTerminals().contains(t2));
		
		Terminal t3= Tiger2Factory.eINSTANCE.createTerminal();
		this.getFixture().getSyntacticNodes().add(t3);
		
		assertNotNull(this.getFixture().getTerminals());
		assertEquals(3, this.getFixture().getTerminals().size());
		assertTrue(this.getFixture().getTerminals().contains(t1));
		assertTrue(this.getFixture().getTerminals().contains(t2));
		assertTrue(this.getFixture().getTerminals().contains(t3));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.tiger2.Graph#getIncomingEdges(java.lang.String) <em>Get Incoming Edges</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.tiger2.Graph#getIncomingEdges(java.lang.String)
	 */
	public void testGetIncomingEdges__String() 
	{
		NonTerminal nt1= Tiger2Factory.eINSTANCE.createNonTerminal();
		nt1.setId("nt1");
		this.getFixture().getSyntacticNodes().add(nt1);
		NonTerminal nt2= Tiger2Factory.eINSTANCE.createNonTerminal();
		nt2.setId("nt2");
		this.getFixture().getSyntacticNodes().add(nt2);
		NonTerminal nt3= Tiger2Factory.eINSTANCE.createNonTerminal();
		nt3.setId("nt3");
		this.getFixture().getSyntacticNodes().add(nt3);
		
		Edge e1= Tiger2Factory.eINSTANCE.createEdge();
		e1.setTarget(nt1);
		e1.setSource(nt2);
		this.getFixture().getEdges().add(e1);
		
		Edge e2= Tiger2Factory.eINSTANCE.createEdge();
		e2.setTarget(nt1);
		e2.setSource(nt3);
		this.getFixture().getEdges().add(e2);
		
		assertNotNull(this.getFixture().getIncomingEdges("nt1"));
		assertTrue(this.getFixture().getIncomingEdges("nt1").contains(e1));
		assertTrue(this.getFixture().getIncomingEdges("nt1").contains(e2));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.tiger2.Graph#getOutgoingEdges(java.lang.String) <em>Get Outgoing Edges</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.tiger2.Graph#getOutgoingEdges(java.lang.String)
	 */
	public void testGetOutgoingEdges__String() 
	{
		NonTerminal nt1= Tiger2Factory.eINSTANCE.createNonTerminal();
		nt1.setId("nt1");
		this.getFixture().getSyntacticNodes().add(nt1);
		NonTerminal nt2= Tiger2Factory.eINSTANCE.createNonTerminal();
		nt2.setId("nt2");
		this.getFixture().getSyntacticNodes().add(nt2);
		NonTerminal nt3= Tiger2Factory.eINSTANCE.createNonTerminal();
		nt3.setId("nt3");
		this.getFixture().getSyntacticNodes().add(nt3);
		
		Edge e1= Tiger2Factory.eINSTANCE.createEdge();
		e1.setTarget(nt2);
		e1.setSource(nt1);
		this.getFixture().getEdges().add(e1);
		
		Edge e2= Tiger2Factory.eINSTANCE.createEdge();
		e2.setTarget(nt3);
		e2.setSource(nt1);
		this.getFixture().getEdges().add(e2);
		
		assertNotNull(this.getFixture().getOutgoingEdges("nt1"));
		assertTrue(this.getFixture().getOutgoingEdges("nt1").contains(e1));
		assertTrue(this.getFixture().getOutgoingEdges("nt1").contains(e2));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.tiger2.Graph#findNode(java.lang.String) <em>Find Node</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.tiger2.Graph#findNode(java.lang.String)
	 * @generated
	 */
	public void testFindNode__String() 
	{
		Terminal t1= Tiger2Factory.eINSTANCE.createTerminal();
		t1.setId("t1");
		this.getFixture().getSyntacticNodes().add(t1);
		assertEquals(this.getFixture().findNode("t1"), t1);
		
		NonTerminal nt2= Tiger2Factory.eINSTANCE.createNonTerminal();
		nt2.setId("nt2");
		this.getFixture().getSyntacticNodes().add(nt2);
		assertEquals(this.getFixture().findNode("t1"), t1);
		assertEquals(this.getFixture().findNode("nt2"), nt2);
		
		Terminal t3= Tiger2Factory.eINSTANCE.createTerminal();
		t3.setId("t3");
		this.getFixture().getSyntacticNodes().add(t3);
		assertEquals(this.getFixture().findNode("t1"), t1);
		assertEquals(this.getFixture().findNode("nt2"), nt2);
		assertEquals(this.getFixture().findNode("t3"), t3);
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.tiger2.Graph#findEdge(java.lang.String) <em>Find Edge</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.tiger2.Graph#findEdge(java.lang.String)
	 */
	public void testFindEdge__String() 
	{
		Edge edge1= Tiger2Factory.eINSTANCE.createEdge();
		edge1.setId("e1");
		this.getFixture().getEdges().add(edge1);
		assertEquals(this.getFixture().findEdge("e1"), edge1);
		
		Edge edge2= Tiger2Factory.eINSTANCE.createEdge();
		edge2.setId("e2");
		this.getFixture().getEdges().add(edge2);
		assertEquals(this.getFixture().findEdge("e1"), edge1);
		assertEquals(this.getFixture().findEdge("e2"), edge2);
		
		Edge edge3= Tiger2Factory.eINSTANCE.createEdge();
		edge3.setId("e3");
		this.getFixture().getEdges().add(edge3);
		assertEquals(this.getFixture().findEdge("e1"), edge1);
		assertEquals(this.getFixture().findEdge("e2"), edge2);
		assertEquals(this.getFixture().findEdge("e3"), edge3);
	}

} //GraphTest
