package com.example.demo.wallet;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class CompanyController {
	@Autowired
	private CompanyRepository companyrepository;
	@PostMapping("/company")
	public company addNewCompany(@RequestBody company newcompany) {
		return this.companyrepository.save(newcompany);
	}
	@GetMapping("/companies")
	public Collection<company> getCompanies() {
		return this.companyrepository.findAll();
	}
}
