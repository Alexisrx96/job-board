package sv.edu.udb.www.jobboard.controllers;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/c")
public class CompanyController {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
    @ModelAttribute("module")
    public String module() {
        return "area";
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        //model.addAttribute("", new Object());
        return "company/profile";
    }

    @GetMapping("/applicants")
    public String applicants(Model model) {
        //model.addAttribute("", new Object());
        return "company/applicants";
    }
    @GetMapping("/publish-offer")
    public String publishOffer(Model model) {
        //model.addAttribute("", new Object());
        return "company/publish-offer";
    }
    @GetMapping("/display-offer")
    public String displayOffer(Model model) {
        //model.addAttribute("", new Object());
        return "company/display-offer";
    }
    @GetMapping("/offers")
    public String offers(Model model) {
        //model.addAttribute("", new Object());
        return "company/offers";
    }
}
