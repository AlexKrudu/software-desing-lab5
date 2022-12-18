package org.example;

import org.example.draw.Awt;
import org.example.draw.DrawingApi;
import org.example.draw.Graph;
import org.example.draw.JavaFX;
import org.example.models.ListGraph;
import org.example.models.MatrixGraph;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args == null || args.length != 2) {
            throw new IllegalArgumentException("2 arguments expexted: <api_type> <graph_representation>");
        }

        DrawingApi api;

        switch (args[0]) {
            case "javafx" -> {
                JavaFX.run();
                api = new JavaFX();
            }
            case "awt" -> api = new Awt();
            default -> throw new IllegalArgumentException("Unexpected api type. Supported options are: javafx, awt");
        }
        Graph graph;
        switch (args[1]) {
            case "matrix" -> {
                System.out.println("Enter N - number of vertexes. Then enter NxN graph matrix");
                graph = new MatrixGraph(api);
            }
            case "list" -> {
                System.out.println("Enter N - number of vertexes. Then enter E - number of edges." +
                        " Then enter E pairs of v1 v2 where 0 <= v1, v2 <= N");
                graph = new ListGraph(api);
            }
            default -> throw new IllegalArgumentException("Unexpected graph type. Supported options are: matrix, list");
        }

        graph.readGraph(new Scanner(System.in));
        graph.drawGraph();
    }
}