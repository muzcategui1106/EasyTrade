package com.tennismaniac.tennismaniaclib.Controller.mongo.repositories;

/**
 * Created by muzcategui1106 on 1/24/2017.
 */

import com.tennismaniac.tennismaniaclib.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
