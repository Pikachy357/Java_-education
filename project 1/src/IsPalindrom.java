import java.util.Scanner;

class IsPalindrom{
    public void main(String[] args) {
        String s = "nagana";
        System.out.println(isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        char[] test = new char[s.length()];
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j < 28; j++){
                if (s.charAt(i) == 'a'+ j){
                    test[count] = (char)('a'+ j);
                    count++;
                    break;
                }
                if (s.charAt(i) == 'A'+ j){;
                    test[count] = (char)('A'+ j + 32);
                    count++;
                    break;
                }
            }
        }
        for (int i = 0; i < count / 2; i++){
            if (test[i] != test[count-1 - i]){
                return false;
            }
        }
        return true; 
    }
}