import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;


public class Task_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String buff [] = new String[2];
        buff = reader.readLine().split(" ");
        int n = Integer.parseInt(buff[0]);
        int summ = Integer.parseInt(buff[1]);
        Map <Integer, Integer> chisl = new HashMap<>();
        String buff2 [] = new String[n];
        buff2 = reader.readLine().split(" ");
        for (int i = 0 ; i < n; i++){
            int x = Integer.parseInt(buff2[i]);
            if (chisl.containsKey(x)){
                chisl.put(x,chisl.get (x) + 1);
            } else{
                chisl.put(x,1);
            }
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> s : chisl.entrySet()){
            int y = summ - s.getKey(), x = s.getKey();
            if (chisl.containsKey(y) && x < y) {
                count += Math.min(chisl.get(y), chisl.get(x));
            } else if (x == y) {
                count += s.getValue() - 1;
            }

        }
        writer.write(String.valueOf(count));
        reader.close();
        writer.close();
    }
}