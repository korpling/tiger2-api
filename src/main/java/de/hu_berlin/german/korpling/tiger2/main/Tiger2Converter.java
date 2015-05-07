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
package de.hu_berlin.german.korpling.tiger2.main;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import de.hu_berlin.german.korpling.tiger2.Corpus;
import de.hu_berlin.german.korpling.tiger2.exceptions.TigerException;
import de.hu_berlin.german.korpling.tiger2.exceptions.TigerResourceException;
import de.hu_berlin.german.korpling.tiger2.resources.TigerResourceFactory;

public class Tiger2Converter {

	/**
	 * Resource set to load and store &lt;tiger2&gt; model.
	 */
	private ResourceSet resourceSet = null;
	
	public Tiger2Converter()
	{
		// create resource set and resource 
		resourceSet= new ResourceSetImpl();
		// Register XML resource factory
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(TigerResourceFactory.FILE_ENDING_TIGER2, new TigerResourceFactory());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(TigerResourceFactory.FILE_ENDING_TIGER2_2, new TigerResourceFactory());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(TigerResourceFactory.FILE_ENDING_TIGERXML, new TigerResourceFactory());
	}
	
	
	/**
	 * Reads the data coming from the <code>inputFile</code> into the &lt;tiger2&gt; model and outputs the data
	 * to the given <code>outputFile</code>. If the inputFile is a directory, the contained files will be read recursively, and
	 * the same file structure in output file will be created.
	 * @param inputFile
	 * @param outputFile output folder
	 */
	public void convert(File inputFile, File outputFile, PARAMETERS convertMode)
	{
		if (inputFile== null)
			throw new TigerException("Cannot convert files, because given inputFile is empty.");
		if (outputFile== null)
			throw new TigerException("Cannot convert files, because given inputFile is empty.");
		if (!outputFile.isDirectory())
			throw new TigerException("Cannot convert files, because given outputFile is not a directory.");
		
		this.convertRec(inputFile, outputFile, convertMode);
	}

	/**
	 * Creates the folders in output recursively to mirror the input folder.
	 * @param inputFile
	 * @param outputFile
	 * @param convertMode
	 */
	public void convertRec(File inputFile, File outputFile, PARAMETERS convertMode)
	{
		for (File subInputFile: inputFile.listFiles())
		{
			if (subInputFile.isDirectory())
			{//file is a folder
				File subOutFolder= new File(outputFile.getAbsolutePath()+"/"+ subInputFile.getName());
				subOutFolder.mkdirs();
				convertRec(subInputFile, subOutFolder, convertMode);
			}//file is a folder
			else
			{// file is a file
				convertFiles(subInputFile, outputFile, convertMode);
			}// file is a file
		}
	}
	
	/**
	 * Reads the data coming from the <code>inputFile</code> into the &lt;tiger2&gt; model and outputs the data
	 * to the given <code>outputFile</code>. The given file <code>inputFile</code> must be a file  and not a  directory.
	 * @param inputFile
	 * @param outputFile output folder
	 */
	public void convertFiles(File inputFile, File outputFile, PARAMETERS convertMode)
	{
		if (inputFile== null)
			throw new TigerException("Cannot convert files, because given inputFile is empty.");
		if (outputFile== null)
			throw new TigerException("Cannot convert files, because given inputFile is empty.");
		if (inputFile.isDirectory())
			throw new TigerException("Cannot convert files, because given inputFile is a directory, please call methos convert(..) instead.");
		if (!outputFile.exists())
			outputFile.mkdirs();
		if (!outputFile.isDirectory())
			throw new TigerException("Cannot convert files, because given outputFile is not a directory.");
		
		Corpus corpus= null;
		//start: read model
			try
			{
				URI inputURI= URI.createFileURI(inputFile.toString());
				Resource resourceIn = resourceSet.createResource(inputURI);
				if (resourceIn== null)
					throw new TigerException("No resource found for file '"+inputFile.getAbsolutePath()+"'.");
				resourceIn.load(null);
				if (resourceIn.getContents()== null)
					throw new TigerResourceException("Cannot load 'Corpus' object from uri '"+inputFile.getAbsolutePath()+"'.");
				if (resourceIn.getContents().size()== 0)
					throw new TigerResourceException("Cannot load 'Corpus' object from uri '"+inputFile.getAbsolutePath()+"'.");
				Object corpObj=resourceIn.getContents().get(0);
				if (!(corpObj instanceof Corpus))
					throw new TigerResourceException("Cannot load 'Corpus' object from uri '"+inputFile.getAbsolutePath()+"', beacuse the file does not contain a <tiger2/> conform 'Corpus' object.");
				corpus= (Corpus) corpObj;
			}catch (IOException e) {
				throw new TigerResourceException("Cannot load 'Corpus' object from uri '"+inputFile.getAbsolutePath()+"', beacuse of a nested exception.", e);
			}
			
			try
			{
				URI outputURI= null; 
				if (	(convertMode.equals(PARAMETERS.t_t2)) ||
						(convertMode.equals(PARAMETERS.t2_t2)))
				{
					outputURI= URI.createFileURI(outputFile.getAbsolutePath()+"/"+inputFile.getName()+"."+TigerResourceFactory.FILE_ENDING_TIGER2);
				}
				else if (	(convertMode.equals(PARAMETERS.t_t)) ||
							(convertMode.equals(PARAMETERS.t2_t)))
				{
					outputURI= URI.createFileURI(outputFile.getAbsolutePath()+"/"+inputFile.getName()+"."+TigerResourceFactory.FILE_ENDING_TIGERXML);
				}
				else throw new TigerException("No matching convertMode was given.");
				
				Resource resourceOut = resourceSet.createResource(outputURI);
				if (resourceOut== null)
					throw new TigerException("No resource found for file '"+outputFile.getAbsolutePath()+"'.");
				resourceOut.getContents().add(corpus);
				resourceOut.save(null);
			}catch (IOException e) {
				throw new TigerResourceException("Cannot save 'Corpus' object from uri '"+inputFile.getAbsolutePath()+"', beacuse of a nested exception.", e);
			}
		//end: read model
	}
	
