import java.util.Scanner;

class TheaterV1 {
    String title;
    boolean threeD;
    boolean luxury;
    boolean[] seats;
    int basePrice;

    TheaterV1(boolean threeD, boolean luxury, int numSeats) {
        this.threeD = threeD;
        this.luxury = luxury;
        this.seats = new boolean[numSeats + 1];
    }

    void setTitle(String title) {
        if (title == null || title.length() == 0) {
            System.out.println("invalid title");
            return;
        }
        this.title = title;
    }

    void setBasePrice(int price) {
        if (price <= 0) {
            System.out.println("invalid price");
            return;
        }
        this.basePrice = price;
    }

    void printInfo() {
        System.out.println((this.threeD) ? "3D" : "No 3D");
        System.out.println((this.luxury) ? "Luxury" : "Standard");
        System.out.println(this.seats.length - 1);
        System.out.println((this.title == null) ? "title is not set" : this.title);
        System.out.println((this.basePrice == 0) ? "price is not set" : this.basePrice);
    }
}

public class Theater1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int threeD1 = scan.nextInt();
        int luxury1 = scan.nextInt();
        int numSeats = scan.nextInt();
        boolean threeD = false;
        boolean luxury = false;
        if (threeD1 == 1)
            threeD = true;
        if (luxury1 == 1)
            luxury = true;
        TheaterV1 t = new TheaterV1(threeD, luxury, numSeats);

        String dummy = scan.nextLine();
        String title = scan.nextLine();
        if (title.compareTo("-1") == 0)
            t.setTitle(null);
        else
            t.setTitle(title);

        int basePrice = scan.nextInt();
        t.setBasePrice(basePrice);
        t.printInfo();

    }
}