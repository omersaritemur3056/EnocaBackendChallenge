package com.example.demo.services.DTOs.responses.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreatedCompanyResponse {

    private String id;
    private String companyName;
}
