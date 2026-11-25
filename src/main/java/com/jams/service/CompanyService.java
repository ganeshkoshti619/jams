package com.jams.service;

import com.jams.entity.Company;
import com.jams.repository.CompanyRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Optional<Company> getCompany() {
        return companyRepository.findById(1L);
    }
}
