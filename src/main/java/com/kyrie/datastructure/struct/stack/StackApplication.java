package com.kyrie.datastructure.struct.stack;

/**
 * Created by Kyrie on 2019/2/16.
 * 栈的应用案例
 */
public class StackApplication {


    /**
     * 匹配括号
     * @param exp
     * @return
     */
    public static int match(String[] exp){

        Stack stack = new Stack();

        for(int i =0 ; i <exp.length;++i){
            if(exp[i] == "("){
                stack.data[++ stack.top] = "(";
            }
            if(exp[i] ==")"){
                if(stack.top ==-1){
                    return 0;
                }else{
                    --stack.top;
                }
            }
        }
        if(stack.top ==-1){
            return 1; //栈空，括号匹配
        }else{
            return 0; //括号不匹配
        }

    }

    /**
     * 后缀式计算函数：从左往右，遇到数值入栈，遇到操作符连续两次出栈，运算结果再入栈。如此往复，直到结束。栈底元素值为表达式的值。
     * @param exp
     * @return
     */
    public static String com(String[] exp){

        int i, a,b,c ;
        Stack stack = new Stack();

        String Op;
        for(i = 0 ; exp[i] !="\0";++i){

            if(Character.isDigit(exp[i].charAt(0))){//判断是不是数字
                //入栈
                stack.data[++stack.top] = exp[i];
            }else{
                Op = exp[i];
                b= Integer.parseInt(stack.data[stack.top--]);
                a= Integer.parseInt(stack.data[stack.top--]);

                c = op(a, Op, b);
                stack.push(c +"");
            }

        }

        return stack.pop();

    }

    public static int op(int a, String Op,int b){
        if(Op.equals("+"))
            return a + b;
        else if(Op.equals("-"))
            return a - b;
        else if(Op.equals("*"))
            return a * b;
        else  {
            if(b == 0 ){
                throw new RuntimeException("除数为0了");
            }else{
                return a/b;
            }
        }

    }


    public static void main(String args[]){

        String[] exp = {"z","(",")"};
        System.err.println( "match:"+match(exp));

        String[] exp2 = {"3","4","-","5","+","\0"};
        System.err.println("com:"+com(exp2));


    }


}
