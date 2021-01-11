package net.thumbtack.school.pictures.v2;

import net.thumbtack.school.winobjects.v2.Desktop;

import java.util.Objects;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Point() {
        this.x = 0;
        this.y = 0;
    }
    public Point(Point point) {
        this.x = point.x;
        this.y = point.y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void moveRel(int dx, int dy) {
        this.x = this.x + dx;
        this.y = this.y + dy;
    }
    public boolean isVisibleOnDesktop(Desktop desktop) {
        if (x > 0 && x < desktop.getWidth() && y > 0 && y < desktop.getHeight()) {
            return true;
        }
        return false;
    }
    public boolean isNotVisibleOnDesktop(Desktop desktop) {
        if (x > 0 && x < desktop.getWidth() && y > 0 && y < desktop.getHeight()) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
