package co.softwarebox.demos.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.softwarebox.errors.ErrorObject;

@RestController
public class DomainController {


	@Autowired
	private DomainService domainService;

	private DomainController() {
		
	}

	// TODO CrossOrigin is valid for local test. Consider to open it for all the web.
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(method=RequestMethod.GET, value="/api/v1/domains/")
	public List<DomainStatistics> getDomains (@RequestParam(defaultValue = "3", name = "size", required = false) Integer size) throws Exception {
		
		
		return domainService.getDomainStatistics(size);


	}


	@ExceptionHandler
	public ErrorObject exceptionHandler(Exception e) {

		return new ErrorObject(e);
		
	}
}

