import java.util.List;

public class LeetCode120 {
}
class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] dp = new int[len + 1];

        for(int i = len - 1; i >= 0; i--){
            List<Integer> cur = triangle.get(i);
            for(int j = 0; j < cur.size(); j++){
                dp[j] = Math.min(dp[j], dp[j + 1]) + cur.get(j);
            }

        }
        return dp[0];

    }
}