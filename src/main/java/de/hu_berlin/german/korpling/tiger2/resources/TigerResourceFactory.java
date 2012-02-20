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
package de.hu_berlin.german.korpling.tiger2.resources;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;


public class TigerResourceFactory extends ResourceFactoryImpl 
{
	public static final String FILE_ENDING_TIGER2= "tiger2";
	public static final String FILE_ENDING_TIGERXML= "xml";
	
	public Resource createResource(URI uri)
	{
		Resource resource=null;
		if (FILE_ENDING_TIGER2.equalsIgnoreCase(uri.fileExtension()))
		{
			resource=new Tiger2Resource();
			resource.setURI(uri);
		}
		else if (FILE_ENDING_TIGERXML.equalsIgnoreCase(uri.fileExtension()))
		{
			resource=new TigerXMLResource();
			resource.setURI(uri);
		}
		
		return(resource);
	}
}
