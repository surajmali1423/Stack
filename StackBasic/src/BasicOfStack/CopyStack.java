package BasicOfStack;
import java.util.Stack;

public class CopyStack {
    public static Stack<Integer> Copy(Stack<Integer>st){
             Stack<Integer>t1 = new Stack<>();
             while (!st.empty()){
                  t1.push(st.peek());
                  st.pop();
             }

             Stack<Integer>t2 = new Stack<>();

             while (!t1.empty()){
                  t2.push(t1.peek());
                  t1.pop();
             }

             return t2;
    }
    public static Stack<Integer>InsertAtBottom(Stack<Integer>st , int x){
           Stack<Integer>t1 = new Stack<>();

           while (!st.empty()){
               t1.push(st.pop());
           }
           st.push(x);
           while (!t1.empty()){
                st.push(t1.pop());
           }

           return st;
    }
    public static Stack<Integer>InsertAtKthIndex(Stack<Integer>st, int k , int x){
               Stack<Integer>t1 = new Stack<>();

               while (st.size() > k ){
                    t1.push(st.pop());
               }

               st.push(x);

               while (!t1.empty()){
                    st.push(t1.pop());
               }

               return st;
    }
    public static void InsertAtBottomRecursion(Stack<Integer> st, int x) {
        if (st.isEmpty()) {
            st.push(x);
            return;
        }

        int temp = st.pop();
        InsertAtBottomRecursion(st, x);
        st.push(temp);
    }
    public static void Display(Stack<Integer>st){
         if(st.isEmpty()) return ;

         int top = st.pop();
        System.out.print(top+"  ");
        Display(st);
        st.push(top);

    }
    public static void RemoveFromBottom(Stack<Integer>st){
              Stack<Integer> t1 = new Stack<>();

              while (st.size() > 1){
                    t1.push(st.pop());
              }
              st.pop();

              Stack<Integer>t2 = new Stack<>();
              while (!t1.empty()){
                  t2.push(t1.pop());
              }

              while (!t2.empty()){
                   st.push(t2.pop());
              }
    }
    public static void RemoveAtAnyIndex(Stack<Integer> st, int k){
             Stack<Integer>ts = new Stack<>();
             while(st.size() > k+1 ){
                   ts.push(st.pop());
             }
             int del = st.pop();
             while (!ts.empty()){
                   st.push(ts.pop());
             }

    }
    public static void ReverseSatck(Stack<Integer>st){
        Stack<Integer>t1 = new Stack<>();
        while (!st.empty()){
            t1.push(st.pop());
        }
        Stack<Integer>t2 = new Stack<>();
        while (!t1.empty()){
             t2.push(t1.pop());
        }

        while (!t2.empty()){
             st.push(t2.pop());
        }
    }
    public static void ReverseStackByRecursion(Stack<Integer>st){
              if(st.empty()) return ;

              int top = st.pop();
              ReverseStackByRecursion(st);
              InsertAtBottomByRecursion(st , top);
    }
    public static void InsertAtBottomByRecursion(Stack<Integer> st , int x){
            if(st.empty()){
                st.push(x);
                return;
            }
            int top = st.pop();
            InsertAtBottomByRecursion(st, x);
            st.push(top);
    }
    public static void main(String[] args) {
            Stack<Integer>st = new Stack<>();
            st.push(1);
            st.push(2);
            st.push(3);
            st.push(4);
            st.push(5);

//           System.out.print("Befor : ");
//           Display(st);
//           RemoveFromBottom(st);
//           System.out.print("\nAfter : ");
        Display(st);
        ReverseStackByRecursion(st);
        System.out.println();
        Display(st);
    }
}
