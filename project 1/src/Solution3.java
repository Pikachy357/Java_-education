class Solution3 {
    public void main(String[] args){
        int test[] = {1,2,3,3};
        System.out.println(hasDuplicate(test)); 
    }
    public boolean hasDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                if ( nums[i] == nums[j]){
                    return true;
                } 
            } 
        }
        return false;
    }
}