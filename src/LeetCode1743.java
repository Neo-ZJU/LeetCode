import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode1743 {
}
class Solution1743 {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int len = adjacentPairs.length;
        int[] ans = new int[len + 1];
        for(int[] adjacentPair : adjacentPairs){
            List<Integer> list1 = map.getOrDefault(adjacentPair[0], new ArrayList<>());
            list1.add(adjacentPair[1]);
            List<Integer> list2 = map.getOrDefault(adjacentPair[1], new ArrayList<>());
            list2.add(adjacentPair[0]);
            map.put(adjacentPair[0], list1);
            map.put(adjacentPair[1], list2);
        }

        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            if(entry.getValue().size() == 1){
                ans[0] = entry.getKey();
            }
        }

        ans[1] = map.get(ans[0]).get(0);

        for(int i = 2; i <= len; i++){
            List<Integer> list = map.get(ans[i - 1]);
            ans[i] = ans[i - 2] == list.get(0) ? list.get(1) : list.get(0);
        }
        return ans;
    }
}