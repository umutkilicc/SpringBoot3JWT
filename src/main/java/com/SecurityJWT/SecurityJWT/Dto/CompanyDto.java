package com.SecurityJWT.SecurityJWT.Dto;

import com.SecurityJWT.SecurityJWT.Entity.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CompanyDto {

    private Long id;
    private String companyName;
    private String companyAddress;
    private UserInfo userInfo;
}
