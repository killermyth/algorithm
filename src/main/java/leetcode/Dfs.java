package leetcode;

import java.util.Objects;

/**
 * 深度优先
 *
 * @author LvYingBin
 * @version 1.0
 * @since 2022/11/29 8:52 上午
 **/
public class Dfs {
    private int res;

    /**
     * 二维数组图像，相邻格子渲染相同颜色
     * https://leetcode.cn/problems/flood-fill/description/
     *
     * @param
     * @return
     * @since 2022/11/29 10:03 上午
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int originColor = image[sr][sc];
        if (color == originColor) {
            return image;
        }
        dfsColor(image, sr, sc, color, m, n, originColor);
        return image;
    }

    /**
     * 岛屿的最大面积
     * https://leetcode.cn/problems/max-area-of-island/
     *
     * @param
     * @return
     * @since 2022/11/29 10:16 上午
     */
    public int maxAreaOfIsland(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        for (int x = 0; x < h; x++) {
            for (int y = 0; y < w; y++) {
                if (1 == grid[x][y]) {
                    System.out.println(String.format("startDfs %s-%s-%s", x, y, res));
                    int old = res;
                    res = 0;
                    dfsArea(grid, w, h, x, y);
                    res = Math.max(old, res);
                }
            }
        }
        return res;
    }

    /**
     * 二叉树合并
     * https://leetcode.cn/problems/merge-two-binary-trees
     *
     * @param root1
     * @param root2
     * @return
     * @since 2022/11/29 4:41 下午
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (Objects.isNull(root1)) {
            return root2;
        }
        if (Objects.isNull(root2)) {
            return root1;
        }
        TreeNode result = new TreeNode(root1.val + root2.val);
        result.left = mergeTrees(root1.left, root2.left);
        result.right = mergeTrees(root1.right, root2.right);
        return result;
    }

    /**
     * 填充每个节点的下一个右侧节点指针
     * https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/
     *
     * @param
     * @return
     * @since 2022/11/29 5:12 下午
     */
    public Node connect(Node root) {
        if (Objects.isNull(root.left)) {
            return root;
        }
        root.left.next = root.right;
        connect(root.left);
        connect(root.right);
        return root;
    }

    private void dfsColor(int[][] image, int sr, int sc, int color, int m, int n, int originColor) {
        if (sr < 0 || sc < 0 || sr >= m || sc >= n || originColor != image[sr][sc]) {
            return;
        }
        System.out.println(sr + "-" + sc);
        image[sr][sc] = color;
        dfsColor(image, sr - 1, sc, color, m, n, originColor);
        dfsColor(image, sr, sc - 1, color, m, n, originColor);
        dfsColor(image, sr + 1, sc, color, m, n, originColor);
        dfsColor(image, sr, sc + 1, color, m, n, originColor);
    }

    private void dfsArea(int[][] grid, int w, int h, int x, int y) {
        System.out.println(x + "-" + y + ":" + res);
        if (x < 0 || y < 0 || x >= h || y >= w || grid[x][y] == 0) return;
        res++;
        grid[x][y] = 0;
        dfsArea(grid, w, h, x - 1, y);
        dfsArea(grid, w, h, x, y + 1);
        dfsArea(grid, w, h, x + 1, y);
        dfsArea(grid, w, h, x, y - 1);
    }
}
