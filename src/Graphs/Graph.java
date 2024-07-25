package Graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    
    private HashMap<String, ArrayList<String>> adjMap = new HashMap<>();

    public boolean addVertex(String vertex){
        /***
         * This method is used only to create a new vertex on the graph. Edges are going to be added on another function.
         */

        if (adjMap.get(vertex) == null){
            adjMap.put(vertex, new ArrayList<String>());
            return true;
        }
        return false;
    }

    public boolean addEdge(String vertex1, String vertex2){
        ArrayList<String> v1 = adjMap.get(vertex1);
        ArrayList<String> v2 = adjMap.get(vertex2);

        if (v1 != null && v2 != null){
            v1.add(vertex2);
            v2.add(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeEdge(String vertex1, String vertex2){
        ArrayList<String> v1 = adjMap.get(vertex1);
        ArrayList<String> v2 = adjMap.get(vertex2);

        if (v1 != null && v2 != null){
            return(v1.remove(vertex2) && v2.remove(vertex1));
        }
        return false;
    }

    public boolean removeVertex(String vertex){
        ArrayList<String> temp = adjMap.get(vertex);

        if (temp != null){
            /* 
                If vertex exists; 
                Iterate over the list of edges and for every vertex on the list
                remove 'vertex' from their list.
                At the end, remove vertex from the adjancency map.
            */
            for (String v : temp) {
                adjMap.get(v).remove(vertex);
            }
            adjMap.remove(vertex);
            return true;
        }
        return false;
    }

    public void printGraph(){
        System.out.println(adjMap);
    }

}
