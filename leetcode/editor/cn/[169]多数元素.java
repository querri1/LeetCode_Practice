class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        return getMajority(nums,0,n-1);
    }


    private int getMajority(int[] nums,int left,int right){
        if(right==left) return nums[left];

        int mid=left+(right-left)/2;
        int leftMajority = getMajority(nums,left,mid);
        int rightMajorit = getMajority(nums,mid+1,right);

        if(leftMajority==rightMajorit) return leftMajority;

        int leftcount=0;
        int rightcount=0;
        for(int i=left;i<=right;i++){
            if(nums[i]==leftMajority){
                leftcount++;
            }
            else if(nums[i]==rightMajorit) rightcount++;
        }
        return leftcount > rightcount ? leftMajority : rightMajorit;
    }
}