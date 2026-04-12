package LeetcodeQuestion;

import java.util.Stack;

public class Maximul_Rectangle {
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
        int MaxArea = 0;

        for (int i = 0; i < n; i++) {
            MaxArea = Math.max(MaxArea , (arr[i] * (N[i] - P[i] - 1)));
        }

        return MaxArea;
    }
    public static int MaxRectangle(char [][] arr) {

        int rows = arr.length;
        int cols = arr[0].length;

        int[][] res = new int[rows][cols];
        for (int i = 0; i < cols; i++) {   // column-wise
            int sum = 0;
            for (int j = 0; j < rows; j++) {

                if (arr[j][i] == '1') {
                    sum += 1;
                } else {
                    sum = 0 ;
                }

                res[j][i] = sum;
            }

        }
        int Maxarea = 0;
        for(int i = 0 ; i < arr.length ; i++){
            Maxarea = Math.max(Maxarea , LargestRectangle(res[i]));
        }

        return Maxarea;

    }

    public static void main(String[] args) {

        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };

        System.out.println(MaxRectangle(matrix));

    }
}