import leetcode.LinkedList;
import util.LinkedListUtils;
import util.ListNode;

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
        LinkedList linkedList = new LinkedList();
        int[] array = {1, 2, 3, 4, 5};
        ListNode node = LinkedListUtils.generate(array);
        ListNode res = linkedList.reverseList(node);
        LinkedListUtils.print(res);
    }
}
