package com.app.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Employee;

public interface EmpRepository extends JpaRepository<Employee,Serializable> {

}
