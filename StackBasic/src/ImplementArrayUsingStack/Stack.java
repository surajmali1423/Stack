package ImplementArrayUsingStack;

class Stack {

    private  int arr[] = new int[5];
    int i = -1;

    void push(int ele){
        if(i == arr.length - 1){
            System.out.println("Stack Overflow");
            return;
        }
        arr[++i] = ele;
    }

    int pop(){
        if(i == -1){
            System.out.println("Stack Underflow");
            return -1;
        }
        int ele = arr[i];
        i--;
        return ele;
    }

    int peek(){
        if(i == -1) return -1;
        return arr[i];
    }

    void Print(){
        if(i == -1){
            System.out.println("Stack Underflow");
            return ;
        }
        for (int j = arr.length - 1; j >= 0  ; j--) {
            System.out.print(arr[j]+" ");
        }

        System.out.println();
    }

}