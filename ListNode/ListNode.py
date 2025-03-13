class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
        
def generateList(l):
    if len(l)==0:
        return None
    head=ListNode(l[0])
    p=head
    for i in l[1:]:
        p.next=ListNode(i)
        p=p.next
    return head