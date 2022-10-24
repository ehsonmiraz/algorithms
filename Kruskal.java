import java.util.*;

import org.xml.sax.ext.EntityResolver2;
class Edge implements Comparable<Edge>{
    int src;
    int des;
    int weight;

    Edge(int src, int des, int weight){
        this.src=src;
        this.des=des;
        this.weight=weight;
    }
     public int compareTo(Edge that){

        if(this.weight==that.weight)
            return 0;
        else if(this.weight>that.weight)
            return  1;
        else
            return -1;
    }
}
public class Kruskal {
 
  int parent[]={0,1,2,3,4,5,6,7,8,9,10};  
  int findParent(int x){
    while(x!=parent[x])
       x=parent[x];
    return x ;
  }
  void union(int x,int y){
    x=findParent(x);
    y=findParent(y);
    if(x==y)
      return ;
    parent[y]=x;  
  }
  void buildMST(ArrayList<Edge> edges, int V){
    int count = 0;
    Edge output[]=new Edge[V-1];
    int i=0;
    while(count < V-1){
        int x=findParent(edges.get(i).src);
        int y=findParent(edges.get(i).des);
        if(x!=y){
            output[count++]=edges.get(i);
            parent[y]=x;
        }
        i++;
    }
    for( i= 0;i<count;i++){
    if(output[i].src > output[i].des)
    System.out.println(output[i].src+" -> "+output[i].des+" : " +output[i].weight);
    else
    System.out.println(output[i].src+" -> "+output[i].des+" : " +output[i].weight);
    }
  }
 public static void main(String[] args) {
    int E=11;
    int V=6;
    ArrayList<Edge> edges = new ArrayList<Edge>();

    edges.add(new Edge(1,3,1));
    edges.add(new Edge(0,1,2));
    edges.add(new Edge(0,3,3));
    edges.add(new Edge(0,2,4));
    edges.add(new Edge(4,5,5));
    edges.add(new Edge(2,3,6));
    edges.add(new Edge(3,5,7));
    edges.add(new Edge(2,1,8));
    edges.add(new Edge(2,4,9));
    edges.add(new Edge(2,5,10));
    edges.add(new Edge(3,4,11));

   
    Collections.sort(edges);
    Kruskal hm =new Kruskal();
    hm.buildMST(edges, V);
   
 }    
}
