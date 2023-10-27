package com.example.inventariominimarket.controller;

import com.example.inventariominimarket.entity.Category;
import com.example.inventariominimarket.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@CrossOrigin("**")
@RequiredArgsConstructor()
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        List<Category> categoryList = categoryService.findAll();
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {

        Category category = categoryService.findById(id);

        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Category category) {
        return new ResponseEntity<>(categoryService.update(category,id), HttpStatus.OK);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return new ResponseEntity<>(categoryService.delete(id), HttpStatus.NO_CONTENT);
    }
}
