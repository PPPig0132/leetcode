package Stack;
/*通过两个栈实现队列  push pop()
一个栈进栈
一个栈出栈

进栈只进到in中
执行出栈时先看out是否为空，是则将进栈的元素全部放到out中去；不空则将out中元素出栈

*/
import java.util.*;
public class MyQueue {
    Deque<Integer> in;
    Deque<Integer> out;
   // Duque<Integer> in;
    //Duque<Integer>  out;

    public MyQueue() {
        in=new LinkedList<>();
        out=new LinkedList<>();
        //in=stk1;out=stk2;
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        if(out.isEmpty()){
            while(in.size()!=1){
            out.push(in.pop());
            }
            return in.pop();
        }
        return out.pop();
    }
    
    public int peek() {
       if(out.isEmpty()){
            while(in.size()!=1){
            out.push(in.pop());
            }
            int x=in.pop();
            out.push(x);
            return x;
        }
        return out.peekFirst();
    }
    
    public boolean empty() {
        return in.isEmpty()&&out.isEmpty();
    }
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek()); // 输出: 1
        System.out.println(queue.pop());  // 输出: 1
        System.out.println(queue.empty()); // 输出: false
        System.out.println(queue.pop());  // 输出: 2
        System.out.println(queue.empty()); // 输出: true
    }
}
