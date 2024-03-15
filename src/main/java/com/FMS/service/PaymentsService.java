package com.FMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FMS.model.Payments;
import com.FMS.repository.PaymentsRepository;

@Service
public class PaymentsService {

	private final PaymentsRepository paymentsRepository;
	
	@Autowired
	public PaymentsService(PaymentsRepository paymentsRepository) {
		this.paymentsRepository = paymentsRepository;
	}
	
	public List<Payments> getPayments(){
		return paymentsRepository.findAll();
	}

	
	public Payments getPaymentbyID(Long id) {
		return paymentsRepository.getReferenceById(id);
		
	};


	public void addNewPayment(Payments payments) {
		paymentsRepository.save(payments);
		
		
	}


	public void deletePayment(Long id) {
		paymentsRepository.deleteById(id);
	}


}
