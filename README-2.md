Assignment report:

Double the vertices and edges, roughly double the time. This is because both algorithms visit each vertex and each edge exactly once. Adding more vertices adds more iterations to the while-loop (BFS) or more recursive calls (DFS). Adding more edges adds more iterations to the inner for-each loop. Neither algorithm does any repeated work, so there's no exponential or quadratic blowup.

DFS is consistently faster across all three sizes. The reason is overhead. BFS uses a LinkedList-backed Queue every queue.add() and queue.poll() involves Java creating and destroying node objects in the linked list, which costs memory allocation time. DFS uses the call stack through recursion, which after JVM optimization is cheaper per operation. Both are O(V + E) same complexity class but DFS has a smaller constant factor in this implementation.

V+E grows roughly linearly from size 10 to 100 in your graph structure, and the measured times also grow roughly linearly. If the complexity were O(V²), going from 10 to 100 vertices would cause 100× longer times. The actual increase is roughly 4×, matching the actual growth in V+E. The match isn't perfect because of JVM warmup, garbage collection pauses, and OS scheduling but the pattern clearly confirms linear behavior, not quadratic or exponential.

BFS and DFS produce the same SET of visited vertices but in entirely different orders, determined by the graph's shape. On your tree-like small graph, BFS produces 0 1 2 3 4 5 6 7 8 9, natural level-by-level order. DFS produces 0 1 3 7 9 4 8 2 5 6, it dives to the deepest node on each branch first. On a different graph say one where vertex 0 connects to every other vertex directly - BFS and DFS would produce identical or near-identical output because there's only one level. The edge insertion order also matters for DFS: whichever neighbor appears first in the adjacency list gets explored first.

Whenever you need the shortest path. BFS guarantees it finds the path with the fewest edges first because it explores level by level the first time it reaches a destination, that's guaranteed to be the shortest route. GPS navigation (fewest turns), social networks (degrees of separation), network routing protocols, and web crawlers that prioritize nearby links all use BFS. Also preferred when the solution is likely close to the starting point BFS finds it quickly without going deep.

What are the limitations of DFS? First, it does not guarantee the shortest path. It might find A->B via a 10-step detour even if a 2-step path exists, because it commits fully to the first branch it explores. Second, recursive DFS can cause a stack overflow on very deep graphs ,Java's call stack has a limited size (typically a few thousand frames), and a graph with thousands of vertices in a chain would crash it. An iterative DFS using an explicit Stack object avoids this but is harder to write. Third, the traversal order is unpredictable and depends on edge insertion order, making it less suitable when consistent ordering matters. Fourth, on wide graphs with many branches, DFS might explore a very long wrong path before backtracking, making it slow to find shallow solutions.

BFS uses a Queue object so every time i add or remove something from it, Java does extra work managing that object. 
DFS just calls itself recursively, which after the JVM optimizes it, is slightly cheaper. Both are O(V + E), meaning
the time grows proportionally to the number of vertices plus edges, but DFS has a smaller constant cost per operation.


