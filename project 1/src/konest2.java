import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class konest2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] buff = reader.readLine().split(" ");
        int n = Integer.parseInt(buff[0]);
        int m = Integer.parseInt(buff[1]);
        int[] mass = new int[1000000000];
        for (int i=0; i < n; i++){
            String[] buff2 = reader.readLine().split(" ");
            int l = Integer.parseInt(buff2[0]);
            int r = Integer.parseInt(buff2[1]);
            int x = Integer.parseInt(buff2[2]);
            for(int j=l; j<=r; j++){
                if (i % 2 == 0) {mass[j] += x;}
                if (i % 2 == 1) {mass[j] -= x;}
            }
        }
        for (int k=0; k<m; k++){
            writer.write(String.valueOf(mass[Integer.parseInt(reader.readLine())]));
        }
        reader.close();
        writer.close();
    }
}