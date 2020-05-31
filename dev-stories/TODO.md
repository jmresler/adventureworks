# TODO


## Adventure Works Stories




```markdown
 - Migrate Oauth-2.0 source code to aw-security
 	As a developer I want to
 	pull down the aw-security project by itself and work on this isolated code
 	 	
 - Migrate aw-sso to aw-security 
 	As a developer I want to
 	pull down the aw-security project by itself and work on this isolated code

 - Refactor keycloak/JWTS code to packages org.awdillon.spring.security...
 
 -	As a user, I want to login securely to the application
 		The user interface (UI) should validate my credentials upon login
 		Upon submitting the credentials, the UI should indicate a user credentials
 		are invalid under the following circumstances
 		
 			-- If my user name contains any of the following regular expression characters
  				: (<white space> | % | ^ | # | ! | * | () | ` | ~ | $ | + | " | ' | : | ; < | > | ? | | / | , | \)  
 				The UI should reject the login and display a message
 						
 			-- If my user name contains any of the following regular expression characters
 			 	: (<white space> | % | ^ | # | ! | * | () | ` | ~ | $ | + | ; | < | > | ? | | / | , | \)
 				The UI should reject the login and display a message
 				
 		
 		If my user name is not in the keycloak, server the server should 
 		provide a message indicating I am not a registered user.

 		If my user name is not in the HumanResource.AppUser table, the UI should 
 		provide a message indicating I am not a registered user.
```

### Development Tasks


```markdown

A task can be in the following states:

* open
* declined
* done
* deleted (removed from the document)

# TODO - Migrate Oauth-2.0 source code to aw-security
- [open] Migrate Oauth-2.0 source code to aw-security @awdillon@gmail.com

# TODO - Migrate aw-sso to aw-security 
- [open] Migrate aw-sso to aw-security @awdillon@gmail.com

# TODO - Refactor keycloak/JWTS code to packages org.awdillon.spring.security...
- [open] Refactor keycloak/JWTS code to packages org.awdillon.spring.security...


# Integrate JWTS login security into aw-services, end to end
- [open] @johnmresler@gmail.com

# SPIKE - research AspectJ as a mechanism for managing secure access from one library project
          across all micro service project, minimizing the dependencies in other projects.
          For example a project that has exposed services should only require an addition
          like this to the application pom file to enable security
        	
        	<dependency>
        		<groupId>org.awdillon</groupId>
				<artifactId>aw-security</artifactId>
				<version>1.0-SNAPSHOT</version>
        	</dependency>

```
