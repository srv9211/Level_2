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
    public boolean f1, f2;
    public TreeNode find(TreeNode root, TreeNode p, TreeNode q){
        if(root==null)
            return null;
        TreeNode l = find(root.left, p, q);
        TreeNode r = find(root.right, p, q);
        
        if(root==p){
            f1 = true;
            return root;
        }
        if(root==q){
            f2 = true;
            return root;
        }
        
        if(l!=null && r!=null)
            return root;
        else if(l!=null)
            return l;
        return r;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ret = find(root, p, q);
        if(f1 && f2)
            return ret;
        return null;
    }
}
