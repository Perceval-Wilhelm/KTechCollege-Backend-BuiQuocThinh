package LeetCode;

public class Main {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int k=0;
        for (int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length-1; j++) {
                if (nums[i]!=nums[j]) {
                    nums[k] = nums[j+1];
                }
                else {

                }
            }
        }
        return k;
    }
}
