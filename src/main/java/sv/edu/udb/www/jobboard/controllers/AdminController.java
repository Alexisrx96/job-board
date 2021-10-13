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
@RequestMapping(path = "/a")
public class AdminController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
    @ModelAttribute("module")
    public String module() {
        return "area";
    }

    @GetMapping("/display-offer")
    public String displayOffer(Model model) {
        //model.addAttribute("", new Object());
        return "admin/display-offer";
    }
    @GetMapping("/offers")
    public String getOffers(Model model) {
        //model.addAttribute("", new Object());
        return "admin/offers";
    }

    @GetMapping("/companies")
    public String companies(Model model) {
        //model.addAttribute("", new Object());
        return "admin/profile/company";
    }

    @GetMapping("/professionals")
    public String professionals(Model model) {
        //model.addAttribute("", new Object());
        return "admin/profile/professional";
    }

    @GetMapping("/display-company")
    public String displayCompanies(Model model) {
        //model.addAttribute("", new Object());
        return "admin/profile/display-company";
    }


    @GetMapping("/display-professional")
    public String displayProfessional(Model model) {
        //model.addAttribute("", new Object());
        return "admin/profile/display-professional";
    }
}
