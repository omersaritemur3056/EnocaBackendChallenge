package com.example.demo.services.DTOs.requests.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateCompanyDto {

    private String id;
    private String companyName;
}
