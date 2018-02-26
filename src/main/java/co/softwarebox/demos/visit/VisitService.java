package co.softwarebox.demos.visit;

import java.net.URISyntaxException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.softwarebox.utils.Utils;

@Service
public class VisitService {

	@Autowired
	private VisitRepository visitRepository;
	
	public void addVisit(Visit visit) throws URISyntaxException {
		
		String domain = Utils.getDomainName(visit.getUrl());
		
		visit.setDomain(domain);
		visit.setDate(new Date());
		visitRepository.save(visit);
		
	}


}
