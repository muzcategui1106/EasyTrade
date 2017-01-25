package com.easytrade.easytradelib.Controller.mongo;

import com.easytrade.easytradelib.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by muzcategui1106 on 1/24/2017.
 */

@Component
public class UserMongoController {
    @Autowired
    private UserRepository userRepository;

    public User getUsersById(String id){
        return userRepository.findOne(id);
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

}
