package edu.luc.cs271.myhashmap;
import java.util.*;
import org.jgrapht.*;
import org.jgrapht.alg.color.GreedyColoring;
import org.jgrapht.graph.*;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.traverse.ClosestFirstIterator;
import org.jgrapht.traverse.DepthFirstIterator;
import org.jgrapht.traverse.RandomWalkIterator;

public class Codes{
  static final String CH = "CHAD";
  static final String CAR = "CENTRAL AFRICAN REPUBLIC";
  static final String SD = "SUDAN";
  static final String CM = "CAMEROON";
  static final String NG = "NIGER";
  static final String LY = "LIBYA";
  static final String NA = "NIGERIA";

   Graph<String, DefaultEdge> myMap = new SimpleGraph<>(DefaultEdge.class);
 
   public Codes(Graph<String, DefaultEdge> myMap) {
    this.myMap = myMap;
  }

  public Graph<String, DefaultEdge> Map() {

     myMap.addVertex(CH);
   myMap.addVertex(CAR);
   myMap.addEdge(CH, CAR);
   myMap.addVertex(SD); //Sudan
   myMap.addVertex(CM); //Cameroon
   myMap.addVertex(NG); //Niger
   myMap.addVertex(NA); //Nigeria
   myMap.addVertex(LY); //Libya
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
   System.out.print(myMap);
   return myMap; 
    
  } 

  public void BreadthFirstIterator() {
    final Iterator<String> breadth = new BreadthFirstIterator(myMap, CH);

    for (int i = 0; i < 6; i++) {
      if (breadth.hasNext()) {
        final String co = breadth.next();
        System.out.println(co);

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
    for (int i = 0; i < 6; i++) {
      if (depth.hasNext()) {
        final String co = depth.next();
        System.out.println(co);
      } else return;
    }
  }

  public void RandomWalkIterator() {
    final Iterator<String> rw = new RandomWalkIterator<>(myMap, CH);
    for (int i = 0; i < 6; i++) {
      if (rw.hasNext()) {
        final String co = rw.next();
        System.out.println(co);
      } else return;
    }
  }

  public void Coloring() {
    GreedyColoring<String, DefaultEdge> color = new GreedyColoring<>(myMap);
    System.out.println(color.getColoring());
  }
 
}
