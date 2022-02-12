package de.neufische.myfamousshop;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo {

    private List<Product> products;

    ProductRepo(){
        this.products = new ArrayList<>();
    }

    public Product get(int i) throws Exception {
        for (Product product : products) {
            if (product.getId() == i) {
                return product;
            }
        }
        throw new Exception("There is no product of this id!");
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
