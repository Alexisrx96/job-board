package sv.edu.udb.www.jobboard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sv.edu.udb.www.jobboard.models.dto.ProfessionalAccountForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.www.jobboard.services.JobOfferService;
import sv.edu.udb.www.jobboard.services.ProfessionalService;
import javax.validation.Valid;

@Controller
@RequestMapping(path = "/p")
public class ProfessionalController {

    @Autowired
    ProfessionalService professionalService;

    @Autowired
    JobOfferService jobOfferService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @ModelAttribute("module")
    public String module() {
        return "professional";
    }


    //profile
    @GetMapping(path = "/profile/{id}")
    public String getProfile( @PathVariable int id, Model model){
        model.addAttribute("form", professionalService.getProfessionalAccountForm(id));
        return "professional/profile";
    }

    @GetMapping(path = "/resume")
    public String getResume( Model model){

        return "professional/resume";
    }

    //job-offer
    @GetMapping(path = "/job-offers")
    public String getJobOffer(Model model){
        model.addAttribute("offers",professionalService.getAllOffers());
        return "professional/job-offer";
    }

    @GetMapping(path = "/applications")
    public String getApplications(Model model) {
        return "professional/applications";
    }

    @GetMapping(path = "/display-offer/{id}")
    public String displayJobOffer(Model model,@PathVariable int id){
        model.addAttribute("offer",jobOfferService.getJobOffer(id));
        return "professional/display-job-offer";
    }

    @GetMapping(path = "/apply")
    public String displayApply(Model model) {
        return "professional/apply";
    }


    // update de profile
    @PostMapping("/update")
    public String saveUpdatedProfessional(@ModelAttribute("professional") @Valid ProfessionalAccountForm professional, final BindingResult result) {
        if (result.hasErrors()) {
            return "/professional/profile";
        }
        professionalService.editProfessional(professional);
        return "redirect:/professional/profile";
    }

    // update de job-offer

    @PostMapping("/update1")
    public String saveUpdatedProfessional1(@ModelAttribute("professional") @Valid ProfessionalAccountForm professional, final BindingResult result) {
        if (result.hasErrors()) {
            return "/professional/job-offer";
        }
        professionalService.editProfessional(professional);
        return "redirect:/professional/job-offer";
    }



//guardar de profile

    @PostMapping("/save")
    public String saveProfessional(@ModelAttribute("professional") @Valid ProfessionalAccountForm professional, final BindingResult result) {
        if (result.hasErrors()) {
            return "/professional/profile";
        }
        professionalService.editProfessional(professional);
        return "redirect:/professional/profile";
    }


    //guardar de profile

    @PostMapping("/save1")
    public String saveProfessional1(@ModelAttribute("professional") @Valid ProfessionalAccountForm professional, final BindingResult result) {
        if (result.hasErrors()) {
            return "/professional/job-offer";
        }
        professionalService.editProfessional(professional);
        return "redirect:/professional/job-offer";
    }


}
