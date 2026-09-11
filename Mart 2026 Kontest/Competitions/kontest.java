import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class kontest {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] buff = reader.readLine().split(" ");
        int n = Integer.parseInt(buff[0]);
        int m = Integer.parseInt(buff[1]);
        int arr[][] = new int[n][m];
        for(int i = 0; i < n; i++){
            String line = reader.readLine();
            for(int j =0; j < m; j++){
               if(line.charAt(j) == '#') { 
                   arr[i][j] = 1;
               }        
            }
        }
        int count = 0;
        for(int i = 0; i < n-1; i++){;
            for(int j =0; j < m; j++){

               if(arr[i][j] == 0 && arr[i+1][j] == 0){
                   count++;
               }        
            }
        }
        for(int i = 0; i < n; i++){;
            for(int j =0; j < m-1; j++){
               if(arr[i][j] == 0 && arr[i][j+1] == 0) { 
                   count++;
               }       
            }
        }
        writer.write(String.valueOf(count));
        reader.close();
        writer.close();
    }
}