package org.jmresler.spring.aw.services;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginControllerTest {
	
	@Test
	public void testLoginController_expectPass() {
		LoginController controller = mock(LoginController.class);
		when(controller.login("jmresler", "password")).thenReturn("true");
		assertTrue("true".equals(controller.login("jmresler", "password")));
	}
}
