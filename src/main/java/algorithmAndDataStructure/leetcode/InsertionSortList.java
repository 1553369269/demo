package algorithmAndDataStructure.leetcode;

/**
 * @Description 对链表进行插入排序
 * 地址:https://leetcode-cn.com/problems/insertion-sort-list/
 * Author caihaojie
 * @Date 2020-03-31 21:08
 **/
public class InsertionSortList {
    // head当前已排序的最后一个位置
    public ListNode insertionSortList(ListNode head) {
       ListNode dummy = new ListNode(0); // 新链表
       ListNode pre;
       dummy.next = head; // 新链表指向旧链表的头节点
       while (head != null && head.next != null){
           if (head.val < head.next.val) { // 当前已排序的最后一个位置大于没排序的第一个位置，head后移
              head = head.next;
              continue;
           }
           // 如果未排序的节点小于已排序的最后一个节点，则从表头开始循环比较
           pre = dummy; // 表示表头
           while (pre.next.val < head.next.val){
               pre = pre.next;
           }
           // 退出循环说明找到了插入的位置，插入即可
           ListNode curr = head.next; // 当前要插入的节点
           head.next = curr.next; // head后移
           // 插入在pre后面
           curr.next = pre.next;
           pre.next = curr;
       }
       return dummy.next;
    }
}
