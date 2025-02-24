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
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetric(root.left, root.right);
    }
    public boolean isSymmetric(TreeNode left ,  TreeNode right){
        if(left==null || right==null) return left==right;
        if(left.val != right.val) return false;

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
    // public boolean isSymmetric(TreeNode root) {
        // Queue<TreeNode> q = new LinkedList<>();
        // q.add(root.left);
        // q.add(root.right);
        // while(!q.isEmpty()){
        //     TreeNode left = q.poll();
        //     TreeNode right = q.poll();
        //     if(left == null && right == null){
        //         continue;
        //     }
        //     if(left == null || right == null){
        //         return false;
        //     }
        //     if(left.val != right.val){
        //         return false;
        //     }
        //     q.add(left.left);
        //     q.add(right.right);
        //     q.add(left.right);
        //     q.add(right.left);
        // }
        // return true;
    // }
}