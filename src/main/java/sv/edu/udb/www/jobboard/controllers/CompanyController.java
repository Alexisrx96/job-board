package sv.edu.udb.www.jobboard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.www.jobboard.models.dto.CompanyAccountForm;
import sv.edu.udb.www.jobboard.models.dto.JobOfferForm;
import sv.edu.udb.www.jobboard.models.dto.ProfessionalAccountForm;
import sv.edu.udb.www.jobboard.services.AreaService;
import sv.edu.udb.www.jobboard.services.CompanyService;
import sv.edu.udb.www.jobboard.services.JobOfferService;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/c")
public class CompanyController {

    @Autowired
    CompanyService companyService;
    @Autowired
    AreaService areaService;
    @Autowired
    JobOfferService jobOfferService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
    @ModelAttribute("module")
    public String module() {
        return "area";
    }

    @GetMapping("/profile/{id}")
    public String profile(Model model, @PathVariable int id) {
            model.addAttribute("profile", companyService.getCompanyAccountForm(id));
        return "company/profile";
    }

    @GetMapping("/applicants")
    public String applicants(Model model) {
        //model.addAttribute("", new Object());
        return "company/applicants";
    }
    @GetMapping("/publish-offer/{id}")
    public String publishOffer(Model model, @PathVariable int id) {
        var offer = new JobOfferForm();
        offer.setCompany(id);
        offer.setState(1);
        model.addAttribute("offer",offer);
        model.addAttribute("areas", areaService.getAreaList());
        return "company/publish-offer";
    }
    @PostMapping("/publish-offer")
    public String saveNewOffer(@ModelAttribute("offer") @Valid JobOfferForm offerForm, final BindingResult result) {
        if (result.hasErrors()) {
            return "/company/publish-offer";
        }
        companyService.publishOffer(offerForm);
        return "redirect:/";
    }
    @GetMapping("/display-offer/{id}")
    public String displayOffer(Model model, @PathVariable int id) {
        model.addAttribute("offer", jobOfferService.getJobOffer(id));
        return "company/display-offer";
    }
    @GetMapping("/offers/{id}")
    public String offers(Model model, @PathVariable int id) {
        model.addAttribute("offers", companyService.getMyOffers(id));
        return "company/offers";
    }
}
