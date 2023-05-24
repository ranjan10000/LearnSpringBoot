package com.web.application.Methods;

import java.io.File;
import java.io.IOException;

public class CreateNewFile {

	public static void main(String[] args) throws IOException {
		File dir = new File("C:\\Sample_file");
		File file = new File("C:\\Sample_file\\abc.txt");

		if (!file.exists()) {
			dir.mkdir();
			file.createNewFile();
			System.out.println("File,Folder Created.");
		}
	}
}
