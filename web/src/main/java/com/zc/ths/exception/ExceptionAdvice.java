package com.zc.ths.exception;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Log4j2
public class ExceptionAdvice {

    @ExceptionHandler({NullPointerException.class, IndexOutOfBoundsException.class})
    public String handleException(Exception e){
        log.error(e);
        return e.getMessage();
    }

}
