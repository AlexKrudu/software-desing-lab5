package org.example.draw;

import org.example.geometry.GeometryHelper;

import java.util.Scanner;

public abstract class Graph {

    protected final DrawingApi drawingApi;
    protected int nVertexes;
    protected GeometryHelper helper;

    public Graph(DrawingApi drawingApi) {
        this.drawingApi = drawingApi;
        this.helper = new GeometryHelper();
    }

    public abstract void drawGraph();

    public abstract void readGraph(Scanner input);
}
