package com.example.inventariominimarket.controller;


import com.example.inventariominimarket.dto.Message;
import com.example.inventariominimarket.dto.request.CategoryRequestDTO;
import com.example.inventariominimarket.dto.response.CategoryResponseDTO;
import com.example.inventariominimarket.entity.Category;
import com.example.inventariominimarket.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class CategoryController {

    private final CategoryService categoryService;
    @GetMapping("/categories")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findAll());
    }



    @GetMapping("/category/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        CategoryResponseDTO category = categoryService.findById(id);
        log.info("Category: {}", category);
        if (category == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Message("Category doesn't exist"));
        }

        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping("/category")
    public ResponseEntity<?> save(@RequestBody CategoryRequestDTO categoryRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.save(categoryRequestDTO));
    }


    @PutMapping("/category/{id}")
    public ResponseEntity<?> update(@RequestBody CategoryRequestDTO categoryRequestDTO,@PathVariable Long id){

        Category category = categoryService.update(categoryRequestDTO,id);

        if (category == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category doesn't exist");
        }
        return ResponseEntity.status(HttpStatus.OK).body(category);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if (!categoryService.delete(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category doesn't exist");
        }
        categoryService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Category deleted");
    }
}

