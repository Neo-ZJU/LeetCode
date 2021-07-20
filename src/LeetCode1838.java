import java.util.Arrays;
import java.util.LinkedList;

public class LeetCode1838 {
}
class Solution1838 {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int max = 0;
        int tempSum = 0;
        int left = 0;
        for(int i = 0; i < nums.length; i++){
            while(nums[i] * (i - left) - tempSum > k){
                tempSum -= nums[left++];
            }
            tempSum += nums[i];
            max = Math.max(max, i - left + 1);
        }
        return max;



    }
}