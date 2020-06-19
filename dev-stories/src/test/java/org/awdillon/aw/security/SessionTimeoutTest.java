package org.awdillon.aw.security;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SessionTimeoutTest {

    @DataProvider
    protected Object[][] getData() {
        return new Object[][] {};
    }

    @BeforeTest
    protected void beforeTest() {

    }

    @AfterTest
    protected void afterTest() {

    }


    @Test(dataProvider = "getData")
    public void testMe() {

    }
}
