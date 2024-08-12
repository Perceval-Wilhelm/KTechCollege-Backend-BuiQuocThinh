package vn.edu.likelion.assigment2jpa.service;

import vn.edu.likelion.assigment2jpa.entity.UserEntity;

public interface AppService {
    UserEntity login(String username, String password);
}
