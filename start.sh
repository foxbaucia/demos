
#!/bin/bash
echo ------------
echo BUILD
echo -----------
mvn clean install
echo ------------
echo STARTING APP
echo ------------

java -jar target/course-api-0.0.1-SNAPSHOT.jar
