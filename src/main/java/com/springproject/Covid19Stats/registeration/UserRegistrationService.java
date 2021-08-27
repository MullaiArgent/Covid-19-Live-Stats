package com.springproject.Covid19Stats.registeration;

import com.springproject.Covid19Stats.appuser.AppUser;
import com.springproject.Covid19Stats.appuser.AppUserRole;
import com.springproject.Covid19Stats.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserRegistrationService {
    private final AppUserService appUserService;
    private final EmailValidator emailValidator;
    public String register(UserRegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if(!isValidEmail){
            throw new IllegalStateException("Email not Valid");
        }
        return appUserService.signUpUser(new AppUser(
                request.getFirstname(),
                request.getLastname(),
                request.getEmail(),
                request.getPassword(),
                AppUserRole.USER_ROLE
        ));
    }
}
