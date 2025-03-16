package ListNode;

public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
    public static Node generateLinkList(int[] values) {
        if (values == null || values.length == 0) {
            return null; // 如果数组为空，返回 null
        }

        // 创建头节点
        Node head = new Node(values[0]);
        Node current = head; // 用于遍历链表的指针

        // 遍历数组，依次创建链表节点
        for (int i = 1; i < values.length; i++) {
            current.next = new Node(values[i]);
            current = current.next; // 移动指针到下一个节点
        }

        return head; // 返回链表的头节点
    }

}