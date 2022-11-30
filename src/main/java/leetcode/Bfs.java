package leetcode;

import algorithm.base.StdOut;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先
 *
 * @author LvYingBin
 * @version 1.0
 * @since 2022/11/29 6:13 下午
 **/
public class Bfs {
    /**
     * 填充每个节点的下一个右侧节点指针
     * https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/
     *
     * @param
     * @return
     * @since 2022/11/29 5:12 下午
     */
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i < size - 1) {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    public class Matrix {
        int x;
        int y;

        public Matrix(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int w = mat[0].length;
        int h = mat.length;
        LinkedList<Matrix> queue = new LinkedList<>();
        int[][] result = new int[h][w];
        for (int x = 0; x < h; x++) {
            for (int y = 0; y < w; y++) {
                if (mat[x][y] == 0) {
                    queue.add(new Matrix(x, y));
                    result[x][y] = 0;
                } else {
                    result[x][y] = -1;
                }
            }
        }
        StdOut.println(Arrays.deepToString(result));
        while (!queue.isEmpty()) {
            Matrix matrix = queue.poll();
            if (matrix.x - 1 >= 0 && result[matrix.x - 1][matrix.y] == -1) {
                StdOut.println(matrix.x - 1 + "-" + matrix.y);
                result[matrix.x - 1][matrix.y] = result[matrix.x][matrix.y] + 1;
                queue.add(new Matrix(matrix.x - 1, matrix.y));
            }
            if (matrix.y + 1 < w && result[matrix.x][matrix.y + 1] == -1) {
                StdOut.println(matrix.x + "-" + matrix.y + 1);
                result[matrix.x][matrix.y + 1] = result[matrix.x][matrix.y] + 1;
                queue.add(new Matrix(matrix.x, matrix.y + 1));
            }
            if (matrix.x + 1 < h && result[matrix.x + 1][matrix.y] == -1) {
                StdOut.println(matrix.x + 1 + "-" + matrix.y);
                result[matrix.x + 1][matrix.y] = result[matrix.x][matrix.y] + 1;
                queue.add(new Matrix(matrix.x + 1, matrix.y));
            }
            if (matrix.y - 1 >= 0 && result[matrix.x][matrix.y - 1] == -1) {
                StdOut.println(matrix.x + "-" + (matrix.y - 1));
                result[matrix.x][matrix.y - 1] = result[matrix.x][matrix.y] + 1;
                queue.add(new Matrix(matrix.x, matrix.y - 1));
            }
        }
        return result;
    }

    /**
     * 腐烂的橘子传染时间计算
     * https://leetcode.cn/problems/rotting-oranges/
     *
     * @param
     * @return
     * @since 2022/11/30 2:33 下午
     */
    public int orangesRotting(int[][] grid) {
        int w = grid[0].length;
        int h = grid.length;
        LinkedList<Matrix> queue = new LinkedList<>();
        int[][] seen = new int[h][w];
        int fresh = 0;
        for (int x = 0; x < h; x++) {
            for (int y = 0; y < w; y++) {
                seen[x][y] = -1;
                if (grid[x][y] == 2) {
                    seen[x][y] = 0;
                    queue.add(new Matrix(x, y));
                } else if (grid[x][y] == 1) {
                    fresh++;
                }
            }
        }
        StdOut.println(Arrays.deepToString(seen));
        if (fresh == 0) return 0;
        if (queue.isEmpty()) return -1;
        int result = 0;
        int[][] array = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while (!queue.isEmpty() && fresh > 0) {
            Matrix matrix = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = matrix.x + array[i][0];
                int ny = matrix.y + array[i][1];
                if (nx >= 0 && ny >= 0 && nx < h && ny < w && grid[nx][ny] != 0 && seen[nx][ny] == -1) {
                    StdOut.println(nx + "|" + ny);
                    if (grid[nx][ny] == 1) {
                        fresh--;
                    }
                    seen[nx][ny] = seen[matrix.x][matrix.y] + 1;
                    result = Math.max(result, seen[nx][ny]);
                    queue.add(new Matrix(nx, ny));
                    StdOut.println(Arrays.deepToString(seen));
                }
            }
        }
        return fresh > 0 ? -1 : result;
    }
}
