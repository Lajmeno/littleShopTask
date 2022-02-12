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

    public List<Product> get(int index) throws Exception {
        for (Order order : orders){
            if(order.getId() == index){
                return order.getProducts();
            }
        }
        throw new Exception("There is no order of this id!");
    }

    @Override
    public String toString() {
        return orders + "";
    }
}
