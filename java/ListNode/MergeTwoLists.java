import ListNode.ListNode;
public class MergeTwoLists {
    public static void main(String []args){
        int []arr1={1,2,4};
        int []arr2={1,3,4};
        ListNode head1=ListNode.generateLinkList(arr1);
        ListNode head2=ListNode.generateLinkList(arr2);
        MergeTwoLists mtl=new MergeTwoLists();
        ListNode result=mtl.mergeTwoLists(head1,head2);
        while(result!=null){
            System.out.println(result.val);
            result=result.next;
        }
        

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        if(list1 ==null){
            return list2;
        }
        if(list2==null ){
            return list1;
        }
        ListNode new_head=(list1.val < list2.val)? list1:list2;
        ListNode head=(list1.val >= list2.val)? list1:list2;
        
        list1=new_head.next;
        new_head.next=null;
        list2=new_head; //as end
        while(list1!=null && head!=null){
            if(list1.val<=head.val){
                ListNode temp;
                temp=list1;
                list1=list1.next;
                temp.next=list2.next;
                list2.next=temp;
                list2=list2.next;
            }
            else{
                ListNode temp;
                temp=head;
                head=head.next;
                temp.next=list2.next;
                list2.next=temp;
                list2=list2.next;
            }
        }
        if(list1!=null){
            list2.next=list1;
        }
        if(head !=null){
            list2.next=head;
        }
        return(new_head);
    }
    
}