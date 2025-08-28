import ListNode.ListNode;

public class MergeKLists {
    public ListNode mergeKLists(ListNode []lists){
        if(lists.length==0 ){
            return null;
        }
        if( lists.length==1){
            return lists[0];
        }
        int x=lists.length;
        while(x>1){
            for(int i=0;i<x/2;i++){
                lists[i]=merge(lists[2*i],lists[2*i+1]);
            }
            if((x&1)==1) {
                lists[x/2]=lists[x-1];
                 x=x/2+1;
            }
            else{
                x=x/2;
            }
             
            
        }
        
        return lists[0];
    }
    public ListNode merge(ListNode list1, ListNode list2){
        ListNode new_head=new ListNode(0);
        ListNode end=new_head;
        while(list1!=null && list2!=null){
            ListNode temp;   
            if(list1.val>=list2.val){
               end.next=list2;
               list2=list2.next;
               end=end.next;
            }
            else{
                end.next=list1;
                list1=list1.next;
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
    public static void main(String[] args) {
        MergeKLists mergeKLists = new MergeKLists();
        ListNode[] lists = new ListNode[3];
        lists[0] = ListNode.generateLinkList(new int[]{1, 4, 5});
        lists[1] = ListNode.generateLinkList(new int[]{1, 3, 4});
        lists[2] = ListNode.generateLinkList(new int[]{2, 6});
        ListNode mergedList = mergeKLists.mergeKLists(lists);
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }
}
