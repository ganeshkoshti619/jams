package com.jams.controller;

import com.jams.service.CompanyService;
import com.jams.entity.Company;
import com.jams.repository.CompanyRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController 
@RequestMapping ("/api/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<Company> getCompany() {
        return companyService.getCompany()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
