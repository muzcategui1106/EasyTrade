package com.easytrade.easytradelib.Controller.mongo.repositories;

/**
 * Created by muzcategui1106 on 1/24/2017.
 */
import com.easytrade.easytradelib.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository <User, String>   {

}
