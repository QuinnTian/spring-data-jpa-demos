package com.example.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/demo2")
public class UserController {
    @Autowired
    private UserCrudRespository userCrudRespository;
    @GetMapping(path = "/add")
    public void addNewUser(@RequestParam String name, @RequestParam String email){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userCrudRespository.save(user);

    }
    @GetMapping(path = "/all")
    @ResponseBody
    public Iterable<User> getAllUsers(){
        return userCrudRespository.findAll();

    }
    @GetMapping(path = "/info")
    @ResponseBody
    public User findOne(@RequestParam Long id){
        return userCrudRespository.findById(id).get();

    }
    @GetMapping(path = "/delete")
    public void delete(@RequestParam Long id){

        userCrudRespository.deleteById(id);

    }
}
