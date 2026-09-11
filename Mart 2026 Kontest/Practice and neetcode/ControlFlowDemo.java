import java.util.Scanner;

public class ControlFlowDemo {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Mode (1-sum, 2-countdown, 3-day): ");
            int mode = sc.nextInt();

            if (mode < 1 || mode > 3) {
                System.out.println("Unknown mode");
                return;
            }

            switch (mode) {
                case 1 -> {
                    System.out.print("n = ");
                    int n = sc.nextInt();

                    long sum = 0;
                    for (int i = 1; i <= n; i++) {
                        sum += i;
                    }
                    System.out.println("sum = " + sum);
                }
                case 2 -> {
                    System.out.print("start = ");
                    int x = sc.nextInt();

                    while (x > 0) {
                        System.out.print(x + " ");
                        x--;
                    }
                    System.out.println();
                }
                case 3 -> {
                    System.out.print("day (1-7) = ");
                    int d = sc.nextInt();

                    String name = switch (d) {
                        case 1 -> "Mon";
                        case 2 -> "Tue";
                        case 3 -> "Wed";
                        case 4 -> "Thu";
                        case 5 -> "Fri";
                        case 6 -> "Sat";
                        case 7 -> "Sun";
                        default -> "???";
                    };

                    System.out.println("day = " + name);
                }
            }
        }
    }
}