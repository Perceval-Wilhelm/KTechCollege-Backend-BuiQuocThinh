package vn.edu.likelion.assignment2jpa2.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.likelion.assignment2jpa2.entity.Attribute;
import vn.edu.likelion.assignment2jpa2.repository.AttributeRepo;
import vn.edu.likelion.assignment2jpa2.service.AttributeService;

import java.util.Iterator;
import java.util.Optional;

@Service
public class AttributeServiceImpl implements AttributeService {
    @Autowired
    private AttributeRepo attributeRepo;

    @Override
    public Attribute create(Attribute attribute) {
        return attributeRepo.save(attribute);
    }

    @Override
    public Attribute update(Attribute attribute) {
        return attributeRepo.save(attribute);
    }

    @Override
    public void delete(Attribute attribute) {
        attributeRepo.delete(attribute);
    }

    @Override
    public Iterator<Attribute> findAll() {
        return attributeRepo.findAll().iterator();
    }

    @Override
    public Optional<Attribute> findById(int id) {
        return attributeRepo.findById(id);
    }
}
