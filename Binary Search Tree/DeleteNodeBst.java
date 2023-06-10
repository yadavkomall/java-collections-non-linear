public class DeleteNodeBst {

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node delete(Node root, int val) {
        if (root.data < val) {
            root.right = delete(root.right, val);
        } else if (root.data > val) {
            root.left = delete(root.left, val);
        } else {
            // leaf node
            if (root.left == null && root.right == null) {
                return null;
            }
            // single child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // both children
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);

    }

    public static void main(String args[]) {
        /*
         * 
         * 10
         * / \
         * 8 15
         * / \ / \
         * 4 9 13 17
         * 
         */

        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(15);
        root.left.left = new Node(4);
        root.left.right = new Node(9);
        root.right.left = new Node(13);
        root.right.right = new Node(17);

        inorder(root);
        System.out.println();

        delete(root, 10);

        inorder(root);
        System.out.println();
    }
}
