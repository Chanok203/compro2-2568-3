

class A {
    // Overloading
    void print() {}

    void print(int a) {}

    boolean print(String a, int b) {
        return true;
    }
}

class B extends A {
    // void print() {}

    // void print(int a) {}

    // boolean print(String a, int b) {
    //     return true;
    // }

    // Overload
    String print(String a) {
        return null;
    }

    @Override // optional tag
    void print() {    }

    // Override
    boolean print(String a, int b) {
        return false;
    }
}


public class ExampleOverloadAndOverride {
    
}
