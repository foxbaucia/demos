=== GETTING STARTED ===
To start the project located in the root directory run
./scripts/start.sh 


=== JAVA BACKEND ===
This project is made with Java as Backend using Spring Boot framework.


=== REACT JS PROYECT ===
The Front End of this project is React app.


=== END POINTS ===

POST: /api/v1/visits/
body: {"url": "http://www.example.com"}

GET : /api/v1/visits/{id}
Obtain the information about a visit.

PUT : /api/v1/visits/{id}
Update a visit
body: {"url": "http://www.example.com",  "ip": "192.1.1.0"}

DELETE : /api/v1/visits/{id}
Remove the information of a visit

GET : /api/v1/domains/?size=1
Obtain the statistics of hits per domain.

=== CACHE ===

The query for obtain the domains stats is cached. The cache has an expiration of 15 seconds.

=== TESTS ===
DomainsTests.java: Test the domains controller

VisitsControllerTests.java: Test the visits controller

UtilsTest.java: Test core functions.


=== STRESS TESTS ===
For Stress Testing, Please check project https://github.com/foxbaucia/demos-stress-test



