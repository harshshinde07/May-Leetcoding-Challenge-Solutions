// [20 May] Kth Smallest Element in a BST

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {

        AtomicInteger count = new AtomicInteger();
        AtomicInteger result = new AtomicInteger();

        kthInorder(root, k, count, result);
        return result.get();
    }

    void kthInorder(TreeNode root, int k, AtomicInteger count, AtomicInteger result) {
        if(root.left != null) kthInorder(root.left, k, count, result);
        count.getAndIncrement();
        if(count.get() == k) {
            result.set(root.val);
            return;
        }

        if(root.right != null) kthInorder(root.right, k, count, result);
    }
}