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

    public List<Product> getOrder(int index) throws Exception {
        return orderRepo.get(index);
    }

}
