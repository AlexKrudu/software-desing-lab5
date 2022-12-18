package org.example.models;

import org.example.draw.DrawingApi;
import org.example.draw.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class MatrixGraph extends Graph {


    private boolean[][] graphMatrix;

    public MatrixGraph(DrawingApi drawingApi) {
        super(drawingApi);
    }

    @Override
    public void drawGraph() {
        var vertexesCoords = helper.getVertexesCoordinates(nVertexes,
                drawingApi.getDrawingAreaHeight(),
                drawingApi.getDrawingAreaWidth());
        for (int i = 0; i < nVertexes; i++) {
            for (int j = 0; j < nVertexes; j++) {
                if (graphMatrix[i][j]) {
                    var vFrom = vertexesCoords.get(i);
                    var vTo = vertexesCoords.get(j);
                    drawingApi.drawLine(vFrom.x, vFrom.y, vTo.x, vTo.y);
                }
            }
        }
        for (var vertex : vertexesCoords) {
            drawingApi.drawCircle(vertex.x, vertex.y, vertex.radius);
        }
    }

    @Override
    public void readGraph(Scanner input) {
        nVertexes = input.nextInt();
        graphMatrix = new boolean[nVertexes][];
        for (int i = 0; i < nVertexes; i++) {
            graphMatrix[i] = new boolean[nVertexes];
            for (int j = 0; j < nVertexes; j++) {
                graphMatrix[i][j] = input.nextInt() == 1;
            }
        }
    }
}
