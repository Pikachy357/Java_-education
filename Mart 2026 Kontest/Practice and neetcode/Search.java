class Search {
    public void main(String[] args) {
        int nums[] = {1, 2, 4, 6};
        int target = 4;
        System.out.println(search(nums, target));
    }

    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (nums[i] > target) {
                return -1;
            }
        }
        return -1;
    }
}