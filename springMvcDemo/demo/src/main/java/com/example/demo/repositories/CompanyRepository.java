package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Company;

public interface CompanyRepository extends JpaRepository<Company, String> {

}
