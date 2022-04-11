class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;
        //The key point is to find out the first position after the move
        int start = total - k % total;
        List<List<Integer>> res = new ArrayList<>();
        for (int index = start; index < total + start; index++) {
            int i = (index % total) / n, j = (index % total) % n;
            //Each column has n elements
            if ((index - start) % n == 0)
                res.add(new ArrayList<>());
            res.get(res.size() - 1).add(grid[i][j]);
        }
        return res;
    }
}