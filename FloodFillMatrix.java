// Time Complexity : O(m * n)
// Space Complexity : O(m * n) 
// Did this code successfully run on Leetcode : Yes

// Approach:
// 1. Capture the old color of the starting pixel. If it's already the same as the new color, return the image directly.
// 2. Use BFS (queue) starting from (sr, sc). For each cell, change its color to the new one.
// 3. Explore 4-directionally (up, left, right, down). If the neighbor has the old color, enqueue it and change its color.
// 4. Continue until the queue is empty, then return the updated image.


import java.util.LinkedList;
import java.util.Queue;

public class FloodFillMatrix {
    int[][] dirs;
    int m, n;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.dirs = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        this.m = image.length;
        this.n = image[0].length;

        int oldColor = image[sr][sc];
        if(oldColor == color) return image;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        image[sr][sc] = color;

        while(!q.isEmpty()){
            int[] curr = q.poll();

            for(int[] dir : dirs){
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];

                if(r >= 0 && c >= 0 && r < m && c < n && image[r][c] == oldColor){
                    image[r][c] = color;
                    q.add(new int[]{r, c});
                }
            }
        }
        return image;
    }
}
