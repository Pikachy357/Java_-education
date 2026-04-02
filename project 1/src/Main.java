import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        byte [][] pole = new byte [2001][2001];
        int startx = 1000;
        int starty = 1000;
        pole[1000][1000] = 1;
        String comand = reader.readLine();
        int count = 0;
        for (int i = 0 ; i < comand.length(); i++){
            switch (comand.charAt(i)){
                case 'U' ->{
                    if (pole[++starty][startx] == 1){
                        count++;
                    }

                }
                case 'L' ->{
                    if (pole[starty][--startx] == 1){
                        count++;
                    } 

                }
                case 'D' ->{
                    if (pole[--starty][startx] == 1){
                        count++;
                    }
                }
                case 'R' ->{
                    if (pole[starty][++startx] == 1){
                        count++;
                    } 
                }
            }
            if(pole[starty][startx] < 2){
                pole[starty][startx]++;
            }
        }
        writer.write(String.valueOf(count));
        reader.close();
        writer.close();
    }
}