import java.util.Scanner;

class Solution {
    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int x = scoreOfString(s);
        System.out.println("sum = " + x);
    }
    public int scoreOfString(String s) {
        int sum = 0, buf = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            buf = s.charAt(i) - s.charAt(i + 1);
            if (buf < 0) {
                buf = -buf;
            }
            sum += buf;
        }
        return sum;
    }
}