import ListNode.Node;
public class CopyRandomList {
    public static void main(String args[]){
        int []a={1,2,3,4,5,6,7};
        Node head=Node.generateLinkList(a);
        Node temp=head;
        while(temp!=null){
            temp.random=temp.next;
            temp=temp.next;
            
        }
        CopyRandomList obj=new CopyRandomList();
        Node x=obj.copyRandomList(head);
        while(x!=null){
            System.out.print(x.val+" ");
            System.out.print(x.random.val+" ");
            x=x.next;
        }

    }
    public Node copyRandomList(Node head){
        if(head==null){
            return null;
        }
        Node new_head=new Node(head.val);
        Node end=head,end1=new_head;
        end=end.next;
        while(end!=null){
            Node temp=new Node(end.val);
            end1.next=temp;
            end=end.next;
            end1=end1.next;
        }
        end=head;end1=new_head;
        while(end!=null){
            if(end.random==null){
                end1.random=null;
            }
            Node temp=head,temp1=new_head;
            while(temp!=null){
                if(end.random==temp){
                    end1.random=temp1;
                    break;
                }
                temp=temp.next;
                temp1=temp1.next;
            }
            end=end.next;
            end1=end1.next;
        }
        return new_head;

    }
    
}
