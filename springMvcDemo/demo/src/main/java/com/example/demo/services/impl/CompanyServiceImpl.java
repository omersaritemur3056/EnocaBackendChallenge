package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.models.Company;
import com.example.demo.repositories.CompanyRepository;
import com.example.demo.services.CompanyService;
import com.example.demo.services.DTOs.requests.company.CreateCompanyDto;
import com.example.demo.services.DTOs.requests.company.UpdateCompanyDto;
import com.example.demo.services.DTOs.responses.company.CreatedCompanyResponse;
import com.example.demo.services.DTOs.responses.company.DeletedCompanyResponse;
import com.example.demo.services.DTOs.responses.company.GetAllCompanyDto;
import com.example.demo.services.DTOs.responses.company.UpdatedCompanyResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public CreatedCompanyResponse add(CreateCompanyDto createCompanyDto) {

        Company company = new Company();
        company.setId(UUID.randomUUID().toString());
        company.setCompanyName(createCompanyDto.getCompanyName());

        Company createdCompany = companyRepository.save(company);

        CreatedCompanyResponse response = new CreatedCompanyResponse();
        response.setId(createdCompany.getId());
        response.setCompanyName(createdCompany.getCompanyName());

        return response;
    }

    @Override
    public UpdatedCompanyResponse update(UpdateCompanyDto updateCompanyDto) {
        Company inDbCompany = companyRepository.findById(updateCompanyDto.getId())
                .orElseThrow(() -> new RuntimeException("Entered Id not found in DB!"));

        Company company = new Company();
        company.setId(inDbCompany.getId());
        company.setCompanyName(updateCompanyDto.getCompanyName());

        Company updatedCompany = companyRepository.save(company);

        UpdatedCompanyResponse response = new UpdatedCompanyResponse();
        response.setId(updatedCompany.getId());
        response.setCompanyName(updatedCompany.getCompanyName());

        return response;
    }

    @Override
    public DeletedCompanyResponse delete(String id) {
        Company inDbCompany = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entered Id not found in DB!"));

        DeletedCompanyResponse response = new DeletedCompanyResponse();
        response.setId(inDbCompany.getId());
        response.setCompanyName(inDbCompany.getCompanyName());

        companyRepository.delete(inDbCompany);

        return response;
    }

    @Override
    public List<GetAllCompanyDto> getAll() {
        List<Company> companies = companyRepository.findAll();
        List<GetAllCompanyDto> response = new ArrayList<>();
        for (Company company : companies) {
            response.add(new GetAllCompanyDto(company.getId(), company.getCompanyName()));
        }

        return response;
    }

    @Override
    public Company findCompanyById(String id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entered companyId not found in DB!"));
    }

}
