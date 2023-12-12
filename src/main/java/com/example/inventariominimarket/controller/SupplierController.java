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
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class SupplierController {

    private final SupplierService supplierService;

    @GetMapping("/suppliers")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(supplierService.findAll());
    }


    //TODO: Add response message(JSON), When Supplier not found
    @GetMapping("/supplier/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {

        SupplierResponseDTO supplier = supplierService.findById(id);
        if (supplier == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(supplier, HttpStatus.OK);
    }

    @PostMapping("/supplier")
    public ResponseEntity<?> save(@RequestBody SupplierRequestDTO supplierRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(supplierService.save(supplierRequestDTO));
    }


    @PutMapping("/supplier/{id}")
    public ResponseEntity<?> update(@RequestBody SupplierRequestDTO supplierRequestDTO,@PathVariable Long id){

        Supplier supplier = supplierService.update(supplierRequestDTO,id);

        if (supplier == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Supplier doesn't exit");
        }
        return ResponseEntity.status(HttpStatus.OK).body(supplier);
    }

    @DeleteMapping("/supplier/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Integer res = supplierService.delete(id);
        if (res == 3 ){
            log.info("Result delete --> "+res);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("supplier id " +id + " doesn't exit");
        }
        log.info("Resul delete --> "+res);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(res);
    }
}
