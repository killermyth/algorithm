package leetcode;

import util.ListNode;

import java.util.Objects;

/**
 * TODO 类描述
 *
 * @author LvYingBin
 * @version 1.0
 * @since 2022/11/30 3:36 下午
 **/
public class LinkedList {
    /**
     * 合并两个链表
     * https://leetcode.cn/problems/merge-two-sorted-lists
     *
     * @param
     * @return
     * @since 2022/11/30 4:34 下午
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while (Objects.nonNull(l1) && Objects.nonNull(l2)) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    /**
     * 链表反转 递归版本
     * 这个要好好理解
     * https://leetcode.cn/problems/reverse-linked-list/
     *
     * @param
     * @return
     * @since 2022/11/30 4:35 下午
     */
    public ListNode reverseList(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }
        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }

    /**
     * 链表反转 循环版本
     * https://leetcode.cn/problems/reverse-linked-list/
     *
     * @param
     * @return
     * @since 2022/11/30 5:56 下午
     */
    public ListNode reverseListb(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (Objects.nonNull(cur)) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
