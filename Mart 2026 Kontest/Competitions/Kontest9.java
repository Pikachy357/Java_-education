import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Kontest9{
    public static void main(String[] args)throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] buff = reader.readLine().split(" ");
        int n = Integer.parseInt(buff[0]);
        int k = Integer.parseInt(buff[1]);
        String [] detal = reader.readLine().split(" ");
        int count = 0;
        for (int i = 0; i < n; i++){
            if (Integer.parseInt(detal[i]) >= k){
                count++;
            } else{
                break;
            }
        }
        writer.write(String.valueOf(count)+ " ");
        reader.close();
        writer.close();
    }
}