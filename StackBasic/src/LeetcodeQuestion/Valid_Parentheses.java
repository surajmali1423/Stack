package LeetcodeQuestion;

import java.util.Stack;

public class Valid_Parentheses {
    public static boolean isBalance(String str){
        Stack<Character>st = new Stack<>();

        for(char ch : str.toCharArray()){
             if(ch == '(' || ch == '{' || ch == '[') st.push(ch);

             else if(ch == ')' || ch == '}' || ch == ']') {
                  if(st.isEmpty()) return false;
                  char top = st.peek();

                  if((top == '(' && ch == ')') || (top == '[' && ch == ']') || (top == '{' && ch == '}')) st.pop();
            }

             else return false;
        }

          return st.isEmpty();
    }

    public static boolean isValid(String str){
          Stack<Character>st = new Stack<>();

          for(char ch  : str.toCharArray()){
                if(ch == '(') st.push(')');
                else if(ch == '{') st.push('}');
                else if(ch == '[') st.push(']');
                else if(st.peek() == ch) st.pop();
                else return false;
          }

          return st.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println(isValid("((())){()()}"));
    }
}
