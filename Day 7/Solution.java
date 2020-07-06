// [7 May] Cousins in Binary Tree

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

    public boolean isCousins(TreeNode root, int x, int y) {

        AtomicInteger parentX = new AtomicInteger();
        AtomicInteger parentY = new AtomicInteger();
        AtomicInteger depthX = new AtomicInteger(-1);
        AtomicInteger depthY = new AtomicInteger(-1);

        getParentAndDepth(root, x, y, 0, depthX, depthY, parentX, parentY);
        return ((depthX.get() == depthY.get()) && (parentX.get() != parentY.get()));
    }

    void getParentAndDepth(TreeNode root, int x, int y, int depth, AtomicInteger depthX, AtomicInteger depthY,
                           AtomicInteger parentX, AtomicInteger parentY) {
        if(root == null) return;
        if(root.left != null) {
            if(root.left.val == x) {
                parentX.set(root.val);
                depthX.set(depth + 1);
            } else if(root.left.val == y) {
                parentY.set(root.val);
                depthY.set(depth + 1);
            }
        }
        if(root.right != null) {
            if(root.right.val == x) {
                parentX.set(root.val);
                depthX.set(depth + 1);
            } else if(root.right.val == y) {
                parentY.set(root.val);
                depthY.set(depth + 1);
            }
        }
        if(depthX.get() != -1 && depthY.get() != -1) return;

        getParentAndDepth(root.left, x, y, depth + 1, depthX, depthY, parentX, parentY);
        getParentAndDepth(root.right, x, y, depth + 1, depthX, depthY, parentX, parentY);
    }

}