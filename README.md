# tiger2-api

&lt;tiger2/> is a standard conformant XML format modelled to express syntactic structures for a wide variety of theoretical formalisms and corpus architectures. It is closely related to and develops the ideas found in TigerXML: the declared goal of the project is to expand TigerXML only as much as required for the representation of current advanced syntactic resources, without any changes that are not strictly necessary and might increase the learning curve or require substantial alterations to existing tools. The format is similarly conceived as theory neutral, as it is suited to both shallow and deep parsing in any number of theories and supports both pure constituency and dependency trees, as well as combinations of the two. 

<tiger2/>is extensible to any number of new annotation forms for both syntactic nodes and edges through a typing system and gives users the ability to define custom annotations that apply to only certain kinds of nodes and edges.

Further information can be found on http://korpling.german.hu-berlin.de/tiger2.

## Usage

The tiger2-api is mainly developed to be used as an api in other tools, but it also contains a command line user interface to convert data between the TigerXML format and the <tiger2/> format.

### use as a library

The easiest way to include the tiger2-api into your tool is via maven. 

```xml
<dependency>
    <groupId>de.hu_berlin.german.korpling</groupId>
    <artifactId>tiger2-api</artifactId>
    <version>VERSION</version>
<dependency>    
```
The artifact is hosted under the following repository

```xml
<repository>
    <id>korpling</id>
    <name>korpling maven repo</name>
    <url>http://korpling.german.hu-berlin.de/maven2</url>
</repository>
```

### use as command line interface

* First you need to build the tool, therefore it is necessary to have maven on your computer. Open the folder of the tiger2-api and run the following command in a command line.
```
mvn install
```
* After compiling you can now start the tool via
```
bash tiger2converter.sh PARAMETER                  (*nix)
```
or
```
tiger2converter.bat PARAMETER                      (Windows)
```

Where PARAMETER is defined as follows:

```
-i INPUT_FILE -o OUTPUT_FILE [direction]
  INPUT_FILE determines an input file or folder
  OUTPUT_FOLDER determines the output folder
direction:
  -t2_t transforms tigerXML data into <tiger2/> data
  -t_t2 transforms <tiger2/> data into tigerXML data
  -t_t transforms tigerXML data into tigerXML data
  -t2_t2 transforms <tiger2/> data into <tiger2/> data
```

##Contribute

Please help us, to make the api better and give us feedback and send a bug report or a feature request. You can also write a mail to saltnpepper@lists.hu-berlin.de
##License

  Copyright 2009 Humboldt-Universität zu Berlin, INRIA.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
 
  http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.

