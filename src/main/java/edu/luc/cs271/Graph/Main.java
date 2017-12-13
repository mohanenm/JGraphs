public main {
   
   final static String CH = "Chad";//a country in Africa who has at least 5 countries bordering it (Sudan, Cameroon, Niger, Nigeria, Libya, and C.A.R.)
   final static String CAR = "Central African Republic";
   
   final Graph<String, DefaultEdge> myMap = new SimpleGraph<>(DefaultEdge.class);
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
   
   public void breadthFirst(); //double check
{
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
   
       
       
   
   
   public void depthFirstSearch();//double check
   {
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
            }
            else {
                s.pop();
            }
        }
        // Clear visited property of nodes
        clearNodes();
    }


   
   public ListGraph(int numV, boolean directed) {
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