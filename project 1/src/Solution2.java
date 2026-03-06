class Solution2 {
    public void main(String[] args) {
        int arr[] = {1, 3, 4};
        int arr2[] = {0, 0, 0};
        int arr3[] = new int[6];
        arr3 = arr2;
        int test[] = getConcatenation(arr);
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
            ans[i + nums.length] = nums[i];
        }
        return ans;
    }
}