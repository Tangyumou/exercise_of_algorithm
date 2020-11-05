package linkedList;
//删除链表中数据域相同的重复节点
public class RemoveDupNode {
    public static void main(String[] args) {
        LNode head = new LNode();
        head.next = null;
        LNode cur = head;
        //生成有重复数据的链表
        for(int i = 1; i < 8;i++){
            LNode temp = new LNode();
            temp.next = null;
            if(i%2==0){
                temp.data = i-1;
            }else if(i%3==0){
                temp.data = i+2;
            }else{
                temp.data = i;
            }
            cur.next = temp;
            cur = temp;
        }
        for(cur = head.next;cur!=null;cur = cur.next){
            System.out.print(cur.data+" ");
        }
        removeDup(head);
        System.out.println();
        for(cur = head.next;cur!=null;cur = cur.next){
            System.out.print(cur.data+" ");
        }

    }
    public static void removeDup(LNode head){
        LNode outCur;
        LNode innerCur;
        LNode innerPre;
        for(outCur = head.next;outCur!=null;outCur = outCur.next){
            int curData = outCur.data;
            for(innerPre = outCur,innerCur = outCur.next;innerCur!=null;){
                if(innerCur.data==curData){
                    innerPre.next = innerCur.next;
                    innerCur = innerCur.next;
                }else{
                    innerPre = innerCur;
                    innerCur = innerCur.next;
                }

            }

        }

    }
}
