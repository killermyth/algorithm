import algorithm.base.StdOut;
import leetcode.Dfs;

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
        int[][] array = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        StdOut.println(array);
        Dfs dfs = new Dfs();
        int res = dfs.maxAreaOfIsland(array);
        System.out.println(res);
    }
}
