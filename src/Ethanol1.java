import java.util.Scanner;

class Ethanol {
    int intensity;
    int capacity;
    int remaining;

    public Ethanol(int intensity, int capacity) {
        this.intensity = intensity;
        this.capacity = capacity;
        this.remaining = capacity;
    }

    void used(int x) {
        this.remaining -= x;
        if (this.remaining < 0) {
            this.remaining = 0;
        }
    }

    void printInfo() {
        String line = String.format(
                "Ethanol %d%% (%dml./%dml.)",
                this.intensity,
                this.remaining,
                this.capacity);
        System.out.println(line);
    }
}

public class Ethanol1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int intensity = sc.nextInt();
        int capacity = sc.nextInt();
        Ethanol ethanol = new Ethanol(intensity, capacity);

        int x = sc.nextInt();
        ethanol.used(x);
        ethanol.printInfo();
    }
}
