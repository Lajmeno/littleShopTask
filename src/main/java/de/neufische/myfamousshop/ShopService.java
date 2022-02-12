package de.neufische.myfamousshop;

import java.util.List;

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

    public Product getProduct(int id) throws Exception {
        return productRepo.get(id);
    }

    public String listProducts(){
        return productRepo.toString();
    }

    public String listOrders(){
        return orderRepo.toString();
    }

    public void addOrder(int orderId, int[] productIds) {
        Order newOrder = new Order(orderId);
        for (Product product : productRepo.getProducts()){
            for (int i = 0; i <productIds.length ; i++) {
                if(product.getId() == productIds[i]){
                    newOrder.getProducts().add(product);
                }
            }
        }
        orderRepo.getOrders().add(newOrder);
    }

    public List<Product> getOrder(int index){
        return orderRepo.get(index);
    }

}
