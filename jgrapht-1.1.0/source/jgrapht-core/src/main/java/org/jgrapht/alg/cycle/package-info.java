/**
 * Algorithms for enumeration of simple cycles in graphs.
 *
 * <p><b>Implementation Note:</b> All the implementations work correctly with loops but not with
 * multiple duplicate edges.
 *
 * <p><b>Performance Notes:</b> &nbsp;&nbsp;&nbsp;&nbsp; The worst case time complexity of the
 * algorithms for finding cycles in directed graphs is:
 *
 * <ol>
 *   <li>Tiernan - O(V.const^V)
 *   <li>Tarjan - O(VEC)
 *   <li>Johnson - O(((V+E)C)
 *   <li>Szwarcfiter and Lauer - O(V+EC)
 * </ol>
 *
 * where V is the number of vertices, E is the number of edges and C is the number of the simple
 * cycles in the graph.
 *
 * <p>The worst case performance is achieved for graphs with special structure, so on practical
 * workloads an algorithm with higher worst case complexity may outperform an algorithm with lower
 * worst case complexity. Note also that "administrative costs" of algorithms with better worst case
 * performance are higher. Also higher is their memory cost (which is in all cases O(V+E)).
 *
 * <p>The package author's workloads contain typically several hundred nodes and from tens to
 * several thousand simple cycles. On these workloads the algorithms score by performance (best to
 * worst ) so :
 *
 * <ol>
 *   <li>Szwarcfiter and Lauer
 *   <li>Tarjan
 *   <li>Johnson
 *   <li>Tiernan
 * </ol>
 *
 * The worst case time complexity of the Paton's algorithm for finding a cycle base in undirected
 * graphs is O(V^3).
 *
 * <p><b>Literature:</b> <br>
 *
 * <ol>
 *   <li>J.C.Tiernan An Efficient Search Algorithm Find the Elementary Circuits of a Graph.,
 *       Communications of the ACM, V13, 12, (1970), pp. 722 - 726.
 *   <li>R.Tarjan, Depth-first search and linear graph algorithms., SIAM J. Comput. 1 (1972), pp.
 *       146-160.
 *   <li>R. Tarjan, Enumeration of the elementary circuits of a directed graph, SIAM J. Comput., 2
 *       (1973), pp. 211-216.
 *   <li>D.B.Johnson, Finding all the elementary circuits of a directed graph, SIAM J. Comput., 4
 *       (1975), pp. 77-84.
 *   <li>J.L.Szwarcfiter and P.E.Lauer, Finding the elementary cycles of a directed graph in O(n +
 *       m) per cycle, Technical Report Series, #60, May 1974, Univ. of Newcastle upon Tyne,
 *       Newcastle upon Tyne, England.
 *   <li>P.Mateti and N.Deo, On algorithms for enumerating all circuits of a graph., SIAM J.
 *       Comput., 5 (1978), pp. 90-99.
 *   <li>L.G.Bezem and J.van Leeuwen, Enumeration in graphs., Technical report RUU-CS-87-7,
 *       University of Utrecht, The Netherlands, 1987.
 *   <li>K. Paton, An algorithm for finding a fundamental set of cycles for an undirected linear
 *       graph, Comm. ACM 12 (1969), pp. 514-518.
 * </ol>
 */
package org.jgrapht.alg.cycle;
