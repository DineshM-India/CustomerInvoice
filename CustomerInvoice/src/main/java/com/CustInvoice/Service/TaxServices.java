package com.CustInvoice.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CustInvoice.Repository.TaxCalculationRepository;
import com.CustInvoice.entity.TaxCalculation;

@Service
public class TaxServices {

	@Autowired
	private TaxCalculationRepository taxrepo;
	
	public TaxServices(TaxCalculationRepository taxrepo) {
		super();
		this.taxrepo = taxrepo;
	}
	
	public TaxCalculation saveTax(TaxCalculation taxcalculate) {
		return taxrepo.save(taxcalculate);
	}
	
	public List<TaxCalculation> getAlltax(){
		List<TaxCalculation> taxcalculate = new ArrayList<TaxCalculation>();
		taxrepo.findAll().forEach(taxcalculate::add);
		return taxcalculate;
	}
	
	public TaxCalculation getTaxById(int id) {
		return taxrepo.findById(id).get();
	}
	public void deleteById(int id) {
		taxrepo.deleteById(id);
	}
}
