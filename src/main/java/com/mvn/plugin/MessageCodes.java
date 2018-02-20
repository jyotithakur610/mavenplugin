package com.mvn.plugin;

public class MessageCodes {
	public static final String TEXT_TO_SEARCH = "Hello World";
	public static final String TEXT_TO_APPEND = "/** \nHello World\n**/\n";
	public static final String FILE_EXTENSIONS = "java";
	public static final String SOURCE_FOLDER = "/src/main/java";
	
	public static final String MSG_CONTAINS_TEXT = "File already contains text "+TEXT_TO_SEARCH+". File Name: ";
	public static final String MSG_ADD_COMMENT = TEXT_TO_SEARCH+" needs to be added in comment section. File Name: ";
	
}
