import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class One{
    public static void main(String[] args)throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String n = reader.readLine();
        char [] c = new char[n.length()];
        for (int i = 0; i < n.length(); i++){
             c[i] = n.charAt(i);
        }
        boolean f = false;
        for (int j = 0; j < n.length(); j++){
        char k = c[0];
        for (int i = 0; i < n.length()-1; i++){
             c[i] = c[i + 1];
        }
        c[n.length() - 1] = k;
        if (isValid(String.valueOf(c))){
            f = true;
            break;
        }
        }
        if (n.length() == 0) {
            writer.write("YES");
            writer.close();
            reader.close();
            return;
        }
        if (f){writer.write("YES");

        } else {
            writer.write("NO");
        }
        reader.close();
        writer.close();

    }
    public static boolean isValid(String s) {
        char[] stack = new char[s.length() + 1 / 2];
        int countStack = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (countStack < 0) {
                return false;
            }
            if (c == '(') {
                stack[countStack++] = '(';
                continue;
            }
            if (c == '{') {
                stack[countStack++] = '{';
                continue;
            }
            if (c == '[') {
                stack[countStack++] = '[';
                continue;
            }
            if (c == ')') {
                if (countStack == 0) {
                    return false;
                }
                if (stack[countStack - 1] == '(') {
                    countStack--;
                } else {
                    return false;
                }
            }
            if (c == '}') {
                if (countStack == 0) {
                    return false;
                }
                if (stack[countStack - 1] == '{') {
                    countStack--;
                } else {
                    return false;
                }
            }
            if (c == ']') {
                if (countStack == 0) {
                    return false;
                }
                if (stack[countStack - 1] == '[') {
                    countStack--;
                } else {
                    return false;
                }
            }
        }
        if (countStack == 0) {
            return true;
        } else {
            return false;
        }
    }
}