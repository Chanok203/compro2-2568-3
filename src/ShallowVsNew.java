import java.util.Arrays;

class Cat {
    String name;

    public Cat(String name) {
        this.name = name;
    }
    
}

public class ShallowVsNew {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = new int[a.length];
        for (int i = 0; i < b.length; i++) {
            b[i] = a[i];
        }

        b[0] = 50;
        a[1] = 100;
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}
