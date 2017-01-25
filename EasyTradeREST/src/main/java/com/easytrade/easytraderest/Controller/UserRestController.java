package com.easytrade.easytraderest.Controller;

import com.easytrade.easytradelib.Controller.user.UserController;
import com.easytrade.easytradelib.model.User;
import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

/**
 * Created by muzcategui1106 on 1/24/2017.
 */
@RestController
@RequestMapping("/api/user")
public class UserRestController  {

    @Inject
    private UserController userController;

    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT, value = "/create")
    public ResponseEntity<User> createUser(@RequestBody User user) throws JSONException {
        try {
            user = userController.createUser(user.getAddress(),
                    user.getCountry(),
                    user.getFirstName(),
                    user.getMiddleName(),
                    user.getZipCode());
        }
        catch (Exception e){
            return new ResponseEntity<User>((User) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
