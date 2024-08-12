package vn.edu.likelion.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.likelion.bookstore.dto.request.UserRequestDTO;
import vn.edu.likelion.bookstore.dto.response.UserResponseDTO;
import vn.edu.likelion.bookstore.entity.User;
import vn.edu.likelion.bookstore.service.UserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create a new user
    @PostMapping("/create")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setUsername(userRequestDTO.getUsername());
        user.setPassword(userRequestDTO.getPassword());

        User createdUser = userService.create(user);
        return new ResponseEntity<>(convertToDTO(createdUser), HttpStatus.CREATED);
    }

    // Update a user
    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable int id, @RequestBody UserRequestDTO userRequestDTO) {
        Optional<User> existingUser = userService.findById(id);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setUsername(userRequestDTO.getUsername());
            user.setPassword(userRequestDTO.getPassword());
            user.setUpdateTime(LocalDate.now());
            User updatedUser = userService.update(user);
            return new ResponseEntity<>(convertToDTO(updatedUser), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete a user
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        Optional<User> existingUser = userService.findById(id);
        if (existingUser.isPresent()) {
            userService.delete(existingUser.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Soft delete a user (mark as deleted)
    @PutMapping("/remove/{id}")
    public ResponseEntity<Void> removeUser(@PathVariable Integer id) {
        Optional<User> existingUser = userService.findById(id);
        if (existingUser.isPresent()) {
            userService.remove(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get a user by ID
    @GetMapping("/findById/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Integer id) {
        Optional<User> existingUser = userService.findById(id);
        return existingUser.map(value -> new ResponseEntity<>(convertToDTO(value), HttpStatus.OK))
                           .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get all users
    @GetMapping("/findAll")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        Iterator<User> users = userService.findAll();
        List<UserResponseDTO> userResponseDTOs = new ArrayList<>();
        while (users.hasNext()) {
            userResponseDTOs.add(convertToDTO(users.next()));
        }
        return new ResponseEntity<>(userResponseDTOs, HttpStatus.OK);
    }

    private UserResponseDTO convertToDTO(User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setUser_id(user.getId());
        userResponseDTO.setUsername(user.getUsername());
        userResponseDTO.setCreateTime(user.getCreateTime());
        userResponseDTO.setUpdateTime(user.getUpdateTime());
        return userResponseDTO;
    }
}
