import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Kontest6 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String buff = reader.readLine();
        int [] numbers = new int[10];
        int sum = 0;
        for (int i = 0 ; i < buff.length(); i++){
            numbers[buff.charAt(i) - '0']++;
            sum += (buff.charAt(i) - '0'); 
        }
        int f = sum % 3;
        int count = 0;
        if (f == 1){
            if (numbers[1] != 0){
                numbers[1] --;
                count++;
            } else {
                if (numbers[4] != 0){
                    numbers[4] --;
                    count++;
                } else{
                    if (numbers[7] != 0){
                        numbers[7] --;
                        count++;
                        
                    } else{
                        if (numbers[2] != 0){
                            numbers[2] --;
                            count++;
                        }
                        if (numbers[2] != 0){
                            numbers[2] --;
                            count++;
                        } else{
                            if (numbers[5] != 0){
                                numbers[5] --;
                                count++;
                            }
                            if (numbers[5] != 0){
                                numbers[5] --;
                                count++;
                            } else{
                                if (numbers[8] != 0){
                                    numbers[8] --;
                                    count++;
                                }
                                if (numbers[8] != 0){
                                    numbers[8] --;
                                    count++;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (f == 2){
            if (numbers[2] != 0){
                numbers[2] --;
                count++;
            } else {
                if (numbers[5] != 0){
                    numbers[5] --;
                    count++;
                } else{
                    if (numbers[8] != 0){
                        numbers[8] --;
                        count++;
                    } else{
                        if (numbers[1] != 0){
                            numbers[1] --;
                            count++;
                        }
                        if (numbers[1] != 0){
                            numbers[1] --;
                            count++;
                        } else{
                            if (numbers[4] != 0){
                                numbers[4] --;
                                count++;
                            }
                            if (numbers[4] != 0){
                                numbers[4] --;
                                count++;
                            } else{
                                if (numbers[7] != 0){
                                    numbers[7] --;
                                    count++;
                                }
                                if (numbers[7] != 0){
                                    numbers[7] --;
                                    count++;
                                }
                            }
                        }
                    }
                } 
            }
        }
        for (int i = 0; i < buff.length() - count; i++){
            for (int j = 9 ; j >= 0; j--){
                while (numbers[j] != 0){
                    System.out.print(j);
                    numbers[j]--;
                }
            }
        } 
        reader.close();
        writer.close();
    }
}