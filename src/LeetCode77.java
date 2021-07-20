import java.util.LinkedList;
import java.util.List;

public class LeetCode77 {
    public static void main(String[] args) {
        System.out.println(new Solution77().combine(4, 2));
    }
}
class Solution77 {
    List<List<Integer>> res = new LinkedList<>();
    //  LinkedList<Integer> temp = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(new LinkedList<Integer>(), n, k, 0);
        return res;
    }
    public void dfs(LinkedList<Integer> temp, int n, int k, int x){
        if(temp.size() == k){
            res.add(new LinkedList<Integer>(temp));
            return;
        }
        for(int i = x + 1; i <= n; i++){
            temp.add(i);
            dfs(temp, n, k, i);

            temp.removeLast();
        }
    }
}