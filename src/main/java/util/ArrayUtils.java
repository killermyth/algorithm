package util;

/**
 * TODO 类描述
 *
 * @author LvYingBin
 * @version 1.0
 * @since 2022/11/29 8:50 上午
 **/
public class ArrayUtils {

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void exch(Comparable[] array, int a, int b) {
        Comparable aa = array[a];
        array[a] = array[b];
        array[b] = aa;
    }

    public static void exch(char[] array, int a, int b) {
        char aa = array[a];
        array[a] = array[b];
        array[b] = aa;
    }

    public static void show(Comparable[] array) {
        System.out.print("arrayIs: ");
        for (Comparable v : array) {
            System.out.print(v + " ");
        }
        System.out.println("");
    }

    public static void show(char[] array) {
        System.out.print("arrayIs: ");
        for (Comparable v : array) {
            System.out.print(v + " ");
        }
        System.out.println("");
    }

    public static void show(int[] array) {
        System.out.print("arrayIs: ");
        for (int v : array) {
            System.out.print(v + " ");
        }
        System.out.println("");
    }
}
