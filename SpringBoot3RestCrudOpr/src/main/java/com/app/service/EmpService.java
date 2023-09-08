package com.app.service;

import java.util.List;

import com.app.model.Employee;

public interface EmpService {
	
	public String upsert(Employee emp);
	
	public Employee getById(Integer Id);
	
	public List<Employee> getAllEmps();
	
	public String deleteById(Integer Id);

}
