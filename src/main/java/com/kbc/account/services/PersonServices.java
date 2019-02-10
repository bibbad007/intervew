package com.kbc.account.services;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kbc.account.dto.PersonDto;
import com.kbc.account.entity.Account;
import com.kbc.account.entity.Address;
import com.kbc.account.entity.IdProof;
import com.kbc.account.entity.Person;
import com.kbc.account.entity.Person;
import com.kbc.account.jpa.PersonJpaRepo;

@Service
public class PersonServices {
	@Autowired
	private PersonJpaRepo repo;
	
	public List<PersonDto> findAll(){
		List<Person> persons=repo.findAll();
		List<PersonDto> dto=new ArrayList<PersonDto>();
		for(Person person:persons){
			PersonDto newDto = convertToDto(person);
			dto.add(newDto);
		}
		return dto;		
	}
	public PersonDto findById(long id){
		  return convertToDto(repo.findById(id));
	}
	
	private PersonDto convertToDto(Person person) {		
		PersonDto newDto=new PersonDto();
		newDto.setPersonId(person.getId());
		newDto.setName(person.getName());
		newDto.setAge(person.getAge());
		newDto.setHouseName(person.getHomeAddress().getBuilding());
		newDto.setHouseLoc(person.getHomeAddress().getLocation());
		newDto.setHousePhone(person.getHomeAddress().getPhone());
		newDto.setOfficeName(person.getOfficeAddress().getBuilding());
		newDto.setOfficeLoc(person.getOfficeAddress().getLocation());
		newDto.setOfficePhone(person.getOfficeAddress().getPhone());
		newDto.setIdProofType(person.getIdProof().getProofType());
		HashSet<Long> acc=new HashSet<>();
		for(Account ac:person.getAccounts()){
			acc.add(ac.getId());
		}		
		newDto.setAccounts(acc);
		return newDto;
	}
	
	public void deleteById(long id){
		repo.deleteById(repo.findById(id).getId());
	}
    
	public  ResponseEntity<Object> save(PersonDto dto){
		
		Person savedPerson = repo.updateOrInsert(convertToEntity(dto));		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedPerson.getId()).toUri();		
		return ResponseEntity.created(location).build();
	}
	
	private Person convertToEntity(PersonDto newDto) {
		
		Person person= repo.findById(newDto.getPersonId());		
		if(person==null){
			person=new Person();
		}
		
		person.setId(newDto.getPersonId());
		person.setName(newDto.getName());
		person.setAge(newDto.getAge());
		person.setHomeAddress(new Address());
		person.getHomeAddress().setBuilding(newDto.getHouseName());
		person.getHomeAddress().setLocation(newDto.getHouseLoc());
		person.getHomeAddress().setPhone(newDto.getHousePhone());
		person.setOfficeAddress(new Address());
		person.getOfficeAddress().setBuilding(newDto.getOfficeName());
		person.getOfficeAddress().setLocation(newDto.getOfficeLoc());
		person.getOfficeAddress().setPhone(newDto.getOfficePhone());
		person.setIdProof(new IdProof());
		person.getIdProof().setProofType(newDto.getIdProofType());
		
		return person;
	}
	
}
