import java.util.Arrays;
import java.util.LinkedList;

public class LeetCode406 {
}
class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> (o1[0] - o2[0] != 0 ? o2[0] - o1[0] : o1[1] - o2[1]));
        LinkedList<int[]> list = new LinkedList<>();

        for(int[] i : people){
            list.add(i[1], i);
        }
        return list.toArray(new int[list.size()][2]);
    }
}