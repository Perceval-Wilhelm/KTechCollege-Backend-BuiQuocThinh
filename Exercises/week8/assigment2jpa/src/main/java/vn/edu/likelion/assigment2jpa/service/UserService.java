package vn.edu.likelion.assigment2jpa.service;

import vn.edu.likelion.assigment2jpa.entity.UserEntity;

public interface UserService extends BaseCRUD<UserEntity> {
    UserEntity findByUsername(String username);
}