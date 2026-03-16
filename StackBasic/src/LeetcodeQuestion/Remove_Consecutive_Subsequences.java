package LeetcodeQuestion;

import java.util.Stack;

public class Remove_Consecutive_Subsequences {
    public static int [] Remove_Consective(int [] arr){
        Stack<Integer>st = new Stack<>();

        for(int i = 0 ; i < arr.length; i++){
             if(st.isEmpty() || st.peek() != arr[i]) st.push(arr[i]);

             else if(st.peek() == arr[i]){
                   if(arr[i] != arr[i+1]) st.pop();
             }
        }

        int []  temp = new int [st.size()];
        for(int i = st.size() - 1 ; i >= 0;i--){
            temp[i] = st.pop();
        }
        return temp;
    }
    public static void main(String[] args) {
         int [] arr = {1 , 2, 2 , 3 ,3 , 3, 4 , 4 , 5};

         int [] arr1 = Remove_Consective(arr);

         for (int x  :  arr1){
             System.out.print(x +"  ");
         }
    }
}
