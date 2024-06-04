package org.question1.question1calculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthModel {

    private String companyName = "MuraliCalculator";
    private String        clientID = "74e77610-087f-4aa8-bf7f-c56022a994bf";
         private  String  clientSecret ="uEcRVNfTsZhvIeRt";
       private   String    ownerName = "Muralikumar";
          private String  ownerEmail = "muralikumar62345@gmail.com";
         private String   rollNo = "61781921106074";
}

