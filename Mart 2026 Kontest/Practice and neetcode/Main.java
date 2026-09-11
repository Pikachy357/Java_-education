public class Main {
    public static void main(String[] args) {
        User first = new User("Даниил");
        User second = new User("Анна");

        first.showInfo();
        second.showInfo();

        User.showCreatedCount();

        System.out.println("Квадрат числа 5: " + Utils.square(5));
    }

    class Utils {
        public static int square(int x) {
            return x * x;
        }
    }
}

class User {
    public String role = "student";
    private String name;
    private int loginAttempts;
    private static int createdCount = 0;

    public User(String name) {
        this.name = name;
        this.loginAttempts = 0;
        createdCount++;
    }

    public void showInfo() {
        System.out.println("Имя: " + name + ", роль: " + role);
        secret();
    }

    private void secret() {
        System.out.println("Внутренний счетчик входов: " + loginAttempts);
    }

    public static void showCreatedCount() {
        System.out.println("Создано объектов: " + createdCount);
    }
}