package linkedList;

import java.util.Random;

public class AddOfLinkedList {
    public static void main(String[] args) {
        LNode aHead = createLinkedList(9);
        LNode bHead = createLinkedList(5);
        LNode sumHead = add(aHead,bHead);
        LNode cur = sumHead.next;
        while (cur!=null){
            System.out.print(cur.data);
            cur = cur.next;
        }


    }
    //随机数生成链表节点数据域，第一个节点为个位，依此类推
    public static LNode createLinkedList(int n){
        Random r = new Random();
        LNode head = new LNode();
        head.next = null;
        LNode cur = head;
        for(int i = 0; i < n; i++){
            int data = r.nextInt(10);
            if(i==n-1&&data==0){
                data++;
            }
            System.out.print(data);
            LNode temp = new LNode();
            temp.next = null;
            temp.data = data;
            cur.next = temp;
            cur = temp;
        }
        System.out.println();
        return head;
    }
    //两个链表对应数字相加得到新的链表
    public static LNode add(LNode a, LNode b){
        LNode sumHead = new LNode();
        sumHead.next = null;
        LNode aCur = a.next;
        LNode bCur = b.next;
        LNode sumCur = sumHead;
        int carry = 0;
        int sum;

        while(aCur!=null&&bCur!=null){
            LNode temp = new LNode();
            temp.next = null;
            sum = aCur.data+bCur.data+carry;
            temp.data = sum%10;
            carry = sum/10;
            sumCur.next = temp;
            sumCur = temp;
            aCur = aCur.next;
            bCur = bCur.next;
        }

        if(bCur==null){
            bCur = aCur;
        }
        while(bCur!=null){
            LNode temp = new LNode();
            temp.next = null;
            sum = bCur.data+carry;
            temp.data = sum%10;
            carry = sum/10;
            sumCur.next = temp;
            sumCur = temp;
            bCur = bCur.next;
        }
        if(carry!=0){
            LNode temp = new LNode();
            temp.data = carry;
            temp.next = null;
            sumCur.next = temp;
        }

        return sumHead;
    }

}
