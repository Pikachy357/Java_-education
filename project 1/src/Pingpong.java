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
        if (y == 1 || y == f.show_size_Y() - 1 || x == 2 || x == f.show_size_Y() - 2) {
            if (y == 1) {
                dawn = true;
                next();
            }
            if (y == f.show_size_Y() - 1) {
                dawn = false;
                next();
            }
            if (x == 2) {
                if (paddle(paddle_left)) {
                    x = f.show_size_X() / 2;
                    y = f.show_size_Y() / 2;
                    dawn = !dawn;
                    left = !left;
                    next();
                } else {

                }
            }
        } else {
            next();
        }
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
    private boolean paddle(Paddle p){
        if ((y >= p.show_up_Y()) && (y <= p.show_dawn_Y())){
            return true;
        } else {
            return false;
        }
    }
}

class Paddle {
    private int y = 0;
    private int size = 0;

    int show_size() {
        return size;
    }

    Paddle(Field f, int size) {
        this.y = f.show_size_Y() / 2;
        this.size = size;

    }

    void size(int s) {
        size = s;
    }

    int show_position_Y() {
        return y;
    }
    

    void position_change_Y(int y) {
        this.y = y;
    }

    int show_up_Y (){
        if (size % 2 == 0){
            return y - size/2 + 1;
        }else {
            return y - size/2 ;
        }
    }
    int show_dawn_Y (){
        if (size % 2 == 0){
            return y + size/2 ;
        }else {
            return y + size/2 ;
        }
    }

    void up(Field pole) {
        if (show_dawn_Y() >= 1) {
            y--;
        }
    }
}

class Field {
    private int x = 0;
    private int y = 0;

    int show_size_X() {
        return x;
    }

    int show_size_Y() {
        return y;
    }

    void changeField(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void showField(Ball ball, Paddle left, Paddle right, int store_left, int store_right) {
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
                            c = 'o';
                        } else {
                            if (j == 1) {
                                if (i <= left.show_position_Y() + (left.show_size() / 2)
                                        && i >= left.show_position_Y() - (left.show_size() / 2)) {
                                    c = '|';
                                }
                            } else {
                                if (j == x - 2) {
                                    if (i <= right.show_position_Y() + (right.show_size() / 2)
                                            && i >= right.show_position_Y() - (right.show_size() / 2)) {
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
    }
}

public class Pingpong {
    public static void main(String[] args) {
        int store_left = 0, store_right = 0;
        Field pole = new Field();
        pole.changeField(51, 17);
        Paddle left_Paddle = new Paddle(pole, 3);
        Paddle right_Paddle = new Paddle(pole, 3);
        Ball ball = new Ball(pole);
        Scanner sc = new Scanner(System.in);
        do {
            pole.showField(ball, left_Paddle, right_Paddle, store_left, store_right);
            String select = sc.next();
            for (int i = 0; i < select.length(); i++) {
                switch (select.charAt(i)) {
                    case ' ' -> {
                    }
                    case 'a' -> {
                        left_Paddle.up(pole);
                        ball.next(pole, left_Paddle, right_Paddle);
                    }
                    case 'A' -> {
                        left_Paddle.up(pole);
                    }
                    case 'z' -> {
                    }
                    case 'Z' -> {
                    }
                    case 'k' -> {
                    }
                    case 'K' -> {
                    }
                    case 'm' -> {
                    }
                    case 'M' -> {
                    }

                    default -> {
                    }

                }
            }
        } while (store_left < 3 || store_right < 3);

    }
}