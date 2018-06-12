package chapter1.section3.exercises;

import chapter1.section3.content.ResizingArrayStack;
import std.StringUtils;

public class Ex04 {
    public static void main(String[] args) {
        String a = "[()]{}{[()()]()}";
        String b = "[(])";
        System.out.println(isBalanced(a) ? "a is balanced" : "a is not balanced");
        System.out.println(isBalanced(b) ? "b is balanced" : "b is not balanced");
    }

    private static boolean isBalanced(String s){
        ResizingArrayStack<String> stack = new ResizingArrayStack<>();
        String[] chars = StringUtils.eachCharactor(s);
        String last = null;
        for(int i = 0; i < chars.length; i++){
            if(chars[i].equals("]")
                    || chars[i].equals("}")
                    || chars[i].equals(")")){
                String after = chars[i];
                if(!isPair(safePop(stack), after))
                    return false;
            } else {
                stack.push(chars[i]);
            }
        }
        return true;
    }

    private static String safePop(ResizingArrayStack<String> stack) {
        if(stack.isEmpty())
            return null;
        else
            return stack.pop();
    }

    private static boolean isPair(String before, String after) {
        if(before.equals("[") && after.equals("]"))
            return true;
        else if(before.equals("(") && after.equals(")"))
            return true;
        else if(before.equals("{") && after.equals("}"))
            return true;
        else
            return false;
    }

}
