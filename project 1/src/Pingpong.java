class Ball {
    private int x = 0;
    private int y = 0;

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

}

class Paddle {
    private int y = 0;
    private int size = 0;

    int show_size(){
        return size;
    }

    Paddle(Field f, int size) {
        this.y = f.show_size_X() / 2 ;
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
    private int x = 0;
    private int y = 0;

    int show_size_X(){
        return x;
    }
    int show_size_Y(){
        return y;
    }
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
    public static void main(String[] args){

        int store_left = 0, store_right = 0;

        Field pole = new Field();
        pole.changeField(51, 17);
        Paddle left_Paddle = new Paddle(pole, 3);
        Paddle right_Paddle = new Paddle(pole, 3);
        Ball ball = new Ball(pole);
        pole.showField(ball, left_Paddle, right_Paddle, store_left, store_right);



    }
}