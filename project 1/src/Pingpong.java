import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Ball {
    int x;
    int y;

     int positionX() {
        return x;
    }

     int positionY() {
        return y;
    }

     int positionX(){
        this.x = x;
    }

    int positionY(int y){
        this.y = y;
    }

}

public class Paddle {
    int x = 0;
    int y = 0;
    int size = 0;

    int positionX() {
        return x;
    }

    int positionY() {
        return y;
    }

    void positionX(int x) {
        this.x = x;
    }

    void positionY(int y) {
        this.y = y;
    }

     void position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Field{
    int x = 0;
    int y = 0;
    void changeField(int x, int y){
        this.x = x;
        this.y = y;
    }
    void showField(Ball b, Paddle p){
        for (int i = 0 ; i < y; i++){
            for (int j = 0; j < x; j++){
                if (i == 0 || i == y - 1){
                    System.out.print("-");
                } else {
                    if (j == 0 || j == x - 1){
                        System.out.print("|");
                    } else{
                        if (i == b.positionY() && j == b.positionX()){
                            System.out.print("o");
                        }
                        if ((i == b.positionY() && j == b.positionX()))
                    }
                }
            }
        }
    }
}
public class Pingpong {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        reader.close();
        writer.close();
    }
}