	private static String sayHello()
	{
		StringBuffer buf= new StringBuffer();
		
		buf.append("**********************************************************************************\n");
		buf.append("***                          Welcome to <tiger2/> api                          ***\n");
		buf.append("**********************************************************************************\n");
		
		return(buf.toString());
	}
	
	private static String getHelp()
	{
		StringBuffer buf= new StringBuffer();
		
		buf.append("any help");
		
		return(buf.toString());
	}
	
	private static String sayBye()
	{
		StringBuffer buf= new StringBuffer();
		
		buf.append("**********************************************************************************\n");
		buf.append("***                        good bye from <tiger2/> api                         ***\n");
		buf.append("**********************************************************************************\n");
		
		return(buf.toString());
	}
	
	/**
	 * An enumeration of all parameters , whcih can be passed to the &lt;tiger2&gt; converter.
	 * @author Florian Zipser
	 *
	 */
	enum PARAMETERS {i, o, t2_t, t_t2, t_t, t2_t2};
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException 
	{
		System.out.println(sayHello());
		
		try
		{
			if (	(args== null)||
					(args.length== 0))
				System.out.println(getHelp());
			
			File inputFile= null;
			File outputFolder= null;
			PARAMETERS convertDirection= null;
			
			for (int i = 0; i< args.length; i++)
			{
				if (args[i].equalsIgnoreCase("-"+PARAMETERS.o) )
				{
					outputFolder= new File(args[i+1]);
				}
				else if (args[i].equalsIgnoreCase("-"+PARAMETERS.i) )
				{
					inputFile= new File(args[i+1]);
				}
				else if (args[i].equalsIgnoreCase("-"+PARAMETERS.t2_t) )
					convertDirection= PARAMETERS.t2_t;
				else if (args[i].equalsIgnoreCase("-"+PARAMETERS.t_t2) )
					convertDirection= PARAMETERS.t_t2;
				else if (args[i].equalsIgnoreCase("-"+PARAMETERS.t_t) )
					convertDirection= PARAMETERS.t_t;
				else if (args[i].equalsIgnoreCase("-"+PARAMETERS.t2_t2) )
					convertDirection= PARAMETERS.t2_t2;
			}
			
			if (inputFile== null)
				throw new IOException("No file or folder for tiger2 was given");
			if (outputFolder== null)
				throw new IOException("No file or folder for tigerXML was given");
			if (convertDirection== null)
				throw new NullPointerException("No convert direction is given.");
			
			Tiger2Converter converter= new Tiger2Converter();
			if (inputFile.isDirectory())
			{
				converter.convert(inputFile, outputFolder, convertDirection);
			}
			else 
				converter.convertFiles(inputFile, outputFolder, convertDirection);
		}finally
		{
			System.out.println(sayBye());
		}
	}

}
