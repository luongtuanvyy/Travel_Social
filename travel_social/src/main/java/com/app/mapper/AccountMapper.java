package com.app.mapper;

import com.app.dto.AccountDto;
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

    public AccountDto accountUserDto (Account account){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT); // Chỉ định cấu hình nghiêm ngặt
        TypeMap<Account, AccountDto> typeMap = modelMapper.getTypeMap(Account.class, AccountDto.class);
        if (typeMap == null) {
            modelMapper.createTypeMap(Account.class, AccountDto.class)
                    .addMappings(mapper -> {
                        mapper.map(Account::getAccountname, AccountDto::setUser_name);

                        mapper.map(src -> src.getEmail(), AccountDto::setEmail);
                        mapper.map(src -> src.isGender(), AccountDto::setGender);
                        mapper.map(src -> src.getHotline(), AccountDto::setPhone_number);
                        mapper.map(src -> src.getAvatar(), AccountDto::setAvatar);
                        mapper.map(src -> src.getBirthday(), AccountDto::setBirth_day);
                        mapper.map(Account::getRole, AccountDto::setRole);
                    });}else{
            typeMap.map(account);
        }
        AccountDto accountUserDto = new AccountDto();
        accountUserDto =modelMapper.map(account, AccountDto.class);
        return accountUserDto;
    }

}
