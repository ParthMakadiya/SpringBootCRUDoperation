package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
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
	public String showSignUpForm(Customer employee) {
		return "add-employee";
	}

	@GetMapping("/list")
	public String showUpdateForm(Model model) {
		model.addAttribute("employees", customerService.getAllCustomer());
		return "index";
	}

	@PostMapping("/add")
	public String addEmployee( Customer employee, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-employee";
		}
		customerService.addCustomer(employee);
		;
		return "redirect:list";
	}

	@GetMapping("/employee/{empId}")
	public String getEmployee(@PathVariable("empId") Integer empId, Model model) {
		Optional<Customer> emp = customerService.getCustomer(empId);
		Customer employee = emp.get();
		model.addAttribute("employee", employee);
		return "update-employee";

	}

	@GetMapping("delete/{empId}")
	public String removeEmployee(@PathVariable("empId") Integer empId, Model model) {

		customerService.removeCustomer(empId);

		model.addAttribute("employees", customerService.getAllCustomer());
		return "index";
	}
	
	@PostMapping("update/{empId}")
	public String updateEmployee(@PathVariable("empId") Integer empId, Customer employee,
			BindingResult bindingResult, Model model) {

		customerService.updateCustomer(employee);
		model.addAttribute("employees", customerService.getAllCustomer());
		return "index";
	}


}
