package com.mvn.plugin;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.mvn.common.FileUtility;

public class CommentPluginTestCase {

	@Test
	public void testCheckFileContentAndAddComment() throws IOException {
		File file = File.createTempFile("testfile", ".tmp");
		PrintWriter pw = new PrintWriter(file);
		pw.write("A file with no text_string to be searched, text_string will be added");
		pw.close();
		
		CommentPlugin commentPlugin = new CommentPlugin();
		commentPlugin.checkFileContentAndAddComment(file);
		
		String content = FileUtility.readContentFromFile(file);
		
		assertTrue(FileUtility.isStringPresent(content, MessageCodes.TEXT_TO_SEARCH));
		
		FileUtils.forceDelete(file);
		
	}
	
	@Test
	public void testAddNoCommentIfFileContainTextAlready() throws IOException {
		String fileContent = "A file with text_string Hello World to be searched, text_string will not be added";
		File file = File.createTempFile("testfile", ".tmp");
		PrintWriter pw = new PrintWriter(file);
		pw.write(fileContent);
		pw.close();
		
		CommentPlugin commentPlugin = new CommentPlugin();
		commentPlugin.checkFileContentAndAddComment(file);
		
		String content = FileUtility.readContentFromFile(file);
		
		assertTrue(content.trim().equals(fileContent.trim()));
		
		FileUtils.forceDelete(file);
		
	}
}
