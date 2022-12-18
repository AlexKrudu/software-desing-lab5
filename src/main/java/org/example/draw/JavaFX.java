package org.example.draw;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class JavaFX extends Application implements DrawingApi {
    private final int height = 600;
    private final int width = 600;

    private static GraphicsContext ctx;

    public static void run(){
        new Thread(JavaFX::launch).start();
    }

    @Override
    public int getDrawingAreaWidth() {
        return width;
    }

    @Override
    public int getDrawingAreaHeight() {
        return height;
    }

    @Override
    public void drawCircle(int x, int y, int radius) {
        ctx.setFill(Color.RED);
        ctx.fillOval(x - radius / 2, y - radius / 2, radius, radius);
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        ctx.setStroke(Color.BLACK);
        ctx.strokeLine(x1, y1, x2, y2);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group g = new Group();
        Canvas canvas = new Canvas(width, height);
        ctx = canvas.getGraphicsContext2D();
        g.getChildren().add(canvas);
        stage.setScene(new Scene(g));
        stage.show();
    }
}
