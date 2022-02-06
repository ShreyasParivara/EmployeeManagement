package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;
import com.example.demo.model.Register;
@Repository
public interface Dao extends CrudRepository<Employee, Integer>{
	
}
