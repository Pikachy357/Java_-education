package practice.block3.quicksort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Task1 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        if (n != 0){
            String [] buff = reader.readLine().split(" ");
            long [] a = new long[n];
            for(int i = 0; i < n; i++){
                a[i] = Long.parseLong(buff[i]);
            }
            long x = Long.parseLong(reader.readLine());
            int count = 0;
            for(int i = 0; i < n; i++){
                if (a[i] < x){
                    count++;
                }
            }
            writer.write(String.valueOf(count) + "\n" + String.valueOf(n - count));
        } else{
            writer.write("0\n0");
        }
        reader.close();
        writer.close();
    }
}