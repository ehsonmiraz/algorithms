import java.util.*;

import org.xml.sax.ext.EntityResolver2;
class Pair implements Comparable<Pair>{
    
    int des;
    int weight;

    Pair(int weight, int des){
        this.des=des;
        this.weight=weight;
    }
     public int compareTo(Pair that){

        if(this.weight==that.weight)
            return 0;
        else if(this.weight>that.weight)
            return  1;
        else
            return -1;
    }
}
public class Prims {
  
  void buildMST(Map<Integer , ArrayList<Pair> >  graph, int V){
   // Collections.sort(edges);
    boolean visited[]=new boolean[V];
    PriorityQueue<Pair> queue= new PriorityQueue<Pair>();
    int count = 0;
    int ans=0;
    queue.add(new Pair(0,0));
    while(!queue.isEmpty()){
       
        Pair vertex=queue.poll();
        if(visited[vertex.des])
        continue;
        visited[vertex.des]=true;
        ans+=vertex.weight;
        ArrayList<Pair> neighbours=graph.get(vertex.des);
        for (Pair vert : neighbours) {
          if(!visited[vert.des]){
              queue.add(vert);
          }
            
        }
        
        
    }
   
      System.out.println(ans);
  }
 public static void main(String[] args) {
   
    int V=5;
    Map<Integer , ArrayList<Pair> >  graph= new HashMap<Integer,ArrayList<Pair>>();
    for (int i = 0; i < V; i++) {
        graph.put(i, new ArrayList<Pair>());
        
    }

    graph.get(0).add(new Pair(2, 1));
    graph.get(0).add(new Pair(6, 4));
    graph.get(0).add(new Pair(7, 3));
    graph.get(1).add(new Pair(2, 0));
    graph.get(1).add(new Pair(1, 2));
    graph.get(1).add(new Pair(4, 4));
    graph.get(2).add(new Pair(3, 3));
    graph.get(2).add(new Pair(2, 4));
    graph.get(2).add(new Pair(1, 1));
    graph.get(3).add(new Pair(3, 2));
    graph.get(3).add(new Pair(7, 0));
    graph.get(3).add(new Pair(5, 4));
    graph.get(4).add(new Pair(6, 0));
    graph.get(4).add(new Pair(4, 1));
    graph.get(4).add(new Pair(2, 2));
    graph.get(4).add(new Pair(5, 3));
    

   
    Prims hm =new Prims();
    hm.buildMST(graph, V);
   
 }    
}
