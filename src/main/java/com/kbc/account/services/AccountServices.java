package com.kbc.account.services;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kbc.account.dto.AccountDto;
import com.kbc.account.entity.Account;
import com.kbc.account.entity.Person;
import com.kbc.account.jpa.AccountJpaRepo;

@Service
public class AccountServices {
	@Autowired
	private AccountJpaRepo repo;
	
	public List<AccountDto> findAll(){
		List<Account> accounts=repo.findAll();
		List<AccountDto> dto=new ArrayList<AccountDto>();
		for(Account account:accounts){
			AccountDto newDto = convertToDto(account);
			dto.add(newDto);
		}
		return dto;		
	}
	public AccountDto findById(long id){
		  return convertToDto(repo.findById(id).get());
	}
	
	public Account findbyIdAsAccount(long id){
		return repo.findById(id).get();
	}
	
    public  ResponseEntity<Object> saveAsAccount(Account account){
		
		Account savedAccount = repo.save(account);		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedAccount.getId()).toUri();		
		return ResponseEntity.created(location).build();
	}
	
	private AccountDto convertToDto(Account account) {
		AccountDto newDto=new AccountDto();
		newDto.setId(account.getId());
		newDto.setOwnerId(account.getPerson().getId());
		newDto.setAccountType(account.getAccountType());
		newDto.setBalance(account.getBalance());
		newDto.setAccountOwner(account.getPerson().getName());
		return newDto;
	}
	
	public void deleteById(long id){
		repo.deleteById(repo.findById(id).get().getId());
	}
    
	public  ResponseEntity<Object> save(AccountDto dto){
		
		Account savedAccount = repo.save(convertToEntity(dto));		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedAccount.getId()).toUri();		
		return ResponseEntity.created(location).build();
	}
	
	private Account convertToEntity(AccountDto dto) {
		Optional<Account> accounts= repo.findById(dto.getId());
		Account account;
		if(accounts.isPresent()){
			account=accounts.get();
		}else{
			account=new Account();	
			account.setPerson(new Person());
			
		}
		account.setId(dto.getId());
		account.getPerson().setId(dto.getOwnerId());
		account.setAccountType(dto.getAccountType());
		account.setBalance(dto.getBalance());
		
		return account;
	}
	
}
