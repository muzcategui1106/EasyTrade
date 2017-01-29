package com.tennismaniac.tennismaniacrest.Controller;

import com.tennismaniac.tennismaniaclib.service.UserService;
import com.tennismaniac.tennismaniaclib.Controller.mongo.MongoConfigTest;
import com.tennismaniac.tennismaniaclib.Exception.IdGenerationException;
import com.tennismaniac.tennismaniaclib.TestUtills;
import com.tennismaniac.tennismaniaclib.model.User;
import com.tennismaniac.tennismaniacrest.TennisManiacRestApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.inject.Inject;
import java.nio.charset.Charset;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by muzcategui1106 on 1/25/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TennisManiacRestApplication.class, MongoConfigTest.class})
@WebAppConfiguration
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserRestControllerTest {
    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
    @Inject
    private WebApplicationContext ctx;
    @Inject
    private UserService userService;
    @InjectMocks
    private UserService userServiceMock = Mockito.mock(UserService.class);
    @Inject
    UserRestController restController;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
        ObjectMapper mapper = new ObjectMapper();
        User user1 = mapper.readValue(TestUtills.getJSONFromFile("first-person.json"), User.class);
        User user2 = mapper.readValue(TestUtills.getJSONFromFile("second-person.json"), User.class);
        restController.setService(userServiceMock);
        userService.create(user1);
        userService.create(user2);
    }

    @Configuration
    @EnableWebMvc
    public static class TestConfiguration {
        @Bean
        public UserRestController userRestController() {
            return new UserRestController();
        }

    }

    @Test
    public void createUser() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        User user1 = new User("test", "", "1", "", "", "");
        // do not mock this one we are using fongo anyways
        restController.setService(userService);
        MvcResult result = mockMvc.perform(put("/api/user/create")
                .contentType(contentType)
                .content(mapper.writeValueAsString(user1)))
                .andExpect(status().isOk())
                .andReturn();
        User resultUser = mapper.readValue(result.getResponse().getContentAsString(), User.class);
        Assert.assertTrue(!resultUser.getId().isEmpty());
        Assert.assertEquals(user1.getFirstName(), resultUser.getFirstName());
    }

    @Test
    public void createUserUnableToGenerateIdTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        User user1 = new User("test", "", "1", "", "", "");
        User user2 = new User("test2", "", "1", "", "", "");
        when(userServiceMock.create(Mockito.anyObject())).thenThrow(IdGenerationException.class);
        MvcResult result = mockMvc.perform(put("/api/user/create")
                .contentType(contentType)
                .content(mapper.writeValueAsString(user1)))
                .andExpect(status().isInternalServerError())
                .andReturn();
    }


    @Test
    public void getUserById() throws Exception {

    }


    @Test
    public void getAllUsers() throws Exception {

    }

}