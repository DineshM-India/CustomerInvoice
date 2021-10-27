package com.CustInvoice.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CustInvoice.entity.TaxCalculation;
@Repository
public interface TaxCalculationRepository extends CrudRepository<TaxCalculation, Integer> {

}
