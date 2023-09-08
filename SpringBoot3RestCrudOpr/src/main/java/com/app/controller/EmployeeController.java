package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Employee;
import com.app.service.EmpService;

@RestController
public class EmployeeController {
		
		@Autowired
		private EmpService empService;
		
		@PostMapping("/emp")
		public ResponseEntity<String> createEmployee(@RequestBody Employee employee)
		{
			
				String status=empService.upsert(employee);
				return new ResponseEntity<>(status,HttpStatus.CREATED);
				
		}
		@GetMapping("/employee/{id}")
		public ResponseEntity<Employee> getEmployee(@PathVariable Integer id)
		{
					Employee emp=empService.getById(id);
					return new ResponseEntity<>(emp,HttpStatus.OK);
		}
		@GetMapping("/emps")
		public ResponseEntity<List<Employee>> getAllEmployees()
		{
			
				 List<Employee> allEmps=empService.getAllEmps();
				 return new ResponseEntity<>(allEmps,HttpStatus.OK);			
		}
		@PutMapping("/emp")
		public ResponseEntity<String> updateEmployee(@RequestBody Employee employee)
		{
			
				String status=empService.upsert(employee);
				return new ResponseEntity<>(status,HttpStatus.OK);
				
		}
		@DeleteMapping("/employee/{id}")
		public ResponseEntity<String> deleteEmployee(@PathVariable Integer id)
		{
					String status=empService.deleteById(id);
					return new ResponseEntity<>(status,HttpStatus.OK);
		}
		
}
