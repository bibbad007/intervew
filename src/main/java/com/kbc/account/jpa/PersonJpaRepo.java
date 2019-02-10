package com.kbc.account.jpa;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kbc.account.entity.Address;
import com.kbc.account.entity.Person;

@Repository
@Transactional()
public class PersonJpaRepo {
	@PersistenceContext
	EntityManager entityManager;
	
	public Person findById(long id){
		return entityManager.find(Person.class, id);
	}	
	
	public Person updateOrInsert(Person person){
		return entityManager.merge(person);
	}	
	
	public void deleteById(long id){	
		entityManager.remove(findById(id));
	}
	
	public List<Person> findAll(){
		TypedQuery<Person> namedQuery=entityManager.createNamedQuery("find_all_persons",Person.class);
		return namedQuery.getResultList();
	}
}
