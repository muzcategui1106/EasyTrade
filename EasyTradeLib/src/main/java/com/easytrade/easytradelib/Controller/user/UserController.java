package com.easytrade.easytradelib.Controller.user;

import com.easytrade.easytradelib.Controller.mongo.MongoAction;
import com.easytrade.easytradelib.Controller.mongo.repositories.UserRepository;
import com.easytrade.easytradelib.Exception.IdGenerationException;
import com.easytrade.easytradelib.model.User;
import org.springframework.stereotype.Component;

import javax.inject.Inject;


/**
 * Created by muzcategui1106 on 1/23/2017.
 */
@Component
public class UserController {
    private int MAX_CREATION_TRIALS = 10;

    @Inject
    private MongoAction mongoAction;
    @Inject
    private UserRepository userRepository;

    public UserController() {
        this.MAX_CREATION_TRIALS = 5;
    }

    public User createUser(User user) throws IdGenerationException {
        return (User) mongoAction.createObject(userRepository, user);
    }
}
