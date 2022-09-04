package com.example.calculator.controller;

import com.example.calculator.model.Person;
import com.example.calculator.model.response.PersonBMIResponse;
import com.example.calculator.service.BMICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BMICalculatorController {

    @Autowired
    BMICalculatorService bmiCalculatorService;

    @PostMapping("/calculate-bmi")
    public List<PersonBMIResponse> calculateBMI(@RequestBody List<Person> personList) {

        return bmiCalculatorService.bmiCalculate(personList);
    }

    @PostMapping("/count-overweight")
    public long getOverweightCount(@RequestBody List<Person> personList) {

        return bmiCalculatorService.getOverweightCount(personList);
    }
}
