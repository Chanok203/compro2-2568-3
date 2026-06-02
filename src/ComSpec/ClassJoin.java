package ComSpec;

import java.util.Scanner;

class Component {
    String model;
    int socket;
    int memType;
    boolean valid;

    Component(String model, int socket, int memType) {
        this.model = model;
        this.socket = socket;
        this.memType = memType;
    }

    void printInfo() {
        System.out.println(this.valid);
        System.out.println(this.model);
        System.out.println(this.socket);
        System.out.println(this.memType);
    }

}

class MainBoard3 extends Component {
    // String model;
    // int socket;
    // int memType;
    // boolean valid;

    // void printInfo() {
    // System.out.println(this.valid);
    // System.out.println(this.model);
    // System.out.println(this.socket);
    // System.out.println(this.memType);
    // }

    MainBoard3(String model, int socket, int memType) {
        super(model, socket, memType);
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
}

class CPU3 extends Component {
    // String model;
    // int socket;
    // int memType;
    // boolean valid;
    int clocks;

    @Override
    void printInfo() {
        super.printInfo();
        System.out.println(clocks);
    }

    CPU3(String model, int clocks, int socket, int memType) {
        super(model, socket, memType);
        this.clocks = clocks;
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
}

public class ClassJoin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String model = sc.nextLine();
        int clocks = sc.nextInt();
        int socket = sc.nextInt();
        int memType = sc.nextInt();

        if (model.length() == 0 && socket % 2 == 0) {
            model = null;
        }

        Component cpu = new CPU3(model, clocks, socket, memType);
        cpu.printInfo();

        sc.nextLine();
        model = sc.nextLine();
        socket = sc.nextInt();
        memType = sc.nextInt();
        
        if (model.length() == 0 && socket % 2 == 0) {
            model = null;
        }

        Component mb = new MainBoard3(model, socket, memType);
        mb.printInfo();
    }
}
