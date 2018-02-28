## Getting Started
To start the project located in the root directory run
./scripts/start.sh 

### User
Use Basic Authorization with this credentials:
demos/password

### Url
localhost:8080/

### END POINTS
**POST:** /api/v1/visits/
body: {"url": "http://www.example.com"}

**GET:** /api/v1/visits/{id}
Obtain the information about a visit.

**PUT:** /api/v1/visits/{id}
Update a visit
body: {"url": "http://www.example.com",  "ip": "192.1.1.0"}

**DELETE:** /api/v1/visits/{id}
Remove the information of a visit

**GET:** /api/v1/domains/?size=1
Obtain the statistics of hits per domain.



# What I'm showing 

## Java Backend
### RESTful API
This is a RESTful API to Create Read Update and Delete VISITS to a server.
And a domains end-point to get statistics.

### Spring Boot.
This project is made with Java as Back-end using Spring Boot framework.

### Cache
The cache has an expiration of 15 seconds. In order to avoid overload of the database, the query for obtain the Domain Statistics is cached. The cache has an expiration of 15 seconds.

See: VisitRepository

### Documentation
All methods and classes are documented.

### JUnit
**DomainsTests.java**: Test the domains controller

**VisitsControllerTests.java**: Test the visits controller

**UtilsTest.java**: Test core functions.

### Multi-threading
Refer to Stress Test project:

***StressTest*** Use of ExecutorService and threads.

***ExpectedResult*** Use of synchronized method.

### Exceptions
***IllegalArgumentException*** Used when the user inputs an invalid argument.

***NotFoundException*** Used when the user try to read an entity that doesn't exist. 
In the API all the exceptions are handled by ExceptionHandler.  
If you want to see try-catch examples please refer to Stress Test project UrlTest and StressTest classes.

### Use of Collections
Refer to Stress Test project class ExpectedResult where I used:

***Hashtable*** for quick access updating a table.

***TreeMap*** to have an ordered List by Hits. 


## Front-End in ReactJS
The Front End of this project is made ReactJS App.
You can see the use of Components
***Layout*** is the main component of the App.
***Credentials*** contains 2 inputs to receive the user and password.
***Filters*** contains components to filter the query.
***List*** renders the table and titles with the obtained data.


###Bootstrap
I used Bootstrap 3 to make a nice presentation. 

## Bash Script
scritps/deploy.sh: Use this script to update the code with the last code in git, compile it and prepare the package.
scritps/start.sh: Use this script to start the server.  

## Security
I used Basic Authentication to control access to the API.


## Indexed Table
The table Visit is indexed by the column DOMAIN as the Statistics by Domain is the most consulted query.

## Stress Test
For Stress Testing, Please check project https://github.com/foxbaucia/demos-stress-test

In this project I simulate requests to the API. 

# Roadmap
For the next release I will continue with:

## Configurations
### Remove all hard-coded configurations.
***Urls***: are all over the code, I need to create good configuration files according each environment Local, Development, QA, Staging, Production

***User/Password***: Make a configuration file with default user and password for testing.

***Stress test***: Make the test configurable

## Data base
Use a MySQL database

## Docker
Implement docker configurations

## AWS
Deploy this code in an AWS server.

## Jenkins
Install a Jenkins server for integration test. 


 


