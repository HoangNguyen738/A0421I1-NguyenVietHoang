package com.codegym.case_study.controller;

import com.codegym.case_study.model.Customer;
import com.codegym.case_study.model.Province;
import com.codegym.case_study.service.CustomerService;
import com.codegym.case_study.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> allProvinces() {
        return provinceService.findAll();
    }

    @GetMapping
    public ModelAndView showList(Optional<String> s, Pageable pageInfo) {
        ModelAndView modelAndView = new ModelAndView("/customers/list");
        Page<Customer> customers = s.isPresent() ? search(s, pageInfo) : getPage(pageInfo);
        modelAndView.addObject("keyword", s.orElse(null));
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView showInformation(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/customers/info");
        Optional<Customer> customerOptional = customerService.findOne(id);
        modelAndView.addObject("customer", customerOptional.get());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView updateCustomer(Customer customer) {
        customerService.save(customer);
        return new ModelAndView("redirect:/customers");
    }

    private Page<Customer> getPage(Pageable pageInfo) {
        return customerService.findAll(pageInfo);
    }

    private Page<Customer> search(Optional<String> s, Pageable pageInfo) {
        return customerService.search(s.get(), pageInfo);
    }
}
