public class JianZhi53 {
    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        System.out.println(new Solution53().search(nums, target));
    }
}
class Solution53 {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while(l < r){
            int m = (r - l) / 2 + l;

            if(nums[m] < target){
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        if(nums[l] < target){
            l += 1;
        }
        int left = l;
        l = 0;
        r = nums.length - 1;
        while(l < r){
            int m = (r - l) / 2 + l;
            if(nums[m] > target){
                r = m - 1;
            }else{
                l = m + 1;
            }
        }
        if(nums[r] > target){
            r -= 1;
        }
        int right = r;
        return right - left + 1;
    }
}

/**
 * 官方题解
 */
class SolutionGuanFang {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if(nums.length == 0) return 0;
        int i = 0;
        int m;//永远在i和j的中间
        int j = nums.length - 1;
        //更新右边界
        while(i <= j){//跳出循环的条件一定是i>j，而且i站在目标值右边一格
            m = (i + j)/2;
            if(nums[m] <= target){
                i = m + 1;  //现在中点比目标小，所以右边界在中点右边
            }else{
                j = m - 1; //中点比目标大，所以我们右边界不会超过中点往左一格
                //j从最左边最大的地方一格一格向右退，直到中点比目标值小的时候才停下，所以我们退出循环的时候j一定是等于目标值的                  //如果所有值都大于目标值，j会退到-1，跳出循环
                //如果不存在目标值，利用下面的判断返回
            }
        }
        if( j >= 0 && nums[j] != target) return 0;
        right = i;
        i = 0;
        j = nums.length - 1;
        while(i <= j){
            m = (i + j)/2;
            if(nums[m] >= target){
                j = m - 1;
            }else{
                i = m + 1;
            }
        }
        left = j;
        return right - left - 1;
    }
}