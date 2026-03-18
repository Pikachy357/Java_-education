import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Kontest2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] buff = reader.readLine().split(" ");
        int n = Integer.parseInt(buff[0]);
        int m = Integer.parseInt(buff[1]);
        int[] l = new int[n];
        int[] r = new int[n];
        int[] x = new int[n];

        for (int i=0; i < n; i++){
            String[] buff2 = reader.readLine().split(" ");
            l[i] = Integer.parseInt(buff2[0]);
            r[i] = Integer.parseInt(buff2[1]);
            x[i] = Integer.parseInt(buff2[2]);
        }
        for(int i=0; i< m; i++){
            int q = Integer.parseInt(reader.readLine());
            int mass = 0 ;
            for(int j = 0; j < n; j++){
                if (q >= l[j] && q <= r[j]){
                    if ((q-l[j]) % 2 == 0){
                        mass += x[j];
                    } else {
                        mass -= x[j];
                    }
                }
            }
            writer.write(mass + "\n");
        }
        reader.close();
        writer.close();
    }
}