package com.easytrade.easytradelib.Controller.mongo;

import com.easytrade.easytradelib.Controller.mongo.repositories.UserRepository;
import com.easytrade.easytradelib.Exception.IdGenerationException;
import com.easytrade.easytradelib.TestUtills;
import com.easytrade.easytradelib.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;

/**
 * Created by muzcategui1106 on 1/25/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoConfigTest.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class MongoActionTest {
    @Rule
    public MongoDbRule mongoDbRule = newMongoDbRule().defaultSpringMongoDb("demo-test");
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MongoAction mongoAction;

    @Test
    public void createObject() throws Exception {
        User user = new User("address", "country", "firstName", "middleName", "lastName", "2001");
        user = (User) mongoAction.createObject(userRepository, user);
        User user2 = (User) mongoAction.getObjectById(userRepository, user);
        Assert.assertEquals(user.getId(), user2.getId());
    }

    @Test
    public void getObjectById() throws IdGenerationException {
        User user = new User("address", "country", "firstName", "middleName", "lastName", "2001");
        user = (User) mongoAction.createObject(userRepository, user);
        User user3 = (User) mongoAction.getObjectById(userRepository, user);
        Assert.assertEquals(user.getId(), user3.getId());
    }

    @Test
    public void getObjectByIdReturnsNullWhenNotFound() {
        User user = new User();
        user.setId("12345");
        user = (User) mongoAction.getObjectById(userRepository, user);
        Assert.assertNull(user);
    }

    @Test
    public void getAllObjectsTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        User user1 = mapper.readValue(TestUtills.getJSONFromFile("first-person.json"), User.class);
        User user2 = mapper.readValue(TestUtills.getJSONFromFile("second-person.json"), User.class);
        mongoAction.createObject(userRepository, user1);
        mongoAction.createObject(userRepository, user2);
        List<User> users = mongoAction.getAllObjects(userRepository, User.class);
        Assert.assertTrue(users.size() == 2);
    }

    // TODO
    @Test
    public void generateObjectId() {
        return;
    }

    //TODO
    public void generateObjectIdThrowIdGenerationException() {
        return;
    }
}