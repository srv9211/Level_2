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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        List<Integer> ans = new ArrayList();
        helper(root, target, k, ans);
        return ans;
    }
    public int helper(TreeNode root, TreeNode target, int k, List<Integer> ans){
        if(root == null)
            return -1;
        
        if(root == target){
            kLevelDown(root, null, k, ans);
            return 1;
        }
        int l = helper(root.left, target, k, ans);
        int r = helper(root.right, target, k, ans);
        
        if(l != -1){
            kLevelDown(root, root.left, k-l, ans);
            return l+1;
        }
        else if(r != -1){
            kLevelDown(root, root.right, k-r, ans);
            return r+1;
        }
        return -1;
    }
    public void kLevelDown(TreeNode root,TreeNode blocker, int k, List<Integer> ans){
        if(root == null || root == blocker)
            return;
        if(k==0){
            ans.add(root.val);
            return;
        }
        kLevelDown(root.left, blocker, k-1, ans);
        kLevelDown(root.right, blocker, k-1, ans);
        
    }
}
