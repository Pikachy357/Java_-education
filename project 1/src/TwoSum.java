import java.util.Scanner;

class TwoSum {
    public void main(String[] args) {
        int[] s = {-1,-2,-3,-4,-5};
        int[] indexSum = twoSum(s, 10);
        System.out.println(indexSum[0] + " " + indexSum[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] indexSum = new int[2];
        int buf = 0;
        for (int i = 0; i < nums.length; i++){
            indexSum[0] = i;
            for (int j = i+1; j < nums.length; j++){
                if (nums[i] + nums[j] ==  target){
                    indexSum[1] = j;
                    return indexSum;
                }
            }
            }
        return indexSum;
    }
}