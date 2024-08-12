package vn.edu.likelion.assigment2jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.likelion.assigment2jpa.entity.UserEntity;
import vn.edu.likelion.assigment2jpa.service.AppService;
import vn.edu.likelion.assigment2jpa.service.UserService;

@Service
public class AppServiceImpl implements AppService {
    @Autowired
    private UserService userService;

    @Override
    public UserEntity login(String username, String password) {
        UserEntity userEntity = userService.findByUsername(username);
        if (userEntity == null) {
            return null;
        }
        if (!userEntity.getPassword().equals(password)) {
            return null;
        }
        return userEntity;
    }
}
