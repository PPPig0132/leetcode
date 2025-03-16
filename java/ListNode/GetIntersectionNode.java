import java.lang.reflect.GenericArrayType;

import ListNode.ListNode;

public class GetIntersectionNode {
    public static void main(String []args){
        int []a={4,1,8,4,5};
        int []b={5,0,1,8,4,5};
        ListNode headA=ListNode.generateLinkList(a);
        ListNode headB=ListNode.generateLinkList(b);
        GetIntersectionNode solution=new GetIntersectionNode();
        ListNode result=solution.getIntersectionNode(headA,headB);
        System.out.println(result.val);
        
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode x=headA,y=headB;
    
        while(x!=null && y!=null){
            x=x.next;
            y=y.next;
        }
        if(x!=null){
            y=headA;
            while(x!=null){
                x=x.next;
                y=y.next;
            }
            while(headB!= null && headB!=y){
                headB=headB.next;
                y=y.next;
            }
            return headB;
        }
    
        else{
            x=headB;
            while(y!=null){
                y=y.next;
                x=x.next;
            }
            while(headA!=null && headA!=x){
                headA=headA.next;
                x=x.next;
            }
            return headA;
    
        }
    }
   
}