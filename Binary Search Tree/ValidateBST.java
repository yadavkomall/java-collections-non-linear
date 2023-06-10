import java.util.*;

public class ValidateBST {
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

    public static void inorder(Node root, ArrayList<Integer> arr) {

        if (root == null) {
            return;
        }
        inorder(root.left, arr);
        arr.add(root.data);
        inorder(root.right, arr);
    }

    public static boolean isValid(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root,arr);
        System.out.println(arr);

        for(int i=0;i<arr.size()-1;i++){
            if(arr.get(i)>arr.get(i+1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
         /*
         * 
         *    10
         *   / \
         *  8   15
         * / \ / \
         * 4 9 13 17
         * 
         */
        ArrayList<Integer> arr = new ArrayList<>();
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(15);
        root.left.left = new Node(4);
        root.left.right = new Node(9);
        root.right.left = new Node(13);
        root.right.right = new Node(17);
        
       
             
       // inorder(root, arr);
       boolean valid = isValid(root);
       System.out.println(valid);

    }
}
