package com.banking.banksystem.repository;

import com.banking.banksystem.model.Employees;
import org.springframework.data.repository.CrudRepository;

public interface Employeesrepository extends CrudRepository<Employees, Integer> {
}
