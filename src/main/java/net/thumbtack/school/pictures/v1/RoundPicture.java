package net.thumbtack.school.pictures.v1;

import java.util.Objects;

public class RoundPicture {
    Point center;
    int radius;
    int format;

    public RoundPicture(Point center, int radius, int format) {
        this.center = center;
        this.radius = radius;
        this.format = format;
    }
    public RoundPicture(int xCenter, int yCenter, int radius, int format) {
        this.center.setX(xCenter);
        this.center.setY(yCenter);
        this.radius = radius;
        this.format = format;
    }
    public RoundPicture(Point center, int radius) {
        this.center = center;
        this.radius = radius;
        this.format = 1;
    }
    public RoundPicture(int xCenter, int yCenter, int radius) {
        this.center.setX(xCenter);
        this.center.setY(yCenter);
        this.radius = radius;
        this.format = 1;
    }
    public Point getCenter() {
        return center;
    }
    public int getRadius() {
        return radius;
    }
    public int getFormat() {
        return format;
    }
    public void moveTo(int x, int y) {
        this.center.setX(x);
        this.center.setY(y);
    }
    public void moveTo(Point point) {
        this.center = point;
    }
    public void setCenter(int x, int y) {
        this.center = new Point(x, y);
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
    public void setFormat(int format) {
        this.format = format;
    }
    public void moveRel(int dx, int dy) {
        this.center.setX(this.center.getX() + dx);
        this.center.setY(this.center.getY() + dy);
    }
    public void resize(double ratio) {
        this.radius = (int) (this.radius * ratio);
        if (this.radius < 1) {
            this.radius = 1;
        }
    }
    public boolean isInside(int x, int y) {
        if (Math.pow(x, 2) + Math.pow(y, 2) > Math.pow(this.radius, 2)) {
            return false;
        }
        return true;
    }
    public boolean isInside(Point point) {
        if (Math.pow(point.getX(), 2) + Math.pow(point.getY(), 2) > Math.pow(this.radius, 2)) {
            return false;
        }
        return true;
    }
    public boolean isFullyVisibleOnDesktop(Desktop desktop) {
        if (this.radius <= desktop.getHeight() / 2) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoundPicture that = (RoundPicture) o;
        return radius == that.radius &&
                format == that.format &&
                Objects.equals(center, that.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius, format);
    }
}
