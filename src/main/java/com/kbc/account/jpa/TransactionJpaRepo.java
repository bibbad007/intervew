package com.kbc.account.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kbc.account.entity.Transaction;

@Repository
@Transactional()
public class TransactionJpaRepo {
	@PersistenceContext
	EntityManager entityManager;
	
	public Transaction findById(long id){
		return entityManager.find(Transaction.class, id);
	}	
	
	public Transaction updateOrInsert(Transaction transaction){
		return entityManager.merge(transaction);
	}	
	
	public List<Transaction> findAllForAccount(long pid){
		List<Transaction> namedQuery=entityManager.createNamedQuery("find_all_from_account",Transaction.class).setParameter("pid",pid).getResultList(); 
		return namedQuery;
	}


}
