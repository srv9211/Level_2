// } Driver Code Ends


/*Complete the function below
Node is as follows:
class Tree{
	int data;
	Tree left,right,random;
	Tree(int d){
		data=d;
		left=null;
		right=null;
		random=null;
	}
}*/
class Solution{
    public Tree cloneTree(Tree tree){
       // add code here.
       
       // copying // kinda left cloned tree
       copyLeftNode(tree);
       Tree ret = tree.left;
       copyRandom(tree);
       game(tree);
       return ret;
     }
     
     public Tree copyLeftNode(Tree node){
         if(node==null) return null;
     
         Tree l = new Tree(node.data);
         l.left = copyLeftNode(node.left);
         node.left = l;
         node.right = copyLeftNode(node.right);
         
         return node;
     } 
     public void copyRandom(Tree node){
         if(node == null) return;
         
         if(node.random != null){
            node.left.random = node.random.left;
         }
         
         copyRandom(node.left.left);
         copyRandom(node.right);
         
     }
     public void game(Tree node){
         if(node==null)
            return;
        
        Tree temp = node.left;
        node.left = node.left.left;
        temp.left = node.left;
        game(node.left);
        if(node.right != null)
            temp.right = node.right.left;
        game(node.right);
     }
     
}









