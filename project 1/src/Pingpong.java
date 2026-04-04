import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

 class Ball {
    int x = 0;
    int y = 0;

    Ball(int x, int y){
        this.x = x;
        this.y =y;
    }
     int show_position_X() {
        return x;
    }

     int show_position_Y() {
        return y;
    }

    void position_change_X(int x){
        this.x = x;
    }

    void position_change_Y(int y){
        this.y = y;
    }

}

 class Paddle {
    int x = 0;
    int y = 0;
    int size = 0;

    Paddle(int y, int size){
        this.y = y;
        this.size = size;
    }

    void size(int s){
        size = s;
    }

    int show_position_Y() {
        return y;
    }

     void position_change_Y( int y) {
        this.y = y;
    }
}
 class Field{
    int x = 0;
    int y = 0;
    void changeField(int x, int y){
        this.x = x;
        this.y = y;
    }
    void showField(Ball b, Paddle left, Paddle right){
        for (int i = 0 ; i < y; i++){
            for (int j = 0; j < x; j++){
                if (i == 0 || i == y - 1){
                    System.out.print("-");
                } else {
                    if (j == 0 || j == x - 1){
                        System.out.print("|");
                    } else{

                        if(j == 1){
                            if (i < left.show_position_Y() + (left.size / 2) && i > left.show_position_Y() - (left.size / 2) ){
                                System.out.print("|");
                            }
                        }
                        if(j == x-2){
                            if (i < right.show_position_Y() + (right.size / 2) && i > right.show_position_Y() - (right.size / 2) ){
                                System.out.print("|");
                            }
                        }
                        if (i == b.show_position_Y() && j == b.show_position_X()){
                            System.out.print("o");
                        }
                    }
                }
            }
            System.out.println();
        }
    }
}
public class Pingpong {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        Field pole = new Field();
        pole.changeField(10,10);
        Paddle left = new Paddle(1 , 2);
        Paddle right = new Paddle(pole.x - 1, 2);
        Ball b = new Ball(pole.x/2,pole.y/2);
        pole.showField(b, left, right);
        reader.close();
        writer.close();
    }
}