public class SearchBST {

    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data= data;
        }

    }

    public static boolean search(Node root,int key){
        if(root==null){
            return false;
        }
        if(root.data==key){
            return true;
        }
        if(root.data>key){
            return search(root.left, key);
        }
        return search(root.right, key);
    }


    public static void main(String args[]){
 /*
         * 
         *    10
         *   / \
         *  8   15
         * / \ / \
         * 4 5 13 17
         * 
         */
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(15);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(13);
        root.right.right = new Node(17);
        int key =17;
        boolean isfound = search(root, key);

        if(isfound) {
            System.out.println(key+" found");
        }
        else{
            System.out.println(key+" not found");
        }
           
        

    }
}
