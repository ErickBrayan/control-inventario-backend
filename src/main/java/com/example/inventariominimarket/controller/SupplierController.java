package com.example.inventariominimarket.controller;

import com.example.inventariominimarket.dto.request.SupplierRequestDTO;
import com.example.inventariominimarket.dto.response.SupplierResponseDTO;
import com.example.inventariominimarket.entity.Supplier;
import com.example.inventariominimarket.service.SupplierService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/supplier")
@RequiredArgsConstructor
@Slf4j
public class SupplierController {

    private final SupplierService supplierService;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(supplierService.findAll());
    }


    //TODO: Add response message(JSON), When Supplier not found
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {

        SupplierResponseDTO supplier = supplierService.findById(id);
        if (supplier == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(supplier, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody SupplierRequestDTO supplierRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(supplierService.save(supplierRequestDTO));
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody SupplierRequestDTO supplierRequestDTO,@PathVariable Long id){

        Supplier supplier = supplierService.update(supplierRequestDTO,id);

        if (supplier == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Supplier no encotrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(supplier);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Integer res = supplierService.delete(id);
        if (res == 3 ){
            log.info(String.valueOf("Resultado delete --> "+res));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("supplier id " +id + " doesn't exit");
        }
        log.info(String.valueOf("Resultado delete --> "+res));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(res);
    }
}
