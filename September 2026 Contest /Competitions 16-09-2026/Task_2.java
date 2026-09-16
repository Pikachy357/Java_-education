import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Task_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String [] buff = reader.readLine().split(" ");
        int n = Integer.parseInt(buff[0]);
        int k = Integer.parseInt(buff[1]);
        String [] buff2 = reader.readLine().split(" ");
        int [] a = new int[n];
        for(int j = 0; j < n; j++){
            a[j] = Integer.parseInt(buff2[j]);
        }
        long oper = Long.MAX_VALUE;
        for (int i = -1; i <= 1; i += 2) {
            long [] c = new long[n];
            for (int j = 0; j < n; j++) {
                if (j % 2 == 0) {
                    c[j] = a[j];
                } else {
                    c[j] = (long) a[j] - i * (long) k;
                }
            }
            Arrays.sort(c);
            long mediana = c[n / 2];
            long sum = 0;
            for (int j = 0; j < n; j++) {
                sum += Math.abs(c[j] - mediana);
            }
            oper = Math.min(oper, sum);
        }
        writer.write(String.valueOf(oper));
        reader.close();
        writer.close();
    }
}