package com.Project.Roommate.Controller.API;

import com.Project.Roommate.DTO.RespDTO;
import com.Project.Roommate.Entity.User;
import com.Project.Roommate.Service.userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class Userapicontroller {

    @Autowired
    private userservice userservice;

    @Autowired
    HttpSession session;

    @PostMapping("/Roommate/signupprob")
    public RespDTO<Integer> signup(@RequestBody User user){
        userservice.signup(user);
        return new RespDTO<Integer>(HttpStatus.OK,1);
    }
}
