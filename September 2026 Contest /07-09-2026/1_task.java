import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i<n; i++){
            String camel = reader.readLine();
            StringBuilder snake = new StringBuilder();
            snake.append(Character.toLowerCase(camel.charAt(0)));
            for (int j = 1 ; j<camel.length(); j++){
                if (Character.isUpperCase(camel.charAt(j))){
                    snake.append('_');
                }
                snake.append(Character.toLowerCase(camel.charAt(j)));
            }
            writer.write(snake.toString());
            writer.write('\n');
        }

        reader.close();
        writer.close();
    }
}