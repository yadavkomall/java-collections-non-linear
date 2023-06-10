import java.util.*;
public class BSTtoBalancedBST {
    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data=data;
            this.left =null;
            this.right=null;
        }
    }

    public static void getInorder(Node root,ArrayList<Integer> arr){
        if(root ==null){
            return;
        }
        getInorder(root.left,arr);
        arr.add(root.data);
        getInorder(root.right, arr);
    }

    public static Node createBST(ArrayList<Integer> inorder,int st,int end){
        if(st>end){
            return null;
        }
        int mid = (st+end)/2;
        Node root = new Node(inorder.get(mid));
        root.left=createBST(inorder, st, mid-1);
        root.right=createBST(inorder, mid+1, end);
        return root;
    }

    public static Node balancedBST(Node root){
        ArrayList<Integer> inorder= new ArrayList<>();
        getInorder(root,inorder);
        root = createBST(inorder, 0, inorder.size()-1);
        return root;
    }

    public static void preorder(Node root){
        if(root==null){
            System.out.print("-1"+" ");
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String args[]){
       Node root = new Node(8);
       root.left = new Node(6);
       root.left.left= new Node(5);
       root.left.left.left=new Node (3);

       root.right= new Node(10);
       root.right.right= new Node(11);
       root.right.right.right= new Node(12);
       root = balancedBST(root);
       preorder(root);
       
    }
}
