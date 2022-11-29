package leetcode;

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
}
