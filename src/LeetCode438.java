import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode438 {
}
class Solution438 {

        public List<Integer> findAnagrams(String s, String p) {
            int pLen = p.length();
            int sLen = s.length();
            List<Integer> ans = new ArrayList<>();
            char[] pChar = p.toCharArray();
            Arrays.sort(pChar);
            for(int i = 0; i <= sLen - pLen; i++){
                String str = s.substring(i, i + pLen);
                char[] strChar = str.toCharArray();
                Arrays.sort(strChar);
                if(Arrays.equals(pChar, strChar)){
                    ans.add(i);
                }
            }
            return ans;
        }
}