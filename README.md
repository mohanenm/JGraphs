

 final Graph<String, DefaultEdge> myMap = new SimpleGraph<>(DefaultEdge.class);
 myMap.addVertex(AT);
 myMap.addVertex(DE);


 myMap.addEdge(AT, DE);
 
 
 
Then print the resulting graph.



Traverse the graph using the following different traversal algorithms (in org.grapht.traverse):



BreadthFirstIterator
ClosestFirstIterator
DepthFirstIterator
RandomWalkIterator
