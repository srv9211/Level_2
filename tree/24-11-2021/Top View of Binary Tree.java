{
    static class pair{
        Node node;
        int width;
        pair(Node node, int width){
            this.node=node;
            this.width=width;
        }
    }
    static ArrayList<Integer> topView(Node root) {
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        if(root==null) return list;
        
        Queue<pair> q = new ArrayDeque<>();
        q.add(new pair(root, 0));
        int minW = 0;
        int maxW = -1;
        while(q.size()>0){
            int size=q.size();
            while(size-- > 0){
                pair rem = q.remove();
                if(rem.width < minW || rem.width > maxW){
                    hm.put(rem.width, rem.node.data);
                    minW = Math.min(minW, rem.width);
                    maxW = Math.max(maxW, rem.width);
                }
                if(rem.node.right != null)
                    q.add(new pair(rem.node.right, rem.width+1));
                if(rem.node.left != null)    
                    q.add(new pair(rem.node.left, rem.width-1));
            }
        }
        while(hm.containsKey(minW)){
            list.add(hm.get(minW));
            minW++;
        }
        return list;
    }
}
