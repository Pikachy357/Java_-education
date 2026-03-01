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
    int select = 0;
    System.out.println("введите вариант: 1 - слож/выч/умнож/дел/дел по мод - 2 целых чисел");
    System.out.println("введите вариант: 2 - приведение типа и инициализация переменных    "
                 + " byte b = 16;\n" + //
                "    short s = 257;\n" + //
                "    int x = 2000000000;\n" + //
                "    double d = 1.23123123;\n" + //
                "    float f = 2312.2131F;\n" + //
                "    int a = (int) d;\n" + //
                "    double d2 = x;");
    System.out.println("введите вариант: 3 - для ввода масива из n элементов ");
    System.out.println("введите вариант: 4 - считываем символ и выводим его asci код");
    if (!sc.hasNextInt()) {
        error = true;
    }
    if (!error) {
        select = sc.nextInt();
    }
    if (!error) {
        switch (select){
            case 1 -> {
                System.out.println("введите 2 целых числа:");
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
                if (!error){
                System.out.println("a1+b1 = " + (a1 + b1));
                System.out.println("a1-b1 = " + (a1 - b1));
                System.out.println("a1*b1 = " + a1 * b1);
                System.out.println("a1/b1 = " + a1 / b1);
                System.out.println("a1%b1 = " + (a1 % b1));
                }
            }
            case 2 -> {
                System.out.println("int = " + x);
                System.out.println("byte = " + b);
                System.out.println("short = " + s);
                System.out.println("int = " + x);
                System.out.println("double = " + d);
                System.out.println("float = " + f);
                System.out.println("(int) double = " + a);
                System.out.println("double2 = " + d2);
            }
            case 3 ->{
                System.out.println("Введите n (количество элементов массива):");
                    if (!sc.hasNextInt()) {
                        error = true;
                    }
                    if (!error){
                        int n = sc.nextInt();
                        if (n<1){
                            error = true;
                        }
                        if (!error){
                            int[] arr = new int[n];   
                            int sum = arr[0], max = arr[0], min = arr[0];                 
                            for (int i = 1; i > n-1; i++ ){
                                sum += arr[i];
                                if (arr[i] > max){
                                    max = arr[i];
                                } else {
                                    min = arr[i];
                                }
                            }
                            double avg = sum / n;
                            System.out.println("sum = " + sum + "max = " + max + "min = " + min + "abg = " + avg);
                        }
                    }
            }
            case 4 ->{

            }
        }
    }

    if (error) {
        System.out.println("n/a");
    }
}