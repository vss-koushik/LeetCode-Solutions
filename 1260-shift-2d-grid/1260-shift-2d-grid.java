class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        //move k times first
        while (k-- > 0) {
            int pre = grid[grid.length - 1][grid[0].length - 1];
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    //swap with the previous element
                    int temp = grid[row][col];
                    grid[row][col] = pre;
                    pre = temp;
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int[] row : grid) {
            result.add(Arrays.stream(row).boxed().collect(Collectors.toList()));
        }
        return result;
    }
}