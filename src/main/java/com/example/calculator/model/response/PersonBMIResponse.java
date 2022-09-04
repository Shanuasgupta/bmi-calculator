package com.example.calculator.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonBMIResponse {

    private double BMI;
    private  String BMICategory;
    private  String healthRisk;
}
