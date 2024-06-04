package org.question1.question1calculator.service;

import org.question1.question1calculator.response.Response;
import org.question1.question1calculator.response.ResponseValue;

public interface CalculatorService {
    Response getCalculatedValue(char param);
}
