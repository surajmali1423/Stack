package LeetcodeQuestion;

import java.util.Stack;

public class RemovestarFromString {
    public static String isRemove(String str){
        Stack<Character>st = new Stack<>();

        for(int i = 0 ; i < str.length(); i++){
             char ch = str.charAt(i);
             if(ch == '*'){
                  if(!st.isEmpty()) st.pop();
             }
             else st.push(ch);
        }
        String  ans = "";
        while (!st.isEmpty()){
             ans = st.pop() + ans;
        }

        return ans;
    }
    public static void main(String[] args) {
           String str = "leet**cod*e";

           String ans = isRemove(str);

        System.out.println(ans);
    }
}
