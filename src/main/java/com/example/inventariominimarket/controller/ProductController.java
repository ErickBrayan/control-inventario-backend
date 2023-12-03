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

        ProductResponseDTO product = productService.findById(id);

        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    /**
     * Recupera una lista de productos que caducarán en el número especificado de días..
     *
     * @param days El número de días hasta la caducidad. Por defecto, es 20 si no se especifica.
     * @return Un ResponseEntity que contiene la lista de productos y un código de estado 200 (OK).
     */
    @GetMapping("/toExpired")
    public ResponseEntity<?> getProductToExpired(@RequestParam(required = false,defaultValue = "20") int days) {

        return new ResponseEntity<>(productService.findAllProductToExpired(days), HttpStatus.OK);
    }

    @GetMapping("/byStock")
    public ResponseEntity<?> getProductByStock(@RequestParam(required = false,defaultValue = "5") int stock) {

        return new ResponseEntity<>(productService.findAllProductByStock(stock), HttpStatus.OK);
    }

    @GetMapping("/byCategory/{id}")
    public ResponseEntity<?> getProductByStock(@PathVariable Long id) {

        return new ResponseEntity<>(productService.findAllByCategory(id), HttpStatus.OK);
    }
    @GetMapping("/byName/{name}")
    public ResponseEntity<?> getProductByStock(@PathVariable String name) {

        return new ResponseEntity<>(productService.findAllByName(name), HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody ProductRequestDTO productRequestDTO) {
        return new ResponseEntity<>(productService.save(productRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProductRequestDTO productRequestDTO) {
        Product product = productService.update(productRequestDTO,id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }


    @DeleteMapping ("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        Integer res = productService.delete(id);
        if (res == 3) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(res, HttpStatus.NO_CONTENT);
    }
}
