package de.neufische.myfamousshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepo {

    private List<Product> products;

    ProductRepo(){
        this.products = new ArrayList<>();
    }

    public Optional<Product> get(int i) {
        for (Product product : products) {
            if (product.getId() == i) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    public void add(Product p){
        products.add(p);
    }

    public List<Product> getProducts(){
        return products;
    }


    @Override
    public String toString() {
        return products + ", ";
    }
}
