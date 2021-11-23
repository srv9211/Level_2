/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     Tree
        Node() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public class pair implements Comparable<pair>{
        int level;
        int data;
        pair(int level, int data){
            this.level = level;
            this.data = data;
        }
        public int compareTo(pair o){
            int ret = this.level-o.level;
            if(ret==0){
                return this.data-o.data;
            }
            return ret;
        }
    }
    public int min = 0;
    public void rec(HashMap<Integer, List<pair>> hm, int verticalLevel, int level, TreeNode node){
        if(node==null)
            return;
        if(hm.containsKey(verticalLevel)){
            pair p = new pair(level, node.val);
            hm.get(verticalLevel).add(p);
        }
        else{
            List<pair> list = new ArrayList();
            list.add(new pair(level, node.val));
            hm.put(verticalLevel, list);
        }
        rec(hm, verticalLevel-1, level+1, node.left);
        rec(hm, verticalLevel+1, level+1, node.right);
        
        min = Math.min(verticalLevel, min);
        
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap< Integer, List<pair> > hm = new HashMap<>();
        rec(hm, 0, 0, root);
        int m = min;
        List<List<Integer>> ans = new ArrayList();
        while(hm.containsKey(min)){
            List<Integer> list = new ArrayList();
            List<pair> temp = hm.get(min);
            Collections.sort(temp);
            for(int i=0; i<temp.size(); i++){
                list.add(temp.get(i).data);
            }
            ans.add(list);
            min++;
        }        
        return ans;
    }
}
