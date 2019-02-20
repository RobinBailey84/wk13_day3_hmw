package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/distilleries")
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping
    public List<Distillery> getAllDistilleries(){
        return distilleryRepository.findAll();
    }

    @GetMapping(value = "{region}")
    public List<Distillery> getAllDistilleriesByRegion(@PathVariable String region){
        return distilleryRepository.findDistilleryByRegion(region);
    }

    @GetMapping(value = "/whisky/{age}")
    public List<Distillery> findDistilleriesThatHaveWhiskyOfAge(@PathVariable int age){
        return distilleryRepository.findDistilleriesThatHaveWhiskyOfAge(age);
    }



}
