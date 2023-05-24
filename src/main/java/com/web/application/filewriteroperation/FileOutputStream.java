package com.web.application.filewriteroperation;

import java.io.IOException;

public class FileOutputStream {

	// for writing raw byte array information (eg:images)
	public static void main(String[] args) throws IOException {
		String location = "UsingFileOutputStream.txt";
		String content = "for writing raw byte array information";

		java.io.FileOutputStream OutputStream = new java.io.FileOutputStream(location);
		byte[] writeThis = content.getBytes();
		OutputStream.write(writeThis);
		OutputStream.close();

	}
}
