public class DutchNationalFlagProblem{
    static void sort(int a[],int n){
    int mid=0,low=0,high=n-1;
       while(mid<=high){
         if(a[mid]==0)
            { 
               int temp= a[mid];
               a[mid]= a[low];
               a[low]= temp;
               low++;
               mid++;
   }
         else if(a[mid]== 1){
                 mid++;
    }
         else {
               int temp= a[mid];
               a[mid]= a[high];
               a[high]= temp;
               high--;
   }
   }
   }

    public static void main(String args[]){
     int a[]={0,1,0,1,2,2,2,0,0,1,0,0,0,0};
      sort(a,a.length);
      for(int i=0; i<a.length;i++)
        System.out.print(a[i]+" ,");
   }
   }