package fornow.linkedlist;
//  You are given two non-empty linked lists representing two non-negative integers.
//  The digits are stored in reverse order and each of their nodes contain a single digit.
//  Add the two numbers and return it as a linked list.
//
//        You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//        Example:
//
//        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//        Output: 7 -> 0 -> 8
//        Explanation: 342 + 465 = 807.

import java.util.Random;

public class AddTwoNumbers {
    public static void main(String[] args)  {
        Random rand = new Random();
        ListNode l1 = new ListNode(rand.nextInt(9) + 1);
        ListNode tail = l1;
        for(int i=1; i<5; i++)  {
            tail.next  = new ListNode(rand.nextInt(9) + 1);
            tail = tail.next;
        }

        ListNode l2 = new ListNode(rand.nextInt(9) + 1);
        ListNode t = l2;
        for(int i=1; i<5; i++)  {
            t.next  = new ListNode(rand.nextInt(9) + 1);
            t = t.next;
        }

        System.out.print("List 1 : "); print(l1);
        System.out.println();
        System.out.print("List 2 : "); print(l2);
        System.out.println();
        ListNode result = addTwoNumbers(l1, l2);
        print(result);
    }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode res = head;
        int cf = 0;
        while(l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int val = x + y + cf;
            cf = val / 10;

            res.next = new ListNode(val % 10);
            res = res.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if(cf != 0){
            res.next = new ListNode(cf);
        }

        return head.next;
    }

    static void print(ListNode l)   {
        while (l != null)  {
            System.out.print(l.val + ((l.next != null) ? "->" : ""));
            l = l.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
