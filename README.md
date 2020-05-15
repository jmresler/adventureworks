# Adventureworks
Combination of Spring Boot, React and the SQL Server AdventureWorks2017 database (data model)

The parent project is broken down into three seperate child projects,

1. aw-entities
2. aw-services
3. aw-ui
	
	
The projects are all maven based, however the aw-ui does not have the npm plugin setup yet and is not hooked into the aw-services project and so can be run in standalone mode using npm start. This will not however provide any connected functionality with 
aw-services.


The aw-entities project is a JPA project setup to work with the MS SQL Server express edition. The database used is the Adventureworks2017 database. Here are the locations of those resources...

1. MS SQL Server Express - https://www.microsoft.com/en-us/sql-server/sql-server-editions-express
2. SQL Server Management Studio is the tool I use for DB management but you may
   use any tool you choose.
3. The Adventureworks2017 backup (bak) file is located here:
   https://github.com/Microsoft/sql-server-samples/releases/download/adventureworks/AdventureWorks2017.bak


The persistence connectivity is setup to use SQL Server Authentication. Additionally the account that
is used to login must be added to the various schemas used in the database or the connections used by JPA
*will fail*. Simply create a user and add that user to each of the schemas and you will be fine.


The aw-services project is spring based and only partially functional. I recommend strongly using a tool
such as Postman <https://dl.pstmn.io/download/latest/win64> to perform interactions with the REST services
for testing, etc. until the UI is plugged in. 


The aw-ui project was created with Node and the create-react-app tool. Because the application structure
has already been created, you will only require Node to execute the UI. Simply type npm start and the 
application will start and display in your browser. 
- There are prototype components in the aw-ui\src\resources folder which will certainly be moved at a
  minimum or deleted. So don't grow attached to them. Refactoring is our watchword.


The application is intended to be built using Jenkins and I use the 'Blue Ocean' plugin for that tool.
This is what the functionality of the JenkinsFile is for. It is required for Blue Ocean and can be used
in Jenkins on its own also.

# Looking For Contributors	

Feel free to fork the project and meddle with it. Suggest features/changes/functionality completion :-).


  Copyright 2020 ISV
 
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
 
       http://www.apache.org/licenses/LICENSE-2.0
 
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
 


- JMR
