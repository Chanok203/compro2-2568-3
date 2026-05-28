package ComSpec;
import java.util.Scanner;

class CPU1 {
    public String model;
    public int clocks;
    public int socket;
    public int memType;
    public boolean valid;

    CPU1(String model, int clocks, int socket, int memType) {
        this.model = model;
        this.clocks = clocks;
        this.socket = socket;
        this.memType = memType;
        this.valid = this.isValidSpec(model, clocks, socket, memType);
    }

    boolean isValidSpec(String model, int clocks, int socket, int memType) {
        if (model == null || model.isEmpty()) {
            return false;
        }
        if (clocks <= 0) {
            return false;
        }
        if (socket <= 0) {
            return false;
        }
        if (memType <= 0 || 10 < memType) {
            return false;
        }
        return true;
    }

    void printInfo() {
        System.out.println(this.model);
        System.out.println(this.clocks);
        System.out.println(this.socket);
        System.out.println(this.memType);
        System.out.println(this.valid);
    }

}

public class CPUSpec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String model = sc.nextLine();
        int clocks = sc.nextInt();
        int socket = sc.nextInt();
        int memType = sc.nextInt();
        if (model.length() == 0 && socket % 2 == 0) {
            model = null;
        }
        CPU2 cpu = new CPU2(model, clocks, socket, memType);
        cpu.printInfo();
    }
}
