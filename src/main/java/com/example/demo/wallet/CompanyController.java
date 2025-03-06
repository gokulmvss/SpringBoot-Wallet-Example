package com.example.demo.wallet;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class CompanyController {
	@Autowired
	private CompanyRepository companyrepository;
	@PostMapping("/company")
	public Company addNewCompany(@RequestBody Company newcompany) {
		return this.companyrepository.save(newcompany);
	}
	@GetMapping("/companies")
	public Collection<Company> getCompanies() {
		return this.companyrepository.findAll();
	}
}
