package ImplementArrayUsingStack;

public class Main {
    public static void main(String[] args) {
           Stack st = new Stack();

           st.push(1);
           st.push(2);
           st.push(3);
           st.push(4);
           st.push(5);
           st.Print();
        System.out.println(st.peek());
        System.out.println(st.pop());
        st.Print();
        System.out.println(st.pop());


    }
}
