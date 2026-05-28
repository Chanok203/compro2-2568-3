package ComSpec;
import java.util.Scanner;

class CPU2 {
    public String model;
    public int clocks;
    public int socket;
    public int memType;
    public boolean valid;

    CPU2(String model, int clocks, int socket, int memType) {
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

class MainBoard {
    public String model;
    public int socket;
    public int memType;
    public boolean valid;

    MainBoard(String model, int socket, int memType) {
        this.model = model;
        this.socket = socket;
        this.memType = memType;
        this.valid = this.isValidSpec(model, socket, memType);
    }

    boolean isValidSpec(String model, int socket, int memType) {
        if (model == null || model.isEmpty()) {
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
        System.out.println(this.socket);
        System.out.println(this.memType);
        System.out.println(this.valid);
    }
}

class Computer {
    public MainBoard mb;
    public CPU2 cpu;
    public boolean valid;

    Computer(MainBoard mb, CPU2 cpu) {
        this.mb = mb;
        this.cpu = cpu;
        this.valid = this.isValidCom(mb, cpu);
    }

    boolean isValidCom(MainBoard mb, CPU2 cpu) {
        if (!this.cpu.valid || !this.mb.valid) {
            return false;
        }
        if (this.cpu.socket != this.mb.socket) {
            return false;
        }
        if (this.cpu.memType != this.mb.memType) {
            return false;
        }
        return true;
    }

    void printInfo() {
        if (this.valid) {
            System.out.println(this.cpu.model);
            System.out.println(this.cpu.clocks);
            System.out.println(this.mb.model);
            System.out.println(this.mb.socket);
            System.out.println(this.mb.memType);
        } else {
            System.out.println("Invalid Spec");
            this.cpu.printInfo();
            this.mb.printInfo();
        }
    }

}

public class MBCompat {
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

        sc.nextLine();
        model = sc.nextLine();
        socket = sc.nextInt();
        memType = sc.nextInt();
        if (model.length() == 0 && socket % 2 == 0) {
            model = null;
        }
        MainBoard mb = new MainBoard(model, socket, memType);
        Computer com = new Computer(mb, cpu);
        com.printInfo();
    }
}
