import java.util.Stack;

public class PostfixPrefix {
    public static void main(String[] args){
        String str = "AB+CD-*";
        String final_result = convertPostfixToPrefix(str);
        System.out.println(final_result);
    }
    static String convertPostfixToPrefix(String exp){
        Stack<String> stack = new Stack<>();
        int length = exp.length();
        for(int i = 0; i < length; ++i){
            char c = exp.charAt(i);
            if(isOperator(c)){
                String s1 = stack.pop();
                String s2 = stack.pop();
                String temp = c+s2+s1;
                stack.push(temp);
            }else {
                stack.push(c+"");
            }
        }
        return stack.pop();
    }
    static boolean isOperator(char c){
        return switch (c){
            case '+', '-', '*', '/', '^', '%' -> true;
            default -> false;
        };
    }
}
