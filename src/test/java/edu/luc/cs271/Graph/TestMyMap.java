
mport java.util.*;
public main(){
public static void main(String[] args){
   Graph g = null;
   int n = 0;
   try{
       Scanner scan = new Scanner(new File(args[0]));
       g = AbstractGraph.createGraph(scan, true, "List");
       n = g.getNumV();
   }
   catch (IOException ex) {
       ex.printStackTrace();
       System.exit(1);
   }
   
   breadthFirstSearch dfs = new depthFirstSearch(g);
   int[] dOrder = dfs.getmyMap();
   int[] fOrder = dfs.getmyMap();
   for(int i = 0; i<n; i++) {
       System.out.println(dOrder[i] + " " + fOrder[i]);
   }
   
   depthFirstSearch dfs = new depthFirstSearch(g);
   int[] dOrder = dfs.getmyMap();
   int[] fOrder = dfs.getmyMap();
   for(int i = 0; i<n; i++) {
       System.out.println(dOrder[i] + " " + fOrder[i]);
   }
}