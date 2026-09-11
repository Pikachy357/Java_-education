import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Task_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue <Integer> que = new ArrayDeque<>();
        boolean exit = false;
        while (!exit){
            String [] buff = reader.readLine().split(" ");
            String read = buff[0];
            switch (read){
                case "push" ->{int x = Integer.parseInt(buff[1]);que.offer(x); writer.write("ok");}
                case "pop" ->{Integer i = que.poll(); if (i == null) {writer.write("error");} else {writer.write(String.valueOf(i));}}
                case "front" ->{Integer i = que.peek(); if (i == null) {writer.write("error");} else {writer.write(String.valueOf(i));}}
                case "size" ->{writer.write(String.valueOf(que.size()));}
                case "clear" ->{que.clear(); writer.write("ok");}
                case "exit" ->{exit = true; writer.write("bye");}

            }
            writer.write('\n');
        }
        reader.close();
        writer.close();
    }
}