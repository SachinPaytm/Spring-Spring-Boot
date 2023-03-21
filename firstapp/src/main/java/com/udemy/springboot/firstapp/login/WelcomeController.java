package com.udemy.springboot.firstapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {
    @RequestMapping("/")
    public String welcomePage(ModelMap model){
        model.put("name",getLoggedInUsername());
        return "welcome";
    }

    private String getLoggedInUsername() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

//    //    private Logger logger= LoggerFactory.getLogger(getClass());
//    private AuthenticationService authenticationService;
//
//    public LoginController(AuthenticationService authenticationService) {
//        this.authenticationService = authenticationService;
//    }

//    @RequestMapping(value = "login", method = RequestMethod.GET)
//    public String loginPage() {
//        return "login";
//    }
//
//    @RequestMapping(value = "login", method = RequestMethod.POST)
//    public String welcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
//
//        if (authenticationService.authenticate(name, password)) {
//            model.put("name", name);
//            model.put("password", password);
//            return "welcome";
//        }
//        model.put("error", "Invalid Credentials  Try Again!!");
//        return "login";
//    }
}
