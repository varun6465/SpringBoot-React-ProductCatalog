package com.ecom.productcatalog.config;

import com.ecom.productcatalog.model.Category;
import com.ecom.productcatalog.model.Product;
import com.ecom.productcatalog.repository.CategoryRepository;
import com.ecom.productcatalog.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Clear all existing data
        productRepository.deleteAll();
        categoryRepository.deleteAll();

        // Create categories
        Category electronics = new Category();
        electronics.setName("Electronics");

        Category clothing = new Category();
        clothing.setName("Clothing");

        Category home = new Category();
        home.setName("Home and kitchen");

        categoryRepository.saveAll(Arrays.asList(electronics, clothing, home));

        // Products
        Product phone = new Product();
        phone.setName("Phone");
        phone.setDescription("Latest model yet");
        phone.setImageurl("https://picsum.photos/200");
        phone.setPrice(69.99);
        phone.setCategory(electronics);

        Product laptop = new Product();
        laptop.setName("Laptop");
        laptop.setDescription("Latest model laptop");
        laptop.setImageurl("https://picsum.photos/200");
        laptop.setPrice(99.99);
        laptop.setCategory(electronics);

        Product jacket = new Product();
        jacket.setName("Jacket");
        jacket.setDescription("Latest warm jacket");
        jacket.setImageurl("https://picsum.photos/200");
        jacket.setPrice(129.99);
        jacket.setCategory(clothing);

        Product mixer = new Product();
        mixer.setName("Mixer");
        mixer.setDescription("Latest mixer yet");
        mixer.setImageurl("https://picsum.photos/200");
        mixer.setPrice(89.99);
        mixer.setCategory(home);

        List<Product> products = Arrays.asList(phone, laptop, jacket, mixer);
        productRepository.saveAll(products);

        // Log saved products
        System.out.println("Saved Products:");
        products.forEach(product -> System.out.println(product.getName()));
    }
}
