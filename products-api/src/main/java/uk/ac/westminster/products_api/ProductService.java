package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;



    public ProductService() {

        // Add a DigitalProduct
        products.add(new DigitalProduct(
                nextId++,
                "Clean Code (E-book)",
                29.99,
                "/downloads/clean-code.pdf",
                4.2
        ));

        // Add a PhysicalProduct
        products.add(new PhysicalProduct(
                nextId++,
                "Java Programming Book",
                49.99,
                10,
                "4.5"
        ));
    }



    // Get all products
    public List<Product> getAllProducts() {
        return products;
    }

    // Add a new product
    public Product addProduct(Product product) {
        product.setId(nextId++);
        products.add(product);
        return product;
    }

    // Find a product by ID
    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public void deleteProduct(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }

    public List<Product> findByName(String name) {
        return products.stream()
                .filter(p -> p.getName().contains(name))
                .toList();
    }

    public List<String> getAllSummaries() {
        List<String> summaries = new ArrayList<>();

        for (Product p : products) {
            summaries.add(p.getSummary());
        }

        return summaries;
    }

}
