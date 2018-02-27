package co.softwarebox.demos.visit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.softwarebox.errors.ErrorObject;
import co.softwarebox.utils.Utils;

@RestController
public class VisitController {


	@Autowired
	private VisitService visitService;

	private VisitController() {
		
	}

	@RequestMapping(method=RequestMethod.POST, value="/api/v1/visits/")
	public void addVisit (@RequestBody Visit visit) throws Exception {
		
		if (visit == null) {
			throw new IllegalArgumentException("The object visit is mandatory");
		}

		if (!Utils.isURL(visit.getUrl())) {
			throw new IllegalArgumentException("The attribute url must be a valid http or https url");
		}
		
		visitService.addVisit(visit);


	}

	@ExceptionHandler
	public ErrorObject exceptionHandler(Exception e) {

		return new ErrorObject(e);
		
	}

}
