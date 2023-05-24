package com.web.application.filewriteroperation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UsingPath {
//this also writes byte array
	public static void main(String[] args) throws IOException {
		String location = "UsingPath.txt";
		String content ="FileWritting Using Path";
		
		Path path = Paths.get(location);
		Files.write(path, content.getBytes());
	}
}
