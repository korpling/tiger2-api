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
package de.hu_berlin.german.korpling.tiger2.resources.tigerXML;

/**
 * This class defines the vocabulary, used by the TigerXML format. It includes all xml element names and xml attribute names.
 * 
 * @author Florian Zipser
 *
 */
public interface TigerXMLDictionary 
{
	/**
	 * URI of the TigerXML namespace of the schema.
	 */
	public static String NAMESPACE_TIGER="http://www.ims.uni-stuttgart.de/projekte/TIGER/public/";
	/**
	 * location of the xsd to validate a TigerXML file
	 */
	public static String XSD_LOCATION_TIGER=NAMESPACE_TIGER+ "TigerXML.xsd";
	/**
	 * location of the xsd to validate a subcorpus TigerXML file
	 */
	public static String XSD_LOCATION_TIGER_SUBCORPUS=NAMESPACE_TIGER+ "TigerXMLSubcorpus.xsd";
	/**
	 * location of the xsd to validate a header TigerXML file
	 */
	public static String XSD_LOCATION_TIGER_HEADER=NAMESPACE_TIGER+ "TigerXMLHeader.xsd";
	
	/**
	 * Name of the element 'corpus' in the xml serialization of the TigerXML api.
	 * XPath to element in TigerXML: /corpus
	 */
	public static String ELEMENT_CORPUS="corpus";
	/**
	 * Name of the element 'subcorpus' in the xml serialization of the TigerXML api.
	 * XPath to element in TigerXML: /corpus/body/subcorpus
	 */
	public static String ELEMENT_SUB_CORPUS="subcorpus";
	/**
	 * Name of the element 'head' in the xml serialization of the TigerXML api.
	 * XPath to element in TigerXML: /corpus/head
	 */
	public static String ELEMENT_HEAD="head";
	/**
	 * Name of the element 'meta' in the xml serialization of the TigerXML api.
	 * XPath to element in TigerXML: /corpus/head/meta
	 */
	public static String ELEMENT_META="meta";
	/**
	 * Name of the element 'name' in the xml serialization of the TigerXML api.
	 * XPath to element in TigerXML: /corpus/head/meta/name
	 */
	public static String ELEMENT_NAME="name";
	/**
	 * Name of the element 'author' in the xml serialization of the TigerXML api.
	 * XPath to element in TigerXML: /corpus/head/meta/author
	 */
	public static String ELEMENT_AUTHOR="author";
	/**
	 * Name of the element 'date' in the xml serialization of the TigerXML api.
	 * XPath to element in TigerXML: /corpus/head/meta/date
	 */
	public static String ELEMENT_DATE="date";
	/**
	 * Name of the element 'description' in the xml serialization of the TigerXML api.
	 * XPath to element in TigerXML: /corpus/head/meta/description
	 */
	public static String ELEMENT_DESCRIPTION="description";
	/**
	 * Name of the element 'format' in the xml serialization of the TigerXML api.
	 * XPath to element in TigerXML: /corpus/head/meta/format
	 */
	public static String ELEMENT_FORMAT="format";
	/**
	 * Name of the element 'history' in the xml serialization of the TigerXML api.
	 * XPath to element in TigerXML: /corpus/head/meta/history
	 */
	public static String ELEMENT_HISTORY="history";
	
