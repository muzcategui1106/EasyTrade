package com.easytrade.easytradelib.Controller.mongo;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.io.IOException;

/**
 * Created by muzcategui1106 on 1/24/2017.
 */
// Configuration for "live" connections
@Configuration
public class MongoConfig {

    @Value("${product.mongo.host}")
    private String mongoHost;

    @Value("${product.mongo.port}")
    private String mongoPort;

    @Value("${product.mongo.database}")
    private String mongoDatabase;

    @Bean(name="mongoClient")
    public MongoClient mongoClient() throws IOException {
        return new MongoClient(mongoHost, Integer.parseInt(mongoPort));
    }

    @Autowired
    @Bean(name="mongoDbFactory")
    public MongoDbFactory mongoDbFactory(MongoClient mongoClient) {
        return new SimpleMongoDbFactory(mongoClient, mongoDatabase);
    }

    @Autowired
    @Bean(name="mongoTemplate")
    public MongoTemplate mongoTemplate(MongoClient mongoClient) {
        return new MongoTemplate(mongoClient, mongoDatabase);
    }
}
