package com.easytrade.easytraderest.Controller;

import com.easytrade.easytradelib.Controller.AbstractController;
import com.easytrade.easytradelib.Exception.IdGenerationException;
import com.easytrade.easytradelib.model.MongoObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Created by Sofy on 1/25/2017.
 */
public abstract class CommonRestController {
    private AbstractController controller;
    private Class type;

    public AbstractController getController() {
        return controller;
    }

    public void setController(AbstractController controller) {
        this.controller = controller;
    }

    public <T extends MongoObject> ResponseEntity<T> create(T object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            object = this.controller.create(object);
        } catch (IdGenerationException e) {
            return new ResponseEntity<T>((T) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<T>((T) object, HttpStatus.OK);
        //return new ResponseEntity<T>(object, HttpStatus.OK);
    }

    public <T extends MongoObject> ResponseEntity<T> getById(T object) {
        object = this.controller.getById(object);
        return new ResponseEntity<T>(object, HttpStatus.OK);
    }

    public <T extends MongoObject> ResponseEntity<List<T>> getAll(Class<T> type) {
        return new ResponseEntity<List<T>>(this.controller.getAll(type), HttpStatus.OK);
    }
}
