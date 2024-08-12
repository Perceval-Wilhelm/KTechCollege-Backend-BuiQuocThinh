package vn.edu.likelion.assigment2jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.likelion.assigment2jpa.customAnnotation.CheckLogin;
import vn.edu.likelion.assigment2jpa.entity.UserEntity;
import vn.edu.likelion.assigment2jpa.service.UserService;

import java.util.Iterator;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
@CheckLogin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity entity) {
        System.out.println(entity);
        return null;
    }

    @GetMapping
    public Iterator<UserEntity> getAllUsers() {
        return userService.findAll();
    }

//    public String create(@RequestParam String message) {
//        System.out.println("Message: " + message);
//        return message + "abc";
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        UserEntity u = new UserEntity();
        u.setId(id);
        userService.delete(u);
        return ResponseEntity.status(HttpStatus.OK).body("delete successfully");
    }
}
