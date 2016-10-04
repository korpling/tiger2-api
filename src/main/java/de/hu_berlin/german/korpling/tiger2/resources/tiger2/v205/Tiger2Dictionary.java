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
package de.hu_berlin.german.korpling.tiger2.resources.tiger2.v205;

/**
 * This class defines the vocabulary, used by the TigerXML format. It includes
 * all xml element names and xml attribute names.
 * 
 * @author Florian Zipser
 *
 */
public interface Tiger2Dictionary {
	/**
	 * Name of the version of the here implemented format specification.
	 */
	public static String VERSION_TIGER2 = "2.0.5";

	/**
	 * URI of the &lt;tiger2/&gt; namespace of the schema.
	 */
	public static String NAMESPACE_TIGER2 = "http://korpling.german.hu-berlin.de/tiger2/V" + VERSION_TIGER2 + "/";

	/**
	 * location of the xsd to validate a &lt;tiger2/&gt; file
	 */
	public static String XSD_LOCATION_TIGER2 = NAMESPACE_TIGER2 + "Tiger2.xsd";

	/**
	 * Name of the element 'corpus' in the xml serialization of the
	 * &lt;tiger2/&gt; api.
	 */
	public static String ELEMENT_CORPUS = "corpus";
	/**
	 * Name of the element 'subcorpus' in the xml serialization of the
	 * &lt;tiger2/&gt; api.
	 */
	public static String ELEMENT_SUB_CORPUS = "subcorpus";
	/**
	 * Name of the element 'head' in the xml serialization of the
	 * &lt;tiger2/&gt; api.
	 */
	public static String ELEMENT_HEAD = "head";
	/**
	 * Name of the element 'meta' in the xml serialization of the
	 * &lt;tiger2/&gt; api.
	 */
	public static String ELEMENT_META = "meta";
	/**
	 * Name of the element 'name' in the xml serialization of the
	 * &lt;tiger2/&gt; api.
	 */
	public static String ELEMENT_NAME = "name";
	/**
	 * Name of the element 'author' in the xml serialization of the
	 * &lt;tiger2/&gt; api.
	 */
	public static String ELEMENT_AUTHOR = "author";
	/**
	 * Name of the element 'date' in the xml serialization of the
	 * &lt;tiger2/&gt; api.
	 */
	public static String ELEMENT_DATE = "date";
	/**
	 * Name of the element 'description' in the xml serialization of the
	 * &lt;tiger2/&gt; api.
	 */
	public static String ELEMENT_DESCRIPTION = "description";
	/**
	 * Name of the element 'format' in the xml serialization of the
	 * &lt;tiger2/&gt; api.
	 */
	public static String ELEMENT_FORMAT = "format";
	/**
	 * Name of the element 'history' in the xml serialization of the
	 * &lt;tiger2/&gt; api.
	 */
	public static String ELEMENT_HISTORY = "history";
	/**
	 * Name of the element 'external' to refer to an external meta-annotation
	 * file
	 */
	public static String ELEMENT_EXTERNAL = "external";

	/**
	 * Name of the element 'annotation' in the xml serialization of the
	 * &lt;tiger2/&gt; api.
	 */
	public static String ELEMENT_ANNOTATION = "annotation";
	/**
	 * Name of the element 'feature' in the xml serialization of the
	 * &lt;tiger2/&gt; api.
	 */
	public static String ELEMENT_FEATURE = "feature";
	/**
	 * Name of the attribute 'name' in the xml serialization of the
	 * &lt;tiger2/&gt; api.
	 */
	public static String ATTRIBUTE_NAME = "name";
	/**
	 * Name of the attribute 'domain' in the xml serialization of the
	 * &lt;tiger2/&gt; api.
	 */
	public static String ATTRIBUTE_DOMAIN = "domain";
	/**
	 * Name of the element 'value' in the xml serialization of the
	 * &lt;tiger2/&gt; api.
	 */
	public static String ELEMENT_VALUE = "value";
	/**
	 * Name of the attribute 'datCat' in the xml serialization of the
	 * &lt;tiger2/&gt; api.
	 */
	public static String ATTRIBUTE_DAT_CAT = "datcat";

	/**
	 * Name of the element 'body' in the xml serialization of the
	 * &lt;tiger2/&gt; api.
	 */
	public static String ELEMENT_BODY = "body";
	/**
	 * Name of the element 's' in the xml serialization of the &lt;tiger2/&gt;
	 * api.
	 */
	public static String ELEMENT_SEGMENT = "s";
	/**
	 * Name of the attribute 'xml:id' in the xml serialization of the
	 * &lt;tiger2/&gt; api.
	 */
	public static String ATTRIBUTE_ID = "xml:id";
	/**
	 * Name of the element 'graph' in the xml serialization of the
	 * &lt;tiger2/&gt; api.
	 */
	public static String ELEMENT_GRAPH = "graph";
	/**
	 * Name of the attribute 'root' in the xml serialization of the
	 * &lt;tiger2/&gt; api.
	 */
	public static String ATTRIBUTE_ROOT = "root";
	/**
	 * Name of the attribute 'discontinuous' in the xml serialization of the
	 * &lt;tiger2/&gt; api.
	 */
	public static String ATTRIBUTE_DISCONTINUOUS = "discontinuous";
	/**
	 * Name of the element 'terminals' in the xml serialization of the
	 * &lt;tiger2/&gt; api.
	 */
	public static String ELEMENT_TERMINALS = "terminals";
	/**
	 * Name of the element 't' in the xml serialization of the &lt;tiger2/&gt;
	 * api.
	 */
	public static String ELEMENT_TERMINAL = "t";
	/**
	 * Name of the attribute 'corresp' in the xml serialization of the
	 * &lt;tiger2/&gt; api.
	 */
	public static String ATTRIBUTE_CORRESP = "corresp";
	/**
	 * Name of the attribute 'target' in the xml serialization of the
	 * &lt;tiger2/&gt; api.
	 */
	public static String ATTRIBUTE_TARGET = "target";
	/**
	 * Name of the attribute 'type' in the xml serialization of the
	 * &lt;tiger2/&gt; api.
	 */
	public static String ATTRIBUTE_TYPE = "type";
	/**
	 * Name of the attribute 'word' in the xml serialization of the
	 * &lt;tiger2/&gt; api.
	 */
	public static String ATTRIBUTE_WORD = "word";
	/**
	 * Name of the element 'nonterminals' in the xml serialization of the
	 * &lt;tiger2/&gt; api.
	 */
	public static String ELEMENT_NONTERMINALS = "nonterminals";
	/**
	 * Name of the element 'nt' in the xml serialization of the &lt;tiger2/&gt;
	 * api.
	 */
	public static String ELEMENT_NONTERMINAL = "nt";
	/**
	 * Name of the element 'edge' in the xml serialization of the
	 * &lt;tiger2/&gt; api.
	 */
	public static String ELEMENT_EDGE = "edge";
}
