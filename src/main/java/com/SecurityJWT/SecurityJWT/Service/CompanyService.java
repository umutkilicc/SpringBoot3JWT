package com.SecurityJWT.SecurityJWT.Service;

import com.SecurityJWT.SecurityJWT.Dto.CompanyDto;
import com.SecurityJWT.SecurityJWT.Entity.Company;
import com.SecurityJWT.SecurityJWT.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<CompanyDto> getAll() {
        List<CompanyDto> companyDtoList = new ArrayList<>();
        companyRepository.findAll().forEach(company -> {
            CompanyDto companyDto = new CompanyDto();
            entityToDto(company, companyDto);
            companyDto.getUserInfo().setPassword(" ");
            companyDto.getUserInfo().setName(" ");
            companyDtoList.add(companyDto);

        });

        return companyDtoList;
    }

    protected void entityToDto(Company company, CompanyDto companyDto)
    {
        companyDto.setId(company.getId());
        companyDto.setCompanyName(company.getCompanyName());
        companyDto.setCompanyAddress(company.getCompanyAddress());
        companyDto.setUserInfo(company.getUserInfo());
    }





}
