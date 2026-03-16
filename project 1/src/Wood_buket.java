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
        int sum = 0;
        int p = Integer.parseInt(buff[0]);
        int v = Integer.parseInt(buff[1]);
        buff = reader.readLine().split(" ");
        int q = Integer.parseInt(buff[0]);
        int m = Integer.parseInt(buff[1]);
        boolean v1 = true;
        boolean m1 = true;
        if (p == q && v == m){
            sum = v*2+1;
        }
        if (m == 0) {
            
        }

        if ((p+v == q-m) || (q+m == p-v)){
            sum = v*2+1 + m*2;
        }
        if (q+m > p+v){
            sum = (q+m) - (p-v)* + 1;
        }
        if (p+v > q+m){
            sum = (p+v) - (q-m) + 1;
        }
        writer.write(String.valueOf(sum));
        reader.close();
        writer.close();
    }
}