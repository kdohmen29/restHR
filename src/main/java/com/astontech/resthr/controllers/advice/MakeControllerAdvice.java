package com.astontech.resthr.controllers.advice;


import com.astontech.resthr.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MakeControllerAdvice {

    @ResponseBody
    @ExceptionHandler(MakeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String makeNotFoundHandler(MakeNotFoundException mEx) {
        return mEx.getLocalizedMessage();
    }


    @ResponseBody
    @ExceptionHandler(ModelNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String modelNotFoundHandler(ModelNotFoundException mEx) {return mEx.getLocalizedMessage();}


    @ResponseBody
    @ExceptionHandler(VehicleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String  vehicleNotFoundHandler(VehicleNotFoundException vEx) {return vEx.getLocalizedMessage();}


    @ResponseBody
    @ExceptionHandler(MakeAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String  makeAlreadyExistsException(MakeAlreadyExistsException vEx) {return vEx.getLocalizedMessage();}

    @ResponseBody
    @ExceptionHandler(ModelAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String  modelAlreadyExistsException(ModelAlreadyExistsException vEx) {return vEx.getLocalizedMessage();}

    @ResponseBody
    @ExceptionHandler(VinAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String  vinAlreadyExistsException(VinAlreadyExistsException vEx) {return vEx.getLocalizedMessage();}
}
