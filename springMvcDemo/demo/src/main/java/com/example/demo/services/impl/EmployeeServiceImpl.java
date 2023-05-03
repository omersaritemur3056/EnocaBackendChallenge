package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.models.Employee;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.services.CompanyService;
import com.example.demo.services.EmployeeService;
import com.example.demo.services.DTOs.requests.employee.CreateEmployeeDto;
import com.example.demo.services.DTOs.requests.employee.UpdateEmployeeDto;
import com.example.demo.services.DTOs.responses.employee.CreatedEmployeeResponse;
import com.example.demo.services.DTOs.responses.employee.DeletedEmployeeResponse;
import com.example.demo.services.DTOs.responses.employee.GetAllEmployeeDto;
import com.example.demo.services.DTOs.responses.employee.UpdatedEmployeeResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final CompanyService companyService;

    @Override
    public CreatedEmployeeResponse add(CreateEmployeeDto createEmployeeDto) {

        Employee employee = new Employee();
        employee.setId(UUID.randomUUID().toString());
        employee.setFirstName(createEmployeeDto.getFirstName());
        employee.setLastName(createEmployeeDto.getLastName());
        employee.setAge(createEmployeeDto.getAge());
        employee.setSalary(createEmployeeDto.getSalary());
        employee.setGender(createEmployeeDto.getGender());
        employee.setCompany(companyService.findCompanyById(createEmployeeDto.getCompanyId()));

        Employee createdEmployee = employeeRepository.save(employee);

        CreatedEmployeeResponse response = new CreatedEmployeeResponse();
        response.setId(createdEmployee.getId());
        response.setFirstName(createdEmployee.getFirstName());
        response.setLastName(createdEmployee.getLastName());
        response.setAge(createdEmployee.getAge());
        response.setSalary(createdEmployee.getSalary());
        response.setGender(createdEmployee.getGender());
        response.setCompanyId(createEmployeeDto.getCompanyId());

        return response;
    }

    @Override
    public UpdatedEmployeeResponse update(UpdateEmployeeDto updateEmployeeDto) {
        Employee inDbEmployee = employeeRepository.findById(updateEmployeeDto.getId())
                .orElseThrow(() -> new RuntimeException("Entered Id not found in DB!"));

        Employee employee = new Employee();
        employee.setId(inDbEmployee.getId());
        employee.setFirstName(updateEmployeeDto.getFirstName());
        employee.setLastName(updateEmployeeDto.getLastName());
        employee.setAge(updateEmployeeDto.getAge());
        employee.setSalary(updateEmployeeDto.getSalary());
        employee.setGender(updateEmployeeDto.getGender());
        employee.setCompany(companyService.findCompanyById(updateEmployeeDto.getCompanyId()));

        Employee updatedEmployee = employeeRepository.save(employee);

        UpdatedEmployeeResponse response = new UpdatedEmployeeResponse();
        response.setId(updatedEmployee.getId());
        response.setFirstName(updatedEmployee.getFirstName());
        response.setLastName(updatedEmployee.getLastName());
        response.setAge(updatedEmployee.getAge());
        response.setSalary(updatedEmployee.getSalary());
        response.setGender(updatedEmployee.getGender());
        response.setCompanyId(updateEmployeeDto.getCompanyId());

        return response;
    }

    @Override
    public DeletedEmployeeResponse delete(String id) {
        Employee inDbEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entered Id not found in DB!"));

        DeletedEmployeeResponse response = new DeletedEmployeeResponse();
        response.setId(inDbEmployee.getId());
        response.setFirstName(inDbEmployee.getFirstName());
        response.setLastName(inDbEmployee.getLastName());
        response.setAge(inDbEmployee.getAge());
        response.setSalary(inDbEmployee.getSalary());
        response.setGender(inDbEmployee.getGender());
        response.setCompanyId(inDbEmployee.getCompany().getId());

        employeeRepository.delete(inDbEmployee);

        return response;
    }

    @Override
    public List<GetAllEmployeeDto> getAll() {
        List<Employee> employees = employeeRepository.findAll();
        List<GetAllEmployeeDto> response = new ArrayList<>();
        for (Employee employee : employees) {
            GetAllEmployeeDto dto = new GetAllEmployeeDto();
            dto.setId(employee.getId());
            dto.setFirstName(employee.getFirstName());
            dto.setLastName(employee.getLastName());
            dto.setAge(employee.getAge());
            dto.setSalary(employee.getSalary());
            dto.setGender(employee.getGender());
            dto.setCompanyId(employee.getCompany().getId());
            response.add(dto);
        }

        return response;
    }

}
