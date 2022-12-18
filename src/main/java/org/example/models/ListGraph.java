package org.example.models;

import org.example.draw.DrawingApi;
import org.example.draw.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListGraph extends Graph {

    List<Edge> edgesList;

    public ListGraph(DrawingApi drawingApi) {
        super(drawingApi);
        edgesList = new ArrayList<>();
    }

    @Override
    public void drawGraph() {
        var vertexesCoords = helper.getVertexesCoordinates(nVertexes,
                drawingApi.getDrawingAreaHeight(),
                drawingApi.getDrawingAreaWidth());
        for (var edge : edgesList) {
            var vFrom = vertexesCoords.get(edge.vertexFrom);
            var vTo = vertexesCoords.get(edge.vertexTo);

            drawingApi.drawLine(vFrom.x, vFrom.y, vTo.x, vTo.y);
        }

        for (var vertex : vertexesCoords) {
            drawingApi.drawCircle(vertex.x, vertex.y, vertex.radius);
        }
    }

    @Override
    public void readGraph(Scanner input) {
        nVertexes = input.nextInt();
        int nEdges = input.nextInt();
        for (int i = 0; i < nEdges; i++) {
            int fromV = input.nextInt();
            int toV = input.nextInt();
            edgesList.add(new Edge(fromV, toV));
        }
    }
}
