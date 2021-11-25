class Solution {
    
    public boolean isEven(int ele){
        int count=0;
        while(ele!=0){
            ele/=10;
            count++;
            }
        if(count%2!=0)
            return false;
       return true;
    }
    public int findNumbers(int[] nums) {
        int count =0;
        for(int i=0; i<nums.length; i++){
            if(isEven(nums[i]))
                count++;
        }
        return count;
        
    }
}
