package com.example.inventariominimarket.controller;

import com.example.inventariominimarket.dto.request.ProductRequestDTO;
import com.example.inventariominimarket.entity.Product;
import com.example.inventariominimarket.dto.response.ProductResponseDTO;
import com.example.inventariominimarket.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("api/v1/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {

        Product product = productService.findById(id);

        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody ProductRequestDTO productRequestDTO) {
        return new ResponseEntity<>(productService.save(productRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Product product) {
        return new ResponseEntity<>(productService.update(product,id), HttpStatus.OK);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return new ResponseEntity<>(productService.delete(id), HttpStatus.NO_CONTENT);
    }
}
