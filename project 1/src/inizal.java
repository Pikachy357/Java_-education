import java.util.Scanner;

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    byte b = 16;
    short s = 257;
    int x = 2000000000;
    double d = 1.23123123;
    float f = 2312.2131F;
    int a = (int) d;
    double d2 = x;
    boolean error = false;
    if (!sc.hasNextInt()) {
        error = true;
    }
    int a1 = 0;
    if (!error) {
        a1 = sc.nextInt();
    }
    if (!sc.hasNextInt()) {
        error = true;
    }
    int b1 = 0;
    if (!error) {
        b1 = sc.nextInt();
    }
    if (!error) {
        if (b1 == 0) {
            error = true;
        }
    }
    if (!error) {
        System.out.println("a1+b1 = " + a1 + b1);
        System.out.println("a1-b1 = " + (a1 - b1));
        System.out.println("a1*b1 = " + a1 * b1);
        System.out.println("a1/b1 = " + a1 / b1);
        System.out.println("a1%b1 = " + a1 % b1);
        System.out.println("int = " + x);
        System.out.println("byte = " + b);
        System.out.println("short = " + s);
        System.out.println("int = " + x);
        System.out.println("double = " + d);
        System.out.println("float = " + f);
        System.out.println("(int) double = " + a);
        System.out.println("double2 = " + d2);
        System.out.println("");
    } else {
        System.out.println("n/a");
    }
}