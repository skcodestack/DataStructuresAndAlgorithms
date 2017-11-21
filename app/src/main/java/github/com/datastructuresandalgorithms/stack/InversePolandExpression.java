package github.com.datastructuresandalgorithms.stack;

import android.util.Log;

import java.io.StringBufferInputStream;
import java.util.Stack;

/**
 * Email  1562363326@qq.com
 * Github https://github.com/skcodestack
 * Created by sk on 2017/10/27
 * Version  1.0
 * Description: 逆波兰表达式法
 */

public class InversePolandExpression {

    public String TAG = "InversePolandExpression";

    //中缀表达式
    private String mInfixExpression = null;

    public  InversePolandExpression(String infixExpression ){

        if(infixExpression == null || "".equals(infixExpression)){
            throw  new IllegalArgumentException("中缀表达式错误");
        }
        this.mInfixExpression = infixExpression;

    }

    /**
     * 生成后缀表达式
     *  (:40  ):41   +:43  -:45  *:42  /:47
     * @return
     */
    public String generatePostfixExpression(){

        StringBuffer sb = new StringBuffer();
        Stack<String> stack = new Stack<>();

        int length = mInfixExpression.length();
        char[] chars = mInfixExpression.toCharArray();
        int index = 0;
        while (index < length){
            char ch = chars[index];
            if("".equals(ch)){
                continue;
            }
            switch (ch){
                //(
                case 40:
                    sb.append(" ");
                    stack.push("(");
                    break;
                //)
                case 41:
                    sb.append(" ");
                    while (!stack.empty()){

                        String pop = stack.pop();
                        if(pop.equals("(")){
                            break;
                        }
                        sb.append(pop).append(" ");

                    }
                    break;
                //+
                case 43:
                    sb.append(" ");
//                    ch = chars[index];
//                    String peek = stack.peek();
                    stack.push("+");
                    break;
                //-
                case 45:
                    sb.append(" ");
                    stack.push("-");
                    break;
                //*
                case 42:
                    sb.append(" ");
                    //将*后的数字拿到
                    String num = fixStack(mInfixExpression, index);
                    int len = num.length();
                    index += len;
                    sb.append(num).append(" ");
                    Log.e(TAG,"*====>"+num);

                    Log.e(TAG,"*====>"+ch);
                    if(!stack.isEmpty()){
                        String peek = stack.peek();
                        if("-".equals(peek) || "+".equals(peek)){
                            sb.append("*").append(" ");
                        }else {
                            stack.push("*");
                        }
                    }

                    while (!stack.isEmpty()){

                        String peek = stack.peek();

                        if("-".equals(peek) || "+".equals(peek)){
                            peek = stack.pop();
                            sb.append(peek).append(" ");
                        }else {
                            break;
                        }

                    }

                    break;
                ///
                case 47:
                    sb.append(" ");
                    String num_ = fixStack(mInfixExpression, index);
                    int len_ = num_.length();
                    index += len_;
                    sb.append(num_).append(" ");

                    Log.e(TAG,"/====>"+ch);
                    if(!stack.isEmpty()){
                        String peek = stack.peek();
                        if("-".equals(peek) || "+".equals(peek)){
                            sb.append("/").append(" ");
                        }else {
                            stack.push("/");
                        }
                    }

                    while (!stack.isEmpty()){

                        String peek = stack.peek();

                        if("-".equals(peek) || "+".equals(peek)){
                            peek = stack.pop();
                            sb.append(peek).append(" ");
                        }else {
                            break;
                        }

                    }

                    break;
                default:
                    Log.e(TAG,"default====>"+ch);
                    sb.append(ch);

            }

            index++;
        }
        String s = sb.toString();
        while (s.contains("  ")){
            s = s.replace("  ", " ");
        }
//        String replace = s.replace("    ", " ").replace("   ", " ").replace("  ", " ");
//        return  replace;
        return s;
    }

    /**
     *
     * 计算表达式
     * @return
     */
    public String calculateExpression(){


        Stack<String> stack = new Stack<>();
        String expression = generatePostfixExpression();
        Log.e(TAG, "expression-----------------------------------------------"+expression);

        String[] split = expression.split(" ");

        int length = split.length;
        int index = 0;
        while (index < length){
            String ch = split[index];
            if(" ".equals(ch)){
                continue;
            }
            Log.e(TAG, "                                                 ");
            Log.e(TAG, "                                                 ");
            Log.e(TAG, "-----------------------------------------------");
            if (!stack.isEmpty()) {
                Log.e(TAG, "stack=====>" + stack.peek());
            }
            Log.e(TAG, "-----------------------------------------------");
            Log.e(TAG, "                                                 ");
            Log.e(TAG, "                                                 ");
            if("*".equals(ch) || "/".equals(ch) || "+".equals(ch) || "-".equals(ch)){

                calculate(stack,ch.charAt(0));

            }else {
                stack.push(ch);
            }


            index++;
        }

        if(!stack.isEmpty()){
            return stack.pop();
        }
        return "";
    }




    public void  calculate( Stack<String> stack,char ch){


        try {
            int param_1 = 0;
            int param_2 = 0;
            if (stack.isEmpty()) {
                throw new IllegalArgumentException("not en");
            }
            param_2 = Integer.parseInt(stack.pop());
            if (stack.isEmpty()) {
                throw new IllegalArgumentException("not en");
            }
            param_1 = Integer.parseInt(stack.pop());

            int re = 0;
            switch (ch) {
                case 43:
                     re = param_1 + param_2;
                    stack.push(re+"");
                    break;
                case 45:
                     re = param_1 - param_2;
                    stack.push(re+"");
                    break;
                case 42:
                     re = param_1 * param_2;
                    stack.push(re+"");
                    break;
                case 47:
                     re = param_1 / param_2;
                    stack.push(re+"");
                    break;
                default:


            }



        }catch (Exception ex){

        }
    }


    /**
     *  在*或者/的情况下，取出符号后面的值
     * @param fixExpression
     * @param index
     * @return
     */
    public  String fixStack(String fixExpression,int index){

        index++;
        StringBuffer sb = new StringBuffer();
        int length = fixExpression.length();
        char[] chars = fixExpression.toCharArray();
        boolean isStop = false;
        while (index < length) {
            char ch = chars[index];
            if ("".equals(ch)) {
                continue;
            }
            switch (ch) {
                //(
                case 40:
                case 41:
                case 43:
                case 45:
                case 42:
                case 47:
                    isStop = true;
                    break;
                default:
                    sb.append(ch);

            }
            if(isStop){
                index--;
                break;
            }
            index++;

        }

        return sb.toString();

    }
}
