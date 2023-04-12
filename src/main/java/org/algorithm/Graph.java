package org.algorithm;

import java.util.ArrayList;

public class Graph {

    private final ArrayList<Vertex> vertices;
    private final boolean isWeighted;
    private final boolean isDirected;

    public Graph(boolean isWeighted, boolean isDirected) {
        this.isWeighted = isWeighted;
        this.isDirected = isDirected;
        this.vertices = new ArrayList<>();
    }

    public Vertex addVertex(String data) {
        Vertex newVertex = new Vertex(data);
        this.vertices.add(newVertex);
        return newVertex;
    }

    public void addEdge(Vertex vertex1, Vertex vertex2, Integer weight) {
        if (!this.isWeighted) {
            weight = null;
        }
        vertex1.addEdge(vertex2, weight);
        if (!this.isDirected) {
            vertex2.addEdge(vertex1, weight);
        }
    }

    public void removeEdge(Vertex vertex1, Vertex vertex2){
        vertex1.removeEdge(vertex2);
        if (!this.isDirected) {
            vertex2.removeEdge(vertex1);
        }
    }

    public void removeVertex(Vertex vertex){
        this.vertices.remove(vertex);
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    public boolean isWeighted() {
        return isWeighted;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public Vertex getVertexByValue(String data){
        for (Vertex v : this.vertices){
            if (v.getData().equals(data)){
                return v;
            }
        }
        return null;
    }

    public void print(){
        for(Vertex v : vertices){
            v.print(this.isWeighted);
        }
    }

    public static void main(String[] args) {
        Graph trainNetwork = new Graph(true, false);
        Vertex luzStation = trainNetwork.addVertex("Luz Station");
        Vertex piqueriStation = trainNetwork.addVertex("Piqueri Station");

        trainNetwork.addEdge(luzStation, piqueriStation, 1000);

        trainNetwork.print();
    }
}