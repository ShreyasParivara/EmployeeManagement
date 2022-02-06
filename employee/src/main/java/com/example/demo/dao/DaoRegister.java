package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Register;
@Repository
public interface DaoRegister extends JpaRepository<Register, Integer> {
	@Query("select emailaddress,password from Register where emailaddress=:name")
	public Register getRegisterByUsername(String name);

}
