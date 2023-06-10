import java.util.*;
public class MaxHeap {
    ArrayList<Integer> arr = new ArrayList<Integer>();
    public void insert(int data){ //o(logn)
        arr.add(data);// insert at last 
        int x = arr.size()-1; //child idx
        int par = (x-1)/2; //par idx

        while(arr.get(x)>arr.get(par)) {
            int temp = arr.get(x);
            arr.set(x,arr.get(par));
            arr.set(par,temp);
            x=par;
            par=(x-1)/2;
        }
    }

    public int peek(){
        return arr.get(0);
    }

    public void heapify(int i){
        int left = 2*i+1;
        int right = 2*i+2;
        int minIdx=i;

        if(left<arr.size() && arr.get(minIdx)<arr.get(left)){
            minIdx=left;
        }
        if(right<arr.size() && arr.get(minIdx)<arr.get(right)){
            minIdx=right;
        }
        if(minIdx !=i){
            int temp=arr.get(i);
            arr.set(i,arr.get(minIdx));
            arr.set(minIdx,temp);
            heapify(minIdx);
        }
    }
    public int remove(){
        int data=arr.get(0);

        int temp = arr.get(0);
        arr.set(0,arr.get(arr.size()-1));
        arr.set(arr.size()-1,temp);

        arr.remove(arr.size()-1);

        heapify(0);

        return data;
    }

    public boolean isEmpty(){
        return arr.size()==0;
    }
    public static void main(String args[]){
        MaxHeap h = new MaxHeap();
        h.insert(1);
        h.insert(3);
        h.insert(4);
        h.insert(2);

        while(!h.isEmpty()){
            System.out.println(h.peek());
            h.remove();
        }
    }
    
}
