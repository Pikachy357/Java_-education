import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class kontest8 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] buff = reader.readLine().split(" ");
        int n = Integer.parseInt(buff[0]);
        int m = Integer.parseInt(buff[1]);
        byte[][] matr = new byte [n][m];
        for (int i = 0; i < n; i++){
            String str = reader.readLine();
            for (int j = 0; j < m; j++){
                if (str.charAt(j) == '#'){
                    matr[i][j] = 1;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (matr[i][j] == 1){
                    int k = 1;
                        while ( (j+k<m) &&matr[i][j+k] == 1){
                            k++;
                        }
                        for (int o = i; o < i+k; o++){
                            for(int l = j; l < j+k; l++){
                                matr[o][l] = 0;
                            }

                        }
                    count++;
                }
                


            }
        }
         writer.write(String.valueOf(count));
        reader.close();
        writer.close();
    }
}