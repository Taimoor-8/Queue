package Queue;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Queue_Using_LinkedList {

    private NodeList front;
    private NodeList rare;
    private int length;

    private static class NodeList{
        public NodeList next;
        int data;

        NodeList(int data){
            this.data = data;
            next = null;
        }
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public int Length(){
        return length;
    }

    public void display(NodeList front){
        NodeList current = front;
        while (current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void enqueue(int data){
        NodeList temp = new NodeList(data);
        if (isEmpty()){
            front = temp;
        }
        else{
            rare.next = temp;
        }
        rare = temp;
        length ++;
    }

    public int dequeue(){
        if (isEmpty()){
            throw new NoSuchElementException("No element is in queue");
        }
        NodeList temp = front;
        int removedElement = temp.data;
        front = front.next;
        temp.next = null;
        return removedElement;
    }

    public int peek(){
        if (isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        return front.data;
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

        Queue_Using_LinkedList q = new Queue_Using_LinkedList();
        Scanner sc = new Scanner(System.in);

        q.Operations();

        int op = sc.nextInt();
        while (op != 5) {

            switch (op) {
                case 1:
                    q.display(q.front);
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
                    q.dequeue();
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
