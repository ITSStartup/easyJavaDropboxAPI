###It is an API for Dropbox's feature using [Dropbox API] (https://www.dropbox.com/developers/).  

###Dropbox API Documentation 

http://dropbox.github.io/dropbox-sdk-java/api-docs/v1.7.x/


https://www.dropbox.com/developers/

###easyJavaDropboxAPI's features 

* list all files easily **listFiles()**
* change of folder with **changeDropboxPath(String newpath)**
* get all feature dropbox api **getClient()**
* search a file in your dropbox **searchFile(String basePath, String query)**

###Download example with Java Application 

* [easyJavaDropboxAPIExample] (https://github.com/ITSStartup/easyJavaDropboxAPIExample)

###Before use

1. You only need to generate a token for app. We have developed a web app for this objective check the following:

###Generate Token Live

[DropboxAPIWeb - Generate Token](http://apps.camilolopes.com.br/dpboxapiweb/)

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
	
###Download .jar 
* Version 1.0.0 [Click here] (https://github.com/ITSStartup/easyJavaDropboxAPI/blob/mvn-repo/com/its/api/easyJavaDropboxAPI/1.0.0/easyJavaDropboxAPI-1.0.0.jar?raw=true)
* [Others Version] (https://github.com/ITSStartup/easyJavaDropboxAPI/tree/mvn-repo/com/its/api/easyJavaDropboxAPI)


fork me!!! 




