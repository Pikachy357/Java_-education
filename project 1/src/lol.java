import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class lol {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        long left_max = Long.MIN_VALUE;
        long right_min = Long.MAX_VALUE;
        for (int i=0; i < n; i++){
            String[] buff = reader.readLine().split(" ");
            long x = Long.parseLong(buff[0]);
            long d = Long.parseLong(buff[1]);
            long left = x-d;
            long right = x+d;
            if (left > left_max) {
                left_max = left;
            }
            if (right < right_min ){
                right_min = right;
            }
        }
        long x = 0;
        if (right_min - left_max < 0){
            x = -1;
        } else{
            x = right_min;
        }
        writer.write(x + "\n");
        reader.close();
        writer.close();
    }
}