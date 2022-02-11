package de.neufische.myfamousshop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {


    @Test
    void expectsToReturnTheProductOfId1() throws Exception {
        Product newProduct =  new Product("Socken", 1);
        ShopService newShop = new ShopService();
        newShop.addProduct(newProduct);
        //System.out.println(newProduct);
        assertEquals(newShop.getProduct(1), newProduct);

    }

    @Test
    void expectsToReturnOrderOfId1(){
        Product product1 =  new Product("Socken", 1);
        Product product2 =  new Product("Teddy", 2);
        ShopService newShop = new ShopService();
        newShop.addProduct(product1);
        newShop.addProduct(product2);
        newShop.addOrder(1, new int[]{1, 2});
        var products = new ArrayList<Product>();
        products.add(product1);
        products.add(product2);
        assertEquals(products, newShop.getOrder(1));


    }

    @Test
    void shouldThrowExceptionWhenGetterIndexNotExists(){
        ShopService newShop = new ShopService();
        newShop.addProduct(new Product("Snake", 3));

       assertThrows(Exception.class, () -> {
            newShop.getProduct(1);
        });
    }


    @Test
    void expectsToReturnAllProductsWithProductSocken(){
        ShopService newShop = new ShopService();
        Product newProduct =  new Product("Socken", 1);
        newShop.addProduct(newProduct);

        System.out.println(newShop.listProducts());

    }

    @Test
    void expectsToReturnOrderOfProductOfId01(){
        ShopService newShop = new ShopService();
        Product newProduct =  new Product("Socken", 1);
        newShop.addProduct(newProduct);
        newShop.addOrder(1, new int[]{1, 1});

        System.out.println(newShop.listOrders());

    }

}