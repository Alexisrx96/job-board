package sv.edu.udb.www.jobboard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import sv.edu.udb.www.jobboard.services.EmailService;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    EmailService emailService;

    @ModelAttribute("module")
    public String module() {
        return "home";
    }
    @GetMapping(path = {"/","","/home"})
    public String getIndex(Model model, HttpSession session){
        model.addAttribute("some","Index in controller");
        model.addAttribute("tittle","Index");
        return "index";
    }
    @GetMapping(path = "/mail")
    public String mail(){
        emailService.sendSimpleMessage(/*Escribe tu correo*/"","Bienvenido a ...", "Gracias por formar parte de ...");
        return "index";
    }

    @GetMapping(path = "/v2")
    public String getIndex2(Model model){
        model.addAttribute("some","Index in controller");
        model.addAttribute("tittle","Index");
        return "_layout-v2";
    }
}
