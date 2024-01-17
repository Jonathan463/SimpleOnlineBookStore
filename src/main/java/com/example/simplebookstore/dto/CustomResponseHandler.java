package com.example.simplebookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomResponseHandler {
    public static ResponseEntity<?> responseBuilder(String message, int httpStatus, Object responseObj){
        Map<String, Object> response = new HashMap<>();
        if(httpStatus == 200 || httpStatus == 201 || httpStatus == 202){
            response.put("responseMsg", message);
            response.put("responseCode", "200");
            response.put("data", responseObj);
        }
        else{
            response.put("responseMsg", message);
            response.put("responseCode", "404");
            response.put("data", responseObj);
        }
        return new ResponseEntity<>(response, HttpStatus.valueOf(httpStatus));
    }
}
