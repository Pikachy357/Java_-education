class TopKFrequent {
    public void main(String[] args) {
        int [] test = {3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6};
        int nums[] = {7,7, 34 , 2342 , 342 , 5 , 5 , 6 , 6, 6 , 5,5 , 23, 23, 5 , 23 , 17, 16, 23, 5 , 27};
        topKFrequent(nums, 3);
        sort(test);

    }

    public void topKFrequent(int[] nums, int k) {
        int[] numbers = new int[nums.length];
        int[] counters = new int[nums.length];
        sort(nums);
        numbers[0] = nums[0];
        int count =0;
        for(int i = 0; i < nums.length; i++){
            if (numbers[count] == nums[i]){
                counters[count]++;
            } else{
                count++;
                counters[count]++;
                numbers[count] = nums[i];
            }
        }
        sort(counters, numbers);
        printarr(counters);
        System.out.println("");
        printarr(numbers);
        System.out.println("");
        for(int i = 0; i < k; i++){
          //  System.out.println(numbers[numbers.length - 1 - i]);
        }
    }
    public void sort(int[] nums){
        for (int k = 0; k < nums.length - 1; k++){
            for(int l = 0; l < nums.length - 1; l++){
                if(nums[l] > nums[l+1]){
                    int a = nums[l];
                    nums[l] = nums[l+1];
                    nums[l+1] = a;
                }
            }
        }
    }
    public void sort(int [] nums, int [] count){
        for (int k = 0; k < nums.length - 1; k++){
            for(int l = 0; l < nums.length - 1; l++){
                if(nums[l] > nums[l+1]){
                    int a = nums[l];
                    int b = count[l];
                    nums[l] = nums[l+1];
                    count[l] = count[l+1];
                    nums[l+1] = a;
                    count[l+1] = b;
                }
            }
        }
    }
    public void printarr( int [] test){
        for (int i =0; i < test.length; i++){
            System.out.print(" " + test[i]);
        }
    }
}