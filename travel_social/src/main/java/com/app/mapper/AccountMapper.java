package com.app.mapper;

import com.app.dto.AccountCompanyDto;
import com.app.dto.AccountUserDto;
import com.app.entity.Account;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    @Autowired
    ModelMapper modelMapper;

    public AccountUserDto accountUserDto (Account account){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT); // Chỉ định cấu hình nghiêm ngặt
        TypeMap<Account, AccountUserDto> typeMap = modelMapper.getTypeMap(Account.class, AccountUserDto.class);
        if (typeMap == null) {
            modelMapper.createTypeMap(Account.class, AccountUserDto.class)
                    .addMappings(mapper -> {
                        mapper.map(Account::getUser_name, AccountUserDto::setUser_name);

                        mapper.map(src -> src.getUser().getEmail(), AccountUserDto::setEmail);
                        mapper.map(src -> src.getUser().getGender(), AccountUserDto::setGender);
                        mapper.map(src -> src.getUser().getPhone_number(), AccountUserDto::setPhone_number);
                        mapper.map(src -> src.getUser().getAvatar(), AccountUserDto::setAvatar);
                        mapper.map(src -> src.getUser().getBirth_day(), AccountUserDto::setBirth_day);
                        mapper.map(Account::getRole, AccountUserDto::setRole);
                    });}else{
            typeMap.map(account);
        }
        AccountUserDto accountUserDto = new AccountUserDto();
        accountUserDto =modelMapper.map(account, AccountUserDto.class);
        return accountUserDto;
    }
    public AccountCompanyDto accountCompanyDto(Account account){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT); // Chỉ định cấu hình nghiêm ngặt
        TypeMap<Account, AccountCompanyDto> typeMap = modelMapper.getTypeMap(Account.class, AccountCompanyDto.class);
        if (typeMap == null) {
            modelMapper.createTypeMap(Account.class, AccountCompanyDto.class)
                    .addMappings(mapper -> {
                        mapper.map(Account::getUser_name, AccountCompanyDto::setUser_name);
                        mapper.map(Account::getRole, AccountCompanyDto::setRole);
                        mapper.map(src -> src.getCompany().getName(), AccountCompanyDto::setName);
                        mapper.map(src -> src.getCompany().getVIP(), AccountCompanyDto::setVip);
                        mapper.map(src -> src.getCompany().getAddress(), AccountCompanyDto::setAddress);
                        mapper.map(src -> src.getCompany().getEmail(), AccountCompanyDto::setEmail);

                        mapper.map(src -> src.getCompany().getDescription(), AccountCompanyDto::setDecription);
                    });}
        AccountCompanyDto accountCompanyDto = new AccountCompanyDto();
        accountCompanyDto =modelMapper.map(account, AccountCompanyDto.class);
        return accountCompanyDto ;
    }
}
