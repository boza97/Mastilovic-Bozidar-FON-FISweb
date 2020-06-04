/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastilovic.bozidar.fon.fisweb.controller;

import java.util.List;
import mastilovic.bozidar.fon.fisweb.dto.DepartmentDto;
import mastilovic.bozidar.fon.fisweb.service.DepartmentService;
import mastilovic.bozidar.fon.fisweb.validator.DepartmentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Bozidar
 */
@Controller
@RequestMapping(path = "/department")
public class DepartmentController {

    private final DepartmentService departmentService;
    private final DepartmentValidator departmentValidator;

    @Autowired
    public DepartmentController(DepartmentService departmentService, DepartmentValidator departmentValidator) {
        this.departmentService = departmentService;
        this.departmentValidator = departmentValidator;
    }

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(departmentValidator);
    }

    @GetMapping(value = "all")
    public String all(Model model) {
        if (getDepartments().isEmpty()) {
            model.addAttribute("emptyTable", "There are no departments!");
        }
        return "department/all";
    }

    @GetMapping(value = "add")
    public String add() {
        return "department/add";
    }

    @PostMapping(value = "save")
    public String save(@ModelAttribute(name = "departmentDto") @Validated DepartmentDto departmentDto,
            BindingResult result,
            RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "One or more fields are invalid.");
            redirectAttributes.addFlashAttribute("departmentDto", departmentDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.departmentDto", result);
            return "redirect:/department/add";
        } else {
            departmentService.save(departmentDto);
            redirectAttributes.addFlashAttribute("success", "Department saved successfully.");
            return "redirect:/department/add";
        }
    }

    @GetMapping(value = "{departmentId}/edit")
    public String edit(@PathVariable(name = "departmentId") Long departmentId,
            Model model) {
        DepartmentDto departmentDto = departmentService.findById(departmentId);
        if (departmentDto == null) {
            return "redirect:/department/all";
        }
        model.addAttribute("departmentDto", departmentDto);
        return "department/edit";
    }

    @PatchMapping(value = "update")
    public String update(@ModelAttribute(name = "departmentDto") @Validated DepartmentDto departmentDto,
            BindingResult result,
            RedirectAttributes redirectAttributes,
            Model model) {
        if (result.hasErrors()) {
            model.addAttribute("error", "One or more fields are invalid.");
            model.addAttribute("departmentDto", departmentDto);
            return "department/edit";
        } else {
            departmentService.update(departmentDto);
            redirectAttributes.addFlashAttribute("success", "Department updated successfully.");
            return "redirect:/department/" + departmentDto.getId() + "/edit";
        }
    }
    
    @GetMapping(value = "{departmentId}/delete")
    public String delete(@PathVariable(name = "departmentId") Long departmentId){
        departmentService.delete(departmentId);
        return "redirect:/department/all";
    }

    @ModelAttribute(name = "departments")
    private List<DepartmentDto> getDepartments() {
        return departmentService.getAll();
    }

    @ModelAttribute(name = "departmentDto")
    private DepartmentDto getDepartmentDto() {
        return new DepartmentDto();
    }
}
