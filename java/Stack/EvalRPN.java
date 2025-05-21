package Stack;
/*
后缀表达式转中缀表达式
即数字进栈，遇到运算符时将栈顶的两个元素弹出，进行运算，然后再将结果压入栈
*/
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        int n=tokens.length;
        int []stack=new int[n];
        int top=-1;
        int a;
        for(String token:tokens){
            switch(token){
                case "+":
                    a=stack[top--];
                    stack[top]=stack[top]+a;
                    break;
                case "-":
                    a=stack[top--];
                    stack[top]=stack[top]-a;
                    break;
                case "*":
                    a=stack[top--];
                    stack[top]=stack[top]*a;
                    break;
                case "/":  
                    a=stack[top--];
                        stack[top]=stack[top]/a;
                        break;
                default:
                    stack[++top]=Integer.parseInt(token);
            }
        }
        return stack[top];
    }

    public static void main(String[] args) {
        EvalRPN e=new EvalRPN();
        String []tokens={"2","1","+","3","*"};
        System.out.println(e.evalRPN(tokens));
        tokens=new String[]{"4","13","5","/","+"};
        System.out.println(e.evalRPN(tokens));
        tokens=new String[]{"10","6","9","3","/", "-11", "*", "/", "*"};
        System.out.println(e.evalRPN(tokens));
    }
}
