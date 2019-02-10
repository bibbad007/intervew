package com.kbc.account.services;

import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kbc.account.dto.AccountDto;
import com.kbc.account.dto.TransactionDto;
import com.kbc.account.entity.Account;
import com.kbc.account.entity.Transaction;
import com.kbc.account.exceptions.NotEnoughValueException;
import com.kbc.account.exceptions.PersonNotFoundException;
import com.kbc.account.jpa.TransactionJpaRepo;
@Service
public class TransactionServices {
	@Autowired
	private TransactionJpaRepo repo;
	@Autowired
	private AccountServices accService;
	private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	 Date date = new Date();
	
	public List<TransactionDto> findAllFromAccount(long pid){
		List<Transaction> transactions=repo.findAllForAccount(pid);
		List<TransactionDto> dto=new ArrayList<TransactionDto>();
		for(Transaction transaction:transactions){
			TransactionDto newDto = convertToDto(transaction);
			dto.add(newDto);
		}
		return dto;		
	}
	public TransactionDto findById(long id){
		  return convertToDto(repo.findById(id));
	}
	@Transactional()
	public ResponseEntity<Object>  save(TransactionDto dto){		
		ResponseEntity<Object> obj=null;
		if(checkEnoughMoneyAvaliable(dto))
		{		
		Transaction newtr=convertToEntity(dto);
		Transaction savedTransaction = repo.updateOrInsert(newtr);
		Account fromAccount=accService.findbyIdAsAccount(dto.getAccountIdFrom());
		float fromBalance=fromAccount.getBalance()-dto.getAmountTrans();
		fromAccount.setBalance(fromBalance);
		Account toAccount=accService.findbyIdAsAccount(dto.getAccountIdTo());
		float toBalance=toAccount.getBalance()+dto.getAmountTrans();
		toAccount.setBalance(toBalance);
		accService.saveAsAccount(fromAccount);
		accService.saveAsAccount(toAccount);
			URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(savedTransaction.getId()).toUri();		
			obj= ResponseEntity.created(location).build();
		}
		return obj;
	}
	
	private boolean checkEnoughMoneyAvaliable(TransactionDto dto){
		boolean enough=false;
		AccountDto fromAcc=accService.findById(dto.getAccountIdFrom());
		ResponseEntity<Object> obj=null;
		if(fromAcc.getBalance()>dto.getAmountTrans()){
			enough=true;
		}
		else{
			
			throw new NotEnoughValueException("Only have balance of "+ fromAcc.getBalance());
	     }
		return enough;
	}
	
	private TransactionDto convertToDto(Transaction transaction) {		
		TransactionDto newDto=new TransactionDto();
		newDto.setId(transaction.getId());
		newDto.setAccountIdFrom(transaction.getFromAccount().getId());
		newDto.setAccountIdTo(transaction.getToAccount().getId());
		newDto.setAmountTrans(transaction.getAmountTrans());		
		newDto.setTransDate(transaction.getTransDate());		
		return newDto;
	}	
	
	
	private Transaction convertToEntity(TransactionDto newDto) {		
		Transaction transaction;
	    transaction=new Transaction();	
	    
		transaction.setAmountTrans(newDto.getAmountTrans());
		transaction.setFromAccount(new Account());
		transaction.getFromAccount().setId(newDto.getAccountIdFrom());
		transaction.setToAccount(new Account());
		transaction.getToAccount().setId(newDto.getAccountIdTo());
		transaction.setTransDate(new Date(System.currentTimeMillis()));
		return transaction;
	}
	

}
