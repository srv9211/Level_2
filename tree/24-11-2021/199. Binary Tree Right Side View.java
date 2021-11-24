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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList();
        if(root==null) return list;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(q.size()>0){
            int size=q.size();
            // I added here because the first element will be the
            // right most part.
            list.add(q.peek().val);
            while(size-- > 0){
                TreeNode rem = q.remove();
                // I added right first because,
                // I wanted the first right node of the level.
                if(rem.right != null)
                    q.add(rem.right);
                if(rem.left != null)    
                    q.add(rem.left);
            }
        }
        return list;
    }
}
