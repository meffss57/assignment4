
public class Main {

    public static void main(String[] args) {

        System.out.println(" ");
        System.out.println("   Graph Traversal and Representation System");
        System.out.println(" ");
        System.out.println();
        System.out.println("SMALL GRAPH (10 vertices)");
        System.out.println();

        Graph smallGraph = new Graph();
        for (int i = 0; i < 10; i++) {
            smallGraph.addVertex(new Vertex(i));
        }
        smallGraph.addEdge(0, 1);
        smallGraph.addEdge(0, 2);
        smallGraph.addEdge(1, 3);
        smallGraph.addEdge(1, 4);
        smallGraph.addEdge(2, 5);
        smallGraph.addEdge(2, 6);
        smallGraph.addEdge(3, 7);
        smallGraph.addEdge(4, 8);
        smallGraph.addEdge(5, 9);
        smallGraph.addEdge(6, 7);
        smallGraph.addEdge(7, 9);
        smallGraph.addEdge(8, 9);

        smallGraph.printGraph();
        System.out.println();

        long startBfs = System.nanoTime();
        smallGraph.bfs(0);
        long endBfs = System.nanoTime();
        System.out.println("BFS execution time: " + (endBfs - startBfs) + " ns");
        System.out.println();

        long startDfs = System.nanoTime();
        smallGraph.dfs(0);
        long endDfs = System.nanoTime();
        System.out.println("DFS execution time: " + (endDfs - startDfs) + " ns");
        System.out.println();
        System.out.println("MEDIUM GRAPH (30 vertices)");
        System.out.println();

        Graph mediumGraph = new Graph();
        for (int i = 0; i < 30; i++) mediumGraph.addVertex(new Vertex(i));
        for (int i = 0; i < 30; i++) {
            if (i + 1 < 30) mediumGraph.addEdge(i, i + 1);
            if (i + 2 < 30) mediumGraph.addEdge(i, i + 2);
        }

        long startMedBfs = System.nanoTime();
        mediumGraph.bfs(0);
        long endMedBfs = System.nanoTime();
        System.out.println("BFS execution time: " + (endMedBfs - startMedBfs) + " ns");
        System.out.println();

        long startMedDfs = System.nanoTime();
        mediumGraph.dfs(0);
        long endMedDfs = System.nanoTime();
        System.out.println("DFS execution time: " + (endMedDfs - startMedDfs) + " ns");
        System.out.println();

        System.out.println("LARGE GRAPH (100 vertices)");
        System.out.println();

        Graph largeGraph = new Graph();
        for (int i = 0; i < 100; i++) largeGraph.addVertex(new Vertex(i));
        for (int i = 0; i < 100; i++) {
            if (i + 1 < 100) largeGraph.addEdge(i, i + 1);
            if (i + 2 < 100) largeGraph.addEdge(i, i + 2);
        }

        long startLgBfs = System.nanoTime();
        largeGraph.bfs(0);
        long endLgBfs = System.nanoTime();
        System.out.println("BFS execution time: " + (endLgBfs - startLgBfs) + " ns");
        System.out.println();

        long startLgDfs = System.nanoTime();
        largeGraph.dfs(0);
        long endLgDfs = System.nanoTime();
        System.out.println("DFS execution time: " + (endLgDfs - startLgDfs) + " ns");
        System.out.println();

        Experiment experiment = new Experiment();
        experiment.runMultipleTests();
        experiment.printResults();
    }
}