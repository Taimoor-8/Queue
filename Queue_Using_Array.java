package Queue;

import java.util.Scanner;

public class Queue_Using_Array {

    private int [] arr;
    private int front;
    private int rare;
    private int capacity;
    private int size;

    public Queue_Using_Array(int capacity){
        this.arr = new int[capacity];
        this.front = -1;
        this.rare = -1;
        this.capacity = capacity;
        this.size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == capacity;
    }

    public int size(){
        return size;
    }

    public void enqueue(int value){
        if (isFull()){
            System.out.println("Queue is full so cannot add elements");
            return;
            /*int [] newArr = new int[capacity*2];
            System.arraycopy(arr , 0 , newArr , 0, arr.length);
            arr = newArr;*/
        }
        else if(front == -1 && rare == -1){
            front = rare = 0;
        }
        else{
            rare ++;
        }
        arr[rare] = value;
        size++;
    }

    public int dequeue(){
        if (isEmpty()){
            System.out.println("Queue is empty so cannot remove element");
            return -1;
        }
        int value = arr[front];

        for (int i = 0; i < arr.length-1; i++){
            arr[i] = arr [i+1];
        }
        arr[rare] = 0;
        rare--;
        size--;
        return value;
    }

    public int peek(){
        if (isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[front];
    }

    public void display(){
        if (isEmpty()){
            System.out.println("Queue is empty");
        }
        for (int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void Operations(){
        System.out.println("The operations to be performed are:");
        System.out.println("Enter 1 to display Queue");
        System.out.println("Enter 2 to add element to Queue");
        System.out.println("Enter 3 to remove element from Queue");
        System.out.println("Enter 4 to peek from Queue");
        System.out.println("Enter 5 to exit from Queue");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the initial capacity of Queue");
        int capacity = sc.nextInt();

        Circular_Queue q = new Circular_Queue(capacity);

        q.Operations();

        int op = sc.nextInt();
        while (op != 5) {

            switch (op) {
                case 1:
                    q.display();
                    q.Operations();
                    op = sc.nextInt();
                    break;

                case 2:
                    System.out.println("Enter the number you want to add to Queue");
                    int num = sc.nextInt();

                    q.enqueue(num);

                    q.Operations();
                    op = sc.nextInt();

                    break;

                case 3:
                    System.out.println("Removed element is  " + q.dequeue());
                    q.Operations();
                    op = sc.nextInt();
                    break;

                case 4:
                    System.out.println(q.peek());

                    System.out.println();

                    q.Operations();
                    op = sc.nextInt();

                    break;

                case 5:
                    break;

                default:
                    System.out.println("Enter valid number to perform operation");
                    q.Operations();
                    op = sc.nextInt();
                    break;
            }
        }
    }
}
