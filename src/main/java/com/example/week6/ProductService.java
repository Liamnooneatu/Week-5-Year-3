package com.example.week6;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductService{

    private List<Product> myList = new ArrayList<>();

    public List<Product> addProduct(Product product)
    {
        //do business stuff like retrieving details from db, or generating files pdfs
        myList.add(product);
        return myList;
    }
}
