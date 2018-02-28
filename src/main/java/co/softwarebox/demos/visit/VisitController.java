package co.softwarebox.demos.visit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.softwarebox.errors.ErrorObject;
import co.softwarebox.utils.Utils;
import javassist.NotFoundException;

@RestController
public class VisitController {


	@Autowired
	private VisitService visitService;

	private VisitController() {
		
	}

	/**
	 * Endpoint for creation of visit.
	 * 
	 * @param visit
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method=RequestMethod.POST, value="/api/v1/visits/")
	public Visit addVisit (@RequestBody Visit visit) throws Exception {
		
		if (visit == null) {
			throw new IllegalArgumentException("The object visit is mandatory");
		}

		if (!Utils.isURL(visit.getUrl())) {
			throw new IllegalArgumentException("The attribute url must be a valid http or https url");
		}
		
		return visitService.addVisit(visit);

	}

	
	/**
	 * End point for retrieve an specific visit.
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method=RequestMethod.GET, value="/api/v1/visits/{id}")
	public Visit getVisit (@PathVariable Long id) throws Exception {
		
		if (id == null || id < 0) {
			throw new IllegalArgumentException("The id is mandatory");
		}

		Visit visit = visitService.getVisit(id);
		
		if (visit == null) {
			throw new NotFoundException("There is no visit with the id: " + id);
		}
		
		return visit;

	}

	/**
	 * Endpoint for update a visit.
	 * 
	 * @param id
	 * @param visit
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method=RequestMethod.PUT, value="/api/v1/visits/{id}")
	public Visit updateVisit (@PathVariable Long id, @RequestBody Visit visit) throws Exception {
		
		if (visit == null) {
			throw new IllegalArgumentException("The object visit is mandatory");
		}

		if (!Utils.isURL(visit.getUrl())) {
			throw new IllegalArgumentException("The attribute url must be a valid http or https url");
		}
		
		return visitService.updateVisit(id, visit);

	}


	/**
	 * Endpoint for remove a visit.
	 * @param id
	 * @throws Exception
	 */
	@RequestMapping(method=RequestMethod.DELETE, value="/api/v1/visits/{id}")
	public void removeVisit (@PathVariable Long id) throws Exception {
		
		if (id == null || id < 0) {
			throw new IllegalArgumentException("The id is mandatory");
		}
		
		visitService.removeVisit(id);

	}
	/**
	 * Handles all exception in this controller and return the appropriate answer. 
	 * @param e
	 * @return
	 */
	@ExceptionHandler
	public ResponseEntity<ErrorObject> exceptionHandler(Exception e) {

		ErrorObject errorObj = new ErrorObject(e);
		
		if (e instanceof NotFoundException) {
			return new ResponseEntity<ErrorObject> (errorObj, HttpStatus.NOT_FOUND);
		} else if (e instanceof IllegalArgumentException) {
			return new ResponseEntity<ErrorObject> (errorObj, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<ErrorObject> (errorObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}

}
