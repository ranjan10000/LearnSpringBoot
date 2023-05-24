package com.web.application.filewriteroperation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferReader {

	public static void main(String[] args) throws IOException {
		String location = "UsingBufferWriter.txt";

		FileReader fileReader = new FileReader(location);

		BufferedReader bufferedReader = new BufferedReader(fileReader);

		String currentLine;

		while ((currentLine = bufferedReader.readLine()) != null) {
			System.out.println(currentLine);
		}
	}
}
