import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Kontest11 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String [] string_balls = reader.readLine().split(" ");
        short [] short_balls = new short[string_balls.length];
        for (int i = 0; i < string_balls.length ; i++){
            short_balls[i] = Short.parseShort(string_balls[i]);
        }
        short count = 1;
        short max = 0;
        for(int i = 0; i < string_balls.length - 1; i++){
            if (!delete && short_balls[i] == short_balls[i+1]){
                count++;
            } else{
                if (count >= 3){
                    max += count;
                    delete = true;
                } else{

                    count = 1;
                }
            }
            if (delete && i - count > = 0){
                int j =  count;
                count2 = 1;
                while (short_balls[i - j] == short_balls[i+1]){
                    j++;
                }


            } else{
                delete = false;
            }
        } 
        reader.close();
        writer.close();
    }
}