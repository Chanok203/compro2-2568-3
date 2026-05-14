import java.util.Scanner;

class TheaterV2 {
    String title;
    boolean threeD;
    boolean luxury;
    boolean[] seats;
    int basePrice;

    TheaterV2(boolean threeD, boolean luxury, int numSeats) {
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

    private boolean canReserve(int seatNumber) {
        if (seatNumber <= 0 || this.seats.length <= seatNumber) {
            return false;
        }
        return !this.seats[seatNumber];
    }

    int reserveOne(int seatNumber) {
        if (!this.canReserve(seatNumber)) {
            System.out.println("sorry");
            return -1;
        }
        this.seats[seatNumber] = true;
        return this.basePrice;
    }

    int reserveMultiple(int numSeats, int seatNumber) {
        for (int i = seatNumber; i < seatNumber + numSeats; i++) {
            if (!canReserve(i)) {
                System.out.println("sorry");
                return -1;
            }
        }
        for (int i = seatNumber; i < seatNumber + numSeats; i++) {
            this.seats[i] = true;
        }
        return this.basePrice * numSeats;
    }

}

public class Theater2 {
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
        TheaterV2 t = new TheaterV2(threeD, luxury, numSeats);

        String dummy = scan.nextLine(); // throw away new line character
        String title = scan.nextLine();
        t.setTitle(title);

        int basePrice = scan.nextInt();
        t.setBasePrice(basePrice);

        int N = scan.nextInt();
        for (int i = 0; i < N; ++i) {
            int numberOfSeats = scan.nextInt();
            int seatNumber = scan.nextInt();
            int totalPrice;
            if (numberOfSeats == 1)
                totalPrice = t.reserveOne(seatNumber);
            else
                totalPrice = t.reserveMultiple(numberOfSeats, seatNumber);
            if (totalPrice > 0)
                System.out.println(totalPrice);
        }

        t.printInfo();

    }
}
