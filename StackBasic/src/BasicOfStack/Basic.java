package BasicOfStack;
import java.util.Stack;

public class Basic {
    public static void Print(Stack<Integer> st){
        Stack<Integer>temp = new Stack<>();

        while (st.size() > 0){
             temp.push(st.peek());
             st.pop();
        }

        while (temp.size() > 0){
            System.out.print(temp.peek()+"  ");
            temp.pop();
        }
    }
    public static void main(String[] args) {
        // Initialize the Stack
        Stack<Integer> st = new Stack<>();

        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);

        Print(st);
    }
}
