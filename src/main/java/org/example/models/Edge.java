package org.example.models;

public class Edge {
    public int vertexFrom, vertexTo;

    public Edge(int vertexFrom, int vertexTo){
        this.vertexFrom = Math.min(vertexFrom, vertexTo);
        this.vertexTo = Math.max(vertexFrom, vertexTo);
    }
}
