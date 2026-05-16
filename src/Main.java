public class Main {

    public static void main(String[] args) {

        System.out.println("  Graph Traversal and Representation");
        System.out.println();

        System.out.println("SMALL GRAPH DEMO (10 vertices)");
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

        smallGraph.bfs(0);

        smallGraph.dfs(0);

        System.out.println();
        System.out.println("MEDIUM GRAPH (30 vertices)");

        Graph mediumGraph = new Graph();
        for (int i = 0; i < 30; i++) mediumGraph.addVertex(new Vertex(i));
        for (int i = 0; i < 29; i++) {
            mediumGraph.addEdge(i, i + 1);
            if (i + 2 < 30) mediumGraph.addEdge(i, i + 2);
        }
        mediumGraph.bfs(0);
        mediumGraph.dfs(0);
        System.out.println();

        System.out.println("LARGE GRAPH (100 vertices)");

        Graph largeGraph = new Graph();
        for (int i = 0; i < 100; i++) largeGraph.addVertex(new Vertex(i));
        for (int i = 0; i < 99; i++) {
            largeGraph.addEdge(i, i + 1);
            if (i + 2 < 100) largeGraph.addEdge(i, i + 2);
        }
        largeGraph.bfs(0);
        largeGraph.dfs(0);
        System.out.println();

        Experiment experiment = new Experiment();
        experiment.runMultipleTests();
        experiment.printResults();
    }
}