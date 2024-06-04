package org.question1.question1calculator.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private List<Integer> numbers;
    private List<Integer>windowPreState;
    private  List<Integer> windowCurrState;
    private int avg;
}
