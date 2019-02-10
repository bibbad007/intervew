package com.kbc.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.kbc.account.entity.Address;
import com.kbc.account.entity.Person;
import com.kbc.account.jpa.AccountJpaRepo;
import com.kbc.account.jpa.PersonJpaRepo;

@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement

public class IntervewApplication implements CommandLineRunner{
    private Logger logger=LoggerFactory.getLogger(this.getClass());
   
    @Autowired
    PersonJpaRepo personRepo;
    @Autowired
    AccountJpaRepo accountRepo;
    
	public static void main(String[] args) {
		SpringApplication.run(IntervewApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Person person=personRepo.findById(10001);
		logger.info("All users {}",personRepo.findById(10001).getHomeAddress().getBuilding());
		logger.info("All users {}",personRepo.findById(10002).getIdProof().getProofType());
		person.getHomeAddress().setBuilding("Tesco");
		personRepo.updateOrInsert(person);
		Person p=new Person("SANJU", 22, null, null, null, null);
		personRepo.updateOrInsert(p);		
		logger.info("All accountRepo {}",accountRepo.findAll());  
	}

}

