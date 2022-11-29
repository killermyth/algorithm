package graph;

/**
 * TODO 类描述
 *
 * @author LvYingBin
 * @version 1.0
 * @since 2022/11/29 8:52 上午
 **/
public class Dfs {
    /**
     * 二维数组图像，相邻格子渲染相同颜色
     *
     * @param
     * @return
     * @since 2022/11/29 10:03 上午
     */
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int originColor = image[sr][sc];
        if (color == originColor) {
            return image;
        }
        dfsColor(image, sr, sc, color, m, n, originColor);
        return image;
    }

    public static void dfsColor(int[][] image, int sr, int sc, int color, int m, int n, int originColor) {
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
}