	/**
	 * Name of the element 'annotation' in the xml serialization of the TigerXML api.
	 * XPath to element in TigerXML: /corpus/head/annotation
	 */
	public static String ELEMENT_ANNOTATION="annotation";
	/**
	 * Name of the element 'feature' in the xml serialization of the TigerXML api.
	 * XPath to element in TigerXML: /corpus/head/annotation/feature
	 */
	public static String ELEMENT_FEATURE="feature";
	/**
	 * Name of the element {@value TigerXMLDictionary#ELEMENT_EDGELABEL} in the xml serialization of the TigerXML api.
	 * XPath to element in TigerXML: /corpus/head/annotation/feature/edgelabel
	 */
	public static String ELEMENT_EDGELABEL="edgelabel";
	/**
	 * Name of the element '{@value TigerXMLDictionary#ELEMENT_SECEDGELABEL}' in the xml serialization of the TigerXML api.
	 * XPath to element in TigerXML: /corpus/head/annotation/secedgelabel
	 */
	public static String ELEMENT_SECEDGELABEL="secedgelabel";
	/**
	 * Name of the attribute 'name' in the xml serialization of the TigerXML api.
	 * XPath to element in TigerXML: 
	 * /corpus/head/annotation/feature/@name
	 * /corpus/head/annotation/feature/value/@name
	 */
	public static String ATTRIBUTE_NAME="name";
	/**
	 * Name of the attribute 'domain' in the xml serialization of the TigerXML api.
	 * XPath to element in TigerXML: /corpus/head/annotation/feature/@domain
	 */
	public static String ATTRIBUTE_DOMAIN="domain";
	/**
	 * Name of the element 'value' in the xml serialization of the TigerXML api.
	 * XPath to element in TigerXML: /corpus/head/annotation/feature/value
	 */
	public static String ELEMENT_VALUE="value";
	
	/**
	 * Name of the element 'body' in the xml serialization of the TigerXML api.
	 * XPath to element in TigerXML: /corpus/body
	 */
	public static String ELEMENT_BODY="body";
	/**
	 * Name of the element 's' in the xml serialization of the TigerXML api.
	 * XPath to element in TigerXML: /corpus/body/s
	 */
	public static String ELEMENT_SEGMENT="s";
	/**
	 * Name of the attribute 'xml:id' in the xml serialization of the TigerXML api.
	 */
	public static String ATTRIBUTE_ID="id";
	/**
	 * Name of the element 'graph' in the xml serialization of the TigerXML api.
	 * XPath to element in TigerXML: /corpus/body/s/graph
	 */
	public static String ELEMENT_GRAPH="graph";
	/**
	 * Name of the attribute 'root' in the xml serialization of the TigerXML api.
	 * XPath to element in TigerXML: /corpus/body/s/graph/@root
	 */
	public static String ATTRIBUTE_ROOT="root";
	/**
	 * Name of the attribute 'discontinuous' in the xml serialization of the TigerXML api.
	 * XPath to element in TigerXML: /corpus/body/s/graph/@discontinuous
	 */
	public static String ATTRIBUTE_DISCONTINUOUS="discontinuous";
	/**
	 * Name of the element 'terminals' in the xml serialization of the TigerXML api.
	 */
	public static String ELEMENT_TERMINALS="terminals";
	/**
	 * Name of the element 't' in the xml serialization of the TigerXML api.
	 */
	public static String ELEMENT_TERMINAL="t";
	/**
	 * Name of the attribute 'word' in the xml serialization of the TigerXML api. This is not an 
	 * attribute defined in the TigerXML schema, but it is common use to use this attribute to 
	 * store the primary text covered by a terminal.
	 * XPath to element in TigerXML: /corpus/body/s/graph/terminals/t/@word
	 */
	public static String ATTRIBUTE_WORD="word";
	/**
	 * Name of the attribute 'target' in the xml serialization of the TigerXML api.
	 */
	public static String ATTRIBUTE_IDREF="idref";
	
	/**
	 * Name of the element 'nonterminals' in the xml serialization of the TigerXML api.
	 */
	public static String ELEMENT_NONTERMINALS="nonterminals";
	/**
	 * Name of the element 'nt' in the xml serialization of the TigerXML api.
	 */
	public static String ELEMENT_NONTERMINAL="nt";
	/**
	 * Name of the element 'edge' in the xml serialization of the TigerXML api.
	 */
	public static String ELEMENT_EDGE="edge";
	/**
	 * Name of the element 'secedge' in the xml serialization of the TigerXML api.
	 */
	public static String ELEMENT_SECEDGE="secedge";
	
	/**
	 * Name of the attribute 'label' used in the xml serialization of the TigerXML for edge and secedge elements.
	 */
	public static String ATTRIBUTE_LABEL="label";
}
