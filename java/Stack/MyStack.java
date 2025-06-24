package Stack;

/*
用队列实现栈  队列offer poll
每次向非空队列追加元素，出栈则向空队列移动n-1个元素
*/
import java.util.*;
public class MyStack {
    private Queue<Integer> Q1;
    private Queue<Integer> Q2;
    private Queue<Integer> in;//指向非空队列
    private Queue<Integer> out;

    public MyStack() {
        this.Q1=new LinkedList<Integer>();
        this.Q2=new LinkedList<Integer>();
        in=Q1;
        out=Q2;
    }
    
    public void push(int x) {
        in.offer(x);
    }
    
    public int pop() {
        while(in.size()>1){
            out.offer(in.poll());
        }
        if(in==Q1){
            in=Q2;
            out=Q1;
        }
        else{
            in=Q1;
            out=Q2;
        }
        return out.poll();
    }
    
    public int top() {
         while(in.size()>1){
            out.offer(in.poll());
        }
        if(in==Q1){
            in=Q2;
            out=Q1;
        }
        else{
            in=Q1;
            out=Q2;
        }
        int x=out.poll();
        in.offer(x);
        return x;
        
    }
    
    public boolean empty() {
        return in.isEmpty()&& out.isEmpty();
    }
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top()); // 输出: 2
        System.out.println(stack.pop()); // 输出: 2
        System.out.println(stack.empty()); // 输出: false
        System.out.println(stack.pop()); // 输出: 1
        System.out.println(stack.empty()); // 输出: true
    }
}
