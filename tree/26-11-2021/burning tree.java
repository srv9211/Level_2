class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    public static int minTime(Node root, int target) {
        // Your code goes here
        HashMap<Integer, List<Integer> > hm = new HashMap<>();
        helper(root, target, hm);
        return hm.size()-1;
        
    }
    public static int helper(Node root, int target, HashMap<Integer, List<Integer> > hm){
        
        if(root == null)
            return -1;
        
        if(root.data == target){
            allDown(root, null, 0, hm);
            return 1;
        }
        
        int l = helper(root.left, target, hm);
        int r = helper(root.right, target, hm);
        
        if(l != -1){
            allDown(root, root.left, l, hm);
            return l+1;
        }
        else if(r != -1){
            allDown(root, root.right, r, hm);
            return r+1;
        }
        
        return -1;
    }
    public static void allDown(Node  root, Node blocker, int time, HashMap<Integer, List<Integer> > hm){
        if(root==null || root==blocker)
            return;
        
        if(hm.containsKey(time)){
            hm.get(time).add(root.data);
        }
        else{
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.data);
            hm.put(time, list);
        }
        
        allDown(root.left, blocker, time+1, hm);
        allDown(root.right, blocker, time+1, hm);
        
    }
}
