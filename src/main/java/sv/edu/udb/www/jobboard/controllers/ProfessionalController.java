package sv.edu.udb.www.jobboard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sv.edu.udb.www.jobboard.models.dto.ProfessionalAccountForm;

@Controller
@RequestMapping(path = "/p")
public class ProfessionalController {
    @GetMapping(path = "/profile")
    public String getProfile(Model model){
        model.addAttribute("form", new ProfessionalAccountForm());
        return "professional/profile";
    }

    @GetMapping(path = "/resume")
    public String getResume(Model model){
        return "professional/resume";
    }

    @GetMapping(path = "/job-offer")
    public String getJobOffer(Model model){
        return "professional/job-offer";
    }

    @GetMapping(path = "/applications")
    public String getApplications(Model model){
        return "professional/applications";
    }

    @GetMapping(path = "/display-job-offer")
    public String displayJobOffer(Model model){
        return "professional/display-job-offer";
    }

    @GetMapping(path = "/apply")
    public String displayApply(Model model){
        return "professional/apply";
    }

}
