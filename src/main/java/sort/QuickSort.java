package sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public int[] sortArray(int[] nums) {
//        sortArray(nums, 0, nums.length - 1);
        qsort(nums, 0, nums.length - 1);
        return nums;
    }

    private void qsort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start, j = end;
        int rIndex = new Random().nextInt(end - start + 1) + start;
        swap(nums, rIndex, start);
        int x = nums[start];
        while (i < j) {
            while (i < j && nums[j] >= x) {
                j--;
            }
            while (i < j && nums[i] <= x) {
                i++;
            }
            swap(nums, i, j);
        }
        swap(nums, i, start);
        qsort(nums, start, i - 1);
        qsort(nums, i + 1, end);
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public void sortArray(int[] nums, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(nums, start, end);
            sortArray(nums, start, pivotIndex - 1);
            sortArray(nums, pivotIndex + 1, end);
        }
    }

    public int partition(int[] nums, int start, int end) {
        int randomIndex = start + (int) (Math.random() * (end - start + 1));
        swap(nums, start, randomIndex);
        int pivot = nums[start];
        int low = start + 1, high = end;
        while (low < high) {
            while (low < high && nums[low] <= pivot) {
                low++;
            }
            while (low < high && nums[high] > pivot) {
                high--;
            }
            if (low < high) {
                swap(nums, low, high);
            }
        }
        while (high > start && nums[high] > pivot) {
            high--;
        }
        if (high > start) {
            swap(nums, start, high);
        }
        return high;
    }

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        System.out.println(Arrays.toString(sort.sortArray(new int[]{5, 2, 3, 1})));
    }

}
