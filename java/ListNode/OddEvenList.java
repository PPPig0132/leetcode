import ListNode.ListNode;

public class OddEvenList {
    public ListNode oddEvenList (ListNode head) {
        // write code here
        if(head==null) return head;
        ListNode odd=new ListNode(0),cur=odd,pre=head;
        while(pre.next!=null){
            // if((idx&1)==1){
                cur.next=pre.next;
                pre.next=pre.next.next;
                cur=cur.next;
                cur.next=null;
                if(pre.next!=null){
                    pre=pre.next;
                }
            // }
            // idx++;
        }
        pre.next=odd.next;
        return head;
    }
    public static void main(String[] args) {
        OddEvenList oddEvenList = new OddEvenList();
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = ListNode.generateLinkList(arr);
        ListNode result = oddEvenList.oddEvenList(head);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
