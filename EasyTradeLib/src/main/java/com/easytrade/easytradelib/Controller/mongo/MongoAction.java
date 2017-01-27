package com.easytrade.easytradelib.Controller.mongo;

import com.easytrade.easytradelib.Exception.IdGenerationException;
import com.easytrade.easytradelib.model.MongoObject;
import com.easytrade.easytradelib.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by muzcategui1106 on 1/24/2017.
 */
@Component
public class MongoAction {
    private int MAX_CREATION_TRIALS = 10;

    @Inject
    private MongoController mongoController;

    /**
     * Creates a mongo object. Returns the same object with the id field populated
     *
     * @param repository
     * @param mongoObject
     * @return MongoObject with Id field populated
     * @throws IdGenerationException
     */
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
        // try to create a unique id for MAX_CREATION_TRIALS
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

    /**
     * Return a single Object
     *
     * @param repository
     * @param mongoObject
     * @return MongoObject
     */
    public MongoObject getObjectById(MongoRepository repository, MongoObject mongoObject) {
        return (MongoObject) mongoController.getObjectById(repository, mongoObject);
    }

    /**
     * Returns a List of MongoObjects
     * @param repository
     * @param type
     * @param <T>
     * @return List<MongoObject>
     */
    public <T extends MongoObject> List<T> getAllObjects(MongoRepository repository, Class<T> type) {
        return mongoController.getAllObjects(repository, type);
    }
}
