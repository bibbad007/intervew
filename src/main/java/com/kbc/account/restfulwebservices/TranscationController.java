package com.kbc.account.restfulwebservices;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kbc.account.dto.TransactionDto;
import com.kbc.account.services.TransactionServices;

@RestController
public class TranscationController {
	
	@Autowired
	private TransactionServices service;

	
	@GetMapping("/transcation/acc/{accId}")
	public List<TransactionDto> retrieveByAccount(@PathVariable long accId) {	
		List<TransactionDto> transactions = service.findAllFromAccount(accId);		
		return transactions;
	}
	
	@GetMapping("/transcation/{id}")
	public TransactionDto retrieveTransaction(@PathVariable long id) {
	
		TransactionDto transaction = service.findById(id);
		
		/*if(person==null)
			throw new PersonNotFoundException("id-"+ id);*/
		
		return transaction;
	}
	
	@PostMapping("/transcation")
	public ResponseEntity<Object> createTransaction(@Valid @RequestBody TransactionDto transactionDto) {	
		
		return 	service.save(transactionDto);
		
	}

}
