package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.model.Register;
import com.example.demo.service.ServicesImpl;

@RestController
public class Controller {
	@Autowired
	ServicesImpl service;

	@PostMapping("/register")
	public ResponseEntity<Register> register(@RequestBody Register register) {
		return new ResponseEntity<Register>(service.saveRegister(register), HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<Iterable<Employee>> login() {
		return new ResponseEntity<Iterable<Employee>>(service.getall(), HttpStatus.OK);
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Integer id) {
		return service.delete(id);
	}

	@PostMapping("/add")
	public ResponseEntity<Employee> add(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(service.add(employee),HttpStatus.OK);
	}
	@PostMapping("/edit")
	public ResponseEntity<Employee> edit(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(service.edit(employee), HttpStatus.OK);
	}

}
