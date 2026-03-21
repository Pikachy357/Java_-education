import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Bunker {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Long.parseLong(reader.readLine());
        int abs = 0;
        if (n == Math.sqrt(n)*Math.sqrt(n)){
            writer.write("0");
        } else {
            for (int i = (int)Math.sqrt(n)+1; i >= 1; i--){
                long buff = n;
                int count = 0;
                int max = 0;
                if (buff == i){
                    count = 2;
                    max = 1;
                     }   
                    else {
                    count = (int) (buff / i);
                    max = i;
                    break;
                    }
                while (buff > 0){
                    buff -= i;
                    count++;
                    if (buff == 0 || buff < 0){
                        break;

                    } 
                    buff -= (i-1);
                    count++;
                    max = i;
                }
                if (buff == 0){
                    abs = count - max;
                    break;
                }
            }

            if (abs < 0){
                abs = -abs;
            }
            writer.write(abs + " ");
            }

 
        reader.close();
        writer.close();
        }

    }