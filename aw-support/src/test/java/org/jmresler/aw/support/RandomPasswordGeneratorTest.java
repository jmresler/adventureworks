package org.jmresler.aw.support;

import static org.junit.Assert.*;

import org.junit.Test;

public class RandomPasswordGeneratorTest {

	@Test
	public void testRandomStringGeneratorLong_ExpectPass() {
		RandomStringGenerator generator = new RandomStringGenerator(10_000L);
		String randomString = generator.generateRandomString();
		assertTrue("String length does not equal 10", randomString.length() == 10);
	}

	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testRandomStringGeneratorLong_ExpectFail() {
		RandomStringGenerator generator = new RandomStringGenerator();
		generator.generateRandomString(Integer.MAX_VALUE);
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testRandomStringGeneratorLong_ExpectFailNegative() {
		RandomStringGenerator generator = new RandomStringGenerator();
		generator.generateRandomString(-1);
	}
	
	@Test
	public void testGenerateRandomStringFixedSize_ExpectPass() {
		RandomStringGenerator generator = new RandomStringGenerator(10_000L);
		String randomString = generator.generateRandomString(100);
		assertTrue("String length does not equal 100", randomString.length() == 100);
	}

	@Test
	public void testGenerateRandomString_ExpectPass() {
		RandomStringGenerator generator = new RandomStringGenerator(10_000L);
		String randomString = generator.generateRandomString(100);
		assertTrue("String length does not equal 100", randomString.length() == 100);
	}

	@Test(expected = java.lang.AssertionError.class)
	public void testGenerateRandomStringDifferentStrings_ExpectFail() {
		RandomStringGenerator generator = new RandomStringGenerator(10_000L);
		String randomString = generator.generateRandomString(100);
		String otherRandomString = generator.generateRandomString(100);
		assertTrue("Two random strings should not equal each other", randomString.equals(otherRandomString));
	}

}
