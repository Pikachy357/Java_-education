import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String [] buff = reader.readLine().split(" ");
        int y = Integer.parseInt(buff[0]);
        int x = Integer.parseInt(buff[1]);
        String[] image = new String[y];
        for (int i = 0; i < y; i++){
            Queue<Integer> q = new ArrayDeque<>();
            String line = reader.readLine();
            image[i] = line;
            int count = 0;
            int count_str = 0;
            for(int j = 0; j < x; j++){
                if(line.charAt(j) == '#'){
                    count++;
                }
                if(count > 0 && line.charAt(j) == '.'){
                    count_str++;
                    q.offer(count);
                    count = 0;
                }
            }
            if (count > 0){
                q.offer(count);
                count_str++;
            }
            if (count_str == 0){
                writer.write("0\n");
            } else{
                writer.write(String.valueOf(count_str) + " ");
                while(!q.isEmpty()){
                    writer.write(String.valueOf(q.poll()) + " ");
                }
                writer.write("\n");
            }
        }
        writer.write("\n");

        for (int j = 0; j < x; j++){
            Queue<Integer> q = new ArrayDeque<>();
            int count = 0;
            int count_str = 0;
            for(int i = 0; i < y; i++){
                if(image[i].charAt(j) == '#'){
                    count++;
                }
                if(count > 0 && image[i].charAt(j) == '.'){
                    count_str++;
                    q.offer(count);
                    count = 0;
                }
            }
            if (count > 0){
                q.offer(count);
                count_str++;
            }
            if (count_str == 0){
                writer.write("0\n");
            } else{
                writer.write(String.valueOf(count_str) + " ");
                while(!q.isEmpty()){
                    writer.write(String.valueOf(q.poll()) + " ");
                }
                writer.write("\n");
            }
        }
        /*
        Пример ввода и вывода числа n, где -10^9 < n < 10^9:
        int n = Integer.parseInt(reader.readLine());
        writer.write(String.valueOf(n));
        */

        reader.close();
        writer.close();
    }
}