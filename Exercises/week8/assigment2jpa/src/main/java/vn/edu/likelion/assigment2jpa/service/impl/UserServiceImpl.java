package vn.edu.likelion.assigment2jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.likelion.assigment2jpa.entity.UserEntity;
import vn.edu.likelion.assigment2jpa.model.ErrorHandler;
import vn.edu.likelion.assigment2jpa.repository.UserRepository;
import vn.edu.likelion.assigment2jpa.service.UserService;

import java.util.Iterator;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity create(UserEntity userEntity) {
        try {
            return userRepository.save(userEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new ErrorHandler(e.getMessage());
        }
    }

    @Override
    public UserEntity update(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public void delete(UserEntity userEntity) {
        throw new ErrorHandler("can not delete user");
    }

    @Override
    public Iterator<UserEntity> findAll() {
        return userRepository.findAll().iterator();
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
