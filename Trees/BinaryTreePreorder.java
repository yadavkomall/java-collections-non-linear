public class BinaryTreePreorder {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildtree(int node[]) {
            idx++;
            if (node[idx] == -1) {
                return null;
            }
            Node newnode = new Node(node[idx]);
            newnode.left = buildtree(node);
            newnode.right = buildtree(node);

            return newnode;
        }

        public static void preorderTraversal(Node root){
            if(root==null){
                System.out.print("-1 ");
                return;
            }

            System.out.print(root.data+" ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }



    public static void main(String args[]) {
        int node[] = { 10, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree obj = new BinaryTree();
        Node root = obj.buildtree(node);
        System.out.println("Root node of binary tree : " + root.data);

        obj.preorderTraversal(root);
    }
}