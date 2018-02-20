package com.mvn.common;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

public class FileUtility {
	
	/**
	 * This method is used to read the content of a given file.
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static String readContentFromFile(File file) throws IOException {

		LineIterator lineIterator = FileUtils.lineIterator(file);
		StringBuilder content = new StringBuilder();
		try {
			while (lineIterator.hasNext()) {
				content.append(lineIterator.next());
				content.append("\n");
			}
		} finally {
			LineIterator.closeQuietly(lineIterator);
		}

		return content.toString();
	}
	
	/**
	 * This method is used to append some prefix at the beginning of the
	 * existing file
	 * 
	 * @param file
	 * @param prefix
	 * @param contentInFile
	 * @throws IOException
	 */
	public static void writeContentToFile(File file, String prefix, String contentInFile) throws IOException {
		PrintWriter printWriter = null;
		try {
			StringBuilder content = new StringBuilder();
			content.append(prefix);
			content.append(contentInFile);
			printWriter = new PrintWriter(file);
			printWriter.print(content.toString());
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
		}
	}
	
	/**
	 * search content for the text
	 * 
	 * @param content
	 * @param textToSearch
	 * @return
	 */
	public static boolean isStringPresent(String content, String textToSearch) {
		return content.replaceAll("\\s+", " ").contains(textToSearch);
	}

	
}
