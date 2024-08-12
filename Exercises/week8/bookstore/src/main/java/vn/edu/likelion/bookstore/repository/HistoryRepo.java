package vn.edu.likelion.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.likelion.bookstore.entity.History;

@Repository
public interface HistoryRepo extends JpaRepository<History, Integer> {
}
