package sv.edu.udb.www.jobboard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.www.jobboard.models.dto.TagForm;
import sv.edu.udb.www.jobboard.services.TagService;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/tag") //localhost:8080/tag/list
public class TagController {

    @Autowired
    TagService tagService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @ModelAttribute("module")
    public String module() {
        return "tag";
    }

    @GetMapping(path = {"/list", "/"})
    public String getTags(Model model) {
        model.addAttribute("some", "This is from controller");
        model.addAttribute("title", "Tags");
        model.addAttribute("tags", tagService.getTags());
        return "tag/list";
    }

    @GetMapping("/new")
    public String newTag(Model model) {
        model.addAttribute("tag", new TagForm());
        return "tag/new";
    }

    @PostMapping("/save")
    public String saveTag(@ModelAttribute("tag") @Valid TagForm tag, final BindingResult result) {
        if (result.hasErrors()) {
            return "/tag/new";
        }
        tagService.addTag(tag);
        return "redirect:/tag/list";
    }

    @GetMapping("/edit/{id}")
    public String updateTag(@PathVariable int id, Model model) {
        model.addAttribute("tag", tagService.getTag(id));
        return "tag/edit";
    }

    @PostMapping("/update")
    public String saveUpdatedTag(@ModelAttribute("tag") @Valid TagForm tag, final BindingResult result) {
        if (result.hasErrors()) {
            return "/tag/edit";
        }
        tagService.editTag(tag);
        return "redirect:/tag/list";
    }

    @PostMapping("/delete")
    public String deleteTag(@RequestParam int id) {
        tagService.removeTag(id);
        return "redirect:/tag/list";
    }
}
