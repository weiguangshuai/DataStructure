package com.cqupt.weigs.StackAndQueue;

/**
 * @author weigs
 * @date 2017/7/31 0031
 */
public class CalculateExpression {

    /**
     * 中缀转后缀
     *
     * @param expstr
     * @return
     */
    public static String toPostfix(String expstr) {
        //创建栈，用于存储运算符
        LinkedStack<String> stack = new LinkedStack<>();

        String postfix = "";//存储后缀表达式的字符串
        int i = 0;
        while (i < expstr.length()) {
            char ch = expstr.charAt(i);
            switch (ch) {
                case '+':
                case '-':
                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        postfix += stack.pop();
                    }
                    //入栈
                    stack.push(ch + "");
                    i++;
                    break;
                case '*':
                case '/':
                    while (!stack.isEmpty() &&
                            (stack.peek().equals("*") || stack.peek().equals("/"))) {
                        postfix += stack.pop();
                    }
                    stack.push(ch + "");
                    i++;
                    break;
                case '(':
                    //左括号直接入栈
                    stack.push(ch + "");
                    i++;
                    break;
                case ')':
                    //右括号
                    String out = stack.pop();
                    while (out != null && !out.equals("(")) {
                        postfix += out;
                        out = stack.pop();
                    }
                    i++;
                    break;
                default:
                    while (ch >= '0' && ch <= '9') {
                        postfix += ch;
                        i++;
                        if (i < expstr.length()) {
                            ch = expstr.charAt(i);
                        } else {
                            ch = '=';
                        }
                    }
                    break;
            }
        }
        //最后把所有的运算符出栈
        while (!stack.isEmpty()) {
            postfix += stack.pop();
        }
        return postfix;
    }

    /**
     * 计算后缀表达式的值
     *
     * @param postfix
     * @return
     */
    public static int calculatePostfixValue(String postfix) {
        //栈用于存储操作数,协助运算
        LinkedStack<Integer> stack = new LinkedStack<>();
        int i=0, result=0;
        while (i<postfix.length())
        {
            char ch=postfix.charAt(i);
            if (ch>='0' && ch<='9')
            {
                result=0;
                while (ch!=' ')
                {
                    //将整数字符转为整数值ch=90
                    result = result*10 + Integer.parseInt(ch+"");
                    i++;
                    ch = postfix.charAt(i);
                }
                i++;
                stack.push(result);//操作数入栈
            }
            else
            {  //ch 是运算符,出栈栈顶的前两个元素
                int y= stack.pop();
                int x= stack.pop();
                switch (ch)
                {   //根据情况进行计算
                    case '+': result=x+y; break;
                    case '-': result=x-y; break;
                    case '*': result=x*y; break;
                    case '/': result=x/y; break;   //注意这里并没去判断除数是否为0的情况
                }
                //将运算结果入栈
                stack.push(result);
                i++;
            }
        }
        //将最后的结果出栈并返回
        return stack.pop();
    }

    public static void main(String[] args) {
        String expstr = "1+2*(9-2)+90";
        String postfix = toPostfix(expstr);
        System.out.println(postfix);
    }
}
