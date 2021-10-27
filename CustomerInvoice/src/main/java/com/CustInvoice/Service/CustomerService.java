package com.CustInvoice.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CustInvoice.Repository.CustomerRepository;
import com.CustInvoice.entity.Customer;


@Service
public class CustomerService  {
 
	@Autowired
	private CustomerRepository custrepo;
	
	public CustomerService(CustomerRepository custrepo) {
		super();
		this.custrepo = custrepo;
	}
	
	public List<Customer>  getAllCustomer(){
    	List<Customer> customer = new ArrayList<Customer>();
    	custrepo.findAll().forEach(customer::add);
		return customer;
	}
	
	public Customer registerCust(Customer customer) {
		return custrepo.save(customer);
	}
	
	public Customer getCustomerById(int id) {
		return custrepo.findById(id).get();
	}
	public void deleteById(int id) {
		custrepo.findById(id);
	}
	
}
