package com.springproject.Covid19Stats.registeration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/register")
@AllArgsConstructor
public class UserRegistrationController {
    private final UserRegistrationService userRegistrationService;

    @PostMapping
    public String register(@RequestBody UserRegistrationRequest request){
                return userRegistrationService.register(request);
    }
    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token")String token){
        return userRegistrationService.confirmToken(token);
    }
}
