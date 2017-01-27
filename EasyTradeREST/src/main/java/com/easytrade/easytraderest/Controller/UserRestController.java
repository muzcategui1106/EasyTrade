package com.easytrade.easytraderest.Controller;

import com.easytrade.easytradelib.Controller.UserController;
import com.easytrade.easytradelib.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by muzcategui1106 on 1/24/2017.
 */
@RestController
@RequestMapping("/api/user")
public class UserRestController extends CommonRestController {

    @Inject
    private UserController userController;

    @PostConstruct
    public void init() {
        super.setController(userController);
    }

    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.PUT)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return super.create(user);
    }

    @ResponseBody
    @RequestMapping(value = "/getById", method = RequestMethod.POST)
    public ResponseEntity<User> getUserById(@RequestBody User user) {
        return super.getById(user);
    }

    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers() {
        return super.getAll(User.class);
    }

}
