package linkedList;
//反转链表
public class ReverseLinkedList {
    public static void main(String[] args) {
        //链表头节点
        LNode head = new LNode();
        head.next = null;
        LNode cur;
        //将数据域为1-8的节点加入链表
        cur = head;
        for(int i = 1; i < 8; i++){
            LNode temp = new LNode();
            temp.data = i;
            temp.next = null;
            cur.next = temp;
            cur = temp;
        }
        //打印链表各节点的值
        cur = head;
        while(cur.next!=null){
            cur = cur.next;
            System.out.print(cur.data+" ");
        }
        reverse_(head);
        System.out.println();
        cur = head;
        while(cur.next!=null){
            cur = cur.next;
            System.out.print(cur.data+" ");
        }

    }
    //反转单链表
    //就地逆序，时间复杂度O(n)
    public static void reverse(LNode head){
        if(head==null||head.next==null){
            return;
        }
        //处理第一个节点
        LNode cur = head.next;
        LNode next = cur.next;
        cur.next = null;
        LNode pre = cur;
        cur = next;
        //处理最后一个节点
        while(cur.next!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        //处理最后一个节点
        cur.next = pre;
        head.next = cur;
    }
    //遍历第二个节点之后的每个节点，插入到头节点之后
    public static void reverse_ (LNode head){
        if(head==null||head.next==null){
            return;
        }
        //将链表从第一个节点后断开
        LNode cur = head.next.next;
        head.next.next = null;
        LNode next = null;
        //将第二个节点后的节点依次插入
        while(cur!=null){
            next = cur.next;
            cur.next = head.next;
            head.next = cur;
            cur = next;
        }
    }
}
