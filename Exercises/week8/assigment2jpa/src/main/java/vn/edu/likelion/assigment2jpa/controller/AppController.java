package vn.edu.likelion.assigment2jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.likelion.assigment2jpa.entity.UserEntity;
import vn.edu.likelion.assigment2jpa.service.AppService;
import vn.edu.likelion.assigment2jpa.config.SessionConfig;

@RestController
@RequestMapping("/api/app/")
public class AppController {

    @Autowired
    private AppService appService;

    @Autowired
    private SessionConfig sessionConfig;

    @RequestMapping("/login")
    public UserEntity login(@RequestParam String username, @RequestParam String password) {
        UserEntity user = appService.login(username, password);
        if (user == null) {
            return null;
        }
        sessionConfig.setUserEntity(user);
        return user;
    }
}
