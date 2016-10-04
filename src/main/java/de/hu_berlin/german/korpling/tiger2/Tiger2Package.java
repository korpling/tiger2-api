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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Factory
 * @model kind="package"
 * @generated
 */
public interface Tiger2Package extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "tiger2";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://korpling.german.hu-berlin.de/tiger2/";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "tiger2";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	Tiger2Package eINSTANCE = de.hu_berlin.german.korpling.tiger2.impl.Tiger2PackageImpl.init();

	/**
	 * The meta object id for the
	 * '{@link de.hu_berlin.german.korpling.tiger2.impl.GraphImpl
	 * <em>Graph</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see de.hu_berlin.german.korpling.tiger2.impl.GraphImpl
	 * @see de.hu_berlin.german.korpling.tiger2.impl.Tiger2PackageImpl#getGraph()
	 * @generated
	 */
	int GRAPH = 0;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' containment reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH__EDGES = 0;

	/**
	 * The feature id for the '<em><b>Syntactic Nodes</b></em>' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH__SYNTACTIC_NODES = 1;

	/**
	 * The feature id for the '<em><b>Non Terminals</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH__NON_TERMINALS = 2;

	/**
	 * The feature id for the '<em><b>Terminals</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH__TERMINALS = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH__ID = 4;

	/**
	 * The feature id for the '<em><b>Segment</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH__SEGMENT = 5;

	/**
	 * The number of structural features of the '<em>Graph</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the
	 * '{@link de.hu_berlin.german.korpling.tiger2.AnnotatableElement
	 * <em>Annotatable Element</em>}' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see de.hu_berlin.german.korpling.tiger2.AnnotatableElement
	 * @see de.hu_berlin.german.korpling.tiger2.impl.Tiger2PackageImpl#getAnnotatableElement()
	 * @generated
	 */
	int ANNOTATABLE_ELEMENT = 8;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANNOTATABLE_ELEMENT__ANNOTATIONS = 0;

	/**
	 * The number of structural features of the '<em>Annotatable Element</em>'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANNOTATABLE_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the
	 * '{@link de.hu_berlin.german.korpling.tiger2.impl.SyntacticNodeImpl
	 * <em>Syntactic Node</em>}' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see de.hu_berlin.german.korpling.tiger2.impl.SyntacticNodeImpl
	 * @see de.hu_berlin.german.korpling.tiger2.impl.Tiger2PackageImpl#getSyntacticNode()
	 * @generated
	 */
	int SYNTACTIC_NODE = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYNTACTIC_NODE__ANNOTATIONS = ANNOTATABLE_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYNTACTIC_NODE__GRAPH = ANNOTATABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYNTACTIC_NODE__ID = ANNOTATABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYNTACTIC_NODE__TYPE = ANNOTATABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Syntactic Node</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYNTACTIC_NODE_FEATURE_COUNT = ANNOTATABLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the
	 * '{@link de.hu_berlin.german.korpling.tiger2.impl.NonTerminalImpl <em>Non
	 * Terminal</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see de.hu_berlin.german.korpling.tiger2.impl.NonTerminalImpl
	 * @see de.hu_berlin.german.korpling.tiger2.impl.Tiger2PackageImpl#getNonTerminal()
	 * @generated
	 */
	int NON_TERMINAL = 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NON_TERMINAL__ANNOTATIONS = SYNTACTIC_NODE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NON_TERMINAL__GRAPH = SYNTACTIC_NODE__GRAPH;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NON_TERMINAL__ID = SYNTACTIC_NODE__ID;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NON_TERMINAL__TYPE = SYNTACTIC_NODE__TYPE;

	/**
	 * The number of structural features of the '<em>Non Terminal</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NON_TERMINAL_FEATURE_COUNT = SYNTACTIC_NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the
	 * '{@link de.hu_berlin.german.korpling.tiger2.impl.TerminalImpl
	 * <em>Terminal</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see de.hu_berlin.german.korpling.tiger2.impl.TerminalImpl
	 * @see de.hu_berlin.german.korpling.tiger2.impl.Tiger2PackageImpl#getTerminal()
	 * @generated
	 */
	int TERMINAL = 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TERMINAL__ANNOTATIONS = SYNTACTIC_NODE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TERMINAL__GRAPH = SYNTACTIC_NODE__GRAPH;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TERMINAL__ID = SYNTACTIC_NODE__ID;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TERMINAL__TYPE = SYNTACTIC_NODE__TYPE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TERMINAL__SOURCE = SYNTACTIC_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Word</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TERMINAL__WORD = SYNTACTIC_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Terminal</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TERMINAL_FEATURE_COUNT = SYNTACTIC_NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the
	 * '{@link de.hu_berlin.german.korpling.tiger2.impl.EdgeImpl <em>Edge</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see de.hu_berlin.german.korpling.tiger2.impl.EdgeImpl
	 * @see de.hu_berlin.german.korpling.tiger2.impl.Tiger2PackageImpl#getEdge()
	 * @generated
	 */
	int EDGE = 4;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDGE__ANNOTATIONS = ANNOTATABLE_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDGE__SOURCE = ANNOTATABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDGE__TARGET = ANNOTATABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDGE__GRAPH = ANNOTATABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDGE__ID = ANNOTATABLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDGE__TYPE = ANNOTATABLE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Edge</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDGE_FEATURE_COUNT = ANNOTATABLE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the
	 * '{@link de.hu_berlin.german.korpling.tiger2.impl.SegmentImpl
	 * <em>Segment</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see de.hu_berlin.german.korpling.tiger2.impl.SegmentImpl
	 * @see de.hu_berlin.german.korpling.tiger2.impl.Tiger2PackageImpl#getSegment()
	 * @generated
	 */
	int SEGMENT = 5;

	/**
	 * The feature id for the '<em><b>Graphs</b></em>' containment reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEGMENT__GRAPHS = 0;

	/**
	 * The feature id for the '<em><b>Corpus</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEGMENT__CORPUS = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEGMENT__ID = 2;

	/**
	 * The number of structural features of the '<em>Segment</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEGMENT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the
	 * '{@link de.hu_berlin.german.korpling.tiger2.impl.CorpusImpl
	 * <em>Corpus</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see de.hu_berlin.german.korpling.tiger2.impl.CorpusImpl
	 * @see de.hu_berlin.german.korpling.tiger2.impl.Tiger2PackageImpl#getCorpus()
	 * @generated
	 */
	int CORPUS = 6;

	/**
	 * The feature id for the '<em><b>Segments</b></em>' containment reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CORPUS__SEGMENTS = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CORPUS__ID = 1;

	/**
	 * The feature id for the '<em><b>Sub Corpora</b></em>' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CORPUS__SUB_CORPORA = 2;

	/**
	 * The feature id for the '<em><b>Super Corpus</b></em>' container
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CORPUS__SUPER_CORPUS = 3;

	/**
	 * The feature id for the '<em><b>Meta</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CORPUS__META = 4;

	/**
	 * The feature id for the '<em><b>Features</b></em>' containment reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CORPUS__FEATURES = 5;

	/**
	 * The number of structural features of the '<em>Corpus</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CORPUS_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the
	 * '{@link de.hu_berlin.german.korpling.tiger2.impl.MetaImpl <em>Meta</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see de.hu_berlin.german.korpling.tiger2.impl.MetaImpl
	 * @see de.hu_berlin.german.korpling.tiger2.impl.Tiger2PackageImpl#getMeta()
	 * @generated
	 */
	int META = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int META__ID = 0;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int META__AUTHOR = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int META__NAME = 2;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int META__DATE = 3;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int META__DESCRIPTION = 4;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int META__FORMAT = 5;

	/**
	 * The feature id for the '<em><b>History</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int META__HISTORY = 6;

	/**
	 * The feature id for the '<em><b>Corpus</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int META__CORPUS = 7;

	/**
	 * The number of structural features of the '<em>Meta</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int META_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the
	 * '{@link de.hu_berlin.german.korpling.tiger2.impl.AnnotationImpl
	 * <em>Annotation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see de.hu_berlin.german.korpling.tiger2.impl.AnnotationImpl
	 * @see de.hu_berlin.german.korpling.tiger2.impl.Tiger2PackageImpl#getAnnotation()
	 * @generated
	 */
	int ANNOTATION = 9;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__OWNER = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Feature Ref</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__FEATURE_REF = 2;

	/**
	 * The feature id for the '<em><b>Feature Value Ref</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__FEATURE_VALUE_REF = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__NAME = 4;

	/**
	 * The number of structural features of the '<em>Annotation</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the
	 * '{@link de.hu_berlin.german.korpling.tiger2.impl.FeatureImpl
	 * <em>Feature</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see de.hu_berlin.german.korpling.tiger2.impl.FeatureImpl
	 * @see de.hu_berlin.german.korpling.tiger2.impl.Tiger2PackageImpl#getFeature()
	 * @generated
	 */
	int FEATURE = 10;

	/**
	 * The feature id for the '<em><b>Feature Values</b></em>' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__FEATURE_VALUES = 0;

	/**
	 * The feature id for the '<em><b>Corpus</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__CORPUS = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__ID = 2;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__DOMAIN = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__NAME = 4;

	/**
	 * The feature id for the '<em><b>Dcr Reference</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__DCR_REFERENCE = 5;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE__TYPE = 6;

	/**
	 * The number of structural features of the '<em>Feature</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the
	 * '{@link de.hu_berlin.german.korpling.tiger2.impl.FeatureValueImpl
	 * <em>Feature Value</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see de.hu_berlin.german.korpling.tiger2.impl.FeatureValueImpl
	 * @see de.hu_berlin.german.korpling.tiger2.impl.Tiger2PackageImpl#getFeatureValue()
	 * @generated
	 */
	int FEATURE_VALUE = 11;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_VALUE__FEATURE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_VALUE__ID = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_VALUE__VALUE = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_VALUE__DESCRIPTION = 3;

	/**
	 * The feature id for the '<em><b>Dcr Reference</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_VALUE__DCR_REFERENCE = 4;

	/**
	 * The number of structural features of the '<em>Feature Value</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FEATURE_VALUE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the
	 * '{@link de.hu_berlin.german.korpling.tiger2.DOMAIN <em>DOMAIN</em>}'
	 * enum. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see de.hu_berlin.german.korpling.tiger2.DOMAIN
	 * @see de.hu_berlin.german.korpling.tiger2.impl.Tiger2PackageImpl#getDOMAIN()
	 * @generated
	 */
	int DOMAIN = 12;

	/**
	 * The meta object id for the
	 * '{@link de.hu_berlin.german.korpling.tiger2.DEFAULT_TYPE <em>DEFAULT
	 * TYPE</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see de.hu_berlin.german.korpling.tiger2.DEFAULT_TYPE
	 * @see de.hu_berlin.german.korpling.tiger2.impl.Tiger2PackageImpl#getDEFAULT_TYPE()
	 * @generated
	 */
	int DEFAULT_TYPE = 13;

	/**
	 * The meta object id for the '<em>URI</em>' data type. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see java.net.URI
	 * @see de.hu_berlin.german.korpling.tiger2.impl.Tiger2PackageImpl#getURI()
	 * @generated
	 */
	int URI = 14;

	/**
	 * Returns the meta object for class
	 * '{@link de.hu_berlin.german.korpling.tiger2.Graph <em>Graph</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Graph</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Graph
	 * @generated
	 */
	EClass getGraph();

	/**
	 * Returns the meta object for the containment reference list
	 * '{@link de.hu_berlin.german.korpling.tiger2.Graph#getEdges
	 * <em>Edges</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list
	 *         '<em>Edges</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Graph#getEdges()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_Edges();

	/**
	 * Returns the meta object for the containment reference list
	 * '{@link de.hu_berlin.german.korpling.tiger2.Graph#getSyntacticNodes
	 * <em>Syntactic Nodes</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Syntactic
	 *         Nodes</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Graph#getSyntacticNodes()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_SyntacticNodes();

	/**
	 * Returns the meta object for the reference list
	 * '{@link de.hu_berlin.german.korpling.tiger2.Graph#getNonTerminals <em>Non
	 * Terminals</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Non Terminals</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Graph#getNonTerminals()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_NonTerminals();

	/**
	 * Returns the meta object for the reference list
	 * '{@link de.hu_berlin.german.korpling.tiger2.Graph#getTerminals
	 * <em>Terminals</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Terminals</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Graph#getTerminals()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_Terminals();

	/**
	 * Returns the meta object for the attribute
	 * '{@link de.hu_berlin.german.korpling.tiger2.Graph#getId <em>Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Graph#getId()
	 * @see #getGraph()
	 * @generated
	 */
	EAttribute getGraph_Id();

	/**
	 * Returns the meta object for the container reference
	 * '{@link de.hu_berlin.german.korpling.tiger2.Graph#getSegment
	 * <em>Segment</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Segment</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Graph#getSegment()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_Segment();

	/**
	 * Returns the meta object for class
	 * '{@link de.hu_berlin.german.korpling.tiger2.SyntacticNode <em>Syntactic
	 * Node</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Syntactic Node</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.SyntacticNode
	 * @generated
	 */
	EClass getSyntacticNode();

	/**
	 * Returns the meta object for the container reference
	 * '{@link de.hu_berlin.german.korpling.tiger2.SyntacticNode#getGraph
	 * <em>Graph</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Graph</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.SyntacticNode#getGraph()
	 * @see #getSyntacticNode()
	 * @generated
	 */
	EReference getSyntacticNode_Graph();

	/**
	 * Returns the meta object for the attribute
	 * '{@link de.hu_berlin.german.korpling.tiger2.SyntacticNode#getId
	 * <em>Id</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.SyntacticNode#getId()
	 * @see #getSyntacticNode()
	 * @generated
	 */
	EAttribute getSyntacticNode_Id();

	/**
	 * Returns the meta object for the attribute
	 * '{@link de.hu_berlin.german.korpling.tiger2.SyntacticNode#getType
	 * <em>Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.SyntacticNode#getType()
	 * @see #getSyntacticNode()
	 * @generated
	 */
	EAttribute getSyntacticNode_Type();

	/**
	 * Returns the meta object for class
	 * '{@link de.hu_berlin.german.korpling.tiger2.NonTerminal <em>Non
	 * Terminal</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Non Terminal</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.NonTerminal
	 * @generated
	 */
	EClass getNonTerminal();

	/**
	 * Returns the meta object for class
	 * '{@link de.hu_berlin.german.korpling.tiger2.Terminal <em>Terminal</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Terminal</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Terminal
	 * @generated
	 */
	EClass getTerminal();

	/**
	 * Returns the meta object for the attribute
	 * '{@link de.hu_berlin.german.korpling.tiger2.Terminal#getSource
	 * <em>Source</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Terminal#getSource()
	 * @see #getTerminal()
	 * @generated
	 */
	EAttribute getTerminal_Source();

	/**
	 * Returns the meta object for the attribute
	 * '{@link de.hu_berlin.german.korpling.tiger2.Terminal#getWord
	 * <em>Word</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Word</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Terminal#getWord()
	 * @see #getTerminal()
	 * @generated
	 */
	EAttribute getTerminal_Word();

	/**
	 * Returns the meta object for class
	 * '{@link de.hu_berlin.german.korpling.tiger2.Edge <em>Edge</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Edge</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Edge
	 * @generated
	 */
	EClass getEdge();

	/**
	 * Returns the meta object for the reference
	 * '{@link de.hu_berlin.german.korpling.tiger2.Edge#getSource
	 * <em>Source</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Edge#getSource()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Source();

	/**
	 * Returns the meta object for the reference
	 * '{@link de.hu_berlin.german.korpling.tiger2.Edge#getTarget
	 * <em>Target</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Edge#getTarget()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Target();

	/**
	 * Returns the meta object for the container reference
	 * '{@link de.hu_berlin.german.korpling.tiger2.Edge#getGraph
	 * <em>Graph</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Graph</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Edge#getGraph()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Graph();

	/**
	 * Returns the meta object for the attribute
	 * '{@link de.hu_berlin.german.korpling.tiger2.Edge#getId <em>Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Edge#getId()
	 * @see #getEdge()
	 * @generated
	 */
	EAttribute getEdge_Id();

	/**
	 * Returns the meta object for the attribute
	 * '{@link de.hu_berlin.german.korpling.tiger2.Edge#getType <em>Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Edge#getType()
	 * @see #getEdge()
	 * @generated
	 */
	EAttribute getEdge_Type();

	/**
	 * Returns the meta object for class
	 * '{@link de.hu_berlin.german.korpling.tiger2.Segment <em>Segment</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Segment</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Segment
	 * @generated
	 */
	EClass getSegment();

	/**
	 * Returns the meta object for the containment reference list
	 * '{@link de.hu_berlin.german.korpling.tiger2.Segment#getGraphs
	 * <em>Graphs</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list
	 *         '<em>Graphs</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Segment#getGraphs()
	 * @see #getSegment()
	 * @generated
	 */
	EReference getSegment_Graphs();

	/**
	 * Returns the meta object for the container reference
	 * '{@link de.hu_berlin.german.korpling.tiger2.Segment#getCorpus
	 * <em>Corpus</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Corpus</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Segment#getCorpus()
	 * @see #getSegment()
	 * @generated
	 */
	EReference getSegment_Corpus();

	/**
	 * Returns the meta object for the attribute
	 * '{@link de.hu_berlin.german.korpling.tiger2.Segment#getId <em>Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Segment#getId()
	 * @see #getSegment()
	 * @generated
	 */
	EAttribute getSegment_Id();

	/**
	 * Returns the meta object for class
	 * '{@link de.hu_berlin.german.korpling.tiger2.Corpus <em>Corpus</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Corpus</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Corpus
	 * @generated
	 */
	EClass getCorpus();

	/**
	 * Returns the meta object for the containment reference list
	 * '{@link de.hu_berlin.german.korpling.tiger2.Corpus#getSegments
	 * <em>Segments</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list
	 *         '<em>Segments</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Corpus#getSegments()
	 * @see #getCorpus()
	 * @generated
	 */
	EReference getCorpus_Segments();

	/**
	 * Returns the meta object for the attribute
	 * '{@link de.hu_berlin.german.korpling.tiger2.Corpus#getId <em>Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Corpus#getId()
	 * @see #getCorpus()
	 * @generated
	 */
	EAttribute getCorpus_Id();

	/**
	 * Returns the meta object for the containment reference list
	 * '{@link de.hu_berlin.german.korpling.tiger2.Corpus#getSubCorpora <em>Sub
	 * Corpora</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Sub
	 *         Corpora</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Corpus#getSubCorpora()
	 * @see #getCorpus()
	 * @generated
	 */
	EReference getCorpus_SubCorpora();

	/**
	 * Returns the meta object for the container reference
	 * '{@link de.hu_berlin.german.korpling.tiger2.Corpus#getSuperCorpus
	 * <em>Super Corpus</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Super
	 *         Corpus</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Corpus#getSuperCorpus()
	 * @see #getCorpus()
	 * @generated
	 */
	EReference getCorpus_SuperCorpus();

	/**
	 * Returns the meta object for the containment reference
	 * '{@link de.hu_berlin.german.korpling.tiger2.Corpus#getMeta
	 * <em>Meta</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Meta</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Corpus#getMeta()
	 * @see #getCorpus()
	 * @generated
	 */
	EReference getCorpus_Meta();

	/**
	 * Returns the meta object for the containment reference list
	 * '{@link de.hu_berlin.german.korpling.tiger2.Corpus#getFeatures
	 * <em>Features</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list
	 *         '<em>Features</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Corpus#getFeatures()
	 * @see #getCorpus()
	 * @generated
	 */
	EReference getCorpus_Features();

	/**
	 * Returns the meta object for class
	 * '{@link de.hu_berlin.german.korpling.tiger2.Meta <em>Meta</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Meta</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Meta
	 * @generated
	 */
	EClass getMeta();

	/**
	 * Returns the meta object for the attribute
	 * '{@link de.hu_berlin.german.korpling.tiger2.Meta#getId <em>Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Meta#getId()
	 * @see #getMeta()
	 * @generated
	 */
	EAttribute getMeta_Id();

	/**
	 * Returns the meta object for the attribute
	 * '{@link de.hu_berlin.german.korpling.tiger2.Meta#getAuthor
	 * <em>Author</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Author</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Meta#getAuthor()
	 * @see #getMeta()
	 * @generated
	 */
	EAttribute getMeta_Author();

	/**
	 * Returns the meta object for the attribute
	 * '{@link de.hu_berlin.german.korpling.tiger2.Meta#getName <em>Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Meta#getName()
	 * @see #getMeta()
	 * @generated
	 */
	EAttribute getMeta_Name();

	/**
	 * Returns the meta object for the attribute
	 * '{@link de.hu_berlin.german.korpling.tiger2.Meta#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Meta#getDate()
	 * @see #getMeta()
	 * @generated
	 */
	EAttribute getMeta_Date();

	/**
	 * Returns the meta object for the attribute
	 * '{@link de.hu_berlin.german.korpling.tiger2.Meta#getDescription
	 * <em>Description</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Meta#getDescription()
	 * @see #getMeta()
	 * @generated
	 */
	EAttribute getMeta_Description();

	/**
	 * Returns the meta object for the attribute
	 * '{@link de.hu_berlin.german.korpling.tiger2.Meta#getFormat
	 * <em>Format</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Format</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Meta#getFormat()
	 * @see #getMeta()
	 * @generated
	 */
	EAttribute getMeta_Format();

	/**
	 * Returns the meta object for the attribute
	 * '{@link de.hu_berlin.german.korpling.tiger2.Meta#getHistory
	 * <em>History</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>History</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Meta#getHistory()
	 * @see #getMeta()
	 * @generated
	 */
	EAttribute getMeta_History();

	/**
	 * Returns the meta object for the container reference
	 * '{@link de.hu_berlin.german.korpling.tiger2.Meta#getCorpus
	 * <em>Corpus</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Corpus</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Meta#getCorpus()
	 * @see #getMeta()
	 * @generated
	 */
	EReference getMeta_Corpus();

	/**
	 * Returns the meta object for class
	 * '{@link de.hu_berlin.german.korpling.tiger2.AnnotatableElement
	 * <em>Annotatable Element</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Annotatable Element</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.AnnotatableElement
	 * @generated
	 */
	EClass getAnnotatableElement();

	/**
	 * Returns the meta object for the reference list
	 * '{@link de.hu_berlin.german.korpling.tiger2.AnnotatableElement#getAnnotations
	 * <em>Annotations</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Annotations</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.AnnotatableElement#getAnnotations()
	 * @see #getAnnotatableElement()
	 * @generated
	 */
	EReference getAnnotatableElement_Annotations();

	/**
	 * Returns the meta object for class
	 * '{@link de.hu_berlin.german.korpling.tiger2.Annotation
	 * <em>Annotation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Annotation</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Annotation
	 * @generated
	 */
	EClass getAnnotation();

	/**
	 * Returns the meta object for the reference
	 * '{@link de.hu_berlin.german.korpling.tiger2.Annotation#getOwner
	 * <em>Owner</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Owner</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Annotation#getOwner()
	 * @see #getAnnotation()
	 * @generated
	 */
	EReference getAnnotation_Owner();

	/**
	 * Returns the meta object for the attribute
	 * '{@link de.hu_berlin.german.korpling.tiger2.Annotation#getValue
	 * <em>Value</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Annotation#getValue()
	 * @see #getAnnotation()
	 * @generated
	 */
	EAttribute getAnnotation_Value();

	/**
	 * Returns the meta object for the reference
	 * '{@link de.hu_berlin.german.korpling.tiger2.Annotation#getFeatureRef
	 * <em>Feature Ref</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Feature Ref</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Annotation#getFeatureRef()
	 * @see #getAnnotation()
	 * @generated
	 */
	EReference getAnnotation_FeatureRef();

	/**
	 * Returns the meta object for the reference
	 * '{@link de.hu_berlin.german.korpling.tiger2.Annotation#getFeatureValueRef
	 * <em>Feature Value Ref</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the reference '<em>Feature Value Ref</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Annotation#getFeatureValueRef()
	 * @see #getAnnotation()
	 * @generated
	 */
	EReference getAnnotation_FeatureValueRef();

	/**
	 * Returns the meta object for the attribute
	 * '{@link de.hu_berlin.german.korpling.tiger2.Annotation#getName
	 * <em>Name</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Annotation#getName()
	 * @see #getAnnotation()
	 * @generated
	 */
	EAttribute getAnnotation_Name();

	/**
	 * Returns the meta object for class
	 * '{@link de.hu_berlin.german.korpling.tiger2.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Feature</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Feature
	 * @generated
	 */
	EClass getFeature();

	/**
	 * Returns the meta object for the containment reference list
	 * '{@link de.hu_berlin.german.korpling.tiger2.Feature#getFeatureValues
	 * <em>Feature Values</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Feature
	 *         Values</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Feature#getFeatureValues()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_FeatureValues();

	/**
	 * Returns the meta object for the container reference
	 * '{@link de.hu_berlin.german.korpling.tiger2.Feature#getCorpus
	 * <em>Corpus</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Corpus</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Feature#getCorpus()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_Corpus();

	/**
	 * Returns the meta object for the attribute
	 * '{@link de.hu_berlin.german.korpling.tiger2.Feature#getId <em>Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Feature#getId()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Id();

	/**
	 * Returns the meta object for the attribute
	 * '{@link de.hu_berlin.german.korpling.tiger2.Feature#getDomain
	 * <em>Domain</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Domain</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Feature#getDomain()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Domain();

	/**
	 * Returns the meta object for the attribute
	 * '{@link de.hu_berlin.german.korpling.tiger2.Feature#getName
	 * <em>Name</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Feature#getName()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Name();

	/**
	 * Returns the meta object for the attribute
	 * '{@link de.hu_berlin.german.korpling.tiger2.Feature#getDcrReference
	 * <em>Dcr Reference</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Dcr Reference</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Feature#getDcrReference()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_DcrReference();

	/**
	 * Returns the meta object for the attribute
	 * '{@link de.hu_berlin.german.korpling.tiger2.Feature#getType
	 * <em>Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.Feature#getType()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Type();

	/**
	 * Returns the meta object for class
	 * '{@link de.hu_berlin.german.korpling.tiger2.FeatureValue <em>Feature
	 * Value</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Feature Value</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.FeatureValue
	 * @generated
	 */
	EClass getFeatureValue();

	/**
	 * Returns the meta object for the container reference
	 * '{@link de.hu_berlin.german.korpling.tiger2.FeatureValue#getFeature
	 * <em>Feature</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Feature</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.FeatureValue#getFeature()
	 * @see #getFeatureValue()
	 * @generated
	 */
	EReference getFeatureValue_Feature();

	/**
	 * Returns the meta object for the attribute
	 * '{@link de.hu_berlin.german.korpling.tiger2.FeatureValue#getId
	 * <em>Id</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.FeatureValue#getId()
	 * @see #getFeatureValue()
	 * @generated
	 */
	EAttribute getFeatureValue_Id();

	/**
	 * Returns the meta object for the attribute
	 * '{@link de.hu_berlin.german.korpling.tiger2.FeatureValue#getValue
	 * <em>Value</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.FeatureValue#getValue()
	 * @see #getFeatureValue()
	 * @generated
	 */
	EAttribute getFeatureValue_Value();

	/**
	 * Returns the meta object for the attribute
	 * '{@link de.hu_berlin.german.korpling.tiger2.FeatureValue#getDescription
	 * <em>Description</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.FeatureValue#getDescription()
	 * @see #getFeatureValue()
	 * @generated
	 */
	EAttribute getFeatureValue_Description();

	/**
	 * Returns the meta object for the attribute
	 * '{@link de.hu_berlin.german.korpling.tiger2.FeatureValue#getDcrReference
	 * <em>Dcr Reference</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Dcr Reference</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.FeatureValue#getDcrReference()
	 * @see #getFeatureValue()
	 * @generated
	 */
	EAttribute getFeatureValue_DcrReference();

	/**
	 * Returns the meta object for enum
	 * '{@link de.hu_berlin.german.korpling.tiger2.DOMAIN <em>DOMAIN</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>DOMAIN</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.DOMAIN
	 * @generated
	 */
	EEnum getDOMAIN();

	/**
	 * Returns the meta object for enum
	 * '{@link de.hu_berlin.german.korpling.tiger2.DEFAULT_TYPE <em>DEFAULT
	 * TYPE</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>DEFAULT TYPE</em>'.
	 * @see de.hu_berlin.german.korpling.tiger2.DEFAULT_TYPE
	 * @generated
	 */
	EEnum getDEFAULT_TYPE();

	/**
	 * Returns the meta object for data type '{@link java.net.URI
	 * <em>URI</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>URI</em>'.
	 * @see java.net.URI
	 * @model instanceClass="java.net.URI"
	 * @generated
	 */
	EDataType getURI();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Tiger2Factory getTiger2Factory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that
	 * represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the
		 * '{@link de.hu_berlin.german.korpling.tiger2.impl.GraphImpl
		 * <em>Graph</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see de.hu_berlin.german.korpling.tiger2.impl.GraphImpl
		 * @see de.hu_berlin.german.korpling.tiger2.impl.Tiger2PackageImpl#getGraph()
		 * @generated
		 */
		EClass GRAPH = eINSTANCE.getGraph();

		/**
		 * The meta object literal for the '<em><b>Edges</b></em>' containment
		 * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GRAPH__EDGES = eINSTANCE.getGraph_Edges();

		/**
		 * The meta object literal for the '<em><b>Syntactic Nodes</b></em>'
		 * containment reference list feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GRAPH__SYNTACTIC_NODES = eINSTANCE.getGraph_SyntacticNodes();

		/**
		 * The meta object literal for the '<em><b>Non Terminals</b></em>'
		 * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GRAPH__NON_TERMINALS = eINSTANCE.getGraph_NonTerminals();

		/**
		 * The meta object literal for the '<em><b>Terminals</b></em>' reference
		 * list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GRAPH__TERMINALS = eINSTANCE.getGraph_Terminals();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute GRAPH__ID = eINSTANCE.getGraph_Id();

		/**
		 * The meta object literal for the '<em><b>Segment</b></em>' container
		 * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GRAPH__SEGMENT = eINSTANCE.getGraph_Segment();

		/**
		 * The meta object literal for the
		 * '{@link de.hu_berlin.german.korpling.tiger2.impl.SyntacticNodeImpl
		 * <em>Syntactic Node</em>}' class. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see de.hu_berlin.german.korpling.tiger2.impl.SyntacticNodeImpl
		 * @see de.hu_berlin.german.korpling.tiger2.impl.Tiger2PackageImpl#getSyntacticNode()
		 * @generated
		 */
		EClass SYNTACTIC_NODE = eINSTANCE.getSyntacticNode();

		/**
		 * The meta object literal for the '<em><b>Graph</b></em>' container
		 * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SYNTACTIC_NODE__GRAPH = eINSTANCE.getSyntacticNode_Graph();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SYNTACTIC_NODE__ID = eINSTANCE.getSyntacticNode_Id();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SYNTACTIC_NODE__TYPE = eINSTANCE.getSyntacticNode_Type();

		/**
		 * The meta object literal for the
		 * '{@link de.hu_berlin.german.korpling.tiger2.impl.NonTerminalImpl
		 * <em>Non Terminal</em>}' class. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see de.hu_berlin.german.korpling.tiger2.impl.NonTerminalImpl
		 * @see de.hu_berlin.german.korpling.tiger2.impl.Tiger2PackageImpl#getNonTerminal()
		 * @generated
		 */
		EClass NON_TERMINAL = eINSTANCE.getNonTerminal();

		/**
		 * The meta object literal for the
		 * '{@link de.hu_berlin.german.korpling.tiger2.impl.TerminalImpl
		 * <em>Terminal</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see de.hu_berlin.german.korpling.tiger2.impl.TerminalImpl
		 * @see de.hu_berlin.german.korpling.tiger2.impl.Tiger2PackageImpl#getTerminal()
		 * @generated
		 */
		EClass TERMINAL = eINSTANCE.getTerminal();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TERMINAL__SOURCE = eINSTANCE.getTerminal_Source();

		/**
		 * The meta object literal for the '<em><b>Word</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TERMINAL__WORD = eINSTANCE.getTerminal_Word();

		/**
		 * The meta object literal for the
		 * '{@link de.hu_berlin.german.korpling.tiger2.impl.EdgeImpl
		 * <em>Edge</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see de.hu_berlin.german.korpling.tiger2.impl.EdgeImpl
		 * @see de.hu_berlin.german.korpling.tiger2.impl.Tiger2PackageImpl#getEdge()
		 * @generated
		 */
		EClass EDGE = eINSTANCE.getEdge();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EDGE__SOURCE = eINSTANCE.getEdge_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EDGE__TARGET = eINSTANCE.getEdge_Target();

		/**
		 * The meta object literal for the '<em><b>Graph</b></em>' container
		 * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EDGE__GRAPH = eINSTANCE.getEdge_Graph();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EDGE__ID = eINSTANCE.getEdge_Id();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EDGE__TYPE = eINSTANCE.getEdge_Type();

		/**
		 * The meta object literal for the
		 * '{@link de.hu_berlin.german.korpling.tiger2.impl.SegmentImpl
		 * <em>Segment</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see de.hu_berlin.german.korpling.tiger2.impl.SegmentImpl
		 * @see de.hu_berlin.german.korpling.tiger2.impl.Tiger2PackageImpl#getSegment()
		 * @generated
		 */
		EClass SEGMENT = eINSTANCE.getSegment();

		/**
		 * The meta object literal for the '<em><b>Graphs</b></em>' containment
		 * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SEGMENT__GRAPHS = eINSTANCE.getSegment_Graphs();

		/**
		 * The meta object literal for the '<em><b>Corpus</b></em>' container
		 * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SEGMENT__CORPUS = eINSTANCE.getSegment_Corpus();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SEGMENT__ID = eINSTANCE.getSegment_Id();

		/**
		 * The meta object literal for the
		 * '{@link de.hu_berlin.german.korpling.tiger2.impl.CorpusImpl
		 * <em>Corpus</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see de.hu_berlin.german.korpling.tiger2.impl.CorpusImpl
		 * @see de.hu_berlin.german.korpling.tiger2.impl.Tiger2PackageImpl#getCorpus()
		 * @generated
		 */
		EClass CORPUS = eINSTANCE.getCorpus();

		/**
		 * The meta object literal for the '<em><b>Segments</b></em>'
		 * containment reference list feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CORPUS__SEGMENTS = eINSTANCE.getCorpus_Segments();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CORPUS__ID = eINSTANCE.getCorpus_Id();

		/**
		 * The meta object literal for the '<em><b>Sub Corpora</b></em>'
		 * containment reference list feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CORPUS__SUB_CORPORA = eINSTANCE.getCorpus_SubCorpora();

		/**
		 * The meta object literal for the '<em><b>Super Corpus</b></em>'
		 * container reference feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CORPUS__SUPER_CORPUS = eINSTANCE.getCorpus_SuperCorpus();

		/**
		 * The meta object literal for the '<em><b>Meta</b></em>' containment
		 * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CORPUS__META = eINSTANCE.getCorpus_Meta();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>'
		 * containment reference list feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CORPUS__FEATURES = eINSTANCE.getCorpus_Features();

		/**
		 * The meta object literal for the
		 * '{@link de.hu_berlin.german.korpling.tiger2.impl.MetaImpl
		 * <em>Meta</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see de.hu_berlin.german.korpling.tiger2.impl.MetaImpl
		 * @see de.hu_berlin.german.korpling.tiger2.impl.Tiger2PackageImpl#getMeta()
		 * @generated
		 */
		EClass META = eINSTANCE.getMeta();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute META__ID = eINSTANCE.getMeta_Id();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute META__AUTHOR = eINSTANCE.getMeta_Author();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute META__NAME = eINSTANCE.getMeta_Name();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute META__DATE = eINSTANCE.getMeta_Date();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>'
		 * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute META__DESCRIPTION = eINSTANCE.getMeta_Description();

		/**
		 * The meta object literal for the '<em><b>Format</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute META__FORMAT = eINSTANCE.getMeta_Format();

		/**
		 * The meta object literal for the '<em><b>History</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute META__HISTORY = eINSTANCE.getMeta_History();

		/**
		 * The meta object literal for the '<em><b>Corpus</b></em>' container
		 * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference META__CORPUS = eINSTANCE.getMeta_Corpus();

		/**
		 * The meta object literal for the
		 * '{@link de.hu_berlin.german.korpling.tiger2.AnnotatableElement
		 * <em>Annotatable Element</em>}' class. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see de.hu_berlin.german.korpling.tiger2.AnnotatableElement
		 * @see de.hu_berlin.german.korpling.tiger2.impl.Tiger2PackageImpl#getAnnotatableElement()
		 * @generated
		 */
		EClass ANNOTATABLE_ELEMENT = eINSTANCE.getAnnotatableElement();

		/**
		 * The meta object literal for the '<em><b>Annotations</b></em>'
		 * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ANNOTATABLE_ELEMENT__ANNOTATIONS = eINSTANCE.getAnnotatableElement_Annotations();

		/**
		 * The meta object literal for the
		 * '{@link de.hu_berlin.german.korpling.tiger2.impl.AnnotationImpl
		 * <em>Annotation</em>}' class. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see de.hu_berlin.german.korpling.tiger2.impl.AnnotationImpl
		 * @see de.hu_berlin.german.korpling.tiger2.impl.Tiger2PackageImpl#getAnnotation()
		 * @generated
		 */
		EClass ANNOTATION = eINSTANCE.getAnnotation();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ANNOTATION__OWNER = eINSTANCE.getAnnotation_Owner();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ANNOTATION__VALUE = eINSTANCE.getAnnotation_Value();

		/**
		 * The meta object literal for the '<em><b>Feature Ref</b></em>'
		 * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ANNOTATION__FEATURE_REF = eINSTANCE.getAnnotation_FeatureRef();

		/**
		 * The meta object literal for the '<em><b>Feature Value Ref</b></em>'
		 * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ANNOTATION__FEATURE_VALUE_REF = eINSTANCE.getAnnotation_FeatureValueRef();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ANNOTATION__NAME = eINSTANCE.getAnnotation_Name();

		/**
		 * The meta object literal for the
		 * '{@link de.hu_berlin.german.korpling.tiger2.impl.FeatureImpl
		 * <em>Feature</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see de.hu_berlin.german.korpling.tiger2.impl.FeatureImpl
		 * @see de.hu_berlin.german.korpling.tiger2.impl.Tiger2PackageImpl#getFeature()
		 * @generated
		 */
		EClass FEATURE = eINSTANCE.getFeature();

		/**
		 * The meta object literal for the '<em><b>Feature Values</b></em>'
		 * containment reference list feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FEATURE__FEATURE_VALUES = eINSTANCE.getFeature_FeatureValues();

		/**
		 * The meta object literal for the '<em><b>Corpus</b></em>' container
		 * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FEATURE__CORPUS = eINSTANCE.getFeature_Corpus();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute FEATURE__ID = eINSTANCE.getFeature_Id();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute FEATURE__DOMAIN = eINSTANCE.getFeature_Domain();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute FEATURE__NAME = eINSTANCE.getFeature_Name();

		/**
		 * The meta object literal for the '<em><b>Dcr Reference</b></em>'
		 * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute FEATURE__DCR_REFERENCE = eINSTANCE.getFeature_DcrReference();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute FEATURE__TYPE = eINSTANCE.getFeature_Type();

		/**
		 * The meta object literal for the
		 * '{@link de.hu_berlin.german.korpling.tiger2.impl.FeatureValueImpl
		 * <em>Feature Value</em>}' class. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see de.hu_berlin.german.korpling.tiger2.impl.FeatureValueImpl
		 * @see de.hu_berlin.german.korpling.tiger2.impl.Tiger2PackageImpl#getFeatureValue()
		 * @generated
		 */
		EClass FEATURE_VALUE = eINSTANCE.getFeatureValue();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' container
		 * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FEATURE_VALUE__FEATURE = eINSTANCE.getFeatureValue_Feature();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute FEATURE_VALUE__ID = eINSTANCE.getFeatureValue_Id();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute FEATURE_VALUE__VALUE = eINSTANCE.getFeatureValue_Value();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>'
		 * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute FEATURE_VALUE__DESCRIPTION = eINSTANCE.getFeatureValue_Description();

		/**
		 * The meta object literal for the '<em><b>Dcr Reference</b></em>'
		 * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute FEATURE_VALUE__DCR_REFERENCE = eINSTANCE.getFeatureValue_DcrReference();

		/**
		 * The meta object literal for the
		 * '{@link de.hu_berlin.german.korpling.tiger2.DOMAIN <em>DOMAIN</em>}'
		 * enum. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see de.hu_berlin.german.korpling.tiger2.DOMAIN
		 * @see de.hu_berlin.german.korpling.tiger2.impl.Tiger2PackageImpl#getDOMAIN()
		 * @generated
		 */
		EEnum DOMAIN = eINSTANCE.getDOMAIN();

		/**
		 * The meta object literal for the
		 * '{@link de.hu_berlin.german.korpling.tiger2.DEFAULT_TYPE <em>DEFAULT
		 * TYPE</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see de.hu_berlin.german.korpling.tiger2.DEFAULT_TYPE
		 * @see de.hu_berlin.german.korpling.tiger2.impl.Tiger2PackageImpl#getDEFAULT_TYPE()
		 * @generated
		 */
		EEnum DEFAULT_TYPE = eINSTANCE.getDEFAULT_TYPE();

		/**
		 * The meta object literal for the '<em>URI</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see java.net.URI
		 * @see de.hu_berlin.german.korpling.tiger2.impl.Tiger2PackageImpl#getURI()
		 * @generated
		 */
		EDataType URI = eINSTANCE.getURI();

	}

} // Tiger2Package
