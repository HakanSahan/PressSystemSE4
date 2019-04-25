package be.springPressOrder.controllers;

import groovy.util.logging.Log4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
@Log4j
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    public String handleEmptyFieldException(Exception e){
        return "/error/403";
    }

}
