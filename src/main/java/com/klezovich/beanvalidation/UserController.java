package com.klezovich.beanvalidation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @PostMapping("/users")
    ResponseEntity<String> addUser(@Valid @RequestBody User user) {
        // persisting the user
        return ResponseEntity.ok("User is valid");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {

        var fieldNameToErrorMap = new HashMap<String, String>();

        var errors = ex.getBindingResult().getAllErrors();

        for(var error: errors) {
            var fieldName = ((FieldError) error).getField();
            var errorMessage = error.getDefaultMessage();
            fieldNameToErrorMap.put(fieldName, errorMessage);
        }

        return fieldNameToErrorMap;
    }

}