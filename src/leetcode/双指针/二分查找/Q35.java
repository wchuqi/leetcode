package leetcode.双指针.二分查找;

public class Q35 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,5,7};
        System.out.println(findLeftIndex(nums,4));
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
        return left;
    }

}
