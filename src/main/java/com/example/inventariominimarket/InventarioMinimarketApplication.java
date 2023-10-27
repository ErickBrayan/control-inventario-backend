package com.example.inventariominimarket;

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

            Category category = Category.builder().name("categoria").description("description").build();

            categoryRepository.save(category);



            Category category1 = categoryRepository.findById(1L).get();


            Product product = Product.builder().name("name").description("description").price(BigDecimal.valueOf(22.5)).stock(20).category(category1).build();

            productService.save(product);


            List<Product> found = productService.findAll();

            found.forEach(System.out::println);

        };
    }

}
