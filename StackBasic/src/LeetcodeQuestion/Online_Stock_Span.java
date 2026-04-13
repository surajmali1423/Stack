package LeetcodeQuestion;

import java.util.Stack;

public class Online_Stock_Span {
    public static  int [] StockSpan(int [] arr){
         int n = arr.length;
        Stack<Integer>st = new Stack<>();
        int [] ans = new  int[n];

        for(int i = 0; i < n; i++){
            while (!st.isEmpty() && arr[i] >= arr[st.peek()]) st.pop();

            ans[i] = st.isEmpty() ? i - (-1) :  i - st.peek();

            st.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
          int [] arr = {7 , 2 , 1, 3 , 3 , 1, 8};

         int [] ans = StockSpan(arr);

         for (int x : ans){
             System.out.print(x +"  ");
         }
    }
}
