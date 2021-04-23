package functest.list;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;
@Slf4j
public class MyLinkedListTest {
    private static void generateLinkedList() {
        LinkedList<String> lList = new LinkedList<String>();
        lList.add("1");
        lList.add("2");
        lList.add("3");
        lList.add("4");
        lList.add("5");
        System.out.println("链表的第一个元素是 : " + lList.getFirst());
        System.out.println("链表最后一个元素是 : " + lList.getLast());
        LinkedList<String> lList2 = new LinkedList<>(lList);
        lList2.add(2,"xxxxx");
        lList2.addAll(lList2.size(),lList);
        System.out.println(lList2);
    }
    public static void main(String[] args) {
//        generateLinkedList();
        MyLinkedListTest myLinkedListTest = new MyLinkedListTest();
        int ans = myLinkedListTest.ysf(5,2);
        log.info(String.valueOf(ans));

    }

    // https://www.nowcoder.com/practice/41c399fdb6004b31a6cbb047c641ed8a?tpId=190&tqId=36013&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-rd%2Fquestion-ranking&tab=answerKey
    public int ysf (int n, int m) {
        if(m == 1 || n == 1){
            return n;
        }
        // write code here
        // 1.将所有的数据变为一个链表
        ListNode head = generateLinkList(n);
        printLinkList(head);
        // 2.开始逐步剥离
        while(head.next != head){
            head = moveStep(head, m);
            head = removeSelect(head);
            printLinkList(head);
        }

        return head.val;
    }

    // 移动m - 1步 ,到达需要被删除的值的前一位
    public static ListNode moveStep(ListNode mileStone, int m){
        for(int i = 1; i < m - 1; i ++){
            mileStone = mileStone.next;
        }
        return mileStone;
    }

    // 去掉被选中的值
    public static ListNode removeSelect(ListNode pre){
        ListNode toRemove = pre.next;
        pre.next = toRemove.next;
        return pre.next;
    }

    public static ListNode generateLinkList(int n){
        ListNode head = new ListNode(1);
        ListNode moveIdx = head;
        for(int i = 2 ; i <= n; i ++){
            moveIdx.next = new ListNode(i);
            moveIdx = moveIdx.next;
        }
        moveIdx.next = head;
        return head;
    }

    public static void printLinkList(ListNode head){
        log.info(String.valueOf(head.val));
        ListNode stone = head.next;
        while(stone != head){
            log.info(String.valueOf(stone.val));
            stone = stone.next;
        }
        log.info("end");
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}