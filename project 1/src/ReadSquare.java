import java.util.Scanner;

public class ReadSquare {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Введи 5 чисел:");

            int[] a = new int[5];
            for (int i = 0; i < 5; i++) {
                a[i] = sc.nextInt();
            }

            int max = a[0];
            for (int i = 1; i < 5; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }

            System.out.println("Максимальное число " + max);
        }
    }
}