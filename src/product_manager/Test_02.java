package product_manager;

import java.io.*;
import java.util.ArrayList;

public class Test_02 {
    public static void main(String[] args) {
        String url = "src/product_manager/productTest.csv";
//        ArrayList<Product> products = new ArrayList<>();
//        products.add(new Product(1, "PC", 10060));
//        products.add(new Product(2, "PS4", 8060));
//        products.add(new Product(3, "PS5", 9060));
//        products.add(new Product(4, "XBox One", 7060));
//        products.add(new Product(5, "Nintendo", 7560));
//        try (FileOutputStream fileOutputStream = new FileOutputStream(url);
//             ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);){
//            products.forEach(product -> {
//                try {
//                    outputStream.writeObject(product);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//            System.out.println("Write complete!");
//        }catch (IOException e){
//            e.printStackTrace();
//        }

        ArrayList<Product> readProduct = new ArrayList<>();
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(url))){
            Object object;
            while ((object = inputStream.readObject())!= null){
                if (object instanceof Product){
                    readProduct.add((Product) object);
                }
            }
        }catch (EOFException e){
            System.out.println("read finished!");
        }catch (ClassNotFoundException e){
            System.err.println("Class not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("read product");
        readProduct.forEach(System.out::println);
    }
}
