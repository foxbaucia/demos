package co.softwarebox.demos.visit;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.softwarebox.utils.Utils;

/**
 * Business logic for visit.
 * 
 * @author martinfox
 *
 */
@Service
public class VisitService {

	@Autowired
	private VisitRepository visitRepository;
	
	/**
	 * Crate a new visit in the DB
	 * 
	 * @param visit
	 * @return
	 * @throws URISyntaxException
	 */
	public Visit addVisit(Visit visit) throws URISyntaxException {
		
		String domain = Utils.getDomainName(visit.getUrl());
		
		visit.setDomain(domain);
		visit.setDate(new Date());
		return visitRepository.save(visit);
		
	}

	/**
	 * Find one visit
	 * @param id
	 * @return
	 */
	public Visit getVisit(Long id) {
		
		return visitRepository.findOne(id);
		
	}

	public List<Visit> getAllVisits() {
		
		Iterable<Visit> findAll = visitRepository.findAll();
		List<Visit> result = new ArrayList<Visit>();
		if (findAll == null) {
			return result; 
		}
		for (Visit aVisit : findAll) {
			result.add(aVisit);
		}
		return result;
		
	}
	
	/**
	 * Updates an specific visit.
	 * 
	 * @param id
	 * @param visit
	 * @return
	 */
	public Visit updateVisit(Long id, Visit visit) {
		visit.setId(id);
		return visitRepository.save(visit);
		
	}

	/**
	 * 
	 * Remove an specific visit.
	 * 
	 * @param id
	 */
	public void removeVisit(Long id) {
		
		visitRepository.delete(id);
	
	}


}
