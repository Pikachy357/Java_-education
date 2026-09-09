import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Stack{

    public Stack(String s){
        this.s = s;
    }
    public char revert (char c){
        switch (c){
            case '(' -> return ')';
            case "[" -> return ']';
            default -> return c;
        }
    }
    public boolean isValid(){
        Deque <Charecter> stack= new Deque<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if ((c == '(') || (c == '[')){
                stack.push(c);
            } else{
                if (stack.peek() == null) {
                    return false;
                } else{
                    if (revet(stack.peek()) == c){
                        stack.pop();
                    }
                }
            }

        }
        if (stack.peek() != null) {
            return false;
        }
        return true;
    }
    public boolean (){
        Deque <Charecter> = new <>();
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack buff = new Stack(reader.readline);
        if (buff.isvalid) {
            writer("yes");
        } else{
            writer("no");
        }
        reader.close();
        writer.close();
    }
}