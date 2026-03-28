package LeetcodeQuestion;

import java.util.Stack;

public class NGEll {
    public static int [] NGE2_Method_1 (int [] arr){
         int n = arr.length;
         int [] ans = new int[n];

         for(int i = 0 ; i < n ; i++){
               for (int j = i+1 ; j < i + (n-1  ) ; j++){
                     int idx = j % n;
                     if(arr[idx] > arr[i]) {
                         ans[i] = arr[idx];
                         break;
                     }
               }

               if(ans[i] == 0) ans[i] = -1;
         }

         return ans;
    }


    public static int [] NGE2(int [] arr){
         int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int [] ans = new int[n];

        for(int i = (2 * n - 1) ; i >= 0 ; i--){
             while (!st.isEmpty() && arr[i%n] >= arr[st.peek()]) st.pop();

             if(i < n ){
                    ans[i] = st.isEmpty() ? -1 : arr[st.peek()];
             }

             st.push(i%n);
        }

        return ans;
    }
    public static void main(String[] args) {
           int [] arr = { 2 , 10,  12 , 1 ,11};
           int [] ans = NGE2(arr);

           for (int x : ans){
               System.out.print(x+"  ");
           }
    }
}
