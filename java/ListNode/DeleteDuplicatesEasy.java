import ListNode.ListNode;
/*给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。*/

public class DeleteDuplicatesEasy {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode pre=head,end=head.next;
        while(end!=null){
            while(end!=null && pre.val==end.val){
                end=end.next;
            }
            pre.next=end;
            pre=pre.next;
            if(end!=null) end=end.next;
        }
        return head;
    }
    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        
        DeleteDuplicatesEasy solution = new DeleteDuplicatesEasy();
        ListNode result = solution.deleteDuplicates(head);
        
        // Print the result
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
