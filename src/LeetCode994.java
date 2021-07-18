import java.util.LinkedList;
import java.util.Queue;

public class LeetCode994 {
}
class Solution994 {
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int mins = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] seen = new boolean[rows][cols];
        int cnt = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                    seen[i][j] = true;
                    cnt++;
                }
                if(grid[i][j] == 0){
                    seen[i][j] = true;
                    cnt++;
                }
            }
        }
        if(cnt == rows * cols) return 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            mins++;

            for(int i = 0; i < size; i++){
                int[] cur = queue.poll();
                int r = cur[0];
                int c = cur[1];

                for(int k = 0; k < 4; k++){
                    int curR = r + dirs[k][0];
                    int curC = c + dirs[k][1];
                    if(curR >= 0 && curR < rows && curC >= 0 && curC < cols && !seen[curR][curC]){
                        queue.offer(new int[]{curR, curC});
                        seen[curR][curC] = true;
                    }
                }
            }
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(!seen[i][j]){
                    return -1;
                }
            }
        }
        return mins - 1;
    }
}