package de.neufische.myfamousshop;

import java.util.List;
import java.util.Optional;

public class ShopService {

    ProductRepo productRepo;
    OrderRepo orderRepo;

    ShopService(){
        this.productRepo = new ProductRepo();
        this.orderRepo = new OrderRepo();
    }

    public void addProduct(Product p){
        productRepo.add(p);
    }


    public String listProducts(){
        return productRepo.toString();
    }

    public String listOrders(){
        return orderRepo.toString();
    }

    public void addOrder(int orderId, int[] productIds) throws Exception {
        Order newOrder = new Order(orderId);
        int counter = productIds.length;
        for (Product product : productRepo.getProducts()){
            for (int i = 0; i <productIds.length ; i++) {
                if(product.getId() == productIds[i]){
                    newOrder.getProducts().add(product);
                    counter--;
                }
            }
        }
        if(counter == 0) {
            orderRepo.getOrders().add(newOrder);
        }else{
            throw new Exception("Order can't be completed: One or more product-ids don't exist!");
        }
    }

    public Optional<Product> getProduct(int id){
        return productRepo.get(id);
    }

    public Optional<List<Product>> getOrder(int index) {
        return orderRepo.get(index);
    }

}
