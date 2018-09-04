package com.security.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.security.demo.Entity.Task;
import com.security.demo.Entity.User;
import com.security.demo.Service.TaskService;
import com.security.demo.Service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringSecurityApplicationTests {
    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;
    @Before
    public void initDb(){
        {
            User newUser = new User("testUser@gmail.com", "testUser", "123456");
            userService.createUser(newUser);
        }
        {
            User newUser = new User("testAdmin@gmail.com", "testAdmin", "123456");
            userService.createAdmin(newUser);
        }
        Task userTask = new Task("03/01/2018","00:11","11:00","You need to work today");
            User user = userService.findOne("testUser@gmail.com");
            taskService.addTask(userTask, user);
    }

    @Test
    public void testUser() {
        User user = userService.findOne("testUser@gmail.com");
        assertNotNull(user);
        User admin = userService.findOne("testAdmin@gmail.com");
        assertEquals(admin.getEmail(),"testAdmin@gmail.com");
    }

    @Test
    public void testTask() {
        User user = userService.findOne("testUser@gmail.com");
        List<Task> task = taskService.findUserTask(user);
        assertNotNull(task);
    }
}
