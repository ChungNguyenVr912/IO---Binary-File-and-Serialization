package product_manager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private static String productSourceFile = "src/product_manager/products.csv";
    private static int available = 0;

    public static void addProduct(List<Product> products) {
        List<Product> productList = readAllProduct();
        try (FileOutputStream fileOutputStream = new FileOutputStream(productSourceFile);
             ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream)) {

            if (productList == null) {
                productList = new ArrayList<>();
                productList.addAll(products);
            } else {
                productList.addAll(products);
            }
            outputStream.writeObject(productList);
            available += products.size();
            System.out.println("Add successful!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addProduct(Product product) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(product);
        addProduct(products);
    }

    public static Product searchProduct(int productID) {
        List<Product> products = readAllProduct();
        Product result = null;
        if (products.size() == 0) {
            System.out.println("Product id not found!");
            return null;
        } else {
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getId() == productID) {
                    result = products.get(i);
                }
            }
        }
        return result;
    }

    public static void viewAllProduct() {
        List<Product> products = readAllProduct();
        if (products == null) {
            System.out.println("read fail");
        } else if (products.size() == 0) {
            System.out.println("Product list empty!");
        } else {
            products.forEach(product -> {
                if (product != null) {
                    System.out.println(product);
                }
            });
        }
    }

    public static List<Product> readAllProduct() {
        List<Product> productList = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(productSourceFile))) {
            productList = (List<Product>) objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Read fail!");
        }
        return productList;
    }

    public static String getProductSourceFile() {
        return productSourceFile;
    }

    public static void setProductSourceFile(String productSourceFile) {
        ProductManager.productSourceFile = productSourceFile;
    }

    public static int getAvailable() {
        return available;
    }
}
