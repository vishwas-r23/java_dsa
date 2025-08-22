
package graph;

public class GraphAdj {
    private int[][] adjacencyMatrix;
    private int numVertices;

    // Constructor to initialize the graph with the given number of vertices
    public GraphAdj(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new int[numVertices][numVertices];
    }

    // Add an edge to the graph (undirected)
    public void addEdge(int i, int j) {
        if (isValidVertex(i) && isValidVertex(j)) {
            adjacencyMatrix[i][j] = 1;
            adjacencyMatrix[j][i] = 1; // For undirected graph
        } else {
            throw new IllegalArgumentException("Vertex number is out of bounds");
        }
    }

    // Remove an edge from the graph (undirected)
    public void removeEdge(int i, int j) {
        if (isValidVertex(i) && isValidVertex(j)) {
            adjacencyMatrix[i][j] = 0;
            adjacencyMatrix[j][i] = 0; // For undirected graph
        } else {
            throw new IllegalArgumentException("Vertex number is out of bounds");
        }
    }

    // Check if an edge exists between two vertices
    public boolean isEdge(int i, int j) {
        if (isValidVertex(i) && isValidVertex(j)) {
            return adjacencyMatrix[i][j] == 1;
        } else {
            throw new IllegalArgumentException("Vertex number is out of bounds");
        }
    }

    // Print the adjacency matrix representing the graph
    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Helper method to check if a vertex index is valid
    private boolean isValidVertex(int v) {
        return v >= 0 && v < numVertices;
    }

    // Example main method to demonstrate usage
    public static void main(String[] args) {
        GraphAdj graph = new GraphAdj(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        System.out.println("Adjacency Matrix:");
        graph.printGraph();

        System.out.println("Is there an edge between 0 and 1? " + graph.isEdge(0, 1));
        System.out.println("Is there an edge between 1 and 3? " + graph.isEdge(1, 3));

        graph.removeEdge(0, 1);
        System.out.println("Edge between 0 and 1 removed.");

        System.out.println("Updated Adjacency Matrix:");
        graph.printGraph();
    }
}

