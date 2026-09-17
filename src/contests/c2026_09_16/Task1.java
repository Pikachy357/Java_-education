package contests.c2026_09_16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Task1 {
    public static long count_qvad(long a, long b){
        long t = a;
        if (a < b){
            a = b;
            b = t;
        }
        if (a % b != 0){
            long count = a / b;
            long next_a = a % b;
            return count + count_qvad(next_a, b);
        } else{
            return a / b;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String [] buff = reader.readLine().split(" ");
        long a = Long.parseLong(buff[0]);
        long b = Long.parseLong(buff[1]);
        writer.write(String.valueOf(count_qvad(a,b)));
        reader.close();
        writer.close();
    }
}