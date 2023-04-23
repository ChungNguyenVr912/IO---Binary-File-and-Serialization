package product_manager;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "PC", 1000));
        products.add(new Product(2, "PS4", 800));
        products.add(new Product(3, "PS5", 900));
        products.add(new Product(4, "XBox One", 700));
        products.add(new Product(5, "Nintendo", 750));
        ProductManager.addProduct(products);
        System.out.println("Keep running!");
        ProductManager.addProduct(new Product(6, "PS6", 2000));
        ProductManager.viewAllProduct();
        System.out.println(ProductManager.searchProduct(6));
        System.out.println(ProductManager.searchProduct(2));
    }
}
