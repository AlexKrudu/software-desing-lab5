package org.example.draw;

public interface DrawingApi {
    int getDrawingAreaWidth();
    int getDrawingAreaHeight();
    void drawCircle(int x, int y, int radius);
    void drawLine(int x1, int y1, int x2, int y2);
}
