package com.springproject.Covid19Stats.registeration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/register")
@AllArgsConstructor
public class UserRegistrationController {
    private UserRegistrationService userRegistrationService;
    public String register(@RequestBody UserRegistrationRequest request){
                return userRegistrationService.register(request);
            }
}