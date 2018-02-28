package co.softwarebox.demos.visit;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Basic integration tests for demo application.
 *
 * @author Martin Fox
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class VisitsControllerTests {

	private static final String API_V1_VISITS_ENDPOINT = "/api/v1/visits/";
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testNewVisit() {
		
		// TEST THE POST
		Visit originalVisit = new Visit();
		String url = "http://www.server.com";
		originalVisit.setUrl(url);

		ResponseEntity<Visit> postResponse = this.restTemplate.postForEntity(API_V1_VISITS_ENDPOINT, originalVisit, Visit.class);
		assertThat(postResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertNotNull(postResponse.getBody());
		assertNotNull(postResponse.getBody().getId());
		assertEquals(url, postResponse.getBody().getUrl());
		assertEquals("server.com", postResponse.getBody().getDomain());
		
		// TEST THE GET
		ResponseEntity<Visit> getResponse = this.restTemplate.getForEntity(API_V1_VISITS_ENDPOINT + postResponse.getBody().getId(), Visit.class);
		assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		Visit visit = getResponse.getBody();
		assertNotNull(visit);
		assertNotNull(visit.getId());
		assertEquals(url, visit.getUrl());
		assertEquals("server.com", visit.getDomain());
	
		
		// TEST EDITION
		String ip = "192.168.0.1";
		visit.setIp(ip);
		this.restTemplate.put(API_V1_VISITS_ENDPOINT + visit.getId(), visit);
		ResponseEntity<Visit> getResponseAfterEdition = this.restTemplate.getForEntity(API_V1_VISITS_ENDPOINT + visit.getId(), Visit.class);
		assertThat(getResponseAfterEdition.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertEquals(ip, getResponseAfterEdition.getBody().getIp());


		this.restTemplate.delete(API_V1_VISITS_ENDPOINT + visit.getId());
		ResponseEntity<Visit> getResponseAfterDelete = this.restTemplate.getForEntity(API_V1_VISITS_ENDPOINT + visit.getId(), Visit.class);
		assertThat(getResponseAfterDelete.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);

		
	}

	@Test
	public void testBadRequest() {
		Visit v = new Visit();
		v.setUrl("server.com");

		ResponseEntity<Visit> entity = this.restTemplate.postForEntity(API_V1_VISITS_ENDPOINT, v, Visit.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);

	}
	
}