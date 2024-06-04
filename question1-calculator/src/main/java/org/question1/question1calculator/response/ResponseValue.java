package org.question1.question1calculator.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseValue {
   private List<Integer> numbers;
}
