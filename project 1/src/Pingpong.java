import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Ball {
    int x = 0;
    int y = 0;

    Ball(int x, int y) {
        this.x = x;
        this.y = y;
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

}

class Paddle {
    int x = 0;
    int y = 0;
    int size = 0;

    Paddle(int y, int size) {
        this.y = y;
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
}

class Field {
    int x = 0;
    int y = 0;

    void changeField(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void showField(Ball b, Paddle left, Paddle right, int store_left, int store_right) {
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
                        if (i == b.show_position_Y() && j == b.show_position_X()) {
                            c = 'o';
                        } else {
                            if (j == 1) {
                                if (i <= left.show_position_Y() + (left.size / 2)
                                        && i >= left.show_position_Y() - (left.size / 2)) {
                                    c = '|';
                                }
                            } else {
                                if (j == x - 2) {
                                    if (i <= right.show_position_Y() + (right.size / 2)
                                            && i >= right.show_position_Y() - (right.size / 2)) {
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
    public static void main(String[] args) throws IOException {
        int store_left = 0, store_right = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        Field pole = new Field();
        pole.changeField(51, 17);
        Paddle left = new Paddle(pole.y / 2, 3);
        Paddle right = new Paddle(pole.y / 2, 3);
        Ball b = new Ball(pole.x / 2, pole.y / 2);
        pole.showField(b, left, right, store_left, store_right);
        reader.close();
        writer.close();
    }
}