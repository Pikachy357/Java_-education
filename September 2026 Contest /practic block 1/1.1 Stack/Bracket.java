import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;


public class Bracket {

    static class Pack {
        String s;
        public Pack(String s){
            this.s = s;
        }
        public char revert (char c){
            switch (c){
                case '(' -> {return ')';}
                case '[' -> {return ']';}
                case '{' -> {return '}';}
                default -> {return c;}
            }
        }
        public boolean isValid(){
            Deque <Character> stack= new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if ((c == '(') || (c == '[') || (c == '{')){
                    stack.push(c);
                } else{
                    if (stack.peek() == null) {
                        return false;
                    } else{
                        if (revert(stack.peek()) == c){
                            stack.pop();
                        } else {
                            return false;
                        }
                    }
                }

            }
            if (!stack.isEmpty()) {
                return false;
            }
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        Pack buff = new Pack(reader.readLine());
        if (buff.isValid()) {
            writer.write("yes");
        } else{
            writer.write("no");
        }
        reader.close();
        writer.close();
    }
}