# mavenplugin
This plugin can be run on any project like other maven plugin but first you need to install it on your local m2 repository (mvn clean install).

Please add below dependencies to your project before using it:

<plugin>
  <groupId>addComments.plugin</groupId>
  <artifactId>addComments-maven-plugin</artifactId>
  <version>1.0-SNAPSHOT</version>
  <executions>
    <execution>
      <goals>
        <goal>commentsPlugin</goal>
      </goals>
    </execution>
  </executions>
</plugin>
	  
Use below command to test from command prompt:
mvn addComments.plugin:addComments-maven-plugin:1.0-SNAPSHOT:commentsPlugin 
