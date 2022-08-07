package leetcode.双指针.二分查找;

public class Q34 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(findLeftIndex(nums,3));
        System.out.println(findRightIndex(nums,3));
    }
    public int[] searchRange(int[] nums, int target) {
        int leftIndex = findLeftIndex(nums, target);
        int rightIndex = findRightIndex(nums, target);
        return new int[]{leftIndex, rightIndex};
    }

    static int findLeftIndex(int[] nums, int target) {
        int left = 0, right=nums.length-1;
        while (left <= right) {
            int mid = left + (right-left)/2;
//            System.out.println("left:"+left+"mid:"+mid+"right:"+right);
            if (nums[mid] > target) {
                right = mid-1;
            } else if (nums[mid] < target) {
                left = mid +1;
            } else if (nums[mid] == target) {
                right = mid-1;
            }
        }
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }
    static int findRightIndex(int[] nums, int target) {
        int left = 0, right=nums.length-1;
        while (left <= right) {
            int mid = left + (right-left)/2;
//            System.out.println("left:"+left+"mid:"+mid+"right:"+right);
            if (nums[mid] > target) {
                right = mid-1;
            } else if (nums[mid] < target) {
                left = mid +1;
            } else if (nums[mid] == target){
                left = mid+1;
            }
        }
        if (right <0 || nums[right] != target) {
            return -1;
        }
        return right;
    }


}
