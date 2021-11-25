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
    public void flatten(TreeNode root) {
        
        if(root == null){
            return;
        }
        helper(root);
        
    }
    public TreeNode helper(TreeNode root){
        
        if(root.left==null && root.right==null){
            return root;
        }
        else if(root.left==null && root.right!=null){
            return helper(root.right);
        }
        else if(root.left!=null && root.right==null){
            TreeNode l = helper(root.left);
            root.right = root.left;
            root.left = null;
            return l;
        }
        else{
            TreeNode l = helper(root.left);
            TreeNode r = helper(root.right);
            l.right = root.right;
            root.right = root.left;
            root.left = null;
            return r;
        }
    }
    
}
