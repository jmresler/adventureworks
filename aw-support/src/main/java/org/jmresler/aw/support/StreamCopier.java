package org.jmresler.aw.support;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamCopier {

	
	/**
	 * 
	 * @param in
	 * @param out
	 * @throws IOException
	 */
	public static void copy(InputStream in, OutputStream out) throws IOException {
		synchronized (in) {
			int bytesRead = 0;
			byte[] buffer = new byte[256];
			int eof = -1;
			
			while ((bytesRead = in.read(buffer)) != eof) {
				out.write(buffer, 0, bytesRead);
			}
		}
	}
}
