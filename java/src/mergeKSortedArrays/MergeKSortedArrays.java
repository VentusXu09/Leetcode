package mergeKSortedArrays;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Leetcode 23. Merge k Sorted Lists
 * Created by Ventus on 2019/9/26 3:53 PM
 */

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 * Tags: Linked List, Divide and Conquer, Heap
 */
public class MergeKSortedArrays {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }

        //Initialize testing cases
        public static ListNode list2ListNode(int[] list) {
            ListNode node = new ListNode(list[0]);
            ListNode tmp = node;
            for (int i=1; i<list.length; i++) {
                tmp.next = new ListNode(list[i]);
                tmp = node.next;
            }
            return node;
        }

        public static ListNode[] lists2ListNodes(int[][] lists) {
            ListNode[] nodes = new ListNode[lists.length];
            for (int i = 0; i < lists.length; i++) {
                nodes[i] = list2ListNode(lists[i]);
            }
            return nodes;
        }
    }

    public static void main(String[] args) {
        int[][] list = {{1,4,5},{1,3,4},{2,5}};
        ListNode[] listNodes = ListNode.lists2ListNodes(list);
        ListNode result = solution(listNodes);
        while (result != null) {
            System.out.println(result.val + "->");
            result = result.next;
        }
    }

    public static ListNode solution(ListNode[] listNodes) {
        if (null == listNodes || listNodes.length == 0) return null;
//        return divideAndConquer(0, listNodes.length -1, listNodes);
        return priorityQueue(listNodes);
    }

    /**
     * Use minimum heap
     * Assuming k lists and each list containing n elements
     * queue.poll() consuming O(logk) each time
     * And We need to run call it nk times
     * @param listNodes
     * @return sorted ListNode
     */
    public static ListNode priorityQueue(ListNode[] listNodes) {
        if (null == listNodes || listNodes.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(listNodes.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) return -1;
                else if (o1.val == o2.val) return 0;
                else return 1;
            }
        });
        ListNode node = new ListNode(0), tmp = node;
        for (ListNode l : listNodes) {
            if (null != l) queue.add(l);
        }
        while (!queue.isEmpty()) {
            tmp.next = queue.poll();
            tmp = tmp.next;
            if (tmp.next != null){
                queue.add(tmp.next);
            }
        }
        return node.next;
    }

    /**
     * Merge lists 2 by 2
     * @param left
     * @param right
     * @param listNodes
     * @return sorted ListNode
     */
    public static ListNode divideAndConquer(int left, int right, ListNode[] listNodes) {
        if (left >= right) return listNodes[left];
        int mid = (left + right) >>> 1;
        ListNode list_0 = divideAndConquer(left, mid, listNodes);
        ListNode list_1 = divideAndConquer(mid + 1, right, listNodes);
        return merge2Lists(list_0, list_1);
    }

    public static ListNode merge2Lists(ListNode list_0, ListNode list_1) {
        ListNode node = new ListNode(0);
        ListNode tmp = node;
        while (list_0 != null && list_1 != null) {
            if (list_0.val <= list_1.val) {
                tmp.next = new ListNode(list_0.val);
                list_0 = list_0.next;
            } else if (list_0.val > list_1.val) {
                tmp.next = new ListNode(list_1.val);
                list_1 = list_1.next;
            }
            tmp = tmp.next;
        }
        tmp.next = list_0 != null ? list_0 : list_1;
        return node.next;
    }

}
