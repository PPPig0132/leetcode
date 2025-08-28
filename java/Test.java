import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import ListNode.Node;

class Parent {
    public int publicVar = 1;
    protected int protectedVar = 2;
    private int privateVar = 3;

    public void publicMethod() {
        System.out.println("This is a public method.");
    }

    protected void protectedMethod() {
        System.out.println("This is a protected method.");
    }

    private void privateMethod() {
        System.out.println("This is a private method.");
    }
    public void getPrivateVar(){
        System.out.println( privateVar);
    }
}

class Child extends Parent {
    void accessParentMembers() {
        System.out.println(publicVar);       // 可以访问
        System.out.println(protectedVar);    // 可以访问
        // System.out.println(privateVar);     // 编译错误，无法访问私有成员
        publicMethod();                       // 可以访问
        protectedMethod();
        getPrivateVar();                    // 可以访问
        // privateMethod();                    // 编译错误，无法访问私有方法
    }
}
public class Test {
        public static void main(String[] args) {
            Test obj = new Test();
           Child child = new Child();
            child.accessParentMembers();
        }
    
}