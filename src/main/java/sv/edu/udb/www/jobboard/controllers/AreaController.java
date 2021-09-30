package sv.edu.udb.www.jobboard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.www.jobboard.models.Area;
import sv.edu.udb.www.jobboard.services.AreaService;

import javax.validation.Valid;

@Controller
public class AreaController {

    @Autowired
    AreaService areaService;

    @ModelAttribute("module")
    public String module() {
        return "area";
    }

    @GetMapping(path = {"/area-list"})
    public String getArea(Model model){
        model.addAttribute("some","This is from controller");
        model.addAttribute("tittle","Area");
        model.addAttribute("areas", areaService.getAreaList());
        model.addAttribute("module_l2",module()+"/all");
        return "area/list";
    }

    @GetMapping("/area-new")
    public String newArea(Model model) {
        model.addAttribute("area",new Area());
        return "area/new";
    }

    @PostMapping("/area-new-save")
    public String saveNewArea(@Valid Area area, BindingResult result) {
        if (result.hasErrors()) {
            return "area/new";
        }
        areaService.addArea(area);
        return "redirect:area-list";
    }

    @GetMapping("/area-edit/{id}")
    public String updateArea(@PathVariable int id, Model model) {
        model.addAttribute("area",areaService.getArea(id));
        return "area/edit";
    }

    @PostMapping("/area-update-save")
    public String saveUpdatedArea(@Valid Area area, BindingResult result) {
        if (result.hasErrors()) {
            return "area-edit";
        }
        areaService.addArea(area);
        return "redirect:area-list";
    }

    @PostMapping("/area-delete")
    public String deleteArea(@RequestParam int id) {
        areaService.removeArea(id);
        return "redirect:area-list";
    }
}
