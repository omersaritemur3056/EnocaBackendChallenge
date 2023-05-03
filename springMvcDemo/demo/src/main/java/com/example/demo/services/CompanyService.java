package com.example.demo.services;

import java.util.List;

import com.example.demo.services.DTOs.requests.company.CreateCompanyDto;
import com.example.demo.services.DTOs.requests.company.UpdateCompanyDto;
import com.example.demo.services.DTOs.responses.company.CreatedCompanyResponse;
import com.example.demo.services.DTOs.responses.company.DeletedCompanyResponse;
import com.example.demo.services.DTOs.responses.company.GetAllCompanyDto;
import com.example.demo.services.DTOs.responses.company.UpdatedCompanyResponse;

public interface CompanyService {

    CreatedCompanyResponse add(CreateCompanyDto createCompanyDto);

    UpdatedCompanyResponse update(UpdateCompanyDto updateCompanyDto);

    DeletedCompanyResponse delete(String id);

    List<GetAllCompanyDto> getAll();
}
