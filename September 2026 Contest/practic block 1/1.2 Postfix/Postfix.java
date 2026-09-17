import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Postfix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = reader.readLine();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c != ' ') {
                switch (c){
                    case '+' -> {stack.push( stack.pop() + stack.pop());}
                    case '-' -> {int a = stack.pop(), b = stack.pop(); stack.push(b-a);}
                    case '*' -> {stack.push(stack.pop() * stack.pop());}
                    default -> { stack.push(c - '0');}
                }
            }
        }
        System.out.println(stack.pop());
        //writer.write(Integer.valueOf(stack.pop()));
        reader.close();
        writer.close();
    }
}