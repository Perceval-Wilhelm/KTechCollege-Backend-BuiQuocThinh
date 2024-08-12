package vn.edu.likelion.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.likelion.bookstore.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
}
