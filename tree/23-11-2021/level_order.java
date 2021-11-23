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
    
    public void rec(HashMap<Integer, List<Integer>> hm, int level, TreeNode node){
        if(node==null)
            return;
        
        if(hm.containsKey(level)){
            hm.get(level).add(node.val);
        }
        else{
            List<Integer> list = new ArrayList();
            list.add(node.val);
            hm.put(level, list);
        }
        level++;
        rec(hm, level, node.left);
        rec(hm, level, node.right);
        
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        
        rec(hm, 0, root);
        List<List<Integer>> ans = new ArrayList();
        int i=0;
        while(hm.containsKey(i)){
            ans.add(hm.get(i));
            i++;
        }
        return ans;
    }
}
