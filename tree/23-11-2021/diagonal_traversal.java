/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 // *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int min=0;
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
        rec(hm, level+1, node.left);
        rec(hm, level, node.right);
        min = Math.max(min, level);
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        
        rec(hm, 0, root);
        List<List<Integer>> ans = new ArrayList();
        while(hm.containsKey(min)){
            ans.add(hm.get(min));
            min--;
        }
        return ans;
    }
}
