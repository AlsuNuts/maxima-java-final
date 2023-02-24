package controller;

import exceptions.DrugNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

//этот клас возвращает exception для вызова несуществующего кота
@ControllerAdvice
public class DrugNotFoundAdvice {


    @ResponseBody
    @ExceptionHandler(DrugNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String CatNotFoundHandler(DrugNotFoundException ex){
        return ex.getMessage();
    }
}
