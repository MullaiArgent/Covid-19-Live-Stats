package com.springproject.Covid19Stats.service;

import com.springproject.Covid19Stats.dao.AppUserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService{
    private final String USER_NOT_FOUND_MSG = "user with email %s Not Found";
    private final AppUserRepo appUserRepo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return appUserRepo.findByEmail(s).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG,s)));
    }
}
