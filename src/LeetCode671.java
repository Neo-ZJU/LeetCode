import java.util.ArrayList;
import java.util.List;

public class LeetCode671 {
}


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
 TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }

class Solution671 {
    int val = Integer.MAX_VALUE;
    boolean isFind = false;
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null) return -1;
        int rootVal = root.val;
        if(root.left == null || root.right == null) return -1;
        dfs(root, rootVal);
        if(!isFind) return -1;
        return val;
    }
    public void dfs(TreeNode root, int rootVal){
        if(root == null) return;
        if(root.val > rootVal) {
            isFind = true;
            val = Math.min(val, root.val);}
        System.out.println(val);
        dfs(root.left, rootVal);
        dfs(root.right, rootVal);
    }
}class Solution538 {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root != null){
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode pre = null;

        while(root != null){
            if(root.left != null){
                pre = root.left;
                while(pre.right != null && pre.right != root){
                    pre = pre.right;
                }
                if(pre.right == null){
                    //左子树没有访问完
                    pre.right = root;
                    root = root.left;
                }else{
                    //左子树访问完了
                    ans.add(root.val);
                    pre.right = null;
                    root = root.right;
                }
            }else{
                ans.add(root.val);
                root = root.right;
            }
        }
        return ans;
    }
}