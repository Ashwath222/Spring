package com.ashwath.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashwath.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends 
							JpaRepository<Employee, Integer> {

	//add a function to sort 
	public List<Employee> findAllByOrderByLastNameAsc();
}
