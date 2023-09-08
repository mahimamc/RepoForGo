package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Employee;
import com.app.repo.EmpRepository;

@Service
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	private EmpRepository repo;

	@Override
	public String upsert(Employee emp) {

		repo.save(emp);
		return "Operation completed successfully";
	}

	@Override
	public Employee getById(Integer Id) {

		Optional<Employee> findById=repo.findById(Id);
		if(findById.isPresent())
		{
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmps() {
		
		return repo.findAll();
	}

	@Override
	public String deleteById(Integer Id) {
		
			if(repo.existsById(Id))
			{
				repo.deleteById(Id);
				return "Delete Success";
			}
			else
			{
				return "No Record found";
			}

		
	}

}
