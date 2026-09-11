import java.util.Scanner;

public class Inizal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        show_menu();
        start_select(sc);
    }

    static void show_menu() {
        System.out.println("введите вариант: 1 - слож/выч/умнож/дел/дел по мод - 2 целых чисел");
        System.out.println("введите вариант: 2 - приведение типа и инициализация переменных");
        System.out.println("введите вариант: 3 - для ввода масива из n элементов ");
        System.out.println("введите вариант: 4 - считываем символ и выводим его asci код");
    }

    static boolean two_int(Scanner sc) {
        System.out.println("введите 2 целых числа:");
        boolean error = false;
        Integer a = add_int(sc);
        if (a == null)
            error = true;
        if (!error) {
            Integer b = add_int(sc);
            if (b == null)
                error = true;
            if (!error) {
                System.out.println(a + "+" + b + " = " + (a + b));
                System.out.println(a + "-" + b + " = " + (a - b));
                System.out.println(a + "*" + b + " = " + a * b);
                System.out.println(a + "/" + b + " = " + (double) a / b);
                System.out.println(a + "%" + b + " = " + (a % b));
            }

        }
        return error;
    }

    static void print_peren() {
        byte b = 16;
        short s = 257;
        int x = 2000000000;
        double d = 1.23123123;
        float f = 2312.2131F;
        int a = (int) d;
        double d2 = x;
        System.out.println("int = " + x);
        System.out.println("byte = " + b);
        System.out.println("short = " + s);
        System.out.println("int = " + x);
        System.out.println("double = " + d);
        System.out.println("float = " + f);
        System.out.println("(int) double = " + a);
        System.out.println("double2 = " + d2);
    }

    static boolean read_arr(Scanner sc) {
        boolean error = false;
        System.out.println("Введите n (количество элементов массива):");
        Integer n = add_int(sc);
        if (n < 1 || n == null) {
            error = true;
        }
        if (!error) {
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = add_int(sc);
                if (arr[i] == null) {
                    error = true;
                    break;
                }
            }
            if (!error) {
                int sum = arr[0], max = arr[0], min = arr[0];
                for (int i = 1; i < n; i++) {
                    sum += arr[i];
                    if (arr[i] > max) {
                        max = arr[i];
                    }
                    if (arr[i] < min) {
                        min = arr[i];
                    }
                }
                double avg = (double) sum / n;
                System.out.println("sum = " + sum + "max = " + max + "min = " + min + "abg = " + avg);
            }
        }
        return error;
    }

    static Integer add_int(Scanner sc) {
        Integer x = 0;
        if (!sc.hasNextInt()) {
            x = null;
        }
        if (x != null) {
            x = sc.nextInt();
        }
        return x;
    }

    static void start_select(Scanner sc) {
        boolean error = false;
        Integer select = add_int(sc);
        if (select == null) {
            error = true;
        }
        if (!error) {
            switch (select) {
                case 1 -> {
                    if (!error)
                        error = two_int(sc);
                }
                case 2 -> {
                    print_peren();
                }
                case 3 -> {
                    if (!error)
                        error = read_arr(sc);
                }
                case 4 -> {
                    System.out.print("Ведите один символ : ");
                    String line = sc.nextLine();
                    if (line.length() != 1) {
                        error = true;
                    }
                    if (!error) {
                        char c = line.charAt(0);
                        System.out.println("введён символ - " + c + "его ASCI кол - " + (int) c);
                    }

                }
                default -> {
                    error = true;
                }
            }
        }

        if (error) {
            System.out.println("n/a");
        }
    }
}
