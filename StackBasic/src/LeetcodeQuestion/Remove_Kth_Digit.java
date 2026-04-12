package LeetcodeQuestion;

import java.util.Stack;

public class Remove_Kth_Digit{
    public static String RemoveKthDigit(String str, int k) {
        String ans = "";
        int n = str.length();
        Stack<Integer> st = new Stack<>();

        if (n == k || k >= n) return "0";

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && k > 0 && (str.charAt(i) - '0') < st.peek()) {
                st.pop();
                k--;
            }
            st.push(str.charAt(i) - '0');
        }

        while (k > 0) {
            st.pop();
            k--;
        }

        if (st.empty()) return "0";

        Stack<Integer> t1 = new Stack<>();
        while (!st.empty()) {
            t1.push(st.pop());
        }

        while (!t1.isEmpty()) {
            ans += t1.pop();
        }

        int i = 0;
        while (i < ans.length() && ans.charAt(i) == '0') {
            i++;
        }

        ans = ans.substring(i);

        return ans.length() == 0 ? "0" : ans;
    }
    public static void main(String[] args) {
        System.out.println("Answer Is : "+ RemoveKthDigit("00100" , 2));
    }
}
