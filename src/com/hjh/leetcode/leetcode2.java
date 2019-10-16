package com.hjh.leetcode;

import java.util.ArrayList;

/**
 * @author hejiahao
 * @version 1.0
 * @date 2019/7/2 11:15
 * @projct_name leetcode
 */
public class leetcode2 {
    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        ListNode l1 = new ListNode(8);
        l1.next =new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(6);
        l2.next = new ListNode(4);
        l2.next.next= new ListNode(3);
        int nodeint =  nodeToInt(l2);
        System.out.println(l1);
        System.out.println(nodeint);

//        System.out.println(intToNode(1999999999));
        leetcode2 leetcode2 = new leetcode2();
        ListNode l4 = leetcode2.addTwoNumbers(l1,l2);
        System.out.println(l4);
//        ListNode l3 = leetcode2.addTwoNumbers(intToNode(1999999999),intToNode(9));
//        System.out.println(1999999999+9);
//        System.out.println(l3);
    }



    public  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode p1 = l1,p2 = l2,curr = node;
        int carry=0,sum;
        while(p1.next != null || p2.next != null){
            int x = (p1 != null)?p1.val:0;
            int y = (p2 != null)?p2.val:0;
            sum = x + y + carry;
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            if(p1 != null) p1 = p1.next;
            if(p2 != null) p2 = p2.next;
        }
        if(carry>0){
            curr.next = new ListNode(carry);
        }
        return node.next;
    }

    //int转为node
    public static ListNode intToNode(int i){
        String is = String.valueOf(i);
        int j = is.length();
        ListNode node = null;

        for (int k = 0;k< j  ;k++){
            ListNode listnode= new ListNode(Integer.valueOf(is.substring(k,k+1)));
            listnode.next = node;
            node = listnode;
        }
        return node;
    }

    //node转为int
    public static int nodeToInt(ListNode node){
      int nodeint = 0;
      int len = nodelength(node);
      for(int i=0;i<len;i++){
          nodeint += node.val*Math.pow(10,i);
          node = node.next;
      }
    return nodeint;
    }

    //计算链表长度
    public static int nodelength(ListNode node){
        int i = 0;
        while (node !=null){
            i++;
            node = node.next;
        }
        return i;
    }

//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode dummyHead = new ListNode(0);
//        ListNode p=l1,q=l2,curr=dummyHead;
//        int carry=0;//进位
//        while(p!=null || q!=null){
//            int x=(p!=null)?p.val:0;
//            int y=(q!=null)?q.val:0;
//            int sum=x+y+carry;
//            carry=sum/10;
//            curr.next=new ListNode(sum%10);
//            curr=curr.next;
//            if(p!=null) p=p.next;
//            if(q!=null) q=q.next;
//        }
//        if(carry>0){
//            curr.next=new ListNode(carry);
//        }
//
//        return dummyHead.next;
//
//    }
}
