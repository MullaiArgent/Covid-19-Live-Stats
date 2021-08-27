package com.springproject.Covid19Stats.registeration.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConfirmationTokenRepo extends JpaRepository<ConfirmationToken, Long> {

    Optional<ConfirmationToken> findByToken(Long aLong);
}
