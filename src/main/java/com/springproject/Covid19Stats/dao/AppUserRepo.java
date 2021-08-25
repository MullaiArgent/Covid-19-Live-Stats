package com.springproject.Covid19Stats.dao;

import com.springproject.Covid19Stats.models.AppUser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
@Repository
public interface AppUserRepo {
    Optional<AppUser> findByEmail(String email);
}
