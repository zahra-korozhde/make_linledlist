import java.util.Arrays;
import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

    class LinkedList {
        Node head;
//        to show merged list adad ajib gharib neshon nade
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node current = head;
            while (current != null) {
                sb.append(current.data).append(" ");
                current = current.next;
            }
            return sb.toString();
        }



    public LinkedList() {
        this.head = null;
    }

    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void removeOddNumbers() {
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (current.data % 2 != 0) {
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
            } else {
                prev = current;
            }
            current = current.next;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }




    public static LinkedList mergeLists(LinkedList list1, LinkedList list2) {
        LinkedList mergedList = new LinkedList();
        Node current1 = list1.head;
        Node current2 = list2.head;

        while (current1 != null && current2 != null) {
            if (current1.data < current2.data) {
                mergedList.add(current1.data);
                current1 = current1.next;
            } else {
                mergedList.add(current2.data);
                current2 = current2.next;
            }
        }

        while (current1 != null) {
            mergedList.add(current1.data);
            current1 = current1.next;
        }

        while (current2 != null) {
            mergedList.add(current2.data);
            current2 = current2.next;
        }

        return mergedList;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input_user =  new Scanner(System.in);

        LinkedList list1 = new LinkedList();
        list1.add(1);
        list1.add(2);
        list1.add(8);
        list1.add(9);

        LinkedList list2 = new LinkedList();
        list2.add(3);
        list2.add(5);
        list2.add(7);

        LinkedList mergedList = LinkedList.mergeLists(list1, list2);



        System.out.println("choice a number : " + "1_show orginal list"  );
        System.out.println("                  "+ "2_show removed list" );
        System.out.println("                  " + "3_show merged list");
        int SwichCase = input_user.nextInt();
        switch (SwichCase){
            case 1:
                System.out.println(" Linked List: " );
                list1.display();
                break;
            case 2:
                System.out.println("removed Linked List: " );
                list1.removeOddNumbers();
                list1.display();
                break;
            case 3:
               
                System.out.println("merged list : " + mergedList) ;




        }

    }
}
