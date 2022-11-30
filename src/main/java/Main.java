import algorithm.base.StdOut;
import leetcode.Bfs;
import leetcode.Dfs;

import java.util.Arrays;

/**
 * algorithm代码参考
 * https://algs4.cs.princeton.edu/code/
 *
 * @author LvYingBin
 * @version 1.0
 * @since 2022/11/29 8:49 上午
 **/
public class Main {
    public static void main(String args[]) {
        int[][] array = {{2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}};
        Bfs bfs = new Bfs();
        int res = bfs.orangesRotting(array);
        StdOut.println(res);
    }
}
