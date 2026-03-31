import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class lolo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        long [] preff = new long[2*n+1];
        String shcool = reader.readLine();
        preff[n]= 1;
        int count = 0;
        int x = 0;
        for (int i = 0; i < n; i++){
            if (shcool.charAt(i) == 'a'){
                count++;
            } else{
                count--;
            }
            int j = count + n;
            x += preff[j];
            preff[j]++;
        }
        System.out.println(x);
        reader.close();
        writer.close();
    }
}