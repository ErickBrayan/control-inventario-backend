package com.example.inventariominimarket;

import com.example.inventariominimarket.dto.response.ProductResponseDTO;
import com.example.inventariominimarket.entity.Category;
import com.example.inventariominimarket.entity.Product;
import com.example.inventariominimarket.repository.CategoryRepository;
import com.example.inventariominimarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class InventarioMinimarketApplication {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductService productService;

    public static void main(String[] args) {
        SpringApplication.run(InventarioMinimarketApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {

            /*Category category = Category.builder().description("description").build();

            categoryRepository.save(category);


            Product product = Product.builder()
                    .name("name")
                    .description("description")
                    .stock(10)
                    .batch("batch")
                    .dueDate(LocalDate.now())
                    .purchasePrice(BigDecimal.ONE)
                    .salePrice(BigDecimal.ONE)
                    .category(category).build();


            productService.save(product);*/





        };
    }

}
