package LeetcodeQuestion;

import java.util.Stack;

public class Largest_Reactangle_in_Histogram1 {
    public static int [] PSE(int [] arr){
        int n = arr.length;
        Stack<Integer> st =   new Stack<>();
        int []  ans = new int[n];

        for(int i = 0 ; i < n; i++){
             while (!st.isEmpty() && arr[i] < arr[st.peek()]) st.pop();
             ans[i] = st.isEmpty() ? -1 : st.peek();
             st.push(i);
        }

        return ans;
    }

    public static int [] NSE(int [] arr){
        int n = arr.length;
        Stack<Integer> st =   new Stack<>();
        int []  ans = new int[n];

        for(int i = n-1 ; i >= 0; i--){
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) st.pop();
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return ans;
    }

    public static int LargestRectangle(int [] arr) {

        int n = arr.length;
        int[] P = PSE(arr);
        int[] N = NSE(arr);
        int MaxArea = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            MaxArea = Math.max(MaxArea , (arr[i] * (N[i] - P[i] - 1)));
        }

        return MaxArea;
    }
        public static void main (String[]args){
            int[] arr = {2 ,  4};
            System.out.println("Max Area Is : "+LargestRectangle(arr));
        }

}
