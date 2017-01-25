package com.easytrade.easytradelib.Controller.mongo;

import com.easytrade.easytradelib.Exception.IdGenerationException;
import com.easytrade.easytradelib.model.MongoObject;
import com.easytrade.easytradelib.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by Sofy on 1/24/2017.
 */
@Component
public class MongoAction {
    private int MAX_CREATION_TRIALS = 10;

    @Inject
    private MongoController mongoController;

    public MongoObject createObject(MongoRepository repository, MongoObject mongoObject) throws IdGenerationException {
        ObjectMapper mapper = new ObjectMapper();
        String id = this.generateObjectId(repository);
        mongoObject.setId(id);
        return mongoController.createObject(repository, mongoObject);
    }

    /**
     * Generates user Id and returns Id only if it is unique
     *
     * @return the id
     * @throws IdGenerationException
     */
    private String generateObjectId(MongoRepository repository) throws IdGenerationException {
        boolean idCreated = false;
        String id = "";
        for (int i = 0; i <= MAX_CREATION_TRIALS; i++) {
            id = Long.toString((long) Math.floor(Math.random() * 1000000000));
            // check that id is unique across users
            User user = new User();
            user.setId(id);
            user = mongoController.getObjectById(repository, user);
            if (user == null) {
                idCreated = true;
                break;
            }
        }
        if (!idCreated) {
            throw new IdGenerationException();
        }
        return id;
    }
}
