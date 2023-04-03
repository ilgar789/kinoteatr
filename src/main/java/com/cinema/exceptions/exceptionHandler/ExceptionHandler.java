package com.cinema.exceptions.exceptionHandler;

import com.cinema.exceptions.exception.CinemaException;
import com.cinema.exceptions.exception.ReservationException;
import com.cinema.exceptions.exception.SessionException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String>handlerInvalidArgument(MethodArgumentNotValidException ex){
        Map<String,String>errorMap=new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error->{
            errorMap.put(error.getField(),error.getDefaultMessage());
        });

        return errorMap;
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @org.springframework.web.bind.annotation.ExceptionHandler(CinemaException.class)
    public Map<String, String> handleCinemaException(CinemaException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", ex.getMessage());
        return errorMap;
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @org.springframework.web.bind.annotation.ExceptionHandler(ReservationException.class)
    public Map<String, String> handleReservationException(ReservationException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", ex.getMessage());
        return errorMap;
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @org.springframework.web.bind.annotation.ExceptionHandler(SessionException.class)
    public Map<String, String> handleSessionException(SessionException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", ex.getMessage());
        return errorMap;
    }
}
