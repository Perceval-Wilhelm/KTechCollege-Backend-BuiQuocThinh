package vn.edu.likelion.assignment2jpa2.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.likelion.assignment2jpa2.entity.User;
import vn.edu.likelion.assignment2jpa2.repository.UserRepo;
import vn.edu.likelion.assignment2jpa2.service.UserService;

import java.util.Iterator;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public User create(User user) {
        return userRepo.save(user);
    }

    @Override
    public User update(User user) {
        return userRepo.save(user);
    }

    @Override
    public void delete(User user) {
        userRepo.delete(user);
    }

    @Override
    public Iterator<User> findAll() {
        return userRepo.findAll().iterator();
    }

    @Override
    public Optional<User> findById(int id) {
        return userRepo.findById(id);
    }
}
