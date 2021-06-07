package edu.luc.cs271.myhashmap;
import java.util.*;
import org.jgrapht.*;
import org.jgrapht.alg.interfaces.*;
import org.jgrapht.alg.color.GreedyColoring;
import org.jgrapht.graph.*;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.*;

public class Main{
public static void main(final String[] args) {

   UndirectedGraph<String, DefaultEdge> algo =
        new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);
    Codes myMap = new Codes(algo);
    algo = (UndirectedGraph<String, DefaultEdge>) myMap.Map();
    System.out.println(algo);
    
    System.out.println("\n" + "Breadth-First Algorithm:");
    myMap.BreadthFirstIterator();
    System.out.println("\n" + "Closest-First Algorithm:");
    myMap.ClosestFirstIterator();
    System.out.println("\n" + "Depth-First Algorithm:");
    myMap.DepthFirstIterator();
    System.out.println("\n" + "Random-Walk Algorithm:");
    myMap.RandomWalkIterator();
    System.out.println("\n" + "Coloring:");
    myMap.Coloring();
  }
}
