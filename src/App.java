
class Dog {
    static int count = 0;

    Dog() {
        Dog.count++;
    }
}
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(Dog.count); // 0

        Dog d1 = new Dog();
        Dog d2 = new Dog();
        System.out.println(Dog.count); // 2
        System.out.println(d1.count);  // 2
        System.out.println(d2.count);  // 2
    }
}
