import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Ambulance {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] buff = reader.readLine().split(" ");
        long k1 = Integer.parseInt(buff[0]);
        long m = Integer.parseInt(buff[1]);
        long k2 = Integer.parseInt(buff[2]);
        long p2 = Integer.parseInt(buff[3]);
        long n2 = Integer.parseInt(buff[4]);
        if (n2 > m) { // если жтаж больще чем максимальное кол-во этажей
            writer.write("-1" + " -1");
        } else {
            long l = (long) (p2 - 1) * m + (n2 - 1); // этажей перед квартирой к2
                if (l > 0) {
                    int length = (int) ((k2 - 1) / (double) l - k2 / ((double) l + 1) + 1);
                    if (length < 1) {
                        writer.write("-1" + " -1");
                    } else {
                        int from = (int) Math.ceil(k2 / ((double) l + 1));
                        int to = (int)Math.floor((k2 -1)/ (double) l);
                        long p = 0, n = 0, p1 = -1, n1 = -1;
                        for (int x = from; x <= to; x++) {
                            if (p1!= 0){
                                p1 = (k1 - 1) / (x * m) + 1;
                            }   
                            if (n1 != 0){
                                n1 = ((k1 - 1) % (x * m)) / x + 1;
                            }
                            if(x!=from && p1 != p){
                                p1 = 0;
                            }
                            if (x!=from && n1 != n){
                                n1 = 0;
                            }
                            p = p1;
                            n = n1;
                        }
                        writer.write(p1 + " " + n1 + "\n");
                    }
                } else {
                    long p = 0, n = 0, p1 = -1, n1 = -1;
                    for (int x = (int) k2; x < k1; x++) {
                            if (p1!= 0){
                                p1 = (k1 - 1) / (x * m) + 1;
                            }   
                            if (n1 != 0){
                                n1 = ((k1 - 1) % (x * m)) / x + 1;
                            }
                            if(x!=k2 && p1 != p){
                                p1 = 0;
                            }
                            if (x!=k2 && n1 != n){
                                n1 = 0;
                            }
                            p = p1;
                            n = n1;
                    }
                    writer.write(p1 + " " + n1 + "\n");
                }
            }
            reader.close();writer.close();
        }
}