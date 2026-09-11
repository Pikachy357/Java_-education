class MaxProfit{
    public void main(String[] args) {
        int[] s = {1,2,3,4,5};
        System.out.println(maxProfit(s));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length-1; i++){
            for(int j = i; j < prices.length-1; j++){
             if (prices[j+1] - prices[i] > maxProfit ){
                maxProfit = prices[j+1] - prices[i];
             }      
            }
        }
    return maxProfit;
    }
}