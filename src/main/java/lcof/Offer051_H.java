package lcof;

public class Offer051_H {
    int[] nums, tmp;

    public int reversePairs(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        this.nums = nums;
        tmp = new int[nums.length];
        return mergeSort(l, r);
    }

    private  int mergeSort(int l, int r) {
        if (l >= r) {
            return 0;
        }
        int mid = (l + r) / 2;
        int res = mergeSort(l, mid) + mergeSort(mid + 1, r);
        //设置双指针指向左右子数组的首元素
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            tmp[k] = nums[k];
        }
        for (int k = l; k <= r; k++) {
            //此时左子数组以合并完全，因此添加右子数组当前元素
            if (i == mid + 1) {
                nums[k] = tmp[j++];

            }
            //此时右子数组添加完全或者左子数组当前值小于右子数组当前值时，添加左子数组的值
            else if (j==r+1||tmp[i]<=tmp[j]){
                nums[k] = tmp[i++];

            }
            //此时，左子数组当前值大于右子数组的值，出现逆序数，出现数量为当前左子数组下标到mid为止的所有数
            else {
                nums[k] = tmp[j++];
                res += mid - i + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Offer051_H test = new Offer051_H();
        int[] nums = new int[]{7,3,2,6,0,1,5,4};
        int n = test.reversePairs(nums);
        System.out.println(n);
    }
}
