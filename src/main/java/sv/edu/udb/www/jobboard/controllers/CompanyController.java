package sv.edu.udb.www.jobboard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
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

import javax.servlet.http.HttpSession;
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

    @GetMapping("/profile")
    public String profile(Model model, HttpSession session) {
        int id = (Integer) session.getAttribute("id");
            model.addAttribute("profile", companyService.getCompanyAccountForm(id));
        return "company/profile";
    }

    @GetMapping("/applicants")
    public String applicants(Model model, HttpSession session) {
        //model.addAttribute("", new Object());
        return "company/applicants";
    }
    @GetMapping("/publish-offer")
    public String publishOffer(Model model, HttpSession session) {
        int id = (Integer) session.getAttribute("id");
        var offer = new JobOfferForm();
        offer.setCompany(id);
        offer.setState(1);
        model.addAttribute("offer",offer);
        model.addAttribute("areas", areaService.getAreaList());
        return "company/publish-offer";
    }
    @PostMapping(value = "/publish-offer", produces = "application/json")
    public ResponseEntity<JobOfferForm> saveNewOffer(@ModelAttribute("offer") @Valid JobOfferForm offerForm,
                                       final BindingResult result,
                                       HttpSession session) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(offerForm);
        }
        companyService.publishOffer(offerForm);

        return ResponseEntity.ok(offerForm);
    }
    @GetMapping("/display-offer/{id}")
    public String displayOffer(Model model,
                               @PathVariable int id,
                               HttpSession session) {
        model.addAttribute("offer", jobOfferService.getJobOffer(id));
        return "company/display-offer";
    }
    @GetMapping("/offers")
    public String offers(Model model,
                         HttpSession session) {
        int id = (Integer) session.getAttribute("id");
        model.addAttribute("offers", companyService.getMyOffers(id));
        return "company/offers";
    }
}
