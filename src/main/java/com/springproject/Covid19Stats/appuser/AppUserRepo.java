package com.springproject.Covid19Stats.appuser;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
@Repository
public interface AppUserRepo {
    Optional<AppUser> findByEmail(String email);
}
