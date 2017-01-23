package com.easytrade.easytradeweb.controller;

/**
 * Created by muzcategui1106 on 1/22/2017.
 */
import com.easytrade.easytradelib.Greeting;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Controller
public class GreetingController {

    @RequestMapping("/greeting")
    public String greeting(Model model) throws IOException {
        RestTemplate template = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();
        String gr_string = template.getForObject("http://localhost:8080/api/greeting", String.class);
        Greeting gr = mapper.readValue(gr_string, Greeting.class);
        model.addAttribute("name",gr.getContent());
        return "greeting";
    }

}