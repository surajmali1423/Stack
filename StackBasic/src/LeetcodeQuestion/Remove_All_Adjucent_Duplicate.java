package LeetcodeQuestion;

import java.util.Stack;

public class Remove_All_Adjucent_Duplicate {
    public static String RemoveDuplicate1(String str){
        Stack<Character>st = new Stack<>();
        String temp = "";
        for (int i = 0; i < str.length(); i++) {
               if(st.isEmpty() || st.peek() != str.charAt(i)) {
                   st.push(str.charAt(i));
               }
               else{
                    if(str.charAt(i) == st.peek()) st.pop();
               }
        }

        Stack<Character>st2 = new Stack<>();
        while (!st.empty()){
             st2.push(st.pop());
        }
        while (!st2.empty()){
             temp += st2.pop();
        }

        return temp;
    }
    public static String RemoveDuplicate2(String str){
        Stack<Character>st = new Stack<>();
        StringBuilder temp = new StringBuilder();
        for(char ch : str.toCharArray()){
            if(!st.empty() && st.peek() == ch) st.pop();

            else st.push(ch);
        }
        Stack<Character>st1 = new Stack<>();
        while(!st.empty()){
            st1.push(st.pop());
        }

        while(!st1.empty()){
            temp.append(st1.pop());
        }

        return temp.toString();
    }
    public static void main(String[] args) {
          String str = "aaaaaa";

        System.out.println(RemoveDuplicate2(str));
    }
}
