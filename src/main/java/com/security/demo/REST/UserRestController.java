package com.security.demo.REST;

import com.security.demo.Entity.Message;
import com.security.demo.Entity.User;
import com.security.demo.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {

    private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/rest/users")
    public List<User> findAll(){
        return userService.findAll();
    }
    @GetMapping("/rest/users/{email}")
    public User findOne(@PathVariable String email){
        return userService.findOne(email);
    }

//    Authentication
    @GetMapping(value = "/getmessage", produces = "application/json")
    @ResponseBody
    public Message getMessage(){
        logger.info("Accessing protected resource");
        return new Message(100, "Congratulations!", "You have accessed a Basic Auth protected resource.");
    }

    //Register
    @PostMapping(value = "/androidrest", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Message saveUser(@RequestBody User user){
        userService.createUser(user);
        return new Message(101, "Nice!", "You have create a new User");
    }
}

