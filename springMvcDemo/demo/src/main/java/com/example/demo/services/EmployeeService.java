package com.example.demo.services;

import java.util.List;

import com.example.demo.services.DTOs.requests.employee.CreateEmployeeDto;
import com.example.demo.services.DTOs.requests.employee.UpdateEmployeeDto;
import com.example.demo.services.DTOs.responses.employee.CreatedEmployeeResponse;
import com.example.demo.services.DTOs.responses.employee.DeletedEmployeeResponse;
import com.example.demo.services.DTOs.responses.employee.GetAllEmployeeDto;
import com.example.demo.services.DTOs.responses.employee.UpdatedEmployeeResponse;

public interface EmployeeService {

    CreatedEmployeeResponse add(CreateEmployeeDto createEmployeeDto);

    UpdatedEmployeeResponse update(UpdateEmployeeDto updateEmployeeDto);

    DeletedEmployeeResponse delete(String id);

    List<GetAllEmployeeDto> getAll();
}
