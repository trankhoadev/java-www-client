package com.se.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.se.spring.entity.Customer;
import com.se.spring.service.CustomerService;

@Controller
public class DemoController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/")
	public String showHome(Model model) {

		List<Customer> list = customerService.getCustomers();
		model.addAttribute("LIST", list);

		return "home";
	}

	@GetMapping("/showFormAdd")
	public String showFormAdd(Model model) {

		Customer customer = new Customer();
		model.addAttribute("customer", customer);

		return "customerForm";
	}

	@GetMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {

		customerService.saveCustomer(customer);

		return "redirect:/";
	}

	@GetMapping("/delete")
	public String saveCustomer(@RequestParam("id") int id) {

		customerService.deleteCustomer(id);

		return "redirect:/";
	}

	@GetMapping("/showFormUpdate")
	public String showFormUpdate(@RequestParam("id") int id, Model model) {

		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customer", customer);

		return "customerForm";
	}
}
