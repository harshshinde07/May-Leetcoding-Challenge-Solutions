// [24 May] Construct Binary Search Tree from Preorder Traversal

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
    public TreeNode bstFromPreorder(int[] pre) {
        int size = pre.length;

        // The first element of pre[] is always root
        TreeNode root = new TreeNode(pre[0]);

        Stack<TreeNode> s = new Stack<TreeNode>();

        // Push root
        s.push(root);

        // Iterate through rest of the size-1 items of given preorder array
        for (int i = 1; i < size; ++i) {
            TreeNode temp = null;

            /* Keep on popping while the next value is greater than
             stack's top value. */
            while (!s.isEmpty() && pre[i] > s.peek().val) {
                temp = s.pop();
            }

            // Make this greater value as the right child
            // and push it to the stack
            if (temp != null) {
                temp.right = new TreeNode(pre[i]);
                s.push(temp.right);
            }

            // If the next value is less than the stack's top
            // value, make this value as the left child of the
            // stack's top node. Push the new node to stack
            else {
                temp = s.peek();
                temp.left = new TreeNode(pre[i]);
                s.push(temp.left);
            }
        }

        return root;
    }
}