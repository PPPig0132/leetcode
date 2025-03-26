# 知识点

遍历：

先序遍历： 根 ->左->右

中序遍历： 左->根->右

后序遍历： 左->右->根

层序遍历：树的广度优先搜索，使用队列

***前序和后序遍历不能确定唯一二叉树***


平衡二叉树：左树和右树的高度差不超过1，且左右子树均是平衡二叉树

二叉搜索树: 左子树的值均小于根节点、右子树的值均大于根节点

**二叉搜索树的中序遍历必为增序序列**

二叉搜索树平衡调整：

增加

LL：在**被破坏节点**的左边的左边插入而导致失衡。以**被破坏节**点为基础进行右旋

RR：以**被破坏节点**为基础进行左旋

LR：在**被破坏节点**的左边的右边插入而导致失衡，以被**破坏节点L（左）节点**为基础先进行一次L（左）旋，再以**被破坏节点**为基础进行右旋。（左节点左旋，本身右旋）

RL：以被**破坏节点R（右）节点**为基础先进行一次R（右）旋，再以被**破坏节点**为基础进行左旋。（右节点右旋，本身左旋）

删除

在某一边删除而导致失衡时，则判断被破坏节点的某节点的左右高度，如果高度不一致，则相当于在某边+高度高的那一边进行的插入，根据类型判断对应的旋转；如果高度一致，则对被破坏节点进行删除某旋即可。

[平衡二叉树详解](https://blog.csdn.net/m0_37914588/article/details/103754959 "删除")

# 题目

对称树: 对称验证，验证每一个左子树和右子树是否相等check(l\.right,r.left)

验证二叉搜索树:除了中序遍历，其余的迭代验证方法

二叉搜索树第K小的值：除中序遍历外的算法

右视图：除层次遍历外的

二叉树展开：除了先序遍历的方法

路径综合

# 经典代码

- 先序遍历（DFS）
```
void preorderTraversal(TreeNode root) {
    if (root == null) return;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        System.out.print(node.val + " "); // 访问根节点

        if (node.right != null) {
            stack.push(node.right); // 先压右子节点
        }
        if (node.left != null) {
            stack.push(node.left); // 再压左子节点
        }
    }
}
```

- 中序遍历

```
void inorderTraversal(TreeNode root) {
    if (root == null) return;
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;

    while (curr != null || !stack.isEmpty()) {
        while (curr != null) {
            stack.push(curr); // 将当前节点的所有左子节点压入栈
            curr = curr.left;
        }
        curr = stack.pop(); // 弹出栈顶元素
        System.out.print(curr.val + " "); // 访问根节点
        curr = curr.right; // 转向右子树
    }
}
```

- 后序遍历
```
void postorderTraversal(TreeNode root) {
    if (root == null) return;
    Stack<TreeNode> stack = new Stack<>();
    TreeNode lastVisitedNode = null;

    while (root != null || !stack.isEmpty()) {
        while (root != null) {
            stack.push(root); // 将当前节点的所有左子节点压入栈
            root = root.left;
        }
        root = stack.pop(); // 弹出栈顶元素

        // 只有当右子树为空，或者右子树已经访问过时，才访问当前节点
        if (root.right == null || root.right == lastVisitedNode) {
            System.out.print(root.val + " "); // 访问根节点
            lastVisitedNode = root; // 更新最后访问的节点
            root = null; // 防止再次进入循环
        } else {
            stack.push(root); // 重新压入当前节点
            root = root.right; // 转向右子树
        }
    }
}
```

- 层次遍历（BFS）

```
void levelOrderTraversal(TreeNode root) {
    if (root == null) return;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root); // 将根节点加入队列

    while (!queue.isEmpty()) {
        TreeNode node = queue.poll(); // 取出队列中的节点
        System.out.print(node.val + " "); // 访问节点

        if (node.left != null) {
            queue.offer(node.left); // 将左子节点加入队列
        }
        if (node.right != null) {
            queue.offer(node.right); // 将右子节点加入队列
        }
    }
}
```

- 总结
非递归先序遍历：使用栈模拟递归，先压右子节点，再压左子节点。    
非递归中序遍历：使用栈模拟递归，先将左子树压入栈，弹出栈顶元素后访问，再转向右子树。  
非递归后序遍历：使用栈模拟递归，需要记录最后访问的节点，以确保右子树访问后才能访问根节点。  
广度优先遍历：使用队列逐层访问节点。  