package sv.edu.udb.www.jobboard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import sv.edu.udb.www.jobboard.models.dao.AreaDao;
import sv.edu.udb.www.jobboard.util.CodeGenerator;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    AreaDao areaDao;
    @Autowired
    CodeGenerator random;

    @ModelAttribute("module")
    public String module() {
        return "home";
    }
    @GetMapping(path = {"/","","/home"})
    public String getIndex(Model model, HttpSession session){
        model.addAttribute("some","Index in controller");
        model.addAttribute("tittle","Index");
        return "index";
    }
    @GetMapping(path = "/mail/{name}")
    public ResponseEntity<?> mail(@PathVariable String name){
        return ResponseEntity.ok(areaDao.getAreas(name));
    }
}
