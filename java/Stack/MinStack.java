package Stack;
import java.util.*;
/*
设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

实现 MinStack 类:

MinStack() 初始化堆栈对象。
void push(int val) 将元素val推入堆栈。
void pop() 删除堆栈顶部的元素。
int top() 获取堆栈顶部的元素。
int getMin() 获取堆栈中的最小元素。
*/

public class MinStack {
    private Stack<Integer> stack;
    private  Stack<Integer>  minStack;
    public MinStack() {
        stack=new Stack<>();
        minStack=new Stack<>();
        
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek()){//当前元素小于最小元素时才入栈，因为栈的出栈顺序是固定的，不可能存在主栈与最小栈出栈顺序不一致的情况
            minStack.push(val);
        }
        
    }
    
    public void pop() {
        if(stack.isEmpty()){
            throw new IllegalStateException("stack  is Empty");
        }
        int val=stack.pop();
        if(val==minStack.peek()){
            minStack.pop();
        }
        
    }
    
    public int top() {
        if(stack.isEmpty()){
            throw new IllegalStateException("stack is Empty");
        }
        return stack.peek();
        
    }
    
    public int getMin() {
        if(minStack.isEmpty()){
            throw new IllegalStateException("stack is Empty");
        }
        return minStack.peek();
        
    }
    public static void main(String args[]){
        MinStack obj=new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }
    
}
