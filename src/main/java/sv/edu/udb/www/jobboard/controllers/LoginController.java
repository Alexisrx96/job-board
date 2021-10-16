package sv.edu.udb.www.jobboard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import sv.edu.udb.www.jobboard.models.dto.LoginForm;

@Controller
@RequestMapping("/login")
public class LoginController {
    @GetMapping
    public String login(Model model){
        return "login";
    }
}
