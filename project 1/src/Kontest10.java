import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Kontest10{
    public static void main(String[] args)throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        int count = 0;
        int n2 = n;
        while (n != 0){
            int max = max_prostoe(n);
            if (n - max == 1){
                max = max_prostoe(max-1);
            }
            while (n >= max){
                n -= max;
                count++;
            }
        }
        n = n2;
        int [] array = new int [count];
        int k = 0;
        while (n != 0){
            int max = max_prostoe(n);
            if (n - max == 1){
                max = max_prostoe(max-1);
            }
            while (n >= max){
                array[k] = max;
                n -= max;
                k++;
            }
        }
        
        writer.write(String.valueOf(count) + "\n");
        for (int i = 0; i < count-1; i++){
        writer.write(String.valueOf(array[i]) + " ");  
        }
        writer.write(String.valueOf(array[count-1])+"\n"); 
        reader.close();
        writer.close();
    }
    public static boolean prostoe(int a){
        if (a < 2){
            return false;
        }
        for (int i = 2; i*i <= a; i++){
            if (a % i == 0) {
               return false; 
            }        
        }
        return true;
    }
    public static int max_prostoe(int a){
        for (int i = a; i >= 2; i--){
            if (prostoe(i)){
                return i;
            }
        }
        return -1;
    }
}