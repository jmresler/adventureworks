package org.jmresler.aw.support;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Supports supressing unwanted output on streams like System.out and System.err
 * in production usage.
 * 
 * @author Elliotte Rusty Harold
 *
 */
public class DevNull extends OutputStream {

	
	/*
	 * 
	 */
	@Override
	public void write(int b) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * 
	 */
	@Override
	public void write(byte[] buffer) throws IOException {}

	/*
	 * 
	 */
	@Override
	public void write(byte[] buf, int offset, int len) throws IOException {}	

}
