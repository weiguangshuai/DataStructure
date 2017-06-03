package com.cqupt.weigs.StackAndQueue;

/**
 * @author weigs
 * @date 2017/5/23 0023
 */
public class StackApp {
    public static void main(String[] args) {
        String expstr = "1+3*(9-2)+90";
        System.out.println(StackApp.toPostfix(expstr));
    }


    /**
     * 中缀表达式转后缀
     * @param expstr
     * @return
     */
    public static String toPostfix(String expstr) {
        //创建栈，用于存储运算符
        Stack<String> stack = new Stack<>(expstr.length());
        String postfix = "";//存储后缀表达式字符串
        int i = 0;
        while (i < expstr.length()) {
            char ch = expstr.charAt(i);
            switch (ch) {
                case '+':
                case '-':
                    //当栈不为空或者栈顶元素不是后左括号时，直接出栈
                    //和其他的运算符相比+-是最低等级，所有碰到就要出栈
                    while (!stack.isEmpty() && !stack.getTopObject().equals("(")) {
                        postfix += stack.pop();
                    }
                    //入栈
                    stack.push(ch+"");
                    i++;
                    break;
                case '*':
                case '/':
                    while (!stack.isEmpty() && (stack.getTopObject().equals("*"))
                            || stack.getTopObject().equals("/")) {
                        postfix += stack.pop();

                    }
                    stack.push(ch+"");
                    i++;
                    break;

                case '(':
                    //左括号直接入栈
                    stack.push(ch+"");
                    i++;
                    break;

                case ')':
                    //遇到右括号
                    String out = stack.pop();
                    while (out != null && !out.equals("(")) {
                        postfix += out;
                        out = stack.pop();
                    }
                default:
                    //操作数直接入栈
                    while (ch >= '0' && ch <= '9') {
                        postfix += ch;
                        i++;
                        if (i < expstr.length()) {
                            ch = expstr.charAt(i);
                        } else {
                            ch='=';
                        }
                    }
                    //分隔符
                    postfix +="";
                    break;

            }
        }
        //最后把所有运算符出栈(规则5)
        while (!stack.isEmpty())
            postfix += stack.pop();
        return postfix;
    }
}
