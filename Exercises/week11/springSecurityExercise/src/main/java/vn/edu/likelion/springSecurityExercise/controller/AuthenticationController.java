package vn.edu.likelion.springSecurityExercise.controller;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.edu.likelion.springSecurityExercise.dto.request.LoginUserDTO;
import vn.edu.likelion.springSecurityExercise.dto.request.RegisterUserDTO;
import vn.edu.likelion.springSecurityExercise.dto.response.LoginResponse;
import vn.edu.likelion.springSecurityExercise.entity.UserEntity;
import vn.edu.likelion.springSecurityExercise.service.implement.AuthenticationService;
import vn.edu.likelion.springSecurityExercise.service.implement.JwtService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserEntity> registerUser(@RequestBody RegisterUserDTO registerUserDTO) {
        if (registerUserDTO.getRole() == null) {
            registerUserDTO.setRole("ROLE_USER");  // Default role for regular users
        }
        UserEntity registeredUser = authenticationService.signup(registerUserDTO);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@Validated @RequestBody LoginUserDTO loginUserDTO) {
        UserDetails userDetails = authenticationService.authenticate(loginUserDTO);
        String jwtToken = jwtService.generateToken(userDetails);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @GetMapping("/user/userProfile")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String userProfile() {
        return "Welcome to User Profile";
    }

    @GetMapping("/admin/adminProfile")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String adminProfile() {
        return "Welcome to Admin Profile";
    }
}