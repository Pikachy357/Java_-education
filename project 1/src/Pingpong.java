import java.util.Scanner;

class Ball {
    private int x = 0;
    private int y = 0;
    boolean left = true, dawn = true;

    Ball(Field f) {
        this.x = f.show_size_X() / 2;
        this.y = f.show_size_Y() / 2;
    }

    int show_position_X() {
        return x;
    }

    void start(Field f, boolean left) {
        if (left) {
            this.left = false;
            this.dawn = false;
        } else {
            this.left = true;
            this.dawn = true;
        }
        this.x = f.show_size_X() / 2;
        this.y = f.show_size_Y() / 2;
    }

    int show_position_Y() {
        return y;
    }

    void position_change_X(int x) {
        this.x = x;
    }

    void position_change_Y(int y) {
        this.y = y;
    }

    void next(Field f, Paddle paddle_left, Paddle paddle_right) {
        if (y == 1) {
            dawn = true;
        }
        if (y == f.show_size_Y() - 2) {
            dawn = false;
        }
        if (x == paddle_left.show_position_X() + 1) {
            if (paddle(paddle_left)) {
                left = !left;
            }
        }
        if (x == paddle_right.show_position_X() - 1) {
            if (paddle(paddle_right)) {
                left = !left;
            }
        }
        if (x == 1) {
            f.goal_left();
            start(f, true);
        }
        if (x == f.show_size_X() - 2) {
            f.goal_right();
            start(f, false);
        }
        next();
    }

    private void next() {
        if (left) {
            x--;
        } else {
            x++;
        }

        if (dawn) {
            y++;
        } else {
            y--;
        }
    }

    private boolean paddle(Paddle p) {
        if ((y >= p.show_up_Y()) && (y <= p.show_dawn_Y())) {
            return true;
        } else {
            return false;
        }
    }
}

class Paddle {
    private int y = 0;
    private int size = 0;
    private int x = 0;

    int show_size() {
        return size;
    }

    Paddle(Field f, int size, boolean left) { // true = left , false = rihgt
        this.y = f.show_size_Y() / 2;
        this.size = size;
        if (left) {
            x = 1;
        } else {
            x = f.show_size_X() - 2;
        }

    }

    void size(int s) {
        size = s;
    }

    int show_position_Y() {
        return y;
    }

    int show_position_X() {
        return x;
    }

    void position_change_Y(int y) {
        this.y = y;
    }

    int show_up_Y() {
        if (size % 2 == 0) {
            return y - size / 2 + 1;
        } else {
            return y - size / 2;
        }
    }

    int show_dawn_Y() {
        if (size % 2 == 0) {
            return y + size / 2;
        } else {
            return y + size / 2;
        }
    }

    void up() {
        if (show_up_Y() > 1) {
            y--;
        }
    }

    void dawn(Field pole) {
        if (show_dawn_Y() < pole.show_size_Y() - 2) {
            y++;
        }
    }
}

class Field {
    private int x = 0;
    private int y = 0;
    private int store_left = 0;
    private int store_right = 0;

    Field(int store_left, int store_right) {
        this.store_left = store_left;
        this.store_right = store_right;
    }

    void goal_left() {
        store_right++;
    }

    void goal_right() {
        store_left++;
    }

    int show_size_X() {
        return x;
    }

    int show_size_Y() {
        return y;
    }

    int show_store_left() {
        return store_left;
    }

    int show_store_right() {
        return store_right;
    }

    void change_Store(int store_left, int store_right) {
        this.store_left = store_left;
        this.store_right = store_right;
    }

    void change_Field(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void showField(Ball ball, Paddle left, Paddle right) {
        char c;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (i == 0 || i == y - 1) {
                    c = '-';
                } else {
                    if (j == 0 || j == x - 1) {
                        c = '|';
                    } else {
                        c = ' ';
                        if (i == ball.show_position_Y() && j == ball.show_position_X()) {
                            c = '$';
                        } else {
                            if (j == 1) {
                                if (i <= left.show_dawn_Y()
                                        && i >= left.show_up_Y()) {
                                    c = '|';
                                }
                            } else {
                                if (j == x - 2) {
                                    if (i <= right.show_dawn_Y()
                                            && i >= right.show_up_Y()) {
                                        c = '|';
                                    }
                                }
                            }
                        }

                    }
                }
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.println("Store left:" + store_left + "   Store Right:" + store_right);
        // System.out.println("paddle_left.show_position_X() - 1 =" +
        // String.valueOf(left.show_position_X() + 1));
        // System.out.println("paddle_right.show_position_X() + 1 =" +
        // String.valueOf(right.show_position_X() - 1));
        // System.out.println("ball_left.show_position_X() =" +
        // String.valueOf(ball.show_position_X()));
        // System.out.println("ball_right.show_position_Y() =" +
        // String.valueOf(ball.show_position_Y()));
    }
}

public class Pingpong {
    public static void main(String[] args) {
        Field pole = new Field(0, 0);
        pole.change_Field(51, 17);
        Paddle left_Paddle = new Paddle(pole,4 , true);
        Paddle right_Paddle = new Paddle(pole, 3, false);
        Ball ball = new Ball(pole);
        Scanner sc = new Scanner(System.in);
        do {
            pole.showField(ball, left_Paddle, right_Paddle);
            String select = sc.next();
            for (int i = 0; i < select.length(); i++) {
                switch (select.charAt(i)) {
                    case ' ' -> {
                        ball.next(pole, left_Paddle, right_Paddle);
                    }
                    case 'a' -> {
                        left_Paddle.up();
                        ball.next(pole, left_Paddle, right_Paddle);
                    }
                    case 'A' -> {
                        left_Paddle.up();
                        ball.next(pole, left_Paddle, right_Paddle);
                    }
                    case 'z' -> {
                        left_Paddle.dawn(pole);
                        ball.next(pole, left_Paddle, right_Paddle);
                    }
                    case 'Z' -> {
                        left_Paddle.dawn(pole);
                        ball.next(pole, left_Paddle, right_Paddle);
                    }
                    case 'k' -> {
                        right_Paddle.up();
                        ball.next(pole, left_Paddle, right_Paddle);
                    }
                    case 'K' -> {
                        right_Paddle.up();
                        ball.next(pole, left_Paddle, right_Paddle);
                    }
                    case 'm' -> {
                        right_Paddle.dawn(pole);
                        ball.next(pole, left_Paddle, right_Paddle);
                    }
                    case 'M' -> {
                        right_Paddle.dawn(pole);
                        ball.next(pole, left_Paddle, right_Paddle);
                    }

                    default -> {
                    }

                }
            }
        } while (pole.show_store_left() != 1 && pole.show_store_right() != 1);

        if (pole.show_store_left()>pole.show_store_right()){
            System.out.println("Win left_paddle with the score | left: " + pole.show_store_left()+" |right: " + pole.show_store_right()+ " |");
        } else{
            System.out.println("Win right_paddle with the score | right: " + pole.show_store_right() + " |left: " + pole.show_store_left() + " |");
        }
    }
}