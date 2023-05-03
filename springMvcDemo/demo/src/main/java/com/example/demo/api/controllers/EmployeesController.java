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

import com.example.demo.services.EmployeeService;
import com.example.demo.services.DTOs.requests.employee.CreateEmployeeDto;
import com.example.demo.services.DTOs.requests.employee.UpdateEmployeeDto;
import com.example.demo.services.DTOs.responses.employee.CreatedEmployeeResponse;
import com.example.demo.services.DTOs.responses.employee.DeletedEmployeeResponse;
import com.example.demo.services.DTOs.responses.employee.GetAllEmployeeDto;
import com.example.demo.services.DTOs.responses.employee.UpdatedEmployeeResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/employees")
@AllArgsConstructor
public class EmployeesController {
    private EmployeeService employeeService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public CreatedEmployeeResponse add(@RequestBody CreateEmployeeDto createEmployeeDto) {
        return employeeService.add(createEmployeeDto);
    }

    @PutMapping
    @ResponseStatus(value = HttpStatus.OK)
    public UpdatedEmployeeResponse update(@RequestBody UpdateEmployeeDto updateEmployeeDto) {
        return employeeService.update(updateEmployeeDto);
    }

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.OK)
    public DeletedEmployeeResponse delete(@RequestParam String id) {
        return employeeService.delete(id);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<GetAllEmployeeDto> getAll() {
        return employeeService.getAll();
    }
}
