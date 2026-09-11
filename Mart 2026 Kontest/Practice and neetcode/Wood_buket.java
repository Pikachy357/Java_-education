import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Wood_buket {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] buff = reader.readLine().split(" ");
        long sum = 0;
        int p = Integer.parseInt(buff[0]);
        int v = Integer.parseInt(buff[1]);
        buff = reader.readLine().split(" ");
        int q = Integer.parseInt(buff[0]);
        int m = Integer.parseInt(buff[1]);
        long V_left = p - v;
        long V_right = p + v;
        long M_left = q -m;
        long M_right = q + m;
        if (V_right < M_left || M_right < V_left){
            sum = M_right - M_left +1 + V_right - V_left + 1;
        } else{
            long left = 0, right = 0;
            if (M_left <= V_left){
                left = M_left;
            } else{
                left = V_left;
            }
            if (M_right >= V_right){
                right = M_right;
            } else{
                right = V_right;
            }
            sum = right-left +1;
        }
        writer.write(String.valueOf(sum));
        reader.close();
        writer.close();
    }
}