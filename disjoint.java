/**
 * disjoint
 */
public class disjoint {
    int n=10;
    int parent[]=new int[n];
    disjoint(){
        for(int i=0;i<n;i++)
            parent[i]=i;

    }
    int findParent(int x){
        while(parent[x]!=x){
            x=parent[x];
        }
        return x;
    }
    void union(int x,int y){
         x=this.findParent(x);
         y=this.findParent(y);
         if(x==y)
          return;
         parent[y]=x; 

    }
    boolean areFreinds(int x , int y)
    {
        if(this.findParent(x)==this.findParent(y))
            return true;
        return false;    
    }
    public static void main(String[] args) {
      disjoint d=new disjoint();
      System.out.println(d.areFreinds(1, 2));
      d.union(1, 2);
      System.out.println(d.areFreinds(1, 2));
      d.union(1, 2);
      d.union(3, 5);
      d.union(3, 4);
      d.union(4, 5);
      d.union(1, 5);
      //System.out.println(d.parent[1]+"  "+d.parent[2]+" "+d.parent[5]);
      System.out.println(d.areFreinds(1, 5));
    }
}