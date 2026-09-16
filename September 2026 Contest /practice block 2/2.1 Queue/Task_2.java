import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Queue;
import java.util.ArrayDeque;

public class Task_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue <Integer> first = new ArrayDeque<>();
        Queue <Integer> second = new ArrayDeque<>();
        String [] buff1 = reader.readLine().split(" ");
        String [] buff2 = reader.readLine().split(" ");
        for (int i = 0; i < 5; i++){
            first.offer(Integer.parseInt(buff1[i]));
            second.offer(Integer.parseInt(buff2[i]));
        }
        int count = 0;
        while (!first.isEmpty() && !second.isEmpty() && count < 1000000){
            count++;
            if (first.peek() == 0 && second.peek() == 9){
                first.offer(first.poll());
                first.offer(second.poll());
                continue;
            }
            if (first.peek() == 9 && second.peek() == 0){
                second.offer(first.poll());
                second.offer(second.poll());
                continue;
            }
            if (first.peek() > second.peek()){
                first.offer(first.poll());
                first.offer(second.poll());
            } else{
                second.offer(first.poll());
                second.offer(second.poll());
            }
        }
        if (first.isEmpty()){
            writer.write("second " + count);
        } else{
            if (second.isEmpty()){
                writer.write("first " + count);
            } else {
                writer.write("botva");
            }
        }
        reader.close();
        writer.close();
    }
}