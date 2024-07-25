package Graphs;

public class Main {
    
    public static void main(String[] args) {
        Graph myGraph = new Graph();

        myGraph.addVertex("A");
        myGraph.addVertex("B");
        myGraph.addVertex("C");
        myGraph.addVertex("D");

        myGraph.printGraph();

        myGraph.addEdge("A", "B");
        myGraph.addEdge("A", "C");
        
        myGraph.addEdge("C", "B");

        myGraph.addEdge("D", "A");
        myGraph.addEdge("D", "B");
        myGraph.addEdge("D", "C");
        myGraph.addEdge("D", "D");


        myGraph.printGraph();

        myGraph.removeEdge("D", "D");

        myGraph.printGraph();

        myGraph.removeVertex("A");
        myGraph.removeVertex("D");

        myGraph.printGraph();

    }
}
