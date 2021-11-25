/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode find(TreeNode root, TreeNode p, TreeNode q){
        if(root==null)
            return null;
        if(root.val==p.val)
            return p;
        if(root.val==q.val)
            return q;
        
        TreeNode l = find(root.left, p, q);
        TreeNode r = find(root.right, p, q);
        
        if(l!=null && r!=null)
            return root;
        else if(l!=null)
            return l;
        return r;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p, q);
    }
}
