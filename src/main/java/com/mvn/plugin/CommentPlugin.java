package com.mvn.plugin;

import static com.mvn.plugin.MessageCodes.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import static com.mvn.common.FileUtility.*;

/**
 * 
 * @author Jyoti Thakur
 *
 */
@Mojo(name = "commentsPlugin", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class CommentPlugin extends AbstractMojo {

	@Parameter(defaultValue = "${project}")
	private MavenProject project;

	public void execute() throws MojoExecutionException {
		String sourcePath = project.getBasedir().getAbsolutePath().concat(SOURCE_FOLDER);
		File directory = new File(sourcePath);
		String[] extensions = { FILE_EXTENSIONS };
		List<File> files = (List<File>) FileUtils.listFiles(directory, extensions, true);
		for (File file : files) {
			checkFileContentAndAddComment(file);
		}
	}

	/**
	 * 
	 * @param files
	 */
	public void checkFileContentAndAddComment(File file) {
		String content = null;
		try {
			content = readContentFromFile(file);
			if (content != null) {
				if (isStringPresent(content, TEXT_TO_SEARCH)) {
					getLog().info(MSG_CONTAINS_TEXT + file.getName());
				} else {
					getLog().info(MSG_ADD_COMMENT + file.getName());
					writeContentToFile(file, TEXT_TO_APPEND, content);
				}
			}
		} catch (IOException e) {
			getLog().error(e.getMessage() + "File Name:" + file.getName());
		}
	}

}
