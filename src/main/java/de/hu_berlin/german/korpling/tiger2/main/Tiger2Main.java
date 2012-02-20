package de.hu_berlin.german.korpling.tiger2.main;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import de.hu_berlin.german.korpling.tiger2.Corpus;
import de.hu_berlin.german.korpling.tiger2.exceptions.TigerResourceException;
import de.hu_berlin.german.korpling.tiger2.resources.TigerResourceFactory;

public class Tiger2Main {

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
	
	private static Corpus loadTiger2(File tig2File) throws IOException
	{
		System.out.println("resourceSet: "+ resourceSet);
		System.out.println("tig2File: "+ tig2File);
		if(tig2File.toString().endsWith(".tiger2"))
		{
			System.out.println("HERE");
			URI inputURI= URI.createFileURI(tig2File.toString());
			System.out.println("reading uri '"+inputURI+"'... ");
			Resource resource = resourceSet.createResource(inputURI);
			if (resource== null)
				throw new NullPointerException("No resource found for file '"+tig2File.getAbsolutePath()+"'.");
			resource.load(null);
			if (resource.getContents()== null)
				throw new TigerResourceException("Cannot load 'Corpus' object from uri '"+tig2File.getAbsolutePath()+"'.");
			if (resource.getContents().size()== 0)
				throw new TigerResourceException("Cannot load 'Corpus' object from uri '"+tig2File.getAbsolutePath()+"'.");
			Object corpObj=resource.getContents().get(0);
			if (!(corpObj instanceof Corpus))
				throw new TigerResourceException("Cannot load 'Corpus' object from uri '"+tig2File.getAbsolutePath()+"', beacuse the file does not contain a <tiger2/> conform 'Corpus' object.");
			Corpus corpus= (Corpus) corpObj;
			return(corpus);
		}
		return(null);
	}
	
	
	enum PARAMETERS {i, o, t2_t, t_t2, t_t, t2_t2};
	
	
	// create resource set and resource 
	protected static ResourceSet resourceSet = new ResourceSetImpl();
	
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException 
	{
		System.out.println(sayHello());
		
		// Register XML resource factory
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(TigerResourceFactory.FILE_ENDING_TIGER2, new TigerResourceFactory());
		
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
		
		if (convertDirection.equals(PARAMETERS.t2_t))
		{
			// create resource set and resource 
			ResourceSet resourceSet = new ResourceSetImpl();
			// Register XML resource factory
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(TigerResourceFactory.FILE_ENDING_TIGER2, new TigerResourceFactory());
			System.out.println("resourceSet: "+ resourceSet);
			
			if (inputFile.isDirectory())
			{
				if (!outputFolder.exists())
					outputFolder.mkdirs();
				for (File tig2File: inputFile.listFiles())
				{
					if(tig2File.toString().endsWith(".tiger2"))
					{
						URI inputURI= URI.createFileURI(tig2File.toString());
						System.out.println("reading uri '"+inputURI+"'... ");
						Resource resource = resourceSet.createResource(inputURI);
						if (resource== null)
							throw new NullPointerException("No resource found for file '"+tig2File.getAbsolutePath()+"'.");
						resource.load(null);
					}
				}
			}
		}
		else if (convertDirection.equals(PARAMETERS.t2_t2))
		{
			if (inputFile.isDirectory())
			{
				if (!outputFolder.exists())
					outputFolder.mkdirs();
				for (File tig2File: inputFile.listFiles())
				{
					System.out.println("loading model from <tiger2/> file '"+tig2File.getAbsolutePath()+"' ");
					Corpus corpus= loadTiger2(tig2File);
					
					File outputFile= null;
					outputFile= new File(outputFolder.getAbsolutePath()+"/"+tig2File.getName());
					System.out.println("storing model to <tiger2/> file '"+outputFile.getAbsolutePath()+"' ");
					Resource resource = resourceSet.createResource(URI.createURI(outputFile.toURI().toString()));
					resource.getContents().add(corpus);
					resource.save(null);
				}
			}
			else
			{
				System.out.println("loading model from <tiger2/> file '"+inputFile.getAbsolutePath()+"' ");
				Corpus corpus= loadTiger2(inputFile);
				if (corpus== null)
					throw new NullPointerException("Could not map file '"+inputFile.getAbsolutePath()+"' to a <tiger2/> model.");
				
				File outputFile= null;
				outputFile= new File(outputFolder.getAbsolutePath()+"/"+inputFile.getName());
				System.out.println("storing model to <tiger2/> file '"+outputFile.getAbsolutePath()+"' ");
				Resource resource = resourceSet.createResource(URI.createURI(outputFile.toURI().toString()));
				resource.getContents().add(corpus);
				resource.save(null);
			}
		}
		else throw new UnsupportedOperationException("This has not been implemented yet.");

//		
//		if (resource== null)
//			throw new NullPointerException("The resource is null.");
//		resource.load(null);
//		
//		BasicTranscription basicTranscription= (BasicTranscription) resource.getContents().get(0);
//		
//		System.out.println(basicTranscription);
//		
//		Resource resourceOut = resourceSet.createResource(URI.createFileURI(outputFile));
//		resourceOut.getContents().add(basicTranscription);
//		resourceOut.save(null);
		
		System.out.println(sayBye());
	}

}
