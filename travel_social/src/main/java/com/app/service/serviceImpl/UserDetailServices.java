//package com.app.service.serviceImpl;
//
//import com.app.entity.Account;
//import com.app.service.AccountServices;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserDetailServices implements UserDetailsService {
//    @Autowired
//    AccountServices accountServices;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        System.out.println("uusername "+ username);
//        Account account =accountServices.findByUsername(username).orElseThrow(()->{
//            throw new UsernameNotFoundException("Can not find this account");
//        });
//        return UserDetail.creat(account);
//    }
//    public UserDetails loadUserById(Integer id) throws UsernameNotFoundException {
//        Account account =accountServices.findById(id).orElseThrow(()->{
//            throw new UsernameNotFoundException("Can not find this account");
//        });
//        return UserDetail.creat(account);
//    }
//}
