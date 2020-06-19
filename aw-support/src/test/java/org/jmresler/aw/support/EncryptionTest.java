package org.jmresler.aw.support;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.mindrot.jbcrypt.BCrypt;



/**
 * Unit test for simple App.
 */
public class EncryptionTest {
	
	
    /**
     * Checking algorithm in BCrypt for understanding... :-)
     * Expecting it to pass
     */
	@org.junit.Test
    public void testEncryptionService_ExpectPass()
    {
    	String password = "password";
    	String salt = BCrypt.gensalt(10);
    	String encrypted = BCrypt.hashpw(password, salt);
    	boolean equal = BCrypt.checkpw(password, encrypted);
    	assertTrue("Passwords are not equal", equal);
    }
	
	/**
     * Checking algorithm in BCrypt for understanding... :-)
     * Expecting it to fail
	 */
	@org.junit.Test(expected = java.lang.AssertionError.class)
    public void testEncryptionService_ExpectFail()
    {
		String badPassword = "bad-password";
    	String password = "password";
    	String salt = BCrypt.gensalt(10);
    	String encrypted = BCrypt.hashpw(password, salt);
    	boolean equal = BCrypt.checkpw(badPassword, encrypted);
    	assertTrue("Passwords are not equal", equal);
    }	
}
