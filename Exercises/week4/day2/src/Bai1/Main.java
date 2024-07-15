package Bai1;

import java.util.Arrays;
import java.util.LinkedList;

class Node {
    int val;
    Node next;
    Node() {}
    Node(int val) { this.val = val; }
    Node(int val, Node next) { this.val = val; this.next = next; }
}

class MyLinkedList {
    Node head;
    MyLinkedList() {
        this.head = null;
    }

    public void append(Node newNode) {
        Node current = this.head;

        if (current == null) {
            this.head = newNode;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void insert(Node newNode, int index) {
        Node current = this.head;
        if (index == 0) {
            newNode.next = current;
            this.head = newNode;
        } else {
            Node prev = null;
            Node next = null;
            for (int i = 0; i < index && current != null; i++) {
                prev = current;

                next = current.next;
                current = current.next;
            }
            if (next != null) {
                newNode.next = current;
                prev.next = newNode;
            }
        }
    }

    public int delete(int index) {
        Node current = this.head;
        Node previous = null;
        int deletedValue = -1;

        if (index == 0) {
            deletedValue = this.head.val;
            this.head = this.head.next;
            return deletedValue;
        } else {
            for (int i = 0; i < index && current != null; i++) {
                previous = current;
                current = current.next;
            }
            if (current != null) {
                deletedValue = current.val;
                previous.next = current.next;
            }
            return deletedValue;
        }
    }

    public void displayLinkedList() {
        Node current = this.head;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

    public int getMiddleValue() {
        if (this.head == null) {
            throw new IllegalStateException("The linked list is empty.");
        }

        Node slow = this.head;
        Node fast = this.head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.val;
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));

        // Method 1
        System.out.println(list.get(list.size()/2));

        // Method 2
        int[] arr = {1, 2, 3, 4, 5};
        MyLinkedList l1 = new MyLinkedList();

        for (int i = 0; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            l1.append(newNode);
        }

        System.out.println(l1.getMiddleValue());
    }
}
