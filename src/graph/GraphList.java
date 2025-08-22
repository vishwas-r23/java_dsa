package graph;

import java.util.LinkedList;
import java.util.List;

public class GraphList {
    private List<List<Integer>> adjacencyList;
    private int numVertices;

    // Constructor to initialize graph with given vertices
    public GraphList(int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = new LinkedList<>();
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new LinkedList<>());
        }
    }

    // Add an edge to the graph (undirected)
    public void addEdge(int src, int dest) {
        if (isValidVertex(src) && isValidVertex(dest)) {
            adjacencyList.get(src).add(dest);
            adjacencyList.get(dest).add(src); // For undirected graph
        } else {
            throw new IllegalArgumentException("Vertex number is out of bounds");
        }
    }

    // Remove an edge from the graph (undirected)
    public void removeEdge(int src, int dest) {
        if (isValidVertex(src) && isValidVertex(dest)) {
            adjacencyList.get(src).remove(Integer.valueOf(dest));
            adjacencyList.get(dest).remove(Integer.valueOf(src));
        } else {
            throw new IllegalArgumentException("Vertex number is out of bounds");
        }
    }

    // Check if an edge exists between two vertices
    public boolean isEdge(int src, int dest) {
        if (isValidVertex(src) && isValidVertex(dest)) {
            return adjacencyList.get(src).contains(dest);
        } else {
            throw new IllegalArgumentException("Vertex number is out of bounds");
        }
    }

    // Print the adjacency list
    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + ": ");
            for (int v : adjacencyList.get(i)) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    // Helper method to validate vertex index
    private boolean isValidVertex(int v) {
        return v >= 0 && v < numVertices;
    }

    // Demo main method to test the graph implementation
    public static void main(String[] args) {
        GraphList graph = new GraphList(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        System.out.println("Adjacency List:");
        graph.printGraph();

        System.out.println("Edge between 0 and 1? " + graph.isEdge(0, 1));
        System.out.println("Edge between 1 and 3? " + graph.isEdge(1, 3));

        graph.removeEdge(0, 1);
        System.out.println("Removed edge between 0 and 1.");

        System.out.println("Updated Adjacency List:");
        graph.printGraph();
    }
}
