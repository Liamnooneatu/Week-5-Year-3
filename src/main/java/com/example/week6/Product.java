package com.example.week6;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.PositiveOrZero;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @NotBlank(message = "This product must have an ID")
    private String id;
    @NotBlank(message = "This product must have an ID")
    private String name;
    @Max(value = 1000, message = "Cannot be over 1000")
    @Min(value = 300, message = "Must be over 300")
    private double price;
}
