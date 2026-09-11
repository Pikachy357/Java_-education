import java.util.HashSet;
import java.util.Set;

class Solution3 {
    public void main(String[] args) {
        int test[] = {1, 2, 3, 3};
        System.out.println(hasDuplicate(test));
    }

    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int x : nums) {
            if (!seen.add(x)) {
                return true;
            }
        }
        return false;
    }
}