import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Kontest5 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        String [] names = new String[n];
        int [] bals = new int[n];
        for (int i=0; i < n; i++){
            names[i] = reader.readLine();
        }
        int m = Integer.parseInt(reader.readLine());
        int prevA =0, prevB = 0;
        for (int i = 0; i < m; i++){
            String[] buff = reader.readLine().split(" ");
            String[] count = buff[0].split(":");

            int a = Integer.parseInt(count[0]);
            int b = Integer.parseInt(count[1]);
            int ball = a - prevA + b - prevB;
            for (int j = 0; j < n; j++){
                if (names[j].equals(buff[1])){
                    bals[j] += ball;
                    break;
                }
             }
            prevA = a;
            prevB = b;
        }
        int max = 0, k = 0;
            for (int j = 0; j < n; j++){
                if (bals[j] > max){
                    k = j;
                    max = bals[j];
                }
             }
        writer.write(names[k] + " " + bals[k]);
        reader.close();
        writer.close();
    }
}