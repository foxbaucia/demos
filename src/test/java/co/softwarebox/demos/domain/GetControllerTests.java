package co.softwarebox.demos.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import co.softwarebox.demos.visit.Visit;

/**
 * Basic integration tests for demo application.
 *
 * @author Martin Fox
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GetControllerTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testGetDomain() {
		
		// Create a visit
		Visit v = new Visit();
		String url = "http://www.domains-test.com/foo/bar?param=1";
		v.setUrl(url);

		this.restTemplate.postForEntity("/api/v1/visits/", v, Visit.class);
		this.restTemplate.postForEntity("/api/v1/visits/", v, Visit.class);
		this.restTemplate.postForEntity("/api/v1/visits/", v, Visit.class);
		this.restTemplate.postForEntity("/api/v1/visits/", v, Visit.class);
		ResponseEntity<Visit> postResponse = this.restTemplate.postForEntity("/api/v1/visits/", v, Visit.class);
		
		assertNotNull(postResponse.getBody());

		String domainName = postResponse.getBody().getDomain();
		assertNotNull(domainName);

		ResponseEntity<DomainStatistics[]> getResponse = this.restTemplate.getForEntity("/api/v1/domains/", DomainStatistics[].class);
		assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		
		DomainStatistics[] result = getResponse.getBody();
		assertNotNull(result);
		assertTrue(result.length > 0);
		
		DomainStatistics stat = null;
		for (int i = 0 ; i < result.length ; i++) {
			if (domainName.equals(result[i].getName())) {
				stat = result[i];
				break;
			}
		}
	
		assertNotNull(stat);
		assertNotNull(stat.getHits());
		assertEquals(new Long(5), stat.getHits());
	
	}

	
}