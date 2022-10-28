package org.example;

import java.util.Stack;

public class ListNode {

    int val = 0;
    public ListNode next;

    public ListNode(int v) {
        this.val = v;
    }


    public static void test() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        printListNode(head);

        System.out.println(" reverseListByWhile --------------------- ");

        printListNode(reverseListByWhile(head));

    }

    private static void printListNode(ListNode head) {
        while (head != null) {
            System.out.println(" printListNode " + head.val);
            head = head.next;
        }
    }


    /**
     * 1、利用栈进行反转
     * 关键点：先入栈，再出栈
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode currNode = null;
        ListNode newNode = null;
        Stack<ListNode> left = new Stack<>();
        while (head != null){
            left.push(new ListNode(head.val));
            head = head.next;
        }
        while (left.size() != 0){
            ListNode node = left.pop();
            if (currNode == null){
                currNode = node;
                newNode = node;
                continue;
            }
            currNode.next = node;
            currNode = currNode.next;
        }

        return newNode;
    }

    public static ListNode reverseListByWhile(ListNode head) {

        // 单链表没有指向前一个节点的指针域，因此我们需要增加一个指向前一个节点的指针pre，
        // 用于存储每一个节点的前一个节点。此外，还需要定义一个保存当前节点的指针cur，以及下一个节点的						// next。
        // 定义好这三个指针后，遍历单链表，将当前节点的指针域指向前一个节点，之后将定义三个指针往后移动，
        // 直至遍历到最后一个节点停止

        //注意顺序的交接
        ListNode preNode = null;
        ListNode currNode = head;
        ListNode nextNode = null;
        while(currNode != null){
            nextNode = currNode.next;   //nextNode指向下一个节点
            currNode.next = preNode;    //将当前节点next域指向前一个节点
            preNode = currNode;		//preNode指针向后移动
            currNode = nextNode;	//curNode指针向后移动
        }
        return preNode;
    }
}
