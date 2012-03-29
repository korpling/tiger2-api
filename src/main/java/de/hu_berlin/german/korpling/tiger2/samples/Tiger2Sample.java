/**
 * Copyright 2009 Humboldt University of Berlin, INRIA.
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
package de.hu_berlin.german.korpling.tiger2.samples;

import java.net.URI;

import de.hu_berlin.german.korpling.tiger2.Annotation;
import de.hu_berlin.german.korpling.tiger2.Corpus;
import de.hu_berlin.german.korpling.tiger2.DOMAIN;
import de.hu_berlin.german.korpling.tiger2.Edge;
import de.hu_berlin.german.korpling.tiger2.Feature;
import de.hu_berlin.german.korpling.tiger2.FeatureValue;
import de.hu_berlin.german.korpling.tiger2.Graph;
import de.hu_berlin.german.korpling.tiger2.NonTerminal;
import de.hu_berlin.german.korpling.tiger2.Segment;
import de.hu_berlin.german.korpling.tiger2.Terminal;
import de.hu_berlin.german.korpling.tiger2.Tiger2Factory;

public class Tiger2Sample 
{
	/**
	 * Checks the mapping of a corpus given in <tiger2/> model to a given Salt model.
	 * Containing one {@link Segment}, containing one {@link Graph}, containing {@link Terminal} objects, {@link NonTerminal} objects,
	 * {@link Edge} objects between {@link Terminal}s (anaphoric) and between {@link NonTerminal}s and {@link Terminal}s (prim).
	 */
	public static Corpus createSampleCorpus1()
	{
		Corpus corpus= Tiger2Factory.eINSTANCE.createCorpus();
		corpus.setMeta(Tiger2Factory.eINSTANCE.createMeta());
		corpus.getMeta().setName("sampleCorpus1");
		corpus.getMeta().setAuthor("author1");
		corpus.getMeta().setDate("1 January 2010");
		corpus.getMeta().setDescription("some Description");
		corpus.getMeta().setFormat("format 01");
		corpus.getMeta().setHistory("any history");
		
		Segment segment= Tiger2Factory.eINSTANCE.createSegment();
		corpus.getSegments().add(segment);
		Graph graph= Tiger2Factory.eINSTANCE.createGraph();
		segment.getGraphs().add(graph);
		
		Feature lemmaFeat= Tiger2Factory.eINSTANCE.createFeature();
		lemmaFeat.setName("lemma");
		lemmaFeat.setDomain(DOMAIN.T);
		corpus.getFeatures().add(lemmaFeat);
		
		//start: declaring pos feature values
			Feature posFeat= Tiger2Factory.eINSTANCE.createFeature();
			posFeat.setName("pos");
			posFeat.setDomain(DOMAIN.T);
			corpus.getFeatures().add(posFeat);
			
			FeatureValue pos_Punc= Tiger2Factory.eINSTANCE.createFeatureValue();
			pos_Punc.setValue(".");
			pos_Punc.setDescription("Punctuation");
			pos_Punc.setFeature(posFeat);
			
			FeatureValue pos_JJ= Tiger2Factory.eINSTANCE.createFeatureValue();
			pos_JJ.setValue("JJ");
			pos_JJ.setDescription("Adjective");
			pos_JJ.setFeature(posFeat);
			
			FeatureValue pos_NN= Tiger2Factory.eINSTANCE.createFeatureValue();
			pos_NN.setValue("NN");
			pos_NN.setDescription("Noun, singular or mass");
			pos_NN.setDcrReference(URI.create("http://www.isocat.org/datcat/DC-1230"));
			pos_NN.setFeature(posFeat);
			
			FeatureValue pos_PP= Tiger2Factory.eINSTANCE.createFeatureValue();
			pos_PP.setValue("PP");
			pos_PP.setDescription("Personal pronoun");
			pos_PP.setFeature(posFeat);
			
			FeatureValue pos_RP= Tiger2Factory.eINSTANCE.createFeatureValue();
			pos_RP.setValue("RP");
			pos_RP.setDescription("Particle");
			pos_RP.setFeature(posFeat);
			
			FeatureValue pos_VB= Tiger2Factory.eINSTANCE.createFeatureValue();
			pos_VB.setValue("VB");
			pos_VB.setDescription("Verb, base form");
			pos_VB.setFeature(posFeat);
			
			FeatureValue pos_VBP= Tiger2Factory.eINSTANCE.createFeatureValue();
			pos_VBP.setValue("VBP");
			pos_VBP.setDescription("Verb, non-3rd person singular present");
			pos_VBP.setFeature(posFeat);
		//end: declaring pos feature values
		
		//start: declaring function feature values
			Feature functionFeat= Tiger2Factory.eINSTANCE.createFeature();
			functionFeat.setName("function");
			functionFeat.setDomain(DOMAIN.T);
			functionFeat.setType("PRO");
			corpus.getFeatures().add(functionFeat);
			
			FeatureValue func_SC= Tiger2Factory.eINSTANCE.createFeatureValue();
			func_SC.setValue("SC");
			func_SC.setDescription("Verb, base form");
			func_SC.setFeature(functionFeat);
		//start: declaring function feature values
		
		//start: declaring label on coref edge
			Feature labelFeatCoref= Tiger2Factory.eINSTANCE.createFeature();
			labelFeatCoref.setName("label");
			labelFeatCoref.setDomain(DOMAIN.EDGE);
			labelFeatCoref.setType("coref");
			corpus.getFeatures().add(labelFeatCoref);
			
			FeatureValue labelCoref_ANA= Tiger2Factory.eINSTANCE.createFeatureValue();
			labelCoref_ANA.setValue("anaphoric");
			labelCoref_ANA.setDescription("Anaphoric Link");
			labelCoref_ANA.setFeature(labelFeatCoref);
		//end: declaring label on coref edge
			
		//start: declaring label on prim edge
			Feature labelFeatPrim= Tiger2Factory.eINSTANCE.createFeature();
			labelFeatPrim.setName("label");
			labelFeatPrim.setDomain(DOMAIN.EDGE);
			labelFeatPrim.setType("prim");
			corpus.getFeatures().add(labelFeatPrim);
			
			FeatureValue labelPrim_AT= Tiger2Factory.eINSTANCE.createFeatureValue();
			labelPrim_AT.setValue("AT");
			labelPrim_AT.setDescription("Attribute");
			labelPrim_AT.setFeature(labelFeatPrim);
			
			FeatureValue labelPrim_DO= Tiger2Factory.eINSTANCE.createFeatureValue();
			labelPrim_DO.setValue("DO");
			labelPrim_DO.setDescription("Direct Object");
			labelPrim_DO.setFeature(labelFeatPrim);
			
			FeatureValue labelPrim_HD= Tiger2Factory.eINSTANCE.createFeatureValue();
			labelPrim_HD.setValue("HD");
			labelPrim_HD.setDescription("Head");
			labelPrim_HD.setFeature(labelFeatPrim);
			
			FeatureValue labelPrim_IO= Tiger2Factory.eINSTANCE.createFeatureValue();
			labelPrim_IO.setValue("IO");
			labelPrim_IO.setDescription("Infinitive");
			labelPrim_IO.setFeature(labelFeatPrim);
			
			FeatureValue labelPrim_SB= Tiger2Factory.eINSTANCE.createFeatureValue();
			labelPrim_SB.setValue("SB");
			labelPrim_SB.setDescription("Subject");
			labelPrim_SB.setFeature(labelFeatPrim);
		//end: declaring label on prim edge
			
		//start: declaring cat feature values
			Feature catFeat= Tiger2Factory.eINSTANCE.createFeature();
			catFeat.setName("cat");
			catFeat.setDomain(DOMAIN.T);
			corpus.getFeatures().add(catFeat);
			
			FeatureValue cat_NP= Tiger2Factory.eINSTANCE.createFeatureValue();
			cat_NP.setValue("NP");
			cat_NP.setDescription("Nominal Phrase");
			cat_NP.setFeature(catFeat);	
			
			
			FeatureValue cat_S= Tiger2Factory.eINSTANCE.createFeatureValue();
			cat_S.setValue("S");
			cat_S.setDescription("Sentence or Clause");
			cat_S.setFeature(catFeat);
			
			FeatureValue cat_VP= Tiger2Factory.eINSTANCE.createFeatureValue();
			cat_VP.setValue("VP");
			cat_VP.setDescription("Verbal Phrase");
			cat_VP.setFeature(catFeat);
			
			FeatureValue cat_ROOT= Tiger2Factory.eINSTANCE.createFeatureValue();
			cat_ROOT.setValue("ROOT");
			cat_ROOT.setDescription("Graph Root");
			cat_ROOT.setFeature(catFeat);
		//end: declaring cat feature values
			
		Annotation annotation= null;
		//start: token 1
			Terminal t1= Tiger2Factory.eINSTANCE.createTerminal();
			t1.setId("s1_t1");
			t1.setWord("I");
			graph.getSyntacticNodes().add(t1);
			//lemma
			annotation= Tiger2Factory.eINSTANCE.createAnnotation();
			annotation.setFeatureRef(lemmaFeat);
			annotation.setValue("I");
			t1.getAnnotations().add(annotation);
			//pos
			annotation= Tiger2Factory.eINSTANCE.createAnnotation();
			annotation.setFeatureRef(posFeat);
			annotation.setFeatureValueRef(pos_PP);
			t1.getAnnotations().add(annotation);
		//end: token 1
		//start: token 2
			Terminal t2= Tiger2Factory.eINSTANCE.createTerminal();
			t2.setId("s1_t2");
			t2.setWord("wanna");
			graph.getSyntacticNodes().add(t2);
			//lemma
			annotation= Tiger2Factory.eINSTANCE.createAnnotation();
			annotation.setFeatureRef(lemmaFeat);
			annotation.setValue("wanna");
			t2.getAnnotations().add(annotation);
			//pos
			annotation= Tiger2Factory.eINSTANCE.createAnnotation();
			annotation.setFeatureRef(posFeat);
			annotation.setFeatureValueRef(pos_VBP);
			t2.getAnnotations().add(annotation);
		//end: token 2
		//start: token 3
			Terminal t3= Tiger2Factory.eINSTANCE.createTerminal();
			t3.setId("s1_t3");
			t3.setType("PRO");
			graph.getSyntacticNodes().add(t3);
			//function
			annotation= Tiger2Factory.eINSTANCE.createAnnotation();
			annotation.setFeatureRef(functionFeat);
			annotation.setFeatureValueRef(func_SC);
			t3.getAnnotations().add(annotation);
		//end: token 3
		//start: token 4
			Terminal t4= Tiger2Factory.eINSTANCE.createTerminal();
			t4.setId("s1_t4");
			t4.setWord("put");
			graph.getSyntacticNodes().add(t4);
			//lemma
			annotation= Tiger2Factory.eINSTANCE.createAnnotation();
			annotation.setFeatureRef(lemmaFeat);
			annotation.setValue("put");
			t4.getAnnotations().add(annotation);
			//pos
			annotation= Tiger2Factory.eINSTANCE.createAnnotation();
			annotation.setFeatureRef(posFeat);
			annotation.setFeatureValueRef(pos_VB);
			t4.getAnnotations().add(annotation);
		//end: token 4
		//start: token 5
			Terminal t5= Tiger2Factory.eINSTANCE.createTerminal();
			t5.setId("s1_t5");
			graph.getSyntacticNodes().add(t5);
			t5.setWord("up");
			//lemma
			annotation= Tiger2Factory.eINSTANCE.createAnnotation();
			annotation.setFeatureRef(lemmaFeat);
			annotation.setValue("up");
			t5.getAnnotations().add(annotation);
			//pos
			annotation= Tiger2Factory.eINSTANCE.createAnnotation();
			annotation.setFeatureRef(posFeat);
			annotation.setFeatureValueRef(pos_RP);
			t5.getAnnotations().add(annotation);
		//end: token 5
		//start: token 6
			Terminal t6= Tiger2Factory.eINSTANCE.createTerminal();
			t6.setId("s1_t6");
			t6.setWord("new");
			graph.getSyntacticNodes().add(t6);
			//lemma
			annotation= Tiger2Factory.eINSTANCE.createAnnotation();
			annotation.setFeatureRef(lemmaFeat);
			annotation.setValue("new");
			t6.getAnnotations().add(annotation);
			//pos
			annotation= Tiger2Factory.eINSTANCE.createAnnotation();
			annotation.setFeatureRef(posFeat);
			annotation.setFeatureValueRef(pos_JJ);
			t6.getAnnotations().add(annotation);
		//end: token 6
		//start: token 7
			Terminal t7= Tiger2Factory.eINSTANCE.createTerminal();
			t7.setId("s1_t7");
			t7.setWord("wallpaper");
			graph.getSyntacticNodes().add(t7);
			//lemma
			annotation= Tiger2Factory.eINSTANCE.createAnnotation();
			annotation.setFeatureRef(lemmaFeat);
			annotation.setValue("wallpaper");
			t7.getAnnotations().add(annotation);
			//pos
			annotation= Tiger2Factory.eINSTANCE.createAnnotation();
			annotation.setFeatureRef(posFeat);
			annotation.setFeatureValueRef(pos_NN);
			t7.getAnnotations().add(annotation);
		//end: token 7
		//start: token 8
			Terminal t8= Tiger2Factory.eINSTANCE.createTerminal();
			t8.setId("s1_t8");
			t8.setWord(".");
			graph.getSyntacticNodes().add(t8);
			//lemma
			annotation= Tiger2Factory.eINSTANCE.createAnnotation();
			annotation.setFeatureRef(lemmaFeat);
			annotation.setValue(".");
			t8.getAnnotations().add(annotation);
			//pos
			annotation= Tiger2Factory.eINSTANCE.createAnnotation();
			annotation.setFeatureRef(posFeat);
			annotation.setFeatureValueRef(pos_Punc);
			t8.getAnnotations().add(annotation);
		//end: token 8
		
		//non-terminals
			NonTerminal nt1= Tiger2Factory.eINSTANCE.createNonTerminal();
			nt1.setId("s1_nt1");
			annotation= Tiger2Factory.eINSTANCE.createAnnotation();
			annotation.setFeatureRef(catFeat);
			annotation.setFeatureValueRef(cat_NP);
			nt1.getAnnotations().add(annotation);
			graph.getSyntacticNodes().add(nt1);
			
			NonTerminal nt2= Tiger2Factory.eINSTANCE.createNonTerminal();
			nt2.setId("s1_nt2");
			annotation= Tiger2Factory.eINSTANCE.createAnnotation();
			annotation.setFeatureRef(catFeat);
			annotation.setFeatureValueRef(cat_VP);
			nt2.getAnnotations().add(annotation);
			graph.getSyntacticNodes().add(nt2);
			
			NonTerminal nt3= Tiger2Factory.eINSTANCE.createNonTerminal();
			nt3.setId("s1_nt3");
			annotation= Tiger2Factory.eINSTANCE.createAnnotation();
			annotation.setFeatureRef(catFeat);
			annotation.setFeatureValueRef(cat_VP);
			nt3.getAnnotations().add(annotation);
			graph.getSyntacticNodes().add(nt3);
			
			NonTerminal nt4= Tiger2Factory.eINSTANCE.createNonTerminal();
			nt4.setId("s1_nt4");
			annotation= Tiger2Factory.eINSTANCE.createAnnotation();
			annotation.setFeatureRef(catFeat);
			annotation.setFeatureValueRef(cat_NP);
			nt4.getAnnotations().add(annotation);
			graph.getSyntacticNodes().add(nt4);
			
			NonTerminal nt5= Tiger2Factory.eINSTANCE.createNonTerminal();
			nt5.setId("s1_nt5");
			annotation= Tiger2Factory.eINSTANCE.createAnnotation();
			annotation.setFeatureRef(catFeat);
			annotation.setFeatureValueRef(cat_S);
			nt5.getAnnotations().add(annotation);
			graph.getSyntacticNodes().add(nt5);
			
			NonTerminal nt6= Tiger2Factory.eINSTANCE.createNonTerminal();
			nt6.setId("s1_nt6");
			annotation= Tiger2Factory.eINSTANCE.createAnnotation();
			annotation.setFeatureRef(catFeat);
			annotation.setFeatureValueRef(cat_S);
			nt6.getAnnotations().add(annotation);
			graph.getSyntacticNodes().add(nt6);
			
			NonTerminal nt7= Tiger2Factory.eINSTANCE.createNonTerminal();
			nt7.setId("s1_ROOT");
			annotation= Tiger2Factory.eINSTANCE.createAnnotation();
			annotation.setFeatureRef(catFeat);
			annotation.setFeatureValueRef(cat_ROOT);
			nt7.getAnnotations().add(annotation);
			graph.getSyntacticNodes().add(nt7);
		//non-terminals
		
		//edges
			Edge edge1= Tiger2Factory.eINSTANCE.createEdge();
			edge1.setSource(t3);
			edge1.setTarget(t1);
			edge1.setType("coref");
			edge1.setId("edge1");
			annotation= Tiger2Factory.eINSTANCE.createAnnotation();
			annotation.setFeatureRef(labelFeatCoref);
			annotation.setFeatureValueRef(labelCoref_ANA);
			edge1.getAnnotations().add(annotation);
			graph.getEdges().add(edge1);
			
			Edge edge2= Tiger2Factory.eINSTANCE.createEdge();
			edge2.setSource(nt1);
			edge2.setTarget(t1);
			edge2.setType("prim");
			edge2.setId("edge2");
			annotation= Tiger2Factory.eINSTANCE.createAnnotation();
			annotation.setFeatureRef(labelFeatPrim);
			annotation.setFeatureValueRef(labelPrim_HD);
			edge2.getAnnotations().add(annotation);
			graph.getEdges().add(edge2);
			
			Edge edge3= Tiger2Factory.eINSTANCE.createEdge();
			edge3.setSource(nt2);
			edge3.setTarget(t2);
			edge3.setType("prim");
			edge3.setId("edge3");
			annotation= Tiger2Factory.eINSTANCE.createAnnotation();
			annotation.setFeatureRef(labelFeatPrim);
			annotation.setFeatureValueRef(labelPrim_HD);
			edge3.getAnnotations().add(annotation);
			graph.getEdges().add(edge3);
			
			Edge edge4= Tiger2Factory.eINSTANCE.createEdge();
			edge4.setSource(nt2);
			edge4.setTarget(nt5);
			edge4.setType("prim");
			edge4.setId("edge4");
			graph.getEdges().add(edge4);
			
			Edge edge5= Tiger2Factory.eINSTANCE.createEdge();
			edge5.setSource(nt3);
			edge5.setTarget(t4);
			edge5.setType("prim");
			edge5.setId("edge5");
			annotation= Tiger2Factory.eINSTANCE.createAnnotation();
			annotation.setFeatureRef(labelFeatPrim);
			annotation.setFeatureValueRef(labelPrim_HD);
			edge5.getAnnotations().add(annotation);
			graph.getEdges().add(edge5);
			
			Edge edge6= Tiger2Factory.eINSTANCE.createEdge();
			edge6.setSource(nt3);
			edge6.setTarget(t5);
			edge6.setType("prim");
			edge6.setId("edge6");
			graph.getEdges().add(edge6);
			
			Edge edge7= Tiger2Factory.eINSTANCE.createEdge();
			edge7.setSource(nt3);
			edge7.setTarget(nt4);
			edge7.setType("prim");
			edge7.setId("edge7");
			annotation= Tiger2Factory.eINSTANCE.createAnnotation();
			annotation.setFeatureRef(labelFeatPrim);
			annotation.setFeatureValueRef(labelPrim_DO);
			edge7.getAnnotations().add(annotation);
			graph.getEdges().add(edge7);
			
			//start: nt4
				Edge edge8= Tiger2Factory.eINSTANCE.createEdge();
				edge8.setSource(nt4);
				edge8.setTarget(t6);
				edge8.setType("prim");
				edge8.setId("edge8");
				annotation= Tiger2Factory.eINSTANCE.createAnnotation();
				annotation.setFeatureRef(labelFeatPrim);
				annotation.setFeatureValueRef(labelPrim_AT);
				edge8.getAnnotations().add(annotation);
				graph.getEdges().add(edge8);
				
				Edge edge9= Tiger2Factory.eINSTANCE.createEdge();
				edge9.setSource(nt4);
				edge9.setTarget(t7);
				edge9.setType("prim");
				edge9.setId("edge9");
				annotation= Tiger2Factory.eINSTANCE.createAnnotation();
				annotation.setFeatureRef(labelFeatPrim);
				annotation.setFeatureValueRef(labelPrim_HD);
				edge9.getAnnotations().add(annotation);
				graph.getEdges().add(edge9);
			//end: nt4
			
			//start: nt5
				Edge edge10= Tiger2Factory.eINSTANCE.createEdge();
				edge10.setSource(nt5);
				edge10.setTarget(t3);
				edge10.setType("prim");
				edge10.setId("edge10");
				annotation= Tiger2Factory.eINSTANCE.createAnnotation();
				annotation.setFeatureRef(labelFeatPrim);
				annotation.setFeatureValueRef(labelPrim_SB);
				edge10.getAnnotations().add(annotation);
				graph.getEdges().add(edge10);
				
				Edge edge11= Tiger2Factory.eINSTANCE.createEdge();
				edge11.setSource(nt5);
				edge11.setTarget(t1);
				edge11.setType("prim");
				edge11.setId("edge11");
				graph.getEdges().add(edge11);
			//end: nt5
			
			//start: nt6
				Edge edge12= Tiger2Factory.eINSTANCE.createEdge();
				edge12.setSource(nt6);
				edge12.setTarget(t1);
				edge12.setType("prim");
				edge12.setId("edge12");
				annotation= Tiger2Factory.eINSTANCE.createAnnotation();
				annotation.setFeatureRef(labelFeatPrim);
				annotation.setFeatureValueRef(labelPrim_SB);
				edge12.getAnnotations().add(annotation);
				graph.getEdges().add(edge12);
				
				Edge edge13= Tiger2Factory.eINSTANCE.createEdge();
				edge13.setSource(nt6);
				edge13.setTarget(nt2);
				edge13.setType("prim");
				edge13.setId("edge13");
				graph.getEdges().add(edge13);
			//end: nt6
			
			//start: ROOT
				Edge edge14= Tiger2Factory.eINSTANCE.createEdge();
				edge14.setSource(nt7);
				edge14.setTarget(nt1);
				edge14.setType("prim");
				edge14.setId("edge14");
				graph.getEdges().add(edge14);
				
				Edge edge15= Tiger2Factory.eINSTANCE.createEdge();
				edge15.setSource(nt7);
				edge15.setTarget(t8);
				edge15.setType("prim");
				edge15.setId("edge15");
				graph.getEdges().add(edge15);
			//end: ROOT
		//edges
		
		return(corpus);
	}
}
