import java.util.Arrays;
import java.util.HashMap;

public class LeetCode1713 {
}
class Solution1713 {
    public int minOperations(int[] target, int[] arr) {
        HashMap<Integer, Integer> mapTar = new HashMap<>();
        for(int i = 0; i < target.length; i++){
            mapTar.put(target[i], i);
        }
        int len = arr.length;

        for(int i = 0; i < len; i++){
            if(mapTar.containsKey(arr[i])){
                arr[i] = mapTar.get(arr[i]);
            }else{
                arr[i] = Integer.MAX_VALUE;
            }
        }

        //问题转化为求最长递增子序列

        int cnt = 0;

        int[] dp = new int[len + 1];
        dp[0] = Integer.MIN_VALUE;
        for(int i = 0; i < len; i++){
            if(arr[i] == Integer.MAX_VALUE) continue;
            if(arr[i] > dp[cnt]){
                //找到了更长的递增子序列，cnt加长
                dp[++cnt] = arr[i];
            }else{
                //未找到更长的子序列，需要把前面的dp[插入点]修改为当前的arr[i]，因为当前的arr[i]更小，有利于之后找更长的递增子序列
                int bs = Arrays.binarySearch(dp, 1, cnt + 1, arr[i]);
                bs = bs > 0 ? bs : - bs - 1;
                dp[bs] = arr[i];
            }

        }
        return target.length - cnt;
    }
}