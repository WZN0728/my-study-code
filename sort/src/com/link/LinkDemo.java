package com.link;

/**
 * @author wuting
 * @date 2019/06/02
 */
public class LinkDemo {

    private static Node head;

    public static void main(String[] args) {
        head = new Node(3);
        head.next = new Node(5);

        Node temp = head.next;

        temp.next = new Node(4);
        temp = temp.next;
        temp.next = new Node(2);
        temp = temp.next;
        temp.next = new Node(9);
        temp = head;
        while (temp != null) {
            System.out.print(temp.data + "   ");
            temp = temp.next;
        }
        System.out.println();
        //链表反转
        reverseLink();
        temp = head;
        //逆序输出
        while (temp != null) {
            System.out.print(temp.data + "   ");
            temp = temp.next;
        }
    }

    private static void reverseLink() {
        if (head == null || head.next == null) {
            return;
        }
        Node p1 = head;
        Node p2 = head.next;
        Node p3 = null;
        while (p2 != null) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        head.next = null;
        head = p1;
    }

    private static class Node {

        int data;

        Node next;

        public Node(int data) {
            this.data = data;
        }

    }

}
