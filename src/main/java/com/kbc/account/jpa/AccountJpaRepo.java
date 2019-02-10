package com.kbc.account.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kbc.account.entity.Account;
@Repository
public interface AccountJpaRepo extends JpaRepository<Account, Long>{

}
