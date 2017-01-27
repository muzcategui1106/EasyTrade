package com.easytrade.easytradelib.service;

import com.easytrade.easytradelib.Controller.mongo.MongoAction;
import com.easytrade.easytradelib.Exception.IdGenerationException;
import com.easytrade.easytradelib.model.MongoObject;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by muzcategui1106 on 1/25/2017.
 */
public abstract class AbstractBasicService {
    private MongoRepository repository;
    @Inject
    private MongoAction mongoAction;

    public MongoRepository getRepository() {
        return repository;
    }

    public void setRepository(MongoRepository repository) {
        this.repository = repository;
    }

    public <T extends MongoObject> T create(T object) throws IdGenerationException {
        return (T) mongoAction.createObject(repository, object);
    }

    public <T extends MongoObject> T getById(T object) {
        return (T) mongoAction.getObjectById(repository, object);
    }


    public <T extends MongoObject> List<T> getAll(Class<T> type) {
        return (List<T>) mongoAction.getAllObjects(repository, type);
    }

}
