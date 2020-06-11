package org.jmresler.aw.stories;

/**
 * 
 * @author johnm
 *
 */
public class LoginStory {

	/**
	 * As an Adventure Works owner
	 * 	- I want access to the application to be secure
	 * 	- The user access should be controlled by one of the 
	 * 	  common standard technologies:
	 * 		- Oauth
	 * 		- Oauth2
	 * 		- JWTS
	 *
	 *	1. When I as a application user land on the home page
	 *		A. The home page should display a login hyperline with the
	 *			text, "Sign In".
	 *		B. When the hyperlink is clicked, the UI should display a
	 *		 	login panel or dialog with the user name and user password
	 *			entries.
	 *		C. After entering the credentials, and the submit button is
	 *			clicked, the user credentials should be sent to the login
	 *			controller
	 *		D. When the controller returns a JWTS token, the UI will then
	 *			navigate to the application landing page
	 *		E. If the controller returns a a no such user message,
	 *			i. The UI should display a no such user message.
	 *			ii. The UI should provide a link to allow the user
	 *				to request a new password
	 *		F. If the controller returns an incorrect login credentials message,
	 *			the UI should indicate the password is incorrect
	 *
	 * 2. When I submit my credentials from the user interface to the middle tier:
	 * 		A. The middle tier should take the userName and lookup the user
	 * 			a. If the user does not exist, the application should return a message indicating
	 * 				the user does not exist
	 * 			b. If the user does exist, the application should compare the passsword parameter
	 * 				with the stored password.
	 * 			c. if the user password matches, a JWTS token should be returned providing
	 * 				all information required
	 * 			d. If the password does not match, an error message should be returned
	 * 				to the UI 
	 * 
	 */
}
