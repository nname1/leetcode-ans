package com.kelvin.leetcode.num2;


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ln = new ListNode();
        ListNode node;
        ListNode node1;
        ListNode node2;
        if(l1 == null){
            if(l2.val>9){
                ln.val=l2.val-10;
                node = l2.next;
                if(node == null){
                    node = new ListNode();
                }
                node.val=node.val+1;
                l2.next = node;
            }else{
                ln.val = l2.val;
            }
        }else if(l2 == null){
            if(l1.val>9){
                ln.val=l1.val-10;
                node = l1.next;
                if(node == null){
                    node = new ListNode();
                }
                node.val=node.val+1;
                l1.next = node;
            }else{
                ln.val = l1.val;
            }
        }else if(l1.val + l2.val > 9){
            ln.val=(l1.val + l2.val)-10;
            if(l1.next != null){
                node = l1.next;
                node.val=node.val+1;
                l1.next = node;
            }else if(l2.next != null){
                node = l2.next;
                node.val=node.val+1;
                l2.next = node;
            }else{
                node = new ListNode();
                node.val = 1;
                l2.next = node;
            }
        }else{
            ln.val=(l1.val + l2.val);
        }
        if(l1 == null || l1.next == null){
            node1 = null;
        }else{
            node1 = l1.next;
        }
        if(l2 == null || l2.next == null){
            node2 = null;
        }else{
            node2 = l2.next;
        }
        if(node1 == null && node2 == null){
            return ln;
        }else{
            ln.next=addTwoNumbers(node1,node2);
        }
        return ln;
    }

    //Definition for singly-linked list.
      private class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
}

