package com.example.calculator.service;

import com.example.calculator.model.Person;
import com.example.calculator.model.response.PersonBMIResponse;
import com.example.calculator.service.impl.BMICalculatorServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class BMICalculatorServiceImplTest {

    @InjectMocks
    private BMICalculatorServiceImpl bmiCalculatorService;

    @Test
    void calculateBMI() {

        List<Person> personList = getPerSionList();
        List<PersonBMIResponse> actualResult = bmiCalculatorService.bmiCalculate(personList);
        List<PersonBMIResponse> expectedResult = getMockResult();
        assertEquals(actualResult, expectedResult);
    }

    private List<PersonBMIResponse> getMockResult() {
        return List.of(new PersonBMIResponse(32.83061454806607,"Moderately obese","Medium risk"),
                new PersonBMIResponse(32.79194475521777,"Moderately obese","Medium risk"),
                new PersonBMIResponse(23.76543209876543,"Normal weight","Low risk"),
                new PersonBMIResponse(22.499637102627375,"Normal weight","Low risk"),
                new PersonBMIResponse(31.11111111111111,"Moderately obese","Medium risk"),
                new PersonBMIResponse(29.402273297715947,"Overweight","Enhanced risk"));

    }

    private List<Person> getPerSionList() {
        return List.of(new Person("Male", 171L, 96L),
                new Person("Male", 161L, 85L),
                new Person("Male", 180L, 77L),
                new Person("Female", 166L, 62L),
                new Person("Female", 150L, 70L),
                new Person("Female", 167L, 82L));

    }

    @Test
    void calculateCountOverWeight() {

        List<Person> personList = getPerSionList();
        long actualResult = bmiCalculatorService.getOverweightCount(personList);
        assertEquals(actualResult, 1);
    }
}
