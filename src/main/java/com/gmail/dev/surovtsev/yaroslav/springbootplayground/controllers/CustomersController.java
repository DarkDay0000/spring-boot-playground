package com.gmail.dev.surovtsev.yaroslav.springbootplayground.controllers;

import com.gmail.dev.surovtsev.yaroslav.springbootplayground.dao.CustomerDAO;
import com.gmail.dev.surovtsev.yaroslav.springbootplayground.models.Customer;
import com.gmail.dev.surovtsev.yaroslav.springbootplayground.models.CustomerType;
import com.gmail.dev.surovtsev.yaroslav.springbootplayground.services.CustomerService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomersController {

    private final CustomerService customerService;
    private final CustomerDAO customerDAO;

    @Autowired
    public CustomersController(CustomerService customerService, CustomerDAO customerDAO) {
        this.customerService = customerService;
        this.customerDAO = customerDAO;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "customers/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "customers/show";
    }

    @GetMapping("/new")
    public String newCustomer(@ModelAttribute("customer") Customer customer) {
        return "customers/new";
    }

    @PostMapping
    public String save(@ModelAttribute("customer") @Valid Customer customer,
                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "customers/new";
        }
        customer.setCustomerType(CustomerType.RETAIL);
        customerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "customers/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("customer") Customer updatedCustomer,
                         @PathVariable("id") Integer id) {
        customerService.update(id, updatedCustomer);
        return "redirect:/customers";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Integer id) {
        customerService.deleteById(id);
        return "redirect:/customers";
    }
}
