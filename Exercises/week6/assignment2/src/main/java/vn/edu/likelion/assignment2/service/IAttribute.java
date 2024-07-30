package vn.edu.likelion.assignment2.service;

import vn.edu.likelion.assignment2.model.Attribute;

import java.util.List;

public interface IAttribute {
    void createAttribute(Attribute attribute);
    List<Attribute> getAllAttributes();
    int getOrInsertAttribute(int count, int sizeAttribute, String typeAttribute, String colorAttribute, String brandAttribute, int productId);
}
