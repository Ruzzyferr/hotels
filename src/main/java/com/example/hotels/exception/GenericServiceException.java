package com.example.hotels.exception;


import com.example.hotels.enums.ErrorType;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class GenericServiceException extends RuntimeException {

    private ErrorType errorType;

    private String description;

}
