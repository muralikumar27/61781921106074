package org.question1.question1calculator.controller;

import org.question1.question1calculator.response.Response;
import org.question1.question1calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculateController {
    @Autowired
    CalculatorService calculatorService;
    @GetMapping("numbers/{numberid}")
    public ResponseEntity<Response> getCalculated(@PathVariable("numberid") char id){
        Response response = calculatorService.getCalculatedValue(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
