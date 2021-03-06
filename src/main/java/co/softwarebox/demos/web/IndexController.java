package co.softwarebox.demos.web;

import java.util.Date;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class IndexController {


	private IndexController() {
		
	}

	@RequestMapping("/")
    public ModelAndView home(Model model) {
		model.addAttribute("message", "HowToDoInJava Reader !!");
		String version = "" + (new Date()).getTime();
		
		model.addAttribute("version", version);
		return new ModelAndView("index","WelcomeMessage",model);
    }
	
	@RequestMapping("/next")
    public ModelAndView next(Model model) {
        model.addAttribute("message", "You are in new page !!");
		return new ModelAndView("next","WelcomeMessage",model);
	}


}

