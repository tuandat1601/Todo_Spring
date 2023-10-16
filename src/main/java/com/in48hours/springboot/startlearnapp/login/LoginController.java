package com.in48hours.springboot.startlearnapp.login;



import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class LoginController {
	

@RequestMapping( value="/",method=RequestMethod.GET)
public String gotoPage( ModelMap model) {
	model.put("name", getLoggedinUsername());
	return "welcome";
}
private String getLoggedinUsername() {
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	if (!(authentication instanceof AnonymousAuthenticationToken)) {
	    String currentUserName = authentication.getName();
	    return currentUserName;
	}
	return "not found";
}

}
