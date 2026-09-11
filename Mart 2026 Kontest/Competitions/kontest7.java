import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class kontest7 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String balls = reader.readLine();
        int count = 0;
        int sum = 0;
        int min = 25;
        for (int i = 0; i < balls.length(); i++){
            for (int j = 25; j >= 0; j--){
                if ((int)balls.charAt(i) == 90 - j){
                    sum += j;
                    count++;
                    if (j < min){
                        min = j;
                    }
                }
            }
        }
        int avg = (int)Math.round((double)sum / count );

        if (min == 25){
            writer.write("A");
        } else{
            if (min < avg){ 
                writer.write((char)(90 - (min + 1)));
            } else{
                writer.write((char)(90 - avg));
            }
        }
        reader.close();
        writer.close();
    }
}