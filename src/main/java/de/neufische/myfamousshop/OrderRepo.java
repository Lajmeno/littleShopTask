package de.neufische.myfamousshop;

import java.util.ArrayList;
import java.util.List;

public class OrderRepo {

    private List<Order> orders;

    OrderRepo(){
        this.orders = new ArrayList<>();
    }

    public List<Order> getOrders(){
        return orders;
    }

    public List<Product> get(int index){
        for (Order order : orders){
            if(order.getId() == index){
                return order.getProducts();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return orders + "";
    }
}
