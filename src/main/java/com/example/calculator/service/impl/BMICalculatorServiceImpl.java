package com.example.calculator.service.impl;

import com.example.calculator.model.Person;
import com.example.calculator.model.response.PersonBMIResponse;
import com.example.calculator.service.BMICalculatorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BMICalculatorServiceImpl implements BMICalculatorService {

    @Override
    public List<PersonBMIResponse> bmiCalculate(List<Person> personList) {
        return personList.stream().map(this::calculateHealthRisk).collect(Collectors.toList());

    }

    @Override
    public long getOverweightCount(List<Person> personList) {
        List<PersonBMIResponse> list = personList.stream().map(this::calculateHealthRisk).collect(Collectors.toList());
        return list.stream().filter(personBMIResponse -> personBMIResponse.getBMICategory().equalsIgnoreCase("Overweight")).count();
    }

    private PersonBMIResponse calculateHealthRisk(Person person) {
        if (person != null) {
            double heightMetre= person.getHeightCm()* 0.01;
            double bmi = person.getWeightKg() / (heightMetre * heightMetre);
            if (bmi <= 18.4) {
                return new  PersonBMIResponse(bmi,"Underweight","Malnutrition risk");
            } else if (bmi >= 18.5 && bmi <= 24.9) {
                return new PersonBMIResponse(bmi,"Normal weight","Low risk");

            } else if (bmi >= 25 && bmi <= 29.9) {
                return new PersonBMIResponse(bmi,"Overweight","Enhanced risk");

            } else if (bmi >= 30 && bmi <= 34.9) {
                return new PersonBMIResponse(bmi,"Moderately obese","Medium risk");

            } else if (bmi >= 35 && bmi <= 39.9) {
                return new PersonBMIResponse(bmi,"Severely obese","High risk");

            } else if (bmi >= 40) {
                return new PersonBMIResponse(bmi,"Very severely obese","Very high risk");
            }
        }
        return null;

    }

}
