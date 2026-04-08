import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Ambulance {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        String otvet = reader.readLine();
        int count = 0;
        int max = 0;
        for (int i = 0; i < n-1;  i++){
            if (otvet.charAt(i) != 'h' && otvet.charAt(i) != 'a'){
               count = 0;
            } else{
                if (count == 0) count = 1;
                if ((otvet.charAt(i+1) == 'h' || otvet.charAt(i+1) == 'a') && (otvet.charAt(i+1) != otvet.charAt(i))){
                    count ++;
                } else{
                    count = 1;
                }
            }

            if (count > max){
                max = count;
            }
        }
        if (max == 0 && (otvet.charAt(n-1) == 'h' || otvet.charAt(n-1) == 'a')){
            max = 1;
        }
        writer.write(max + "\n");
        reader.close();
        writer.close();
    }
}