package LeetcodeQuestion;

import java.util.Stack;

public class Sum_Of_Subarray {

    // Brout Force Approach
    public static int SubArray(int [] arr){
           int sum = 0;
           for(int i = 0 ; i < arr.length; i++){
               int min = arr[i];
                for(int j = i ; j < arr.length ; j++){
                    if(min > arr[j]) {
                         min = arr[j];
                         sum = (sum + min);
                    }
                    else {
                        sum = (sum + min);
                    }
                }
           }

           return sum;
    }

    public static int [] NSE (int [] arr){
        int n = arr.length;
        int [] ans = new  int[n];
        Stack<Integer>st = new Stack<>();

        for(int i = n - 1; i >= 0 ; i--){
             while(!st.isEmpty() && arr[i] <= arr[st.peek()]) st.pop();
             ans[i] = st.isEmpty() ? n : st.peek();
             st.push(i);
        }

        return ans;
    }
    public static int [] PSE (int [] arr){
        int n = arr.length;
        int [] ans = new  int[n];
        Stack<Integer>st = new Stack<>();

        for(int i = 0; i < n ; i++){
            while(!st.isEmpty() && arr[i] < arr[st.peek()]) st.pop();
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return ans;
    }
    public static int SubArray2(int [] arr){
        int [] N = NSE(arr);
        int [] P = PSE(arr);
        int MOD = 1000000007;
        int n = arr.length;
         int total = 0;

        for(int i = 0 ; i < n; i++){
             int left = i - P[i];
             int right = N[i] - i;

            long contribution = (left * 1L * right) % MOD;
            contribution = (contribution * arr[i]) % MOD;

            total = (int)(total + contribution) % MOD;
        }

        return total;
    }
    public static void main(String[] args) {
        int [] arr = {71,55,82,55};
        System.out.println(SubArray2(arr));
    }
}
