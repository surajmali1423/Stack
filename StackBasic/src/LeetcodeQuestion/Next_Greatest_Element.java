package LeetcodeQuestion;


import java.util.Stack;

public class Next_Greatest_Element {
    public static int[] NextGreatest(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];

        ans[n - 1] = -1;
        int nge = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            ans[i] = nge;
            nge = Math.max(arr[i], nge);
        }

        return ans;
    }

    public static int [] NGE(int [] arr){
         int n = arr.length;
         int [] ans = new int[n];
         Stack<Integer> st = new Stack<>();

         ans[n-1] = -1;
         st.push(arr[n-1]);

         for(int i = n-2 ; i >= 0 ; i--){

             while(!st.isEmpty() && arr[i] >= st.peek()) st.pop();

             if(st.isEmpty()) ans[i] = -1;
             else ans[i] = st.peek();

             st.push(arr[i]);

         }

         return ans;
    }
    public static  int [] NGE1(int [] arr){
          int n  = arr.length;
          int [] ans = new int[n];
          Stack<Integer>st = new Stack<>();

          for(int i = n - 2 ; i >= 0; i--){
                while (!st.isEmpty() && arr[i] >= arr[st.peek()])st.pop();
                if(st.isEmpty()) ans[i] = -1;
                else ans[i] = arr[st.peek()];

                st.push(i);
          }

          return ans;
    }
    public static void main(String[] args) {
         int [] arr = {6, 8, 0, 1, 3};

         int [] ans = NGE1(arr);

         for(int  x : ans){
             System.out.print(" "+x);
         }
    }
}
