package vn.edu.likelion.assignment2jpa2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.likelion.assignment2jpa2.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
}
