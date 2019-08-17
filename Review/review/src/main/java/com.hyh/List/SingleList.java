package com.hyh.List;

import java.util.*;

public class SingleList {

    class Node{
        private Node next;
        private Node data;

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getData() {
            return data;
        }

        public void setData(Node data) {
            this.data = data;
        }
    }

    //单链表反转
    public Node reverseList(Node head){
        Node cur = head;
        Node pre = null;
        Node reverseHead = null;

        while (cur!=null){
            Node curNext = cur.next;
            if (curNext==null){
                reverseHead = cur;
            }
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        return reverseHead;
    }

    //单链表反转

    public Node reverseList1(Node head){
        Node cur = head;
        Node pre = null;
        Node reverseHead = null;
        while (cur != null){
            Node curNext = cur.next;
            if (curNext == null){
                reverseHead = head;
            }
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        return reverseHead;
    }

    //找到中间节点
    //快慢指针法
    public  Node findMid(Node head){
        Node fast = head;
        Node low = head;
        if (fast == null && fast.next ==null){
            return head;
        }
        while (fast!=null && fast.next !=null){
            fast = fast.next.next;
            low = low.next;
        }
        return low;
    }

    //寻找倒数第k个节点
    public Node findKinNode(int k,Node head){
        Node fast = head;
        Node low = head;
        if (fast == null || k<=0){
            return null;
        }
        //先让 fast 走k-1步
        while (k-1>0){
            if (fast.next != null){
                fast = fast.next;
                k--;
            }else {
                return null;
            }
        }
        //再让一起一步一走
        while (fast.next != null){
            fast = fast.next;
            low = low.next;
        }
        return low;
    }


    //构造一个环
    public void createCycle(Node head){
        Node cur=head;
        while (cur.next!=null){
            cur=cur.next;
        }
        cur.next=head.next.next.next;
    }
    //判断链表是否有环
    public boolean hasCycle(Node head){
        Node fast = head;
        Node low = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            low =low.next;
            if (fast == low){
                return true;
            }
        }
        return true;
    }


    // 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 NULL
    public Node detectCycle(Node head){
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                break;
            }
        }
        if (fast == null || fast.next == null){
            return null;
        }
        slow = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }



    //在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
    //重复的结点不保留，返回链表头指针

//    public Node deleteDuplication(Node head){
//        Node newNode
//    }

    //判断链表是不是回文结构

    public boolean chkPalindrome1(Node head){
        Node B = reverseList(head);
        while (head!=null){
            if (B.data != head.data){
                return false;
            }
            B = B.next;
            head = head.next;
        }
        return true;
    }




    //输入年月日  计算出这是一年中的第几天
        public static void main(String [] args){
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                int year = sc.nextInt();
                int mnth = sc.nextInt();
                int date = sc.nextInt();
                int day = 0;
                for(int i=1; i<mnth; i++) {
                    if(i==1 || i==3 || i==5 || i==7 || i==8 || i==10) {
                        day += 31;
                    } else if(i==4 || i==6 || i==9 || i==11) {
                        day += 30;
                    } else if(i==2 && (year%400==0 || (year%4==0 && year%100!=0))) {
                        day += 29;
                    } else {
                        day += 28;
                    }
                }
                day += date;
                System.out.println(day);
            }
        }
}

