package com.mvn.common;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.mvn.plugin.MessageCodes;

public class FileUtilityTestCase {

	@Test
	public void testIsStringPresent() {
		List<TestCase> testCases = new ArrayList<TestCase>() {
			private static final long serialVersionUID = 1L;
			{
				add(new TestCase("Hello World, this contains text to be searched", true));
				add(new TestCase("Hello    World, this contains text to be searched with multiple spaces", true));
				add(new TestCase("Hello \n\t World, this contains text to be searched with new line and tab", true));
				add(new TestCase("Hello sometext World, this do not contain text to be searched", false));
				add(new TestCase("", false));
			}
		};

		for (TestCase testCase : testCases) {
			assertEquals(testCase.result, FileUtility.isStringPresent(testCase.content, MessageCodes.TEXT_TO_SEARCH));
		}
	}

	public static class TestCase {
		public String content;
		public boolean result;

		public TestCase(String content, boolean result) {
			this.content = content;
			this.result = result;
		}
	}

}
