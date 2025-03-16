import ListNode.ListNode;
public class AddTwoNumbers{
    public static void main(String [] args){
        int []arr1={9,9,9,9,9,9,9};
        int []arr2={9,9,9,9};
        ListNode head1=ListNode.generateLinkList(arr1);
        ListNode head2=ListNode.generateLinkList(arr2);
        AddTwoNumbers atn=new AddTwoNumbers();
        ListNode result=atn.addTwoNumbers(head1,head2);
        while(result!=null){
            System.out.println(result.val);
            result=result.next;
        }

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null){
           return l2;
       }
       if(l2==null){
           return l1;
       }
       int x=0;//进位符
       ListNode temp=l1,end=l1;

       while(temp !=null ||  l2!=null){
           int m=(temp==null)?0:temp.val;
           int n=(l2==null)?0:l2.val;
           end.val=(m+n+x)%10;
           x=(m+n+x)/10;
           if(temp!=null ){
               temp=temp.next;
           }
           if(l2!=null){
               l2=l2.next;
           }
          
           if(temp!=null ){
               if(temp!=null){
                   end.next=temp;
                   end=end.next;
               }
           }
           else if(l2!=null ){
               if(l2!=null){
                   end.next=l2;
                   end=end.next;
               }
           }
           
       }
       if(end.next==null && x!=0){
           ListNode onemore =new ListNode(x);
           end.next=onemore;
       }
       return l1;
    }
   }