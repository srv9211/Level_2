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
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        return helper(root, targetSum, hm, 0);
    
    }
    public int helper(TreeNode root, int tar, HashMap<Integer, Integer> hm, int sum){
        if(root == null)
            return 0;
        int ans = 0;
        sum += root.val;
        ans += hm.getOrDefault(sum-tar, 0) ;
        hm.put( sum,  hm.getOrDefault( sum , 0 ) + 1 );
        
        ans += helper(root.left, tar, hm, sum);
        ans += helper(root.right, tar, hm, sum);
        
        // if(hm.get(sum)==0)
        //     hm.remove(sum);
        // else
            hm.put( sum, hm.get(sum)-1 );
        // sum -= root.val;
        
        return ans;
    }
}


