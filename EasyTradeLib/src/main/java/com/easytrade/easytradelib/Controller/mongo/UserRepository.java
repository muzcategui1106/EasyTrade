package com.easytrade.easytradelib.Controller.mongo;

/**
 * Created by muzcategui1106 on 1/24/2017.
 */
import com.easytrade.easytradelib.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository <User, String>   {

}
