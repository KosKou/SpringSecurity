package com.security.demo.Controller;

import com.security.demo.Entity.User;
import com.security.demo.Service.TaskService;
import com.security.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ProfileController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String showProfilePage(Model model, Principal principal){
        String email = principal.getName();     //Returns Id
        User user = userService.findOne(email);

        model.addAttribute("tasks", taskService.findUserTask(user));
        return "views/profile";
    }
}
