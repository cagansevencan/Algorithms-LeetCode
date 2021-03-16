public class InorderBST285 {


      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
         TreeNode(int x) { val = x; }
      }



        private TreeNode previous;
        private TreeNode inorderSuccessorNode;

        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

            //If we can go right we do that, then find leftmost
            if (p.right != null){
                TreeNode leftmost = p.right;

                while(leftmost.left != null){
                    leftmost = leftmost.left;
                }

                this.inorderSuccessorNode = leftmost;
            }else{
                //In order to reach parent, perfrom standard inorder traversal and
                //keep track of previous node.
                this.inorderCase2(root, p);
            }
            return this.inorderSuccessorNode;
        }

        private void inorderCase2(TreeNode node, TreeNode p){
            if(node == null){
                return;
            }

            //Recurse on the left side
            this.inorderCase2(node.left, p);

            //Check if previous is the inorder predecessor of node
            if(this.previous == p && this.inorderSuccessorNode == null){
                this.inorderSuccessorNode = node;
                return;
            }

            //Keeping previous up-to-date for further recursions
            this.previous = node;

            //Recurse on the right side
            this.inorderCase2(node.right, p);
        }
}
