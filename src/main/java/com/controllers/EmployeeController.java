package com.controllers;

import com.dto.EmployeeDTO;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping({"/login", "/"})
    public String callLoginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String callRegistrationPage() {
        return "employeeRegistration";
    }

    @PostMapping("/register")
    public String registerEmployee(@ModelAttribute EmployeeDTO employeeDTO, Model model) {
        employeeService.registerEmp(employeeDTO);
        model.addAttribute("message", "Registration completed successfully");
        return "employeeRegistration";
    }

    @PostMapping("/loginValidate")
    public String authenticate(@RequestParam String emailId, @RequestParam String password, Model model) {
        EmployeeDTO employeeDTO = employeeService.authenticate(emailId, password);
        if (employeeDTO != null) {
            model.addAttribute("employeeDTO", employeeDTO);
            return "congratulations";
        } else {
            model.addAttribute("message", "Wrong credential!!! Re-Try");
            return "login";
        }
    }

    @GetMapping("/search")
    public String searchEmployeePage() {
        return "search";
    }

    @PostMapping("/search")
    public String searchEmployee(@RequestParam String searchTerm, Model model) {
        EmployeeDTO employeeDTO = employeeService.searchEmployee(searchTerm);
        if (employeeDTO != null) {
            model.addAttribute("employeeDTO", employeeDTO);
            return "searchResults";
        } else {
            model.addAttribute("message", "Employee not found");
            return "search";
        }
    }

    @PostMapping("/congratulations")
    public String showCongratulationsPage() {
        return "congratulations"; // Redirect to the congratulations page
    }

    @GetMapping("/fetchAllRecords")
    public String showAllRecords(Model model) {
        model.addAttribute("employeeDtoList", employeeService.findAllEmployees());
        return "showAll";
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam int employeeId, Model model) {
        employeeService.deleteEmp(employeeId);
        model.addAttribute("message", "Record deleted successfully");
        return "redirect:/fetchAllRecords";
    }

    @GetMapping("/editEmployee")
    public String editEmp(@RequestParam int employeeId, Model model) {
        EmployeeDTO employeeDTO = employeeService.retrieveRecord(employeeId);
        model.addAttribute("employeeDTO", employeeDTO);
        return "editEmployee";
    }

    @PostMapping("/updateEmployee")
    public String updateEmp(@ModelAttribute EmployeeDTO employeeDTO, Model model) {
        employeeService.updateKaro(employeeDTO);
        model.addAttribute("message", "Record updated successfully");
        return "redirect:/fetchAllRecords";
    }

    @GetMapping("logout")
    public String logoutEmployee(Model model) {
        model.addAttribute("message", "You have logged-out successfully");
        return "login";
    }
}
