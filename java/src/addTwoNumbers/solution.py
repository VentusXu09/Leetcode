# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        j= 0
        prev = l3 = ListNode(None)
        while l1 or l2:
            val1 = l1.val if l1 else 0
            val2 = l2.val if l2 else 0
            s = val1 + val2 + j
            j = s//10
            s = s%10
            l3.next = ListNode(s)
            l3 = l3.next
            l2 = l2.next if l2 else l2
            l1 = l1.next if l1 else l1
        if j !=0:
            l3.next = ListNode(j)
        return prev.next

