package sv.edu.udb.www.jobboard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.www.jobboard.models.dto.CompanyAccountForm;
import sv.edu.udb.www.jobboard.models.dto.ProfessionalAccountForm;
import sv.edu.udb.www.jobboard.services.AccountService;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    AccountService accountService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping("/register-professional")
    public String registerProfessional(Model model) {
        //model.addAttribute("", new Object());
        return "company/profile";
    }

    @PostMapping("/register-professional")
    public String saveProfessional(@ModelAttribute("professional")@Valid ProfessionalAccountForm professional, final BindingResult result) {
        //model.addAttribute("", new Object());
        return "company/profile";
    }

    @GetMapping("/register-company")
    public String registerCompany(Model model) {
        model.addAttribute("company", new CompanyAccountForm());
        return "register-company";
    }

    @PostMapping("/register-company")
    public String saveCompany(@ModelAttribute("company")@Valid CompanyAccountForm company, final BindingResult result) {
        if(result.hasErrors())
            return "register-company";
        accountService.newCompany(company);
        return "redirect:login";
    }
}
