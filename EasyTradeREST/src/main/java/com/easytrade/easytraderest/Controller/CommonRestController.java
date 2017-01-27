package com.easytrade.easytraderest.Controller;

import com.easytrade.easytradelib.service.AbstractBasicService;
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
    private AbstractBasicService service;
    private Class type;

    public AbstractBasicService getService() {
        return service;
    }

    public void setService(AbstractBasicService service) {
        this.service = service;
    }

    public <T extends MongoObject> ResponseEntity<T> create(T object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            object = this.service.create(object);
        } catch (IdGenerationException e) {
            return new ResponseEntity<T>((T) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<T>((T) object, HttpStatus.OK);
        //return new ResponseEntity<T>(object, HttpStatus.OK);
    }

    public <T extends MongoObject> ResponseEntity<T> getById(T object) {
        object = this.service.getById(object);
        return new ResponseEntity<T>(object, HttpStatus.OK);
    }

    public <T extends MongoObject> ResponseEntity<List<T>> getAll(Class<T> type) {
        return new ResponseEntity<List<T>>(this.service.getAll(type), HttpStatus.OK);
    }
}
