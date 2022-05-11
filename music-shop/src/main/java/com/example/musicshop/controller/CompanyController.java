package com.example.musicshop.controller;

import com.example.musicshop.dto.company.CompanyResponseDto;
import com.example.musicshop.dto.company.CreateCompanyDto;
import com.example.musicshop.dto.company.UpdateCompanyDto;
import com.example.musicshop.mapper.CompanyMapper;
import com.example.musicshop.service.CompanyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CompanyMapper companyMapper;

    @GetMapping
    public List<CompanyResponseDto> getCompanies(){
        return companyMapper.mapEntityToResponse(companyService.getCompanies());
    }

    @GetMapping("/{uuid}")
    public CompanyResponseDto getCompany(@PathVariable String uuid){
        return companyMapper.mapEntityToResponse(companyService.getCompany(uuid));
    }

    @PostMapping
    public CompanyResponseDto create(@RequestBody CreateCompanyDto createCompanyDto){
        return companyMapper.mapEntityToResponse(companyService.create(createCompanyDto));
    }

    @PutMapping("/{uuid}")
    public CompanyResponseDto update(@PathVariable String uuid, @RequestBody UpdateCompanyDto updateCompanyDto){
        return companyMapper.mapEntityToResponse(companyService.update(uuid, updateCompanyDto));
    }

    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable String uuid){
        companyService.delete(uuid);
    }
}
