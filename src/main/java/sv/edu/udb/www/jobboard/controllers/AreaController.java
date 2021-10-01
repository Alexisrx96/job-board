package sv.edu.udb.www.jobboard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.www.jobboard.models.dto.AreaForm;
import sv.edu.udb.www.jobboard.services.AreaService;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/area")
public class AreaController {

    @Autowired
    AreaService areaService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @ModelAttribute("module")
    public String module() {
        return "area";
    }

    @GetMapping(path = {"/list", "/"})
    public String getArea(Model model) {
        model.addAttribute("some", "This is from controller");
        model.addAttribute("title", "Areas");
        model.addAttribute("areas", areaService.getAreaList());
        return "area/list";
    }

    @GetMapping("/new")
    public String newArea(Model model) {
        model.addAttribute("area", new AreaForm());
        return "area/new";
    }

    @PostMapping("/save")
    public String saveArea(@ModelAttribute("area") @Valid AreaForm area, final BindingResult result) {
        if (result.hasErrors()) {
            return "/area/new";
        }
        areaService.addArea(area);
        return "redirect:/area/list";
    }

    @GetMapping("/edit/{id}")
    public String updateArea(@PathVariable int id, Model model) {
        model.addAttribute("area", areaService.getArea(id));
        return "area/edit";
    }

    @PostMapping("/update")
    public String saveUpdatedArea(@ModelAttribute("area") @Valid AreaForm area, final BindingResult result) {
        if (result.hasErrors()) {
            return "/area/edit";
        }
        areaService.editArea(area);
        return "redirect:/area/list";
    }

    @PostMapping("/delete")
    public String deleteArea(@RequestParam int id) {
        areaService.removeArea(id);
        return "redirect:area-list";
    }
}
