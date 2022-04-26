package com.ashwath.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashwath.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
