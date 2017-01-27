package com.easytrade.easytradelib.service;

import com.easytrade.easytradelib.Controller.mongo.repositories.UserRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.inject.Inject;


/**
 * Created by muzcategui1106 on 1/23/2017.
 */
@Component
public class UserService extends AbstractBasicService {
    @Inject
    private UserRepository userRepository;

    @PostConstruct
    public void init() {
        super.setRepository(userRepository);
    }
}
