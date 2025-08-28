import java.util.HashMap;

public class LRUcache {
     private static class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private  int capacity;      // 最大容量
    private  HashMap<Integer, Node> map;  // key -> Node
    private  Node head;         // 虚拟头节点（最久未使用方向）
    private  Node tail;         // 虚拟尾节点（最新使用方向）

    // 初始化 LRU 缓存
    public LRUcache(int capacity) {
        this.capacity  = Math.max(capacity, 1); // 至少为 1
        this.map = new HashMap<>();
        // 建立哨兵节点，简化边界处理
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    // 如果 key 存在，返回对应的 value，并将其置为最新使用；否则返回 -1
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        moveToTail(node);
        return node.value;
    }

    // 插入或更新 key-value
    public void set(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            // 已存在：更新 value，并置为最新
            node.value = value;
            moveToTail(node);
        } else {
            // 新节点
            if (map.size() == capacity) {
                // 需要淘汰最久未使用的节点（位于 head.next）
                Node toEvict = head.next;
                removeNode(toEvict);
                map.remove(toEvict.key);
            }
            Node newNode = new Node(key, value);
            addToTail(newNode);
            map.put(key, newNode);
        }
    }

    /**************** 双向链表辅助操作 ****************/
    private void moveToTail(Node node) {
        removeNode(node);
        addToTail(node);
    }

    private void addToTail(Node node) {
        Node last = tail.prev;
        last.next = node;
        node.prev = last;
        node.next = tail;
        tail.prev = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**************** 简单测试 ****************/
    public static void main(String[] args) {
        LRUcache cache = new LRUcache(2);
        cache.set(1, 1);            // 缓存 {1=1}
        cache.set(2, 2);            // 缓存 {1=1, 2=2}
        System.out.println(cache.get(1)); // 返回 1，缓存 {2=2, 1=1}
        cache.set(3, 3);            // 淘汰 key=2，缓存 {1=1, 3=3}
        System.out.println(cache.get(2)); // 返回 -1
        cache.set(4, 4);            // 淘汰 key=1，缓存 {3=3, 4=4}
        System.out.println(cache.get(1)); // 返回 -1
        System.out.println(cache.get(3)); // 返回 3
        System.out.println(cache.get(4)); // 返回 4
    }
}
