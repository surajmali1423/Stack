package LeetcodeQuestion;

import java.util.Map;
import java.util.Stack;

public class Trapping_Rain_Water {
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
           int [] arr = {2,4};
          System.out.println(Trap2(arr));


    }
}
