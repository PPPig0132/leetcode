import ListNode.ListNode;
/*对链表做插入排序*/

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode pre=new ListNode(),end;
        pre.next=head;
        head=head.next;
        pre.next.next=null;
        end=pre.next;
        while(head!=null){
            ListNode node=head;
            head=head.next;
            insert(pre,end,node);
            if(node.val>=end.val) end=node;
        }
        return pre.next;
        
    }

    public void insert(ListNode head,ListNode end,ListNode node){
        if(node.val>=end.val) {
            node.next=end.next;
            end.next=node;
        }
        else{
            while(head.next!=null && head.next.val<node.val){
                head=head.next;
            }
            node.next=head.next;
            head.next=node;
        }
        
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);

        InsertionSortList sorter = new InsertionSortList();
        ListNode sortedHead = sorter.insertionSortList(head);

        // Print sorted list
        while (sortedHead != null) {
            System.out.print(sortedHead.val + " ");
            sortedHead = sortedHead.next;
        }
    }
}
