
public class Experiment {

    private long[][] results;
    private int[] graphSizes = {10, 30, 100};

    public Experiment() {
        results = new long[graphSizes.length][2];
    }

    private Graph buildGraph(int size) {
        Graph g = new Graph();

        for (int i = 0; i < size; i++) {
            g.addVertex(new Vertex(i));
        }
        for (int i = 0; i < size; i++) {
            if (i + 1 < size) g.addEdge(i, i + 1);
            if (i + 2 < size) g.addEdge(i, i + 2);
        }
        for (int i = 0; i < size - 5; i += 5) {
            g.addEdge(i, i + 4);
        }

        return g;
    }

    public long[] runTraversals(Graph g) {
        long[] times = new long[2];

        long startBfs = System.nanoTime();
        g.bfs(0);
        long endBfs = System.nanoTime();
        times[0] = endBfs - startBfs;

        long startDfs = System.nanoTime();
        g.dfs(0);
        long endDfs = System.nanoTime();
        times[1] = endDfs - startDfs;

        return times;
    }

    public void runMultipleTests() {
        System.out.println("Running Experiments\n");

        for (int i = 0; i < graphSizes.length; i++) {
            int size = graphSizes[i];
            Graph g = buildGraph(size);

            System.out.println("Graph Size: " + size + " vertices, " + g.getEdgeCount() + " edges");
            if (size == 10) {
                g.printGraph();
                System.out.println();
            }

            long[] times = runTraversals(g);
            results[i][0] = times[0];
            results[i][1] = times[1];

            System.out.println();
        }
    }

    public void printResults() {
        System.out.println("Performance Results");
        System.out.println();
        System.out.printf("%-15s %-20s %-20s%n", "Graph Size", "BFS Time (ns)", "DFS Time (ns)");
        System.out.println("-".repeat(55));

        for (int i = 0; i < graphSizes.length; i++) {
            System.out.printf("%-15d %-20d %-20d%n",
                    graphSizes[i], results[i][0], results[i][1]);
        }

        System.out.println();
        System.out.println("Analysis");
        for (int i = 0; i < graphSizes.length; i++) {
            String faster = results[i][0] < results[i][1] ? "BFS" : "DFS";
            System.out.println("Graph size " + graphSizes[i] + ": " + faster + " was faster.");
        }
    }
}