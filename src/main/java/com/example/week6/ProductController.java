package com.example.week6;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;


@RestController
@RequestMapping("/products")

public class ProductController {
    private ProductService myService;


    public ProductController(ProductService myService) {
        this.myService = myService;
    }

    private List<Product> list = new ArrayList<>();
    //creating a  class which is interested in requests and responses. Separation of Concern

    @PostMapping
    public List<Product> newProduct(@RequestBody Product product) {
        //send it to do the business logic
        //redirects request to business layer
        list = myService.addProduct(product);
        return list;
    }


    @PutMapping("/{id}")
    public ResponseEntity<List> updateProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
        for (Product product : list) {
            if (product.getId().equals(id) ){
                list.remove(product);
            }
        }
        list.add(updatedProduct);
        return ResponseEntity.ok(list);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<List> deleteProduct(@PathVariable String id) {

        for (Product product : list) {
            if (product.getId().equals(id)) {
                list.remove(product);
            }
        }
        return ResponseEntity.ok(list);
    }
}