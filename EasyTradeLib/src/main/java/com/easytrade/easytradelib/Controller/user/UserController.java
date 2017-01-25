package com.easytrade.easytradelib.Controller.user;

import com.easytrade.easytradelib.Controller.mongo.UserMongoController;
import com.easytrade.easytradelib.Exception.IdGenerationException;
import com.easytrade.easytradelib.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.springframework.stereotype.Component;

import javax.inject.Inject;


/**
 * Created by muzcategui1106 on 1/23/2017.
 */
@Component
public class UserController {
    private int MAX_CREATION_TRIALS = 10;

    @Inject
    UserMongoController userMongoController;

    public  UserController(){
        this.MAX_CREATION_TRIALS = 5;
    }

    public User createUser(String address, String country,
                                 String firstName, String middleName,
                                 String zipCode) throws IdGenerationException, JsonProcessingException, JSONException {
        ObjectMapper mapper =  new ObjectMapper();
        User user = new User(address, country, firstName,  middleName,  zipCode);
        long id = this.generateUserId();
        user.setId(id);
        return userMongoController.createUser(user);
    }

    /**
     * Generates user Id and returns Id only if it is unique
     * @throws IdGenerationException
     * @return the id
     */
    private long generateUserId() throws IdGenerationException {
        boolean idCreated = false;
        long id = 0;
        for (int i = 0; i <= MAX_CREATION_TRIALS; i++){
            id = (long) Math.floor(Math.random() * 1000000000);
            // check that id is unique across users
            User user = userMongoController.getUsersById(Long.toString(id));
            if (user == null){
                idCreated = true;
                break;
            }
        }
        if (!idCreated){
            throw new IdGenerationException();
        }
        return id;
    }


}
