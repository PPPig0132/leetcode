from typing import Optional,List
from TreeNode import TreeNode
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        if not root:
            return 0
        l,r=0,0 
        # print("target:",targetSum)
        stack=[]
        arr=[]
        count=0
        stack.append(root)
        while stack:
            node=stack.pop()
            arr.append(node)
            if node.left:
                stack.append(node.left)
            if node.right:
                stack.append(node.right)
        for node in arr:
            
            l=self.check(node,targetSum)
            r=self.check(node.left,targetSum)
            print(node.val,l,r)
            count=count+l+r
        return count


    def check(self,root:Optional[TreeNode],targetSum:int)->int:
        if not root:
            return 0
        l,r=0,0
        if root.val==targetSum:
            return 1
        l=self.check(root.left,targetSum-root.val)
        r=self.check(root.right,targetSum-root.val)
        return l+r

           
Node=TreeNode(10)
Node.left=TreeNode(5)
Node.right=TreeNode(-3)
Node.left.left=TreeNode(3)
Node.left.right=TreeNode(2)
Node.right.right=TreeNode(11)
Node.left.left.left=TreeNode(3)
Node.left.left.right=TreeNode(-2)
Node.left.right.right=TreeNode(1)
# Node=Node.right
sol=Solution()
x=sol.pathSum(Node,8)
print(x)