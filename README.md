# Contact Sync
The purpose of this app is to sync contacts between Google Contacts and Notion
## Dependencies
Running this app requires having Java and Maven installed
### MacOS Setup
* Install Java:\
```brew install java```
* Symlink Java:\
```sudo ln -sfn /opt/homebrew/opt/openjdk/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk.jdk```
* Install Maven:\
```brew install maven```
## Compiling and Running

The application expects to find a config file named `config.json` in the project root.\
Create this from the example config file by running:\
```cp config.json.example config.json```

To compile:\
```mvn install```\
To run:\
```java -jar target/gs-maven-0.1.0.jar```