package edu.luc.cs271.myhashmap;
import java.util.*;
import org.jgrapht.alg.interfaces.*;
import org.jgrapht.alg.color.GreedyColoring;
import org.jgrapht.graph.*;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.*;

public class Main{
  static final String CH = "CHAD";
  static final String CAR = "CENTRAL AFRICAN REPUBLIC";
  static final String SD = "SUDAN";
  static final String CM = "CAMEROON";
  static final String NG = "NIGER";
  static final String LY = "LIBYA";
  static final String NA = "NIGERIA";
  private static void main(final String[] args) {
    final SimpleGraph<String, DefaultEdge> myMap = new SimpleGraph<>(DefaultEdge.class);

    myMap.addVertex(CH);
    myMap.addVertex(CAR);
    myMap.addVertex(SD); // Sudan
    myMap.addVertex(CM); // Cameroon
    myMap.addVertex(NG); // Niger
    myMap.addVertex(NA); // Nigeria
    myMap.addVertex(LY); // Libya
    myMap.addEdge(CH, CAR);
    myMap.addEdge(CH, SD);
    myMap.addEdge(CH, CM);
    myMap.addEdge(CH, NG);
    myMap.addEdge(CH, NA);
    myMap.addEdge(CH, LY);
    myMap.addEdge(NG, LY);
    myMap.addEdge(NG, NA);
    myMap.addEdge(CM, NA);
    myMap.addEdge(CM, CAR);
    myMap.addEdge(CAR, SD);
    myMap.addEdge(SD, LY);

    System.out.printf(myMap);
    
  }

    /*
        public void breadthFirst(){
            // BFS uses Queue data structure
            Queue queue = new LinkedList();
            queue.add(myMap.next);//???? is this right?
            printNode(this.rootNode);
            rootNode.visited = true;
            while(!queue.isEmpty()) {
                Node node = (Node)queue.remove();
                Node child=null;
                while((child=getUnvisitedChildNode(node))!=null) {
                    child.visited=true;
                    printNode(child);
                    queue.add(child);
                 }
            }
            // Clear visited property of nodes
            clearNodes();
        }

       public void depthFirstSearch(){
            // DFS uses Stack data structure
            Stack stack = new Stack();
            stack.push(this.rootNode);
            rootNode.visited=true;
            printNode(rootNode);
            while(!stack.isEmpty()) {
                Node node = (Node)s.peek();
                Node child = getUnvisitedChildNode(n);
                if(child != null) {
                    child.visited = true;
                    printNode(child);
                    s.push(child);
                }else {
                    s.pop();
                }
            }
            // Clear visited property of nodes
            clearNodes();
        }



       public static void  ListGraph(int numV, boolean directed) {
       super(numV, directed);
       edges = new List[numV];
       for (int i = 0; i < numV; i++) {
        edges[i] = new LinkedList<Edge>();
       }

    }
    public boolean isEdge(int source, int dest) {
       return edges[source].contains(new Edge(source, dest));
    }

    public void insert(Edge edge) {
       edges[edge.getSource()].add(edge);
       if (!isDirected()) {
        edges[edge.getDest()].add(new Edge(edge.getDest(),
                             edge.getSource(),
                             edge.getWeight()));
       }
    }
    public Iterator<Edge> edgeIterator(int source) {
       return edges[source].iterator();
    }

    public Edge getEdge(int source, int dest) {
       Edge target =
        new Edge(source, dest, Double.POSITIVE_INFINITY);
       for (Edge edge : edges[source]) {
        if (edge.equals(target))
            return edge; // Desired edge found, return it.
       }
       // Assert: All edges for source checked.
       return target; // Desired edge not found.
        }
      }
    */
   
      public void BreadthFirstIterator() {
    final Iterator<String> breadth = new BreadthFirstIterator(myMap, CH);

    for (int i = 0; i < 6; i++) {
      if (breadth.hasNext()) {
        final String country = breadth.next();
        System.out.println(country);

      } else return;
    }
  }

  public void ClosestFirstIterator() {
    final Iterator<String> close = new ClosestFirstIterator(myMap, CH);
     for (int i = 0; i < 6; i++) {
      if (close.hasNext()) {
        final String co = close.next();
        System.out.println(co);
      } else return;
    }
  }

  public void DepthFirstIterator() {
    final Iterator<String> depth = new DepthFirstIterator(myMap, CH);
    for (int i = 0; i < 6; i++){
      if (depth.hasNext()) {
        final String co = depth.next();
        System.out.println(co);
      } else return;
    }
  }

  public void RandomWalkIterator() {
    final Iterator<String> rand= new RandomWalkIterator<>(myMap, CH);
     for (int i = 0; i < 6; i++) {
      if (rand.hasNext()) {
        final String co = rand.next();
        System.out.println(co);
      } else return;
    }
  }

  public void Coloring() {
    GreedyColoring<String, DefaultEdge> color = new GreedyColoring<>(myMap);
    System.out.println(color.getColoring());
  }

}