package com.springproject.Covid19Stats.controller;

import com.springproject.Covid19Stats.service.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoronaVirusDataController {

    @Autowired
    CoronaVirusDataService coronaVirusDataService;

    @GetMapping("/CoronaVirusData")
    public String home(Model model){
        model.addAttribute("data",coronaVirusDataService.getAllStates());
        model.addAttribute("data1", coronaVirusDataService.getAllStates2());
        return "home";
    }
}
