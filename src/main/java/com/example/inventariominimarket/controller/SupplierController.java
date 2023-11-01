package com.example.inventariominimarket.controller;

import com.example.inventariominimarket.entity.Product;
import com.example.inventariominimarket.entity.Supplier;
import com.example.inventariominimarket.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("api/v1/supplier")
public class SupplierController {

    private final SupplierService supplierService;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        List<Supplier> suppliers = supplierService.findAll();
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {

        Supplier supplier = supplierService.findById(id);

        if (supplier == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(supplier, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Supplier supplier) {
        return new ResponseEntity<>(supplierService.save(supplier), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Supplier supplier) {
        return new ResponseEntity<>(supplierService.update(supplier,id), HttpStatus.OK);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return new ResponseEntity<>(supplierService.delete(id), HttpStatus.NO_CONTENT);
    }
}
