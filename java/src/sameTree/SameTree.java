/**
 * Leetcode 100. Same Tree
 * Created by Ventus on 2019/11/7 4:41 PM
 */

public class SameTree {
//   Definition for a binary tree node.
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

     //Simply run through two trees
     class Solution {
         public boolean isSameTree(TreeNode p, TreeNode q) {
             if (null == p && null == q) return true;
             if (null == p || null == q) return false;
             if (p.val == q.val) {
                 return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
             } else {
                 return false;
             }
         }
     }
}
