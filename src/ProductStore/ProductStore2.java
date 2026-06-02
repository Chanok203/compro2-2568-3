package ProductStore;

import java.util.ArrayList;
import java.util.Scanner;

class Product2 {
    String name;
    String sku;
    double price;
    int weight;
    boolean valid;

    Product2(String name, String sku, double price, int weight) {
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

class Shoe extends Product2 {
    int gender;
    int size;
    int type;
    String brand;

    Shoe(String name, String sku, double price, int weight, int gender, int size, int type, String brand) {
        super(name, sku, price, weight);
        this.gender = gender;
        this.size = size;
        this.type = type;
        this.brand = brand;
    }

    @Override
    void printInfo() {
        super.printInfo();

        String genderStr = "male";
        if (this.gender == 1) {
            genderStr = "female";
        }

        String typeStr = "sport";
        if (this.type == 2) {
            typeStr = "formal";
        } else if (this.type == 3) {
            typeStr = "casual";
        }

        String line = String.format("%s, %d, %s, %s",
                genderStr,
                this.size,
                typeStr,
                this.brand);
        System.out.println(line);
    }
}

public class ProductStore2 {
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
            int gender = scan.nextInt();
            int size = scan.nextInt();
            int type = scan.nextInt();
            String brand = scan.next();
            products.add(new Shoe(name, sku, prices, weight, gender, size, type, brand));
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