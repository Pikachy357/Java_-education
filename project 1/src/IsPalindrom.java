import java.util.Scanner;

class IsPalindrom {
    public void main(String[] args) {
        String s = "0P";
        System.out.println(isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        char[] test = new char[s.length()];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                test[count++] = c;
                continue;
            }
            for (int j = 0; j < 26; j++) {
                if (c == 'a' + j) {
                    test[count++] = (char) ('a' + j);
                    break;
                }
                if (c == 'A' + j) {
                    ;
                    test[count++] = (char) ('a' + j);
                    break;
                }
            }
        }
        for (int i = 0; i < count / 2; i++) {
            if (test[i] != test[count - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}