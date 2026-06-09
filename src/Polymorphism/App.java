package Polymorphism;


class Animal {
    String name;
    Animal(String name) {
        this.name = name;
    }

    void say() {
        System.out.println("I am " + name);
    }
}

class Dog extends Animal {
    String name = "Dog";
    Dog(String name) {
        super(name);
    }

    String getName() {
        return super.name;
    }

    @Override
    void say() {
        System.out.print("Dog: ");
        super.say();
    }
}

class Cat extends Animal {

    Cat(String name) {
        super(name);
    }

    void say() {
        System.out.print("Cat: ");
        super.say();
    }
}

class Golden extends Dog {
    Golden(String name) {
        super(name);
    }
}

public class App {
    public static void main(String[] args) {
        Animal d1 = new Dog("d1");
        System.out.println(d1.name);
    }
}
