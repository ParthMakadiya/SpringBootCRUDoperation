package com.example.demo.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@Controller
@RequestMapping(value = "/api")
public class CustomerCotroller {
	
	@Autowired
	private CustomerService customerService;
	
	/*@GetMapping("/allCustomer")
	public List<Customer> getAllCustomer()
	{
		return customerService.getAllCustomer();
		//return "ok";
	}
	
	@GetMapping("/customer/{custId}")
	public Optional<Customer> getSingleCustomer(@PathVariable("custId") Integer custId)
	{
		return customerService.getCustomer(custId);
	}
	
	@DeleteMapping("/deletecustomer/{custId}")
	public String deleteCustomer(@PathVariable("custId") Integer custId)
	{
		boolean result=customerService.removeCustomer(custId);
		if(result==true)
		{
			return "Customer with id "+custId+" is deleted sucessfully";
		}
		else
		{
			return "No customer exists with id "+custId+" for deletion";
		}
	}
	
	@PostMapping("/addcustomer")
	public String addCustomer(@RequestBody Customer customer) 
	{
		customerService.addCustomer(customer);
		return "Customer with ssnId "+customer.getSsn_id()+" added successfully";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.PUT)
	public String updateCustomer(@RequestBody Customer customer)
	{
		customerService.updateCustomer(customer);
		return "Customer with id "+customer.getCustomer_id()+" updated successfully";
	}
	*/
	@GetMapping("/start")
	public String showSignUpForm(Customer customer) {
		return "addcustomer2";
	}

	@GetMapping("/list")
	public String showUpdateForm(Model model) {
		model.addAttribute("customers", customerService.getAllCustomer());
		return "index";
	}

	@PostMapping("/add")
	public String addCustomer(Customer customer, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "addcustomer2";
		}
		customerService.addCustomer(customer);
		
		return "redirect:list";
	}

	@GetMapping("/customer/{custId}")
	public String getCustomer(@PathVariable("custId") Integer custId, Model model) {
		Optional<Customer> cust = customerService.getCustomer(custId);
		Customer customer = cust.get();
		model.addAttribute("customers", customer);
		return "update_customer";

	}

	@GetMapping("delete/{custId}")
	public String removeCustomer(@PathVariable("custId") Integer custId, Model model) {

		customerService.removeCustomer(custId);

		model.addAttribute("customers", customerService.getAllCustomer());
		return "index";
	}
	
	@PostMapping("update/{custId}")
	public String updateCustomer(@PathVariable("custId") Integer custId, Customer customer,
			BindingResult bindingResult, Model model) {

		customerService.updateCustomer(customer);
		model.addAttribute("customers", customerService.getAllCustomer());
		return "index";
	}

}
