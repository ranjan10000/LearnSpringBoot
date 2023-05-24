package com.web.application.filewriteroperation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferWriterExample {
	//Easiest way,performance wise better and widely used
	public static void main(String[] args) throws Exception {
		String location = "UsingBufferWriter.txt";
		String content ="BufferWriter Success....!";
		FileWriter fileWriter = new FileWriter(location);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write(content);
		bufferedWriter.close();
	}

}
