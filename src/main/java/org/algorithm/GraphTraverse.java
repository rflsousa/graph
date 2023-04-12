package org.algorithm;

import java.util.ArrayList;

public class GraphTraverse {
    public static void depthFirstTraversal(Vertex start, ArrayList<Vertex> visitedVertices){
        System.out.println(start.getData());

        for (Edge e : start.getEdges()){
            Vertex neighbor = e.getEnd();

            if(!visitedVertices.contains(neighbor)){
                visitedVertices.add(neighbor);
                GraphTraverse.depthFirstTraversal(neighbor, visitedVertices);
            }
        }
    }
    public static void main(String[] args) {
        TestGraph test = new TestGraph();
        Vertex startingVertex = test.getStartingVertex();
        ArrayList<Vertex> visitedVertices = new ArrayList<>();
        visitedVertices.add(startingVertex);

        GraphTraverse.depthFirstTraversal(startingVertex, visitedVertices);
    }
}
