package de.neufische.myfamousshop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {


    @Test
    void expectsToReturnTheProductOfId1() throws Exception {
        Product newProduct =  new ClothProduct("Socken", 1);
        ShopService newShop = new ShopService();
        newShop.addProduct(newProduct);
        assertEquals(Optional.of(newProduct), newShop.getProduct(1));

    }

    @Test
    void expectsToReturnOrderOfId1() throws Exception {
        Product product1 =  new ClothProduct("Socken", 1);
        Product product2 =  new ToyProduct("Teddy", 2);
        ShopService newShop = new ShopService();
        newShop.addProduct(product1);
        newShop.addProduct(product2);
        newShop.addOrder(1, new int[]{1, 2});
        var products = new ArrayList<Product>();
        products.add(product1);
        products.add(product2);
        assertEquals(Optional.of(products), newShop.getOrder(1));


    }

    @Test
    void shouldReturnOptionalEmptyWhenGetProductIndexNotExists(){
        ShopService newShop = new ShopService();
        newShop.addProduct(new ToyProduct("Snake", 3));

        assertEquals(Optional.empty(), newShop.getProduct(5));
    }

    @Test
    void shouldReturnOptionalEmptyWhenGetOrderIndexNotExists() throws Exception {
        ShopService newShop = new ShopService();
        newShop.addProduct(new ToyProduct("Snake", 3));
        newShop.addOrder(3, new int[]{3, 3});

        assertEquals(Optional.empty(), newShop.getOrder(5));
    }

    @Test
    void shouldThrowExceptionWhenAddOrderProductIndexNotExists() throws Exception {
        ShopService newShop = new ShopService();
        newShop.addProduct(new ToyProduct("Snake", 3));

        assertThrows(Exception.class,() -> {
            newShop.addOrder(3, new int[]{1, 2});
        });
    }


    @Test
    void expectsToListAllProductsWithProductSocken(){
        ShopService newShop = new ShopService();
        Product newProduct =  new ClothProduct("Socken", 1);
        newShop.addProduct(newProduct);

        assertEquals("[[ Socken, id: 1 ]], ", newShop.listProducts());
    }

    @Test
    void expectsToReturnOrderOf2ProductsOfId01() throws Exception {
        ShopService newShop = new ShopService();
        Product newProduct =  new ClothProduct("Socken", 1);
        newShop.addProduct(newProduct);
        newShop.addProduct(new ToyProduct("Teddy", 2));

        newShop.addOrder(1, new int[]{1, 1});
        newShop.addOrder(2, new int[]{1, 2});

        assertEquals("[orderID: 1 [[ Socken, id: 1 ], [ Socken, id: 1 ]], orderID: 2 [[ Socken, id: 1 ], [ Teddy, id: 2 ]]]", newShop.listOrders());

    }

}