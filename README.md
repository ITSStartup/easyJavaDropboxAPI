####It is an API for use Dropbox feature using [Dropbox API] (https://www.dropbox.com/developers/).  

Dropbox API Documentation 

http://dropbox.github.io/dropbox-sdk-java/api-docs/v1.7.x/


https://www.dropbox.com/developers/

###Before use

1. You only need to generate a token for app. We have developed a web app for this objective, check the following:

###Generate Token Live

http://apps.camilolopes.com.br/dpboxapiweb/

###Setup in your Java Project

####Maven Project
* open pom.xml 
* add the repository below
```java
<repositories>
  <repository>
        <id>easyJavaDropboxAPI</id>
        <url>https://raw.github.com/ITSStartup/easyJavaDropboxAPI/mvn-repo</url>
        <snapshots>
            <enabled>true</enabled>
            <updatePolicy>always</updatePolicy>
        </snapshots>
    </repository>
</repositories>
```

* add the dependency 
```java
<dependencies>
		<dependency>
			<groupId>com.its.api</groupId>
			<artifactId>easyJavaDropboxAPI</artifactId>
			<version>1.0.0</version>
		</dependency>
	</dependencies>
	```
	




fork me!!! 




