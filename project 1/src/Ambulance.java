import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Ambulance {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String [] buff = reader.readLine().split(" ");
        int k1 = Integer.parseInt(buff[0]);
        int m = Integer.parseInt(buff[1]);
        int k2 = Integer.parseInt(buff[2]);
        int p2 = Integer.parseInt(buff[3]);
        int n2 = Integer.parseInt(buff[4]);
        if (n2 > m){ // если жтаж больще чем максимальное кол-во этажей
            writer.write( "-1" + " -1");
        } else{
            int l = (p2-1)*m + (n2-1); // этажей перед квартирой к2
            int count = 0;
            int length = (int)Math.floor(k2/(l-1)) - (int)Math.ceil(k2/(l+1));
            if (length <1){
                writer.write( "-1" + " -1");
            } else{
                int [] P1 = new int[length];
                int [] N1 = new int[length];
                for (int x = (int)Math.ceil(k2/(l+1)), i = 0; x<k2/l; x++, i++){
                    P1[i] = (k1-1)/(x * m) + 1; 
                    N1[i] = ((k1-1) % (x*m))/x +1;
                    
                }
                int p1 = P1[0],n1 = N1[0];
                for (int i = 0; i < length-1; i++){
                    if (P1[i] != P1[i+1]){
                        p1 = 0;
                    }
                    if (N1[i] != N1[i+1]){
                        n1 = 0;
                    }
                }
                writer.write( p1 + " " + n1 + "\n");
            }
        }
        reader.close();
        writer.close();
    }
}