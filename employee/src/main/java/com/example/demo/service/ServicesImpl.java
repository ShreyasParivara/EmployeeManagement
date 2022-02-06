package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Dao;
import com.example.demo.dao.DaoRegister;
import com.example.demo.model.Employee;
import com.example.demo.model.Register;

@Service
public class ServicesImpl implements UserDetailsService {
	@Autowired
	Dao dao;
	@Autowired
	DaoRegister daoReg;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		return (UserDetails) daoReg.getRegisterByUsername(username);
	}
	
	public Register saveRegister(Register register) {
		
		return daoReg.save(register);
	}
	
	public Iterable<Employee> getall() {
		return dao.findAll();
	}
	
	public void delete(Integer id) {
		dao.deleteById(id);
	}
	
	public Employee add(Employee employee) {
		return dao.save(employee);
	}

}
