package Graph;
/*
图的深拷贝，类似于链表的深拷贝
连通图，没有重复边和闭环
*/
import java.util.*;
public class CloneGraph {
    Map<Node,Node>map;
    Set<Integer>visited;
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        if(node.neighbors.size()==0){
            return new Node(node.val);
        }
        map=new HashMap<>();visited=new HashSet<>();
        Node root=new Node(node.val),cur=node;
        map.put(node,root);
        dfs(cur);
        return root;
    }
    public void dfs(Node node){
        if(visited.contains(node.val)){
            return;
        }
        visited.add(node.val);
        for(int i=0;i<node.neighbors.size();++i){
            Node temp=node.neighbors.get(i);
            if(map.containsKey(temp)){
                map.get(node).neighbors.add(map.get(temp));
            }
            else{
                Node newNode=new Node(temp.val);
                 map.get(node).neighbors.add(newNode);
                 map.put(temp,newNode);
            }
            dfs(temp);
        }
    }
    public static void main(String[] args) {
        // 测试代码可以在这里添加
        // 创建图的节点和邻居关系，然后调用 cloneGraph 方法进行深拷贝
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        CloneGraph cg = new CloneGraph();
        Node clonedGraph = cg.cloneGraph(node1);

        // 输出克隆后的图的节点值和邻居
        System.out.println("Cloned Graph:");
        for (Node n : clonedGraph.neighbors) {
            System.out.println("Node " + clonedGraph.val + " has neighbor " + n.val);
        }
    }
}
