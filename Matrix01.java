// Time Complexity : O(m * n) because each cell is visited and processed once
// Space Complexity : O(m * n) for the queue in the worst case (all cells are 0 initially)
// Did this code successfully run on Leetcode : Yes

// Approach:
// 1. Multi-source BFS: Add all cells with value 0 to the queue. Mark all 1s as -1 (unvisited).
// 2. Perform BFS level by level. Maintain a distance counter dist that increments at each level.
// 3. For each cell dequeued, check its 4 neighbors. If a neighbor is -1 (unvisited 1), set its value to dist and enqueue it.
// 4. This ensures that each cell is assigned the shortest distance to its nearest 0, since BFS expands outward level by level.
// 5. Return the updated matrix.


import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
    int[][] dirs;
    int m, n;

    public int[][] updateMatrix(int[][] mat) {
        this.dirs = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        this.m = mat.length;
        this.n = mat[0].length;

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i, j});
                }else{
                    mat[i][j] = mat[i][j] * -1;
                }
            }
        }

        int dist = 1;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                for(int[] dir : dirs){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];

                    if(r >= 0 && c >= 0 && r < m && c < n && mat[r][c] == -1){
                        q.add(new int[]{r, c});
                        mat[r][c] = dist;
                    }
                }
            }
            dist++;
        }
        return mat;
    }
}
