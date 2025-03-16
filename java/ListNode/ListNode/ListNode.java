package ListNode;

public class ListNode {
    // 定义链表节点的属性
    public int val;
    public ListNode next;

    // 构造函数，用于创建链表节点
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    // 无参构造函数，方便扩展
    public ListNode() {
        this.val = 0;
        this.next = null;
    }

    /**
     * 通过 int 数组生成链表，并返回链表的头节点
     * @param values 数组中的值将依次作为链表节点的值
     * @return 链表的头节点
     */
    public static ListNode generateLinkList(int[] values) {
        if (values == null || values.length == 0) {
            return null; // 如果数组为空，返回 null
        }

        // 创建头节点
        ListNode head = new ListNode(values[0]);
        ListNode current = head; // 用于遍历链表的指针

        // 遍历数组，依次创建链表节点
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next; // 移动指针到下一个节点
        }

        return head; // 返回链表的头节点
    }
}