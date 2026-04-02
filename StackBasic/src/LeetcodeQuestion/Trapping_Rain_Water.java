package LeetcodeQuestion;

import java.util.Map;
import java.util.Stack;

public class Trapping_Rain_Water {
    public static  int [] NGE(int [] arr){
            int n = arr.length;
            int [] ans = new int[n];
            Stack<Integer> st = new Stack<>();

            for(int i = n - 1; i >= 0 ; i--){
                  while (!st.isEmpty() && arr[i] >= arr[st.peek()]) st.pop();
                  ans[i] = st.isEmpty() ? -1 : arr[st.peek()];
                  st.push(i);

            }

            return ans;
    }
    public static  int [] PGE(int [] arr){
        int n = arr.length;
        int [] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            while (!st.isEmpty() && arr[i] >= arr[st.peek()]) st.pop();
            if(st.isEmpty()) ans[i] = arr[i];
//            if(arr[i] >= arr[st.peek()])st.push(i);

        }

        return ans;
    }
    public static int Trap(int [] arr){
            int [] LB = PGE(arr);
            int [] RB = NGE(arr);

            int ans = 0;

            for(int i = 0 ; i < arr.length; i++){
                   ans += Math.min(LB[i] , RB[i]) - arr[i];
            }

            return ans;
    }
    public static int Trap2 (int [] arr){
         int lmax  = 0 ;
         int rmax = 0;
         int total = 0;
         int l = 0;
         int r = arr.length - 1;

         while(l < r){
              if(arr[l] <= arr[r]) {
                    if(lmax > arr[l])  total += lmax - arr[l];
                    else lmax = arr[l];
                    l += 1;
              }
              else{
                  if(rmax > arr[r]) total += rmax - arr[r];
                  else rmax = arr[r];

                  r -= 1;
              }
         }

         return total;
    }
    public static void main(String[] args) {
           int [] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
          System.out.println(Trap2(arr));


    }
}
