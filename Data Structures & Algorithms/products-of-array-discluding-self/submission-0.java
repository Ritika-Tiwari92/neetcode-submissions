class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer=new int[nums.length];
        int leftProduct=1;
        int rightProduct=1;
        for(int i=0;i<nums.length;i++){
            answer[i] = leftProduct;
            leftProduct *= nums[i];
        }
        for(int j=nums.length-1;j>=0;j--){
            answer[j] *= rightProduct;
            rightProduct *= nums[j];
        }
        return answer;
    }
}  
