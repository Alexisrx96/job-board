package sv.edu.udb.www.jobboard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {
    @ModelAttribute("module")
    public String module() {
        return "home";
    }
    @GetMapping(path = {"/",""})
    public String getIndex(Model model){
        model.addAttribute("some","Index in controller");
        model.addAttribute("tittle","Index");
        return "index";
    }

    @GetMapping(path = "/v2")
    public String getIndex2(Model model){
        model.addAttribute("some","Index in controller");
        model.addAttribute("tittle","Index");
        return "_layout-v2";
    }
}
