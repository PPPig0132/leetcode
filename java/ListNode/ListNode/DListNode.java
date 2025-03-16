package ListNode;

public class DListNode {
    public int val;
    public DListNode next;
    public DListNode prev;

    public DListNode(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }

    public DListNode( ) {
        this.val = 0;
        this.next = null;
        this.prev = null;
    }
    public static DListNode generateLinkList(int[] values) {
        if (values == null || values.length == 0) {
            return null; // 如果数组为空，返回 null
        }

        // 创建头节点
        DListNode head = new DListNode(values[0]);
        DListNode current = head; // 用于遍历链表的指针

        // 遍历数组，依次创建链表节点
        for (int i = 1; i < values.length; i++) {
            current.next = new DListNode(values[i]);
            current.next.prev = current;
            current = current.next; // 移动指针到下一个节点
        }

        return head; // 返回链表的头节点
    }
    
}
