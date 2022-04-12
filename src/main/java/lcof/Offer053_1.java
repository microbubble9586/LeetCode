package lcof;

public class Offer053_1 {
    public static int search(int[] nums, int target) {
        int l=0,r=nums.length-1;
        int res =0;
        if (nums.length==1){
            return target==nums[0]?1:0;
        }
        while (l<=r){
            int mid =l+r>>1;
            if (target>nums[mid]){
                l=mid+1;
            } else if (target<nums[mid]){
                r=mid-1;
            } else if (target==nums[mid]){
                int ml=mid,mr=mid+1;
                while (ml>=0&&nums[ml--]==target){
                    res+=1;
                }
                while (mr<nums.length&&nums[mr++]==target){
                    res+=1;
                }
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        search(new int[]{5,7,7,8,8,10},6);
    }
}
