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
package de.hu_berlin.german.korpling.tiger2.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import de.hu_berlin.german.korpling.tiger2.AnnotatableElement;
import de.hu_berlin.german.korpling.tiger2.Annotation;
import de.hu_berlin.german.korpling.tiger2.Corpus;
import de.hu_berlin.german.korpling.tiger2.Edge;
import de.hu_berlin.german.korpling.tiger2.Feature;
import de.hu_berlin.german.korpling.tiger2.FeatureValue;
import de.hu_berlin.german.korpling.tiger2.Graph;
import de.hu_berlin.german.korpling.tiger2.Meta;
import de.hu_berlin.german.korpling.tiger2.NonTerminal;
import de.hu_berlin.german.korpling.tiger2.Segment;
import de.hu_berlin.german.korpling.tiger2.SyntacticNode;
import de.hu_berlin.german.korpling.tiger2.Terminal;
import de.hu_berlin.german.korpling.tiger2.Tiger2Factory;
import de.hu_berlin.german.korpling.tiger2.Tiger2Package;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class Tiger2PackageImpl extends EPackageImpl implements Tiger2Package {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass graphEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass syntacticNodeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass nonTerminalEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass terminalEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass edgeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass segmentEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass corpusEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass metaEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass annotatableElementEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass annotationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass featureEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass featureValueEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum domainEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum defaulT_TYPEEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType uriEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory
	 * method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.hu_berlin.german.korpling.tiger2.Tiger2Package#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Tiger2PackageImpl() {
		super(eNS_URI, Tiger2Factory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model,
	 * and for any others upon which it depends.
	 * 
	 * <p>
	 * This method is used to initialize {@link Tiger2Package#eINSTANCE} when
	 * that field is accessed. Clients should not invoke it directly. Instead,
	 * they should simply access that field to obtain the package. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Tiger2Package init() {
		if (isInited)
			return (Tiger2Package) EPackage.Registry.INSTANCE.getEPackage(Tiger2Package.eNS_URI);

		// Obtain or create and register package
		Tiger2PackageImpl theTiger2Package = (Tiger2PackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof Tiger2PackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
						: new Tiger2PackageImpl());

		isInited = true;

		// Create package meta-data objects
		theTiger2Package.createPackageContents();

		// Initialize created meta-data
		theTiger2Package.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTiger2Package.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Tiger2Package.eNS_URI, theTiger2Package);
		return theTiger2Package;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getGraph() {
		return graphEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getGraph_Edges() {
		return (EReference) graphEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getGraph_SyntacticNodes() {
		return (EReference) graphEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getGraph_NonTerminals() {
		return (EReference) graphEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getGraph_Terminals() {
		return (EReference) graphEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getGraph_Id() {
		return (EAttribute) graphEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getGraph_Segment() {
		return (EReference) graphEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getSyntacticNode() {
		return syntacticNodeEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getSyntacticNode_Graph() {
		return (EReference) syntacticNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getSyntacticNode_Id() {
		return (EAttribute) syntacticNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getSyntacticNode_Type() {
		return (EAttribute) syntacticNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getNonTerminal() {
		return nonTerminalEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getTerminal() {
		return terminalEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getTerminal_Source() {
		return (EAttribute) terminalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getTerminal_Word() {
		return (EAttribute) terminalEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getEdge() {
		return edgeEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getEdge_Source() {
		return (EReference) edgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getEdge_Target() {
		return (EReference) edgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getEdge_Graph() {
		return (EReference) edgeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getEdge_Id() {
		return (EAttribute) edgeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getEdge_Type() {
		return (EAttribute) edgeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getSegment() {
		return segmentEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getSegment_Graphs() {
		return (EReference) segmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getSegment_Corpus() {
		return (EReference) segmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getSegment_Id() {
		return (EAttribute) segmentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCorpus() {
		return corpusEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCorpus_Segments() {
		return (EReference) corpusEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCorpus_Id() {
		return (EAttribute) corpusEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCorpus_SubCorpora() {
		return (EReference) corpusEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCorpus_SuperCorpus() {
		return (EReference) corpusEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCorpus_Meta() {
		return (EReference) corpusEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCorpus_Features() {
		return (EReference) corpusEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getMeta() {
		return metaEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getMeta_Id() {
		return (EAttribute) metaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getMeta_Author() {
		return (EAttribute) metaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getMeta_Name() {
		return (EAttribute) metaEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getMeta_Date() {
		return (EAttribute) metaEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getMeta_Description() {
		return (EAttribute) metaEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getMeta_Format() {
		return (EAttribute) metaEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getMeta_History() {
		return (EAttribute) metaEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getMeta_Corpus() {
		return (EReference) metaEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getAnnotatableElement() {
		return annotatableElementEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getAnnotatableElement_Annotations() {
		return (EReference) annotatableElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getAnnotation() {
		return annotationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getAnnotation_Owner() {
		return (EReference) annotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getAnnotation_Value() {
		return (EAttribute) annotationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getAnnotation_FeatureRef() {
		return (EReference) annotationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getAnnotation_FeatureValueRef() {
		return (EReference) annotationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getAnnotation_Name() {
		return (EAttribute) annotationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getFeature() {
		return featureEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getFeature_FeatureValues() {
		return (EReference) featureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getFeature_Corpus() {
		return (EReference) featureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getFeature_Id() {
		return (EAttribute) featureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getFeature_Domain() {
		return (EAttribute) featureEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getFeature_Name() {
		return (EAttribute) featureEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getFeature_DcrReference() {
		return (EAttribute) featureEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getFeature_Type() {
		return (EAttribute) featureEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getFeatureValue() {
		return featureValueEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getFeatureValue_Feature() {
		return (EReference) featureValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getFeatureValue_Id() {
		return (EAttribute) featureValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getFeatureValue_Value() {
		return (EAttribute) featureValueEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getFeatureValue_Description() {
		return (EAttribute) featureValueEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getFeatureValue_DcrReference() {
		return (EAttribute) featureValueEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EEnum getDOMAIN() {
		return domainEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EEnum getDEFAULT_TYPE() {
		return defaulT_TYPEEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EDataType getURI() {
		return uriEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Tiger2Factory getTiger2Factory() {
		return (Tiger2Factory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is guarded to
	 * have no affect on any invocation but its first. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		graphEClass = createEClass(GRAPH);
		createEReference(graphEClass, GRAPH__EDGES);
		createEReference(graphEClass, GRAPH__SYNTACTIC_NODES);
		createEReference(graphEClass, GRAPH__NON_TERMINALS);
		createEReference(graphEClass, GRAPH__TERMINALS);
		createEAttribute(graphEClass, GRAPH__ID);
		createEReference(graphEClass, GRAPH__SEGMENT);

		syntacticNodeEClass = createEClass(SYNTACTIC_NODE);
		createEReference(syntacticNodeEClass, SYNTACTIC_NODE__GRAPH);
		createEAttribute(syntacticNodeEClass, SYNTACTIC_NODE__ID);
		createEAttribute(syntacticNodeEClass, SYNTACTIC_NODE__TYPE);

		nonTerminalEClass = createEClass(NON_TERMINAL);

		terminalEClass = createEClass(TERMINAL);
		createEAttribute(terminalEClass, TERMINAL__SOURCE);
		createEAttribute(terminalEClass, TERMINAL__WORD);

		edgeEClass = createEClass(EDGE);
		createEReference(edgeEClass, EDGE__SOURCE);
		createEReference(edgeEClass, EDGE__TARGET);
		createEReference(edgeEClass, EDGE__GRAPH);
		createEAttribute(edgeEClass, EDGE__ID);
		createEAttribute(edgeEClass, EDGE__TYPE);

		segmentEClass = createEClass(SEGMENT);
		createEReference(segmentEClass, SEGMENT__GRAPHS);
		createEReference(segmentEClass, SEGMENT__CORPUS);
		createEAttribute(segmentEClass, SEGMENT__ID);

		corpusEClass = createEClass(CORPUS);
		createEReference(corpusEClass, CORPUS__SEGMENTS);
		createEAttribute(corpusEClass, CORPUS__ID);
		createEReference(corpusEClass, CORPUS__SUB_CORPORA);
		createEReference(corpusEClass, CORPUS__SUPER_CORPUS);
		createEReference(corpusEClass, CORPUS__META);
		createEReference(corpusEClass, CORPUS__FEATURES);

		metaEClass = createEClass(META);
		createEAttribute(metaEClass, META__ID);
		createEAttribute(metaEClass, META__AUTHOR);
		createEAttribute(metaEClass, META__NAME);
		createEAttribute(metaEClass, META__DATE);
		createEAttribute(metaEClass, META__DESCRIPTION);
		createEAttribute(metaEClass, META__FORMAT);
		createEAttribute(metaEClass, META__HISTORY);
		createEReference(metaEClass, META__CORPUS);

		annotatableElementEClass = createEClass(ANNOTATABLE_ELEMENT);
		createEReference(annotatableElementEClass, ANNOTATABLE_ELEMENT__ANNOTATIONS);

		annotationEClass = createEClass(ANNOTATION);
		createEReference(annotationEClass, ANNOTATION__OWNER);
		createEAttribute(annotationEClass, ANNOTATION__VALUE);
		createEReference(annotationEClass, ANNOTATION__FEATURE_REF);
		createEReference(annotationEClass, ANNOTATION__FEATURE_VALUE_REF);
		createEAttribute(annotationEClass, ANNOTATION__NAME);

		featureEClass = createEClass(FEATURE);
		createEReference(featureEClass, FEATURE__FEATURE_VALUES);
		createEReference(featureEClass, FEATURE__CORPUS);
		createEAttribute(featureEClass, FEATURE__ID);
		createEAttribute(featureEClass, FEATURE__DOMAIN);
		createEAttribute(featureEClass, FEATURE__NAME);
		createEAttribute(featureEClass, FEATURE__DCR_REFERENCE);
		createEAttribute(featureEClass, FEATURE__TYPE);

		featureValueEClass = createEClass(FEATURE_VALUE);
		createEReference(featureValueEClass, FEATURE_VALUE__FEATURE);
		createEAttribute(featureValueEClass, FEATURE_VALUE__ID);
		createEAttribute(featureValueEClass, FEATURE_VALUE__VALUE);
		createEAttribute(featureValueEClass, FEATURE_VALUE__DESCRIPTION);
		createEAttribute(featureValueEClass, FEATURE_VALUE__DCR_REFERENCE);

		// Create enums
		domainEEnum = createEEnum(DOMAIN);
		defaulT_TYPEEEnum = createEEnum(DEFAULT_TYPE);

		// Create data types
		uriEDataType = createEDataType(URI);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		syntacticNodeEClass.getESuperTypes().add(this.getAnnotatableElement());
		nonTerminalEClass.getESuperTypes().add(this.getSyntacticNode());
		terminalEClass.getESuperTypes().add(this.getSyntacticNode());
		edgeEClass.getESuperTypes().add(this.getAnnotatableElement());

		// Initialize classes and features; add operations and parameters
		initEClass(graphEClass, Graph.class, "Graph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGraph_Edges(), this.getEdge(), this.getEdge_Graph(), "edges", null, 0, -1, Graph.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraph_SyntacticNodes(), this.getSyntacticNode(), this.getSyntacticNode_Graph(),
				"syntacticNodes", null, 0, -1, Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraph_NonTerminals(), this.getNonTerminal(), null, "nonTerminals", null, 0, -1, Graph.class,
				IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				IS_DERIVED, IS_ORDERED);
		initEReference(getGraph_Terminals(), this.getTerminal(), null, "terminals", null, 0, -1, Graph.class,
				IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				IS_DERIVED, IS_ORDERED);
		initEAttribute(getGraph_Id(), ecorePackage.getEString(), "id", null, 0, 1, Graph.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraph_Segment(), this.getSegment(), this.getSegment_Graphs(), "segment", null, 0, 1,
				Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(graphEClass, this.getEdge(), "getOutgoingEdges", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "nodeId", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(graphEClass, this.getEdge(), "getIncomingEdges", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "nodeId", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(graphEClass, this.getSyntacticNode(), "findNode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "nodeId", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(graphEClass, this.getEdge(), "findEdge", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "edgeId", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(graphEClass, this.getSyntacticNode(), "findRoots", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(graphEClass, this.getSyntacticNode(), "findRoot", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(syntacticNodeEClass, SyntacticNode.class, "SyntacticNode", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSyntacticNode_Graph(), this.getGraph(), this.getGraph_SyntacticNodes(), "graph", null, 0, 1,
				SyntacticNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSyntacticNode_Id(), ecorePackage.getEString(), "id", null, 0, 1, SyntacticNode.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSyntacticNode_Type(), ecorePackage.getEString(), "type", null, 0, 1, SyntacticNode.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nonTerminalEClass, NonTerminal.class, "NonTerminal", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(terminalEClass, Terminal.class, "Terminal", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTerminal_Source(), this.getURI(), "source", null, 0, 1, Terminal.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTerminal_Word(), ecorePackage.getEString(), "word", null, 0, 1, Terminal.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(edgeEClass, Edge.class, "Edge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEdge_Source(), this.getSyntacticNode(), null, "source", null, 0, 1, Edge.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getEdge_Target(), this.getSyntacticNode(), null, "target", null, 0, 1, Edge.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getEdge_Graph(), this.getGraph(), this.getGraph_Edges(), "graph", null, 0, 1, Edge.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEdge_Id(), ecorePackage.getEString(), "id", null, 0, 1, Edge.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEdge_Type(), ecorePackage.getEString(), "type", null, 0, 1, Edge.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(segmentEClass, Segment.class, "Segment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSegment_Graphs(), this.getGraph(), this.getGraph_Segment(), "graphs", null, 0, -1,
				Segment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSegment_Corpus(), this.getCorpus(), this.getCorpus_Segments(), "corpus", null, 0, 1,
				Segment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSegment_Id(), ecorePackage.getEString(), "id", null, 0, 1, Segment.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(corpusEClass, Corpus.class, "Corpus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCorpus_Segments(), this.getSegment(), this.getSegment_Corpus(), "segments", null, 0, -1,
				Corpus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCorpus_Id(), ecorePackage.getEString(), "id", null, 0, 1, Corpus.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCorpus_SubCorpora(), this.getCorpus(), this.getCorpus_SuperCorpus(), "subCorpora", null, 0,
				-1, Corpus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCorpus_SuperCorpus(), this.getCorpus(), this.getCorpus_SubCorpora(), "superCorpus", null, 0,
				1, Corpus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCorpus_Meta(), this.getMeta(), this.getMeta_Corpus(), "meta", null, 0, 1, Corpus.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCorpus_Features(), this.getFeature(), this.getFeature_Corpus(), "features", null, 0, -1,
				Corpus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(corpusEClass, this.getAnnotation(), "createAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDOMAIN(), "domain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(corpusEClass, this.getFeature(), "findFeature", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "featureName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDOMAIN(), "domain", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(corpusEClass, this.getFeatureValue(), "findFeatureValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "featureName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDOMAIN(), "featureDomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "featureValueValue", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(corpusEClass, this.getFeature(), "findFeature", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "featureName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDOMAIN(), "domain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(corpusEClass, this.getAnnotation(), "createAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "featureName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDOMAIN(), "domain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "featureValue", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(corpusEClass, this.getFeatureValue(), "findFeatureValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "featureName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDOMAIN(), "domain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "featureValueValue", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(metaEClass, Meta.class, "Meta", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMeta_Id(), ecorePackage.getEString(), "id", null, 0, 1, Meta.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeta_Author(), ecorePackage.getEString(), "author", null, 0, 1, Meta.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeta_Name(), ecorePackage.getEString(), "name", null, 0, 1, Meta.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeta_Date(), ecorePackage.getEString(), "date", null, 0, 1, Meta.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeta_Description(), ecorePackage.getEString(), "description", null, 0, 1, Meta.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeta_Format(), ecorePackage.getEString(), "format", null, 0, 1, Meta.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeta_History(), ecorePackage.getEString(), "history", null, 0, 1, Meta.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMeta_Corpus(), this.getCorpus(), this.getCorpus_Meta(), "corpus", null, 0, 1, Meta.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(annotatableElementEClass, AnnotatableElement.class, "AnnotatableElement", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnnotatableElement_Annotations(), this.getAnnotation(), this.getAnnotation_Owner(),
				"annotations", null, 0, -1, AnnotatableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(annotatableElementEClass, this.getAnnotation(), "findAnnotation", 0, 1, IS_UNIQUE,
				IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "annotationName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(annotationEClass, Annotation.class, "Annotation", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnnotation_Owner(), this.getAnnotatableElement(), this.getAnnotatableElement_Annotations(),
				"owner", null, 0, 1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnnotation_Value(), ecorePackage.getEString(), "value", null, 0, 1, Annotation.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnnotation_FeatureRef(), this.getFeature(), null, "featureRef", null, 1, 1, Annotation.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnnotation_FeatureValueRef(), this.getFeatureValue(), null, "featureValueRef", null, 0, 1,
				Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnnotation_Name(), ecorePackage.getEString(), "name", null, 0, 1, Annotation.class,
				IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(featureEClass, Feature.class, "Feature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFeature_FeatureValues(), this.getFeatureValue(), this.getFeatureValue_Feature(),
				"featureValues", null, 0, -1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFeature_Corpus(), this.getCorpus(), this.getCorpus_Features(), "corpus", null, 0, 1,
				Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeature_Id(), ecorePackage.getEString(), "id", null, 0, 1, Feature.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeature_Domain(), this.getDOMAIN(), "domain", null, 0, 1, Feature.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeature_Name(), ecorePackage.getEString(), "name", null, 0, 1, Feature.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeature_DcrReference(), this.getURI(), "dcrReference", null, 0, 1, Feature.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeature_Type(), ecorePackage.getEString(), "type", null, 0, 1, Feature.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(featureEClass, this.getFeatureValue(), "findFeatureValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "featureValueValue", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(featureValueEClass, FeatureValue.class, "FeatureValue", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFeatureValue_Feature(), this.getFeature(), this.getFeature_FeatureValues(), "feature", null,
				0, 1, FeatureValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeatureValue_Id(), ecorePackage.getEString(), "id", null, 0, 1, FeatureValue.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeatureValue_Value(), ecorePackage.getEString(), "value", null, 0, 1, FeatureValue.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeatureValue_Description(), ecorePackage.getEString(), "description", null, 0, 1,
				FeatureValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeatureValue_DcrReference(), this.getURI(), "dcrReference", null, 0, 1, FeatureValue.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(domainEEnum, de.hu_berlin.german.korpling.tiger2.DOMAIN.class, "DOMAIN");
		addEEnumLiteral(domainEEnum, de.hu_berlin.german.korpling.tiger2.DOMAIN.T);
		addEEnumLiteral(domainEEnum, de.hu_berlin.german.korpling.tiger2.DOMAIN.NT);
		addEEnumLiteral(domainEEnum, de.hu_berlin.german.korpling.tiger2.DOMAIN.EDGE);

		initEEnum(defaulT_TYPEEEnum, de.hu_berlin.german.korpling.tiger2.DEFAULT_TYPE.class, "DEFAULT_TYPE");
		addEEnumLiteral(defaulT_TYPEEEnum, de.hu_berlin.german.korpling.tiger2.DEFAULT_TYPE.EDGE);
		addEEnumLiteral(defaulT_TYPEEEnum, de.hu_berlin.german.korpling.tiger2.DEFAULT_TYPE.SECEDGE);
		addEEnumLiteral(defaulT_TYPEEEnum, de.hu_berlin.german.korpling.tiger2.DEFAULT_TYPE.PRIM);
		addEEnumLiteral(defaulT_TYPEEEnum, de.hu_berlin.german.korpling.tiger2.DEFAULT_TYPE.LABEL);
		addEEnumLiteral(defaulT_TYPEEEnum, de.hu_berlin.german.korpling.tiger2.DEFAULT_TYPE.SEC);

		// Initialize data types
		initEDataType(uriEDataType, java.net.URI.class, "URI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} // Tiger2PackageImpl
