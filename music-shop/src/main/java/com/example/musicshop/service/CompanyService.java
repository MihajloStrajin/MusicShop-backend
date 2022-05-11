package com.example.musicshop.service;

import com.example.musicshop.constants.ErrorCodes;
import com.example.musicshop.dto.company.CreateCompanyDto;
import com.example.musicshop.dto.company.UpdateCompanyDto;
import com.example.musicshop.entity.Company;
import com.example.musicshop.exception.ConflictException;
import com.example.musicshop.exception.NotFoundException;
import com.example.musicshop.mapper.CompanyMapper;
import com.example.musicshop.repository.CompanyRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyMapper companyMapper;

    public Company create(CreateCompanyDto createCompanyDto) {
        if (companyRepository.findByName(createCompanyDto.getName()) != null
                || companyRepository.findByPib(createCompanyDto.getPib()) != null) {
            throw new ConflictException(ErrorCodes.COMPANY_FOUND);
        }

        Company create = companyMapper.mapToEntity(createCompanyDto);

        return companyRepository.save(create);
    }

    public Company getCompany(String uuid){
        return companyRepository.findById(uuid).orElseThrow(()->{
            throw new NotFoundException(ErrorCodes.COMPANY_NOT_FOUND);
        });
    }

    public List<Company> getCompanies(){
        return companyRepository.findAll();
    }

    public void delete(String uuid){
        Company delete = getCompany(uuid);

        companyRepository.delete(delete);
    }

    public Company update(String uuid, UpdateCompanyDto updateCompanyDto){
        Company update = getCompany(uuid);

        if (companyRepository.findByName(updateCompanyDto.getName()) != null
                || companyRepository.findByPib(updateCompanyDto.getPib()) != null) {
            throw new ConflictException(ErrorCodes.COMPANY_FOUND);
        }

        update = companyMapper.update(updateCompanyDto, update);

        return companyRepository.save(update);
    }
}
