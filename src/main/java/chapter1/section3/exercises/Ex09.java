package chapter1.section3.exercises;

import chapter1.section3.content.Stack;
import std.StringUtils;

public class Ex09 {
    public static void main(String[] args) {
        String input = "1 + 2 ) * 3 - 4 ) * 5- 6 ) ) )".replaceAll("\\s", "");
        String[] a = StringUtils.eachCharactor(input);
        Stack<String> stack = new Stack<>();
        for(String s : a){
            if(!s.equals(")")){
                stack.push(s);
            } else {
                String second = stack.pop();
                String operator = stack.pop();
                String first = stack.pop();
                stack.push("(" + first + operator + second + ")");
            }
        }
        System.out.println(stack.pop());
    }
}
