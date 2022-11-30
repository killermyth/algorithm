package util;

/**
 * TODO 类描述
 *
 * @author LvYingBin
 * @version 1.0
 * @since 2022/11/30 4:59 下午
 **/
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
