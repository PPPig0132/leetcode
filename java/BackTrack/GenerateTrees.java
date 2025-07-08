package BackTrack;

import java.util.ArrayList;
import java.util.List;

import Tree.TreeNode;
/*
给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
*/
public class GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        for (int i = start; i <= end; i++) {
            // 递归生成左子树和右子树
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            // 组合左子树和右子树
            for (TreeNode l : leftTrees) {
                for (TreeNode r : rightTrees) {
                    TreeNode currentNode = new TreeNode(i);
                    currentNode.left = l;
                    currentNode.right = r;
                    allTrees.add(currentNode);
                }
            }
        }
        return allTrees;
    }
    public static void main(String[] args) {
        GenerateTrees generateTrees = new GenerateTrees();
        List<TreeNode> result = generateTrees.generateTrees(3);
        // 输出结果
        for (TreeNode tree : result) {
            System.out.println(tree);
        }
    }
}
