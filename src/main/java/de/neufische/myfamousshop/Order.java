package de.neufische.myfamousshop;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private List<Product> products;


    Order(int id){
        this.id = id;
        this.products = new ArrayList<>();
    }

    public int getId(){
        return id;
    }


    public List<Product> getProducts(){
        return products;
    }

    @Override
    public String toString() {
        return  "orderID: " + id +
                " " + products ;
    }
}
