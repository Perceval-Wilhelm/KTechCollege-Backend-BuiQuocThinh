package vn.edu.likelion.assignment2.service;

import vn.edu.likelion.assignment2.model.User;

import java.util.List;

public interface IUser {
    void createUser(User user);
    User getUserById(int id);
    List<User> getAllUsers();
    void deleteUser(int id);
    User authenticateUser(String username, String password);
    void updateUser(User user);
    User getUserByWarehouseId(int warehouseId);
}
