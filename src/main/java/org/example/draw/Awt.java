package org.example.draw;

import java.awt.*;

public class Awt implements DrawingApi{

    private final Frame frame;
    private final int width = 600;
    private final int height = 600;

    public Awt(){
        frame = new Frame("Graph");
        frame.setSize(width, height);
        frame.setVisible(true);
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
        var graphics = (Graphics2D) frame.getGraphics();
        graphics.setPaint(Color.RED);
        graphics.fillOval(x - radius / 2, y - radius / 2, radius, radius);
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        var graphics = (Graphics2D) frame.getGraphics();
        graphics.setPaint(Color.BLACK);
        graphics.drawLine(x1, y1, x2, y2);
    }
}
