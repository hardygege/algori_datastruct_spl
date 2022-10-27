package org.example;

import java.util.Stack;

public class ListNode {

    int val = 0;
    public ListNode next;

    public ListNode(int v) {
        this.val = v;
    }

    /**
     * 利用栈进行反转
     * 关键点：先入栈，再出栈
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
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

}
