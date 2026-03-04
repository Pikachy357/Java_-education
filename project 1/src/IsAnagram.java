import java.util.Scanner;

class IsAnagram {
    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t) {
        int[] azbuks = new int[128];
        int[] azbukt = new int[128];
        if(s.length() == t.length()){
            for (int i = 0; i < s.length(); i++){
                azbuks[s.charAt(i)]++;
                azbukt[t.charAt(i)]++; 
            }
            for (int i = 0; i < 128; i++){
                if (azbuks[i] != azbukt[i]){
                    return false;
                }
            }
        } else{
            return false;
        }
        return true;
    }
}