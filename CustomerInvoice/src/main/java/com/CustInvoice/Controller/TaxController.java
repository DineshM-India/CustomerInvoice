package com.CustInvoice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CustInvoice.Service.TaxServices;
import com.CustInvoice.entity.TaxCalculation;

@RestController
@RequestMapping("/api")
public class TaxController {
	@Autowired(required = true)
	private TaxServices taxserv;
	public TaxController(TaxServices taxserv) {
		super();
		this.taxserv = taxserv;
	}
	@PostMapping("/createtax")
	public ResponseEntity<TaxCalculation> createTax(@RequestBody TaxCalculation taxcalculate){
		return new ResponseEntity<TaxCalculation>(taxserv.saveTax(taxcalculate),HttpStatus.CREATED);
	}
	@PutMapping("/updatetax")
	public TaxCalculation updateTax(@RequestBody TaxCalculation taxcalculate) {
		taxserv.saveTax(taxcalculate);
		return taxcalculate;
	}
	
	@GetMapping("/getTax")
	public List<TaxCalculation> getAllTax(){
		return taxserv.getAlltax();
	}

}
