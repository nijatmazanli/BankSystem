package com.banking.banksystem.repository;

import com.banking.banksystem.model.Loans;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoansRepository extends JpaRepository<Loans, Long> {
}
