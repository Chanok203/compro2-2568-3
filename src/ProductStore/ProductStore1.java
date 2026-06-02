package ProductStore;

import java.util.ArrayList;
import java.util.Scanner;

class Product1 {
    String name;
    String sku;
    double price;
    int weight;
    boolean valid;

    Product1(String name, String sku, double price, int weight) {
        this.name = name;
        this.sku = sku;
        this.price = price;
        this.weight = weight;
    }

    boolean checkValidity() {
        boolean valid = true;
        if (this.name == null || this.name.isEmpty()) {
            valid = false;
            System.out.println("name is invalid");
        }
        if (this.sku == null || this.sku.isEmpty()) {
            valid = false;
            System.out.println("sku is invalid");
        }
        if (this.price < 0) {
            valid = false;
            System.out.println("price is invalid");
        }
        if (this.weight < 0) {
            valid = false;
            System.out.println("weight is invalid");
        }
        this.valid = valid;
        return valid;
    }

    void printInfo() {
        String line = String.format(
                "%s, %s, %s, %d",
                this.name, this.sku, this.price, this.weight);
        if (!this.valid) {
            line += ", Invalid";
        }
        System.out.println(line);
    }
}

public class ProductStore1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        
        ArrayList<Product2> products = new ArrayList<>();

        for (int i = 0; i < N; ++i) {
            scan.nextLine(); // throw away new-line char
            String name = scan.nextLine();
            String sku = scan.nextLine();
            double prices = scan.nextDouble();
            int weight = scan.nextInt();
            Product2 p = new Product2(name, sku, prices, weight);
            products.add(p);
        }

        // Call checkVaidity of each product object.
        for (int i = 0; i < N; ++i) {
            boolean valid = products.get(i).checkValidity();
            System.out.println(valid);
        }

        // Call printInfo of each product object.
        for (int i = 0; i < N; ++i) {
            products.get(i).printInfo();
        }
    }

}
