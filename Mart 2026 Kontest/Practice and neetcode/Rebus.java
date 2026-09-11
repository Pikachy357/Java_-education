import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Rebus {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String [] buff = reader.readLine().split(" ");
        for (String x:buff){
            int left = 0, right = 0; Boolean f = false;
            for(int i = 0; i < x.length(); i++){
                if ((int)x.charAt(i) == 39 && !f){
                    left++;
                } else{
                    f = true;
                }
                if (f){
                    if ((int)x.charAt(i) == 39){
                        right++;
                    }
                }

            }

            for (int i = 2*left; i < x.length() - right * 2; i++){
                writer.write(x.charAt(i));
            }

        }

        reader.close();
        writer.close();
    }
}