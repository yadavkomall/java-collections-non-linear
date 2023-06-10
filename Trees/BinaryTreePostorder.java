public class BinaryTreePostorder {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    static class BinaryTree{
        static int idx = -1;
      public static Node buildTree(int node[]){
        idx++;
      
        if(node[idx]==-1){
            return null;
        }
        Node newnode = new Node(node[idx]);
        newnode.left=buildTree(node);
        newnode.right=buildTree(node);

        return newnode;
      }

      public static void postorderTraversal(Node root){
        if(root ==null){
            System.out.print("-1 ");
            return;
        }

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.data+" ");

      }

    }
    public static void main(String args[]){
int node[]= { 10, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
BinaryTree obj = new BinaryTree();
Node root = obj.buildTree(node);
System.out.println("Root node of given tree : "+ root);
obj.postorderTraversal(root);
    }
}
