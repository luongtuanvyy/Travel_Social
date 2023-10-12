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
                        mapper.map(Account::getAccountname, AccountUserDto::setUser_name);

                        mapper.map(src -> src.getEmail(), AccountUserDto::setEmail);
                        mapper.map(src -> src.isGender(), AccountUserDto::setGender);
                        mapper.map(src -> src.getHotline(), AccountUserDto::setPhone_number);
                        mapper.map(src -> src.getAvatar(), AccountUserDto::setAvatar);
                        mapper.map(src -> src.getBirthday(), AccountUserDto::setBirth_day);
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
                        mapper.map(Account::getAccountname, AccountCompanyDto::setUser_name);
                        mapper.map(Account::getRole, AccountCompanyDto::setRole);
                        mapper.map(src -> src.getName(), AccountCompanyDto::setName);
                        mapper.map(src -> src.getAddress(), AccountCompanyDto::setAddress);
                        mapper.map(src -> src.getEmail(), AccountCompanyDto::setEmail);
                        mapper.map(src -> src.isVip(), AccountCompanyDto :: setVip);

                        mapper.map(src -> src.getDescription(), AccountCompanyDto::setDecription);
                    });}
        AccountCompanyDto accountCompanyDto = new AccountCompanyDto();
        accountCompanyDto =modelMapper.map(account, AccountCompanyDto.class);
        return accountCompanyDto ;
    }
}
