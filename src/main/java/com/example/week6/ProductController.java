package com.example.week6;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
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
    public List<Product> newProduct(@Valid @RequestBody Product product)
    {
        //send it to do the business logic
         //redirects request to business layer
        list = myService.addProduct(product);
        return list;
    }

    @GetMapping("/getProducts")
    public List<Product> getsProducts() {
        return list;
    }
}
