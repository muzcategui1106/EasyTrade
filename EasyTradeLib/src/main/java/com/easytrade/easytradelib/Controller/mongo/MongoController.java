package com.easytrade.easytradelib.Controller.mongo;

import com.easytrade.easytradelib.model.MongoObject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

/**
 * Created by muzcategui1106 on 1/24/2017.
 */

@Component
public class MongoController {
    public <T extends MongoRepository, E extends MongoObject> E getObjectById(T repository, E mongoObject) {
        return (E) repository.findOne(mongoObject.getId());
    }

    public <T extends MongoRepository, E extends MongoObject> E createObject(T repository, E mongoObject) {
        return (E) repository.save(mongoObject);
    }
}
