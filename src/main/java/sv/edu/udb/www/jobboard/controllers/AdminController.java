package sv.edu.udb.www.jobboard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.www.jobboard.services.AdminService;
import sv.edu.udb.www.jobboard.services.CompanyService;
import sv.edu.udb.www.jobboard.services.ProfessionalService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/a")
public class AdminController {

    @Autowired
    ProfessionalService professionalService;

    @Autowired
    CompanyService companyService;
    @Autowired
    AdminService adminService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @ModelAttribute("module")
    public String module() {
        return "area";
    }

    @GetMapping("/display-offer")
    public String displayOffer(Model model, HttpSession session) {
        //model.addAttribute("", new Object());
        return "admin/display-offer";
    }
    @GetMapping("/offers")
    public String getOffers(Model model) {
        //model.addAttribute("", new Object());
        return "admin/offers";
    }

    @GetMapping("/companies")
    public String companies(Model model, HttpSession session) {
        model.addAttribute("companies", adminService.getCompanyProfiles());
        return "admin/profile/company";
    }

    @GetMapping("/professionals")
    public String professionals(Model model) {
        model.addAttribute("professionals", adminService.getProfessionalProfiles());
        return "admin/profile/professional";
    }

    @GetMapping("/display-company")
    public String displayCompanies(Model model, HttpSession session) {
        //model.addAttribute("", new Object());
        return "admin/profile/display-company";
    }


    @GetMapping("/display-professional/{id}")
    public String displayProfessional(Model model, @PathVariable int id, HttpSession session) {
        model.addAttribute("professional", professionalService.getProfessional(id));
        return "admin/profile/display-professional";
    }
}
