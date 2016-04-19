package strings;

import java.util.Stack;

/**
 * Created by Monil on 4/18/16.
 *
 * http://www.programcreek.com/2014/06/leetcode-longest-valid-parentheses-java/
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        String str = "))()()";

        System.out.println(longestValidParentheses(str));
    }

    public static int longestValidParentheses(String s) {
        Stack<int[]> stack = new Stack<int[]>();
        int result = 0;

        for(int i=0; i<=s.length()-1; i++){
            char c = s.charAt(i);
            if(c=='('){
                int[] a = {i,0};
                stack.push(a);
            }else{
                if(stack.empty()||stack.peek()[1]==1){
                    int[] a = {i,1};
                    stack.push(a);
                }else{
                    stack.pop();
                    int currentLen=0;
                    if(stack.empty()){
                        currentLen = i+1;
                    }else{
                        currentLen = i-stack.peek()[0];
                    }
                    result = Math.max(result, currentLen);
                }
            }
        }

        return result;
    }
}
