import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Twoo{
    public static void main(String[] args)throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        short n = Short.parseShort(reader.readLine());
        String valid = reader.readLine();
        short m = Short.parseShort(reader.readLine());
        boolean [][] plus = new boolean [m][n];
        for(int i = 0; i < m; i++){
            String  student = reader.readLine();
            for (int j = 0; j < n; j++){
                if (student.charAt(j) == valid.charAt(j)){
                    plus[i][j] = true;
                }
            }
        }
        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (){
                    plus[i][j] = true;
                }
            }
        }
    }
}