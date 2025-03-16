import ListNode.ListNode;

public class IsPalindrome {
    public static void main(String []args){
        int [] arr={1,2,3,2,1};
        ListNode head=ListNode.generateLinkList(arr);
        IsPalindrome ip=new IsPalindrome();
        boolean result=ip.isPalindrome(head);
        System.out.println(result);

    }
    public boolean isPalindrome(ListNode head){
        if(head==null || head.next==null){
            return true;
        }
        //新增加一个空的头指针，无论单数还是双数最后慢指针都停留在后一半的pre
        ListNode pre=new ListNode();
        pre.next=head;
        head=pre;
        ListNode end=head; 
        while(end!=null && end.next!=null){
            pre=pre.next;
            end=end.next;
            end=end.next;
        }


        end=pre.next;
        pre.next=null;
        while(end!=null){
            ListNode temp=end;
            end=end.next;
            temp.next=pre.next;
            pre.next=temp;
            
        }
        end=pre.next;
        pre=head.next;
        while(end!=null){
            if(end.val!=pre.val){
                break;
            }
            end=end.next;
            pre=pre.next;
        }
        if(end!=null){
            return false;
        }
        return true;
    
    
            
        }
    
}
