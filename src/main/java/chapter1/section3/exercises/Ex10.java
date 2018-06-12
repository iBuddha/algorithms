package chapter1.section3.exercises;

import chapter1.section3.content.Stack;
import std.StringUtils;

//infix to postfix
public class Ex10 {
    public static void main(String[] args) {
        String[] input = StringUtils.eachNonBlankOperator("( ( 1 + 2 ) * ( 4 / 2 ) )");
        Stack<String> operands = new Stack<>();
        Stack<String> operators = new Stack<>();
        for (String s : input) {
            if (s.equals("(")) {

            } else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
                operators.push(s);
            else if(s.equals(")")){
                String operator = operators.pop();
                String second = operands.pop();
                String first = operands.pop();
                operands.push("( " + first + " " + second + " " + operator + " )");
            } else
                operands.push(s);
        }
        String postfixExpression = operands.pop();
        System.out.println(postfixExpression);
    }
}
