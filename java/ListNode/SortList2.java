import ListNode.ListNode;
import java.util.*;
public class SortList2 {
    public ListNode sortList(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode pre=new ListNode();
        pre.next=head;
        sort(pre,null);
       return pre.next;

    }
    public void sort(ListNode head,ListNode tail){
        if(head==null || head.next==tail){
            return;
        }
       
        ListNode end=head.next,cur=head.next;
        if(cur==tail){
            return;
        }   
        while(cur.next!=tail){
            if(cur.next.val<end.val){
                ListNode temp=cur.next.next;
                cur.next.next=head.next;
                head.next=cur.next;
                cur.next=temp;
            }
            else{
                cur=cur.next;
            }
            
        }
        sort(head,end);
        sort(end,tail);

    }
    public static void main(String args[]){
        int [] arr={4,2,1,3};
        ListNode head=ListNode.generateLinkList(arr);
        SortList2 orderList=new SortList2();
        ListNode new_head=orderList.sortList(head);
        while(new_head!=null){
            System.out.print(new_head.val+" ");
            new_head=new_head.next;
        }

    }
}
