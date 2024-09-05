//package vn.edu.likelion.springSecurityExercise.service.implement;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import vn.edu.likelion.springSecurityExercise.entity.UserEntity;
//import vn.edu.likelion.springSecurityExercise.repository.UserRepository;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserEntity userDetails = userRepository.findByUsername(username);
//
//        if (userDetails == null) {
//            throw new UsernameNotFoundException("User with username: " + username + " not found");
//        }
//
//        // Create and return the Spring Security UserDetails object
//        return org.springframework.security.core.userdetails.User.builder()
//                .username(userDetails.getUsername())
//                .password(userDetails.getPassword())
//                .roles("USER") // Replace with appropriate roles from userDetails if available
//                .build();
//    }
//}
