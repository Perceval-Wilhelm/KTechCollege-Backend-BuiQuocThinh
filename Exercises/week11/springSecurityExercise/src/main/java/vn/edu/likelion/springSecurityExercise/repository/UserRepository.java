package vn.edu.likelion.springSecurityExercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.likelion.springSecurityExercise.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUsername(String username);
}
