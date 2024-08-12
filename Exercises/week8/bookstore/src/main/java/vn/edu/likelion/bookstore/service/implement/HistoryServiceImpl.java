package vn.edu.likelion.bookstore.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.likelion.bookstore.entity.History;
import vn.edu.likelion.bookstore.entity.User;
import vn.edu.likelion.bookstore.repository.HistoryRepo;
import vn.edu.likelion.bookstore.service.HistoryService;

import java.util.Iterator;
import java.util.Optional;

@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    private HistoryRepo historyRepo;

    @Override
    public History create(History history) {
        return historyRepo.save(history);
    }

    @Override
    public History update(History history) {
        return historyRepo.save(history);
    }

    @Override
    public void delete(History history) {
        historyRepo.delete(history);
    }

    @Override
    public void remove(Integer id) {
        Optional<History> historyEntity = historyRepo.findById(id);
        if (historyEntity.isPresent()) {
            History history = historyEntity.get();
            history.setIsDeleted(1);
            historyRepo.save(history);
        } else {
            throw new IllegalArgumentException("History not found with id: " + id);
        }
    }

    @Override
    public Iterator<History> findAll() {
        return historyRepo.findAll().iterator();
    }

    @Override
    public Optional<History> findById(Integer id) {
        return historyRepo.findById(id);
    }
}
