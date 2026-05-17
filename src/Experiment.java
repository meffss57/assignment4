
public class Experiment {

    private int[] graphSizes = {10, 30, 100};
    private long[][] results;

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
        // Long-range edges for structural variety
        for (int i = 0; i < size - 5; i += 5) {
            g.addEdge(i, i + 4);
        }
        return g;
    }

    public long[] runTraversals(Graph g) {
        long[] times = new long[2];

        // Measure BFS execution time
        long startBfs = System.nanoTime();
        g.bfs(0);
        long endBfs = System.nanoTime();
        times[0] = endBfs - startBfs;

        // Measure DFS execution time
        long startDfs = System.nanoTime();
        g.dfs(0);
        long endDfs = System.nanoTime();
        times[1] = endDfs - startDfs;

        return times;
    }

    public void runMultipleTests() {
        System.out.println("Running Performance Experiments");
        System.out.println();

        for (int i = 0; i < graphSizes.length; i++) {
            int size = graphSizes[i];
            Graph g = buildGraph(size);
            System.out.println("[Graph size: " + size + " vertices | "
                    + g.getEdgeCount() + " edges]");
            long[] times = runTraversals(g);
            results[i][0] = times[0];
            results[i][1] = times[1];
            System.out.println("  BFS time: " + times[0] + " ns");
            System.out.println("  DFS time: " + times[1] + " ns");
            System.out.println();
        }
    }

    public void printResults() {
        System.out.println(" ");
        System.out.println("         PERFORMANCE RESULTS         ");
        System.out.println(" ");
        System.out.printf("%-15s %-20s %-20s %-10s%n",
                "Graph Size", "BFS Time (ns)", "DFS Time (ns)", "Faster");
        for (int i = 0; i < graphSizes.length; i++) {
            String faster = results[i][0] <= results[i][1] ? "BFS" : "DFS";
            System.out.printf("%-15d %-20d %-20d %-10s%n",
                    graphSizes[i], results[i][0], results[i][1], faster);
        }
    }
}