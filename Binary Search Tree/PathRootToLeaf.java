import java.util.*;
public class PathRootToLeaf {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public static void print(ArrayList<> path){
        for(int i=0;i<path.size()-1;i++){
            System.out.print(path.get(i)+" ");
        }System.out.println();
    }
    public static void printPaths(Node root,ArrayList<Integer> path){
    if(root==null){
        return;
    }
    path.add(root.data);
    if(root.left==null && root.right==null){
        print(path);
    }
    printPaths(root.left,path);
    printPaths(root.right,path);
    path.remove(path.size()-1);
    }

    public static void main(String args[]){
 /*
         * 
         *    10
         *   / \
         *  8   15
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
        ArrayList <Integer> path = new ArrayList<Integer>();

        printPaths(root, path);
    }
}
