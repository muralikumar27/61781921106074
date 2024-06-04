package org.question1.question1calculator.service;

import org.question1.question1calculator.model.AuthModel;
import org.question1.question1calculator.response.Response;
import org.question1.question1calculator.response.ResponseValue;
import org.question1.question1calculator.util.AuthResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.rmi.ServerException;
import java.util.*;

@Service
public class CalculatorServiceImplementation implements CalculatorService{

    private final AuthModel authModel = new AuthModel();
    private final RestClient restClient;
    private Set<Integer> uniqueNumbers = new HashSet<>();
    private final int cap = 10;
    public CalculatorServiceImplementation(RestClient restClient) {
        this.restClient = restClient;
    }
    Queue<Integer> queue= new LinkedList<>();

    @Override
    public Response getCalculatedValue(char param) {
        AuthResult result = getAuthResult();
        String token = result.getAccess_token();
        String type = result.getToken_type();
        Long date = result.getExpires_in();
        String url = null;
        if(param == 'p')
            url = "http://20.244.56.144/test/primes";
        else if(param == 'f')
            url = "http://20.244.56.144/test/fibo";
        else if (param == 'r') {
            url = "http://20.244.56.144/test/rand";
        } else if (param == 'e') {
            url = "http://20.244.56.144/test/even";
        }
        ResponseValue responseValue = restClient.get()
                .uri(url)
                .header("Authorization" ,type+" "+token)
                .retrieve()
                .body(ResponseValue.class);

        List<Integer> numbers = responseValue.getNumbers();
        List<Integer> prevState = new ArrayList<>(queue);

        for (Integer number : numbers) {
            if (!uniqueNumbers.contains(number)) {
                if (queue.size() >= cap) {
                    Integer removed = queue.poll();
                    uniqueNumbers.remove(removed);
                }
                queue.add(number);
                uniqueNumbers.add(number);
            }
        }

        List<Integer> currState = new ArrayList<>(queue);
        int avg = calculateAverage(queue);

        Response response = new Response(numbers, prevState, currState, avg);
        return response;
    }
    private int calculateAverage(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (int number : queue) {
            sum += number;
        }
        return sum /queue.size();
    }
    private AuthResult getAuthResult(){

        AuthResult authResult = restClient.post()
                .uri( "http://20.244.56.144/test/auth")
                .body (authModel)
                .retrieve()
                .body(AuthResult.class);

        return authResult;
    }

}
