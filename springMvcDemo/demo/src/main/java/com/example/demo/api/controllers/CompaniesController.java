package com.example.demo.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.CompanyService;
import com.example.demo.services.DTOs.requests.company.CreateCompanyDto;
import com.example.demo.services.DTOs.requests.company.UpdateCompanyDto;
import com.example.demo.services.DTOs.responses.company.CreatedCompanyResponse;
import com.example.demo.services.DTOs.responses.company.DeletedCompanyResponse;
import com.example.demo.services.DTOs.responses.company.GetAllCompanyDto;
import com.example.demo.services.DTOs.responses.company.UpdatedCompanyResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/companies")
@AllArgsConstructor
public class CompaniesController {
    private CompanyService companyService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public CreatedCompanyResponse add(@RequestBody CreateCompanyDto createCompanyDto) {
        return companyService.add(createCompanyDto);
    }

    @PutMapping
    @ResponseStatus(value = HttpStatus.OK)
    public UpdatedCompanyResponse update(@RequestBody UpdateCompanyDto updateCompanyDto) {
        return companyService.update(updateCompanyDto);
    }

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.OK)
    public DeletedCompanyResponse delete(@RequestParam String id) {
        return companyService.delete(id);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<GetAllCompanyDto> getAll() {
        return companyService.getAll();
    }
}
