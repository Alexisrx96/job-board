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
import sv.edu.udb.www.jobboard.services.AreaService;
import sv.edu.udb.www.jobboard.services.EmailService;
import sv.edu.udb.www.jobboard.util.CodeGenerator;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    AccountService accountService;
    @Autowired
    AreaService areaService;
    @Autowired
    EmailService emailService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping("/register-professional")
    public String registerProfessional(Model model) {
        model.addAttribute("professional", new ProfessionalAccountForm());
        model.addAttribute("areas",areaService.getAreaList());
        return "register-professional";
    }

    @PostMapping("/register-professional")
    public String saveProfessional(@ModelAttribute("professional")@Valid ProfessionalAccountForm professional, final BindingResult result) {
        if(result.hasErrors())
            return "register-professional";
        var code = accountService.newProfesional(professional).getEmail().getConfirmCode();
        emailService.sendSimpleMessage(professional.getEmail(),
                String.format("Bienvenido %s", professional.getFirstName()),
                "Gracias por formar parte de a la bolsa de trabajo\ntu código es: " + code
                );
        return "redirect:login";
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
        var code = accountService.newCompany(company).getEmail().getConfirmCode();
        emailService.sendSimpleMessage(company.getEmail(),
                String.format("Bienvenido %s", company.getName()),
                "Gracias por formar parte de a la bolsa de trabajo\ntu código es: " + code
        );
        return "redirect:login";
    }
}
