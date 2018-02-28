package co.softwarebox.demos.domain;

import javax.persistence.Id;

public class DomainStatistics {
	
	@Id
	private String name;
	
	private Long hits;

	public DomainStatistics() {
	}
	
	public DomainStatistics(String name, Long hits) {
		
		this.name = name;
		
		this.hits = hits;
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getHits() {
		return hits;
	}

	public void setHits(Long hits) {
		this.hits = hits;
	}


}
