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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root== null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int levelSize = q.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for(int i=0; i<levelSize; i++){
                TreeNode currNode = q.poll();
                currentLevel.add(currNode.val);
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
            res.add(currentLevel);
        }
        return res;















        
        // List<List<Integer>> res = new ArrayList<>();
        // Queue<TreeNode> queue = new LinkedList<>();
        // if(root == null) return res;
        // queue.add(root);
        // while(!queue.isEmpty()){
        //     int levelSize = queue.size();
        //     List<Integer> currentLevel = new ArrayList<>(levelSize);
        //     for(int i=0; i<levelSize; i++){
        //         TreeNode currentNode = queue.poll();
        //         currentLevel.add(currentNode.val);
        //         if(currentNode.left != null){
        //             queue.add(currentNode.left);
        //         }
        //         if(currentNode.right != null){
        //             queue.add(currentNode.right);
        //         }
        //     }
        //     res.add(currentLevel);
        // }
        // return res;
    }
}