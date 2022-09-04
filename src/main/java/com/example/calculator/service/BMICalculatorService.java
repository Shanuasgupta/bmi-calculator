package com.example.calculator.service;

import com.example.calculator.model.Person;
import com.example.calculator.model.response.PersonBMIResponse;

import java.util.List;


public interface BMICalculatorService {

    public List<PersonBMIResponse> bmiCalculate(List<Person> personList);

    long getOverweightCount(List<Person> personList);
}
