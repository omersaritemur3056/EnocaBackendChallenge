package com.example.demo.services.DTOs.responses.employee;

import com.example.demo.models.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeletedEmployeeResponse {

    private String id;

    private String firstName;

    private String lastName;

    private int age;

    private Gender gender;

    private double salary;

    private String companyId;
}
