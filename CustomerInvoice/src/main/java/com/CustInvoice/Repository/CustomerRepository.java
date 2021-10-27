package com.CustInvoice.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CustInvoice.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer , Integer>{

}
