package vn.edu.likelion.bookstore.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.likelion.bookstore.entity.User;
import vn.edu.likelion.bookstore.repository.UserRepo;
import vn.edu.likelion.bookstore.service.UserService;

import java.util.Iterator;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

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
    public void remove(Integer id) {
        Optional<User> userEntity = userRepo.findById(id);
        if (userEntity.isPresent()) {
            User user = userEntity.get();
            user.setIsDeleted(1);
            userRepo.save(user);
        } else {
            throw new IllegalArgumentException("User not found with id: " + id);
        }
    }

    @Override
    public Iterator<User> findAll() {
        return userRepo.findAll().iterator();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userRepo.findById(id);
    }
}
