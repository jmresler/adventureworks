package org.jmresler.aw.support;

import java.util.Random;

public class RandomStringGenerator {

	private static final int DEFAULT_STRING_LENGTH = 10;
	private static final int MAX_SIZE_STRING = 250;
	private static final char[] LEGAL_CHARS = 
			"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789^!".toCharArray();
	private Random random;

	/**
	 * Creates a RandomStringGenerator with a salt equal to System.currentTimeMillis()
	 */
	public RandomStringGenerator() {
		random = new Random(System.currentTimeMillis());
	}
	

	/**
	 * Creates a RandomStringGenerator 
	 * @param salt the selected salt value
	 */
	public RandomStringGenerator(long salt) {
		random = new Random(salt);
	}
	
	/**
	 * 
	 * @return a randomized String of length 10
	 */
	public String generateRandomString() {
		return generateRandomString(DEFAULT_STRING_LENGTH).toString();
	}
	
	/**
	 * Generates a random string of size 250
	 * @param size (cannot exceeed 250)
	 * @return a randomized String of length = size
	 */
	public String generateRandomString(int size) {
		
		if (size < 0 || size > MAX_SIZE_STRING) 
			throw new IllegalArgumentException("Illegal requested string size... " + size);
		
		StringBuilder buffer = new StringBuilder();
		
		for (int i = 0; i < size; i++)
		{
			int temp = random.nextInt();
			int randIndex = temp < 0 ? temp * -1 % LEGAL_CHARS.length : temp % LEGAL_CHARS.length;
			buffer.append(LEGAL_CHARS[randIndex]);
		}
		
		return buffer.toString();
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		RandomStringGenerator generator = new RandomStringGenerator(System.currentTimeMillis());
		String defaultSizeString = generator.generateRandomString();
		System.out.println("Default size random string : " + defaultSizeString + ", size : " + defaultSizeString.length());
		defaultSizeString = generator.generateRandomString(250);		
		System.out.println(MAX_SIZE_STRING + " size random string : " + defaultSizeString + ", size : " + defaultSizeString.length());	
	}
}
