package org.example.geometry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GeometryHelper {

    public List<VertexCoords> getVertexesCoordinates(int nVertexes, int windowHeight, int windowWidth) {
        List<VertexCoords> resPoints = new ArrayList<>();

        int radius = getGraphRadius(windowHeight, windowWidth);
        var center = getGraphCenter(windowHeight, windowWidth);

        if (nVertexes == 1){
            resPoints.add(new VertexCoords(center.getKey(), center.getValue(), radius / 3));
            return resPoints;
        }

        int vertexRadius = getVertexesRadius(nVertexes, radius);
        radius -= vertexRadius;

        for (int i = 0; i < nVertexes; i++) {
            var x = (int) (radius * Math.cos(2 * Math.PI * i / nVertexes));
            var y = (int) (radius * Math.sin(2 * Math.PI * i / nVertexes));
            resPoints.add(new VertexCoords(x + center.getKey(),  y + center.getValue(), vertexRadius));
        }

        return resPoints;
    }

    private int getGraphRadius(int windowHeight, int windowWidth) {
        return Math.min(windowHeight, windowWidth) / 2;
    }

    private Map.Entry<Integer, Integer> getGraphCenter(int windowHeight, int windowWidth) {
        return Map.entry(windowWidth / 2, windowHeight / 2);
    }

    private int getVertexesRadius(int nVertexes, int radius) {
        var x1 = radius;
        var y1 = 0;
        var x2 = radius * Math.cos(2 * Math.PI / nVertexes);
        var y2 = radius * Math.sin(2 * Math.PI / nVertexes);

        var distance = Math.hypot(x1 - x2, y1 - y2);
        return (int) (distance / 6);
    }
}
