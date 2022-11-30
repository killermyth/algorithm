package util;

import java.util.Objects;

/**
 * TODO 类描述
 *
 * @author LvYingBin
 * @version 1.0
 * @since 2022/11/30 4:49 下午
 **/
public class LinkedListUtils {
    public static ListNode generate(int[] array) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        for (int i : array) {
            ListNode node = new ListNode(i);
            pre.next = node;
            pre = pre.next;
        }
        return dummy.next;
    }

    public static void print(ListNode node) {
        System.out.print("NodeList:");
        ListNode dummy = new ListNode(0, node);
        while (Objects.nonNull(dummy.next)) {
            System.out.print(dummy.val + "-");
            dummy = dummy.next;
        }
        System.out.println("");
    }
}
