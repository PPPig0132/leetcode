package Tree;

import java.util.*;

public class AverageOfLevels {
    // List<Double>ans=new ArrayList<>();
    // List<List<Double>>layer=new ArrayList<>();
    // public List<Double> averageOfLevels(TreeNode root) {
    //     dfs(root,0);
    //     for(List<Double> list:layer){
    //         double sum=0;
    //         for(double num:list){
    //             sum+=num;
    //         }
    //         ans.add(sum/list.size());
    //     }
    //     return ans;
        
    // }
    // public void dfs(TreeNode root, int deepth){
    //     if(root==null){
    //         return;
    //     }
    //     if(deepth==layer.size()){
    //         layer.add(new ArrayList<>());
    //         layer.get(deepth).add(root.val/1.0);
    //     }
    //     else{
    //        layer.get(deepth).add(root.val/1.0);
    //     }
    //     deepth++;
    //     dfs(root.left,deepth);
    //     dfs(root.right,deepth);
    // }
     public List<Double> averageOfLevels(TreeNode root) {
        List<Double>ans=new ArrayList<>();
        Queue<TreeNode>queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            double sum=0;
            int count=queue.size();
            for(int i=0;i<count;++i){
                TreeNode node=queue.poll();
                sum+=node.val;
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            ans.add(sum/count);
        }
        // dfs(root,0);
        return ans;
        
    }
    public static void main(String[] args) {
        // 测试代码
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        AverageOfLevels solution = new AverageOfLevels();
        List<Double> result = solution.averageOfLevels(root);
        System.out.println(result); // 输出: [3.0, 14.5, 11.0]
    }
}
