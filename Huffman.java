import java.util.PriorityQueue;
import java.util.Comparator;
class Node{
    Node left;
    Node right;
    int freq;
    char data;
    Node( char data,int freq ){
        this.freq = freq;
        this.data = data;
        left = null;
        right = null;
    }
}

public class Huffman {
    static Comparator<Node> nodeComparator = new Comparator<Node>() {
        @Override
        public int compare(Node s1, Node s2) {
            return s1.freq - s2.freq;
        }
    };
    static PriorityQueue<Node> queue = new PriorityQueue<>(nodeComparator);
    static void encode(){
        
        char data[]={'a','b','c','d','e','f'};
        int freq[]={70,10,50,20,40,30};
        
        for(int i=0; i<freq.length; i++){
            queue.add(new Node(data[i], freq[i]));
        }
        while(queue.size()>1){
            Node min1=queue.poll();
            Node min2=queue.poll();
            Node temp=new Node('$', min1.freq+min2.freq);
            temp.left=min1;
            temp.right=min2;
            queue.add(temp);
        }
    }
    
    static void printCode(String code, Node root){
       if(root==null)
        return ;
       if(root.data!='$')
        System.out.println(root.data +" -> : "+code);
       else{ 
       printCode(code+'0', root.left); 
       printCode(code+'1', root.right); 
       }

    }
    static void printTree(Node root){

        if(root==null)
            return ;
        System.out.println(root.data);
        printTree(root.left);
        printTree(root.right);
    }
    public static void main(String[] args) {
        encode();
        System.out.println(queue.peek().data);
        printCode("", queue.peek());
        //printTree(queue.peek());
        
        
    }
}
