package co.softwarebox.demos.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import co.softwarebox.demos.visit.VisitRepository;

@Service
public class DomainService {

	// @Autowired
	// private DomainRepository domainRepository;
	
	@Autowired
	private VisitRepository visitRepository;
	
	
	public List<DomainStatistics> getDomainStatistics(Integer size) {
		
		if (size == null || size < 0) {
			throw new IllegalArgumentException("Size can not be null or 0");
		}
		
		Pageable page = new PageRequest(0, size);

		return visitRepository.findDomainCount(page);
	}

}
