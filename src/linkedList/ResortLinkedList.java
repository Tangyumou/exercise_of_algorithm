package linkedList;

/*1.4 如何对链表进行重新排序
将链表重新排序，eg.12345->15243
*/
public class ResortLinkedList {
    public static void main(String[] args) {
        //链表头节点
        LNode head = new LNode();
        head.next = null;
        LNode cur;
        //将数据域为1-8的节点加入链表
        cur = head;
        for(int i = 1; i < 9; i++){
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
        resort(head);
        System.out.println();
        cur = head;
        while(cur.next!=null){
            cur = cur.next;
            System.out.print(cur.data+" ");
        }

    }
    private static void resort(LNode head){
        LNode secHead = findMidNode(head);
        LNode cur = secHead.next.next;
        secHead.next.next = null;
        LNode next;
        while(cur!=null){
            next = cur.next;
            cur.next = secHead.next;
            secHead.next = cur;
            cur = next;
        }
        cur = secHead.next;
        secHead.next = null;
        LNode cur1 = head.next;
        LNode next1;
        while(cur!=null){
            next1 = cur1.next;
            next =cur.next;
            cur1.next = cur;
            cur.next = next1;
            cur = next;
            cur1 = next1;
        }

    }
    //找到中间节点，若节点为偶数个，则中间节点为靠后的那个
    private static LNode findMidNode(LNode head){
        LNode fast = head;
        LNode slow = head;
        while(fast.next!=null&&fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.next;
    }
}
