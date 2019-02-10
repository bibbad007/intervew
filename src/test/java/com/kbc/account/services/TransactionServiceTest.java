package com.kbc.account.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import com.kbc.account.dto.AccountDto;
import com.kbc.account.dto.TransactionDto;

@RunWith(MockitoJUnitRunner.class)
public class TransactionServiceTest {
	@Mock
	AccountServices accService;
	@InjectMocks
	TransactionServices ts;
	
	/*@Test
	public void testcheckEnoughMoneyAvaliable(){
		TransactionDto dto =new TransactionDto();
		dto.setAccountIdFrom(6);
		dto.setAmountTrans(200);
		when(accService.findById(dto.getAccountIdFrom()).thReturn
		
	}*/

}
