package com.web.application.filewriteroperation;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {

	//straight forward,direct interaction with files,less performance
	
	public static void main(String[] args) throws IOException {
		
		//1.file location 2. content
		
		 String location="UsingFileWriter.txt";
		 String content="Learning Java Is Simple....!";
		 
		 FileWriter fileWriter =  new FileWriter(location);
		 fileWriter.write(content);
		 fileWriter.close();
	}
}
