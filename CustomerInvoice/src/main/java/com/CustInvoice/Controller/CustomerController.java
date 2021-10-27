package com.CustInvoice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CustInvoice.Service.CustomerService;
import com.CustInvoice.entity.Customer;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private CustomerService custserv;
	
	public CustomerController(CustomerService custserv) {
		super();
		this.custserv = custserv;
	}
		
		@PostMapping("/create")
		 public ResponseEntity<Customer> createCust(@RequestBody Customer customer){
		 return new ResponseEntity<Customer>(custserv.registerCust(customer),HttpStatus.CREATED);
	}
		@PutMapping("/update")
		public Customer updateCustomer(@RequestBody Customer customer) {
			custserv.registerCust(customer);
			return customer;
		}
		
		@GetMapping("/Customer")
		public List<Customer> getAllCustomer(){
			return custserv.getAllCustomer();
		}
		
		@GetMapping("/Customer/{id}")
		public Customer getCustomerById(@PathVariable("id")int id) {
			Customer customer = custserv.getCustomerById(id);
			if(customer == null) {
				throw new RuntimeException("Customer id not found - " + id);
			}
			else {
			return customer;
			}
		}
		
		@DeleteMapping("/Customer/{id}")
		public String deleteCustomer(@PathVariable("id")int id) {
			Customer customer = custserv.getCustomerById(id);
			if(customer == null) {
				throw new RuntimeException("Customer id not found - " + id);
			}
			custserv.deleteById(id);
			return "deleted Customer id:"+id;
		}
}
