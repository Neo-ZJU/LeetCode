import java.util.HashSet;

public class JianZhi03 {
    public static void main(String[] args) {
<<<<<<< HEAD
        int abcabcbb = new Solution03().lengthOfLongestSubstring("abcabcbbabc");
        int a = 0;
=======
        int abcabcbb = new Solution03().lengthOfLongestSubstring("abcabcbbabc");
>>>>>>> master
        System.out.println(abcabcbb);
    }
}
class Solution03 {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int front = 0;
        int back = 0;
        HashSet<Character> set = new HashSet<>();
        int len = s.length();

        while(front < len){
            if(!set.contains(s.charAt(front))){
                max = Math.max(front - back + 1, max);
                set.add(s.charAt(front));
            }else{
                while(!set.isEmpty() && set.contains(s.charAt(front))){
                    set.remove(s.charAt(back++));
                }
                back++;
            }
            front++;
        }
        return max;
    }
}
