package leetcode.slowfastpointer;

//https://leetcode-cn.com/problems/move-zeroes/
public class Q283 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(nums);
    }
    public static void moveZeroes(int[] nums) {
        if (nums.length == 0) return;
        int slow=0,fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }
        for (;slow<nums.length;slow++) {
            nums[slow]=0;
        }
    }
}
