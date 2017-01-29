package com.tennismaniac.tennismaniaclib.Controller.mongo;

import com.tennismaniac.tennismaniaclib.Controller.mongo.repositories.UserRepository;
import com.github.fakemongo.Fongo;
import com.mongodb.Mongo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by muzcategui1106 on 1/25/2017.
 */
@Configuration
@EnableMongoRepositories
@ComponentScan(basePackageClasses = {UserRepository.class, MongoAction.class, MongoTemplate.class})
@PropertySource("classpath:application.properties")
public class MongoConfigTest extends AbstractMongoConfiguration {
    @Override
    protected String getDatabaseName() {
        return "demo-test";
    }

    @Override
    public Mongo mongo() {
        // uses fongo for in-memory tests
        return new Fongo("mongo-test").getMongo();
    }

    @Override
    protected String getMappingBasePackage() {
        return "com.tennismaniac.tennismaniaclib.model";
    }
}