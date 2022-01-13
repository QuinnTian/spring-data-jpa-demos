package com.example.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/demo1")
public class UserController {
    @Autowired
    private UserRespository userRespository;
    @GetMapping(path = "/add")
    public void addNewUser(@RequestParam String name, @RequestParam String email){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRespository.save(user);

    }
    @GetMapping(path = "/all")
    @ResponseBody
    public Iterable<User> getAllUsers(){
        return userRespository.findAll();

    }
}
