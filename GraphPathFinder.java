import java.util.ArrayList;
import java.util.List;

public class GraphPathFinder {
    public static boolean hasIncrementalPath(int[] A, int[] B, int N) {
        List<Integer>[] graph = new ArrayList[N+1];

        // Initialize the adjacency list.
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // Populate the adjacency list based on the input arrays A and B.
        for (int k = 0; k < A.length; k++) {
            graph[A[k]].add(B[k]);
            graph[B[k]].add(A[k]); // Add both directions for an undirected graph.
        }

        boolean[] visited = new boolean[N + 1];
        visited[1] = true; // Start at vertex 1.

        // Initialize variables to keep track of the current and next vertices.
        int current = 1;
        int next = 1;

        while (next != N) {
            boolean foundNext = false;

            for (int neighbor : graph[current]) {
                if (!visited[neighbor] && neighbor == next + 1) {
                    visited[neighbor] = true;
                    next = neighbor;
                    foundNext = true;
                    break;
                }
            }

            if (!foundNext) {
                // If we cannot find the next vertex, there's no incremental path.
                return false;
            }

            current = next;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] A = {1,3};
        int[] B = {2,2};
        int N = 3;

        boolean hasIncrementalPath = hasIncrementalPath(A, B, N);
        System.out.println("Graph contains an incremental path from 1 to N: " + hasIncrementalPath);
    }
}
