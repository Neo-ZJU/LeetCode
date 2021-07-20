import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode46 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(new Solution46().permute(nums));

    }
}
class Solution46 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, 0);
        return res;
    }
    public void dfs(int[] nums, int k){
        if(temp.size() == nums.length){
            res.add(new LinkedList<Integer>(temp));
            System.out.println("f");
            return;
        }
        if(k == nums.length){
            return;
        }


        for(int i = k + 1; i < nums.length; i++){
            temp.add(nums[k]);
            dfs(nums, i);
            temp.removeLast();
        }
    }
}