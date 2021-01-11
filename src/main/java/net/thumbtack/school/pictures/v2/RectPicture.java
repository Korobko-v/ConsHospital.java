package net.thumbtack.school.pictures.v2;

import net.thumbtack.school.iface.v2.Movable;
import net.thumbtack.school.iface.v2.Resizable;
import net.thumbtack.school.winobjects.v2.Desktop;

import java.util.Objects;

public class RectPicture extends Picture implements Movable, Resizable {
    private int format;
    private Point topLeft;
    private Point bottomRight;

    public RectPicture(Point topLeft, Point bottomRight, int format) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
        this.format = format;
    }

    public RectPicture(int xLeft, int yTop, int width, int height, int format) {
        this.topLeft = new Point(xLeft, yTop);
        this.bottomRight = new Point(xLeft + width - 1, yTop + height - 1);
        this.format = format;
    }

    public RectPicture(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
        this.format = 1;
    }

    public RectPicture(int xLeft, int yTop, int width, int height) {
        this.topLeft = new Point(xLeft, yTop);
        this.bottomRight = new Point(xLeft + width-1, yTop + height-1);
        this.format = 1;
    }

    public Point getTopLeft() {

        return topLeft;
    }

    public Point getBottomRight() {

        return bottomRight;
    }

    public int getFormat() {

        return format;
    }

    public void setTopLeft(Point topLeft) {

        this.topLeft = topLeft;
    }

    public void setBottomRight(Point bottomRight) {

        this.bottomRight = bottomRight;
    }

    public int getWidth() {

        return bottomRight.getX() - topLeft.getX() + 1;
    }

    public int getHeight() {

        return  bottomRight.getY() - topLeft.getY() + 1;
    }

    public void moveTo(int x, int y) {
        this.bottomRight.setX(x + this.getWidth() - 1);
        this.bottomRight.setY(y + this.getHeight() - 1);
        this.topLeft = new Point(x, y);
    }

    @Override
    public void moveTo(Point point) {
        this.bottomRight.setX(point.getX() + this.getWidth() - 1);
        this.bottomRight.setY(point.getY() + this.getHeight() -1);
        this.setTopLeft(point);
    }


    public void moveRel(int dx, int dy) {
        this.topLeft.setX(this.topLeft.getX() + dx);
        this.topLeft.setY(this.topLeft.getY() + dy);
        this.bottomRight.setX(this.bottomRight.getX() + dx);
        this.bottomRight.setY(this.bottomRight.getY() + dy);
    }

    public void resize(double ratio) {
        int resizeWidth = (int) (this.getWidth() * ratio);
        int resizeHeight = (int) (this.getHeight() * ratio);
        this.bottomRight.setX((int) (this.topLeft.getX() + resizeWidth) - 1);
        this.bottomRight.setY((int) (this.topLeft.getY() + resizeHeight) - 1);
        if (this.getHeight() < 1) {
            this.bottomRight.setY(this.topLeft.getY());
        }
        if (this.getWidth() < 1) {
            this.bottomRight.setX(this.topLeft.getX());
        }
    }

    public boolean isInside(int x, int y) {
        if (this.bottomRight.getX() < x || this.topLeft.getX() > x || this.bottomRight.getY() < y || this.topLeft.getY() > y) {
            return false;
        }
        return true;
    }

    public boolean isInside(Point point) {
        if (point.getX() < this.topLeft.getX() || point.getX() > this.bottomRight.getX() || this.bottomRight.getY() < point.getY() || this.topLeft.getY() > point.getY()) {
            return false;
        }
        return true;
    }

    public boolean isIntersects(RectPicture rectPicture) {
        if (rectPicture.bottomRight.getY() < this.topLeft.getY() || rectPicture.topLeft.getY() > this.bottomRight.getY()) {
            return false;
        }
        if (rectPicture.bottomRight.getX() < this.topLeft.getX() || rectPicture.topLeft.getX() > this.bottomRight.getX()) {
            return false;
        }
        return true;
    }

    public boolean isInside(RectPicture rectPicture) {
        if (rectPicture.bottomRight.getY() > this.bottomRight.getY() || rectPicture.topLeft.getX() < this.topLeft.getX()) {
            return false;
        }
        if (rectPicture.topLeft.getY() < this.topLeft.getY() || rectPicture.bottomRight.getX() > this.bottomRight.getX()) {
            return false;
        }
        return true;
    }
    public boolean isFullyVisibleOnDesktop(Desktop desktop) {
        if (this.getWidth() > desktop.getWidth() || this.getHeight() > desktop.getHeight()) {
            return false;
        }
        if (this.topLeft.getX() + this.getWidth() > desktop.getWidth() || this.topLeft.getX() < 0) {
            return false;
        }
        if (this.topLeft.getY() + this.getHeight() > desktop.getHeight() || this.topLeft.getY() < 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RectPicture that = (RectPicture) o;
        return format == that.format &&
                Objects.equals(topLeft, that.topLeft) &&
                Objects.equals(bottomRight, that.bottomRight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(format, topLeft, bottomRight);
    }
}

