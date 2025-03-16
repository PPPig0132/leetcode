import ListNode.ListNode;
public class SortList {
    public static void main(String args[]){
        int [] arr={4,2,1,3};
        ListNode head=ListNode.generateLinkList(arr);
        SortList orderList=new SortList();
        ListNode new_head=orderList.sortList(head);
        while(new_head!=null){
            System.out.print(new_head.val+" ");
            new_head=new_head.next;
        }

    }
    public ListNode sortList(ListNode head){
       return sort(head,null);

    }
    public ListNode sort(ListNode head, ListNode tail){
        if(head==null){
            return head;
        }
        if(head.next==tail){
            head.next=null;
            return head;
        }
        //  ListNode mid=head,end=head;
        //   while(end.next!=tail && end.next.next!=tail){
        //     mid=mid.next;
        //     end=end.next.next;
        // }
        // if(end.next!=tail){
        //     end=end.next;
        // }
        ListNode mid=head,end=head;
        while(end.next!=tail){
          mid=mid.next;
          end=end.next;
          if(end.next!=tail){
            end=end.next;
        }
      }
      System.err.println("mid:"+mid.val);
         return merge(sort(head,mid),sort(mid,tail));
    }

    public ListNode merge(ListNode list1, ListNode list2){
        ListNode new_head=new ListNode(0);
        ListNode end=new_head;
        while(list1!=null && list2!=null){
            ListNode temp;   
            if(list1.val>=list2.val){
                temp=list2;
                list2=list2.next;
                temp.next=end.next;
                end.next=temp;
                end=end.next;
            }
            else{
                temp=list1;
                list1=list1.next;
                temp.next=end.next;
                end.next=temp;
                end=end.next;
            }

        }
        if(list1!=null){
            end.next=list1;
        }
        else if(list2!=null){
            end.next=list2;
        }
        return new_head.next;
    }
    
}
