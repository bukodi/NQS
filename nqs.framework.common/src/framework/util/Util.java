package framework.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class Util {
	
	private Util() {};
	
	/**
	 * * Reads all charaters from the input reader.
	 * 
	 * @param in
	 *            input reader
	 * @return readed string
	 * @throws IOException
	 */
	public final static byte[] readFully(InputStream in) throws IOException {
		byte[] b = new byte[4096];
		byte[] w = new byte[0];
		int i;

		while ((i = in.read(b)) != -1) {
			byte[] s = new byte[w.length + i];

			System.arraycopy(w, 0, s, 0, w.length);
			System.arraycopy(b, 0, s, w.length, i);
			w = s;
		}
		in.close();
		return w;
	}


}
