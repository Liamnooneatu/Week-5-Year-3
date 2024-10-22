package com.example.week6;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
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
    //creating a  class whiich is interested in requests and responses. Seperation of Concern

    @PostMapping
    public List<Product> newProduct(@RequestBody Product product)
    {
        //send it to do the business logic
         //redirects request to business layer
        list = myService.addProduct(product);
        return list;
    }
}
