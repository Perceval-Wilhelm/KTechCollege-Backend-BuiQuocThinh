package vn.edu.likelion.assigment2jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.likelion.assigment2jpa.customAnnotation.CheckLogin;
import vn.edu.likelion.assigment2jpa.entity.WarehouseEntity;
import vn.edu.likelion.assigment2jpa.service.WarehouseService;

import java.util.Iterator;

@RestController
@RequestMapping("/api/warehouse")
@CheckLogin
public class WarehouseController {

    @Autowired
    private WarehouseService wareHouseService;

    @PostMapping
    public WarehouseEntity create(@RequestParam String name,
                                  @RequestParam String address) {
        WarehouseEntity wareHouse = new WarehouseEntity();
        wareHouse.setName(name);
        wareHouse.setAddress(address);
        return wareHouseService.create(wareHouse);
    }

    @GetMapping
    public Iterator<WarehouseEntity> findAll() {
        return wareHouseService.findAll();
    }
}
