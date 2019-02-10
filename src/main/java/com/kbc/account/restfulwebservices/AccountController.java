package com.kbc.account.restfulwebservices;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kbc.account.dto.AccountDto;
import com.kbc.account.entity.Account;
import com.kbc.account.services.AccountServices;
@RestController
public class AccountController {

	@Autowired
	private AccountServices service;

	@GetMapping("/accounts")
	public List<AccountDto> retrieveAllAccounts() {
		return service.findAll();
	}

	@GetMapping("/accounts/{id}")
	public AccountDto retrieveAccount(@PathVariable long id) {
	
		AccountDto account = service.findById(id);
		
		/*if(account==null)
			throw new AccountNotFoundException("id-"+ id);*/
		
		return account;
	}

	@DeleteMapping("/accounts/{id}")
	public void deleteUser(@PathVariable int id) {
		 service.deleteById(id);
		/*
		if(account==null)
			throw new AccountNotFoundException("id-"+ id);	*/
	}


	@PostMapping("/accounts")
	public ResponseEntity<Object> createAccount(@Valid @RequestBody AccountDto accountDto) {		
		return service.save(accountDto);	
		
	}
}